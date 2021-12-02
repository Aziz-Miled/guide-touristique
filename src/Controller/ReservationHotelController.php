<?php

namespace App\Controller;

use App\Entity\ReservationHotel;
use App\Entity\Hotel;
use App\Form\ReservationHotelType;
use App\Repository\ReservationHotelRepository;
use App\Repository\HotelRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Twilio\Rest\Client;
use Psr\Log\LoggerInterface;


require __DIR__ . '\..\..\vendor\autoload.php';


/**
 * @Route("/reservation_hotel")
 */
class ReservationHotelController extends AbstractController
{
    /**
     * @Route("/", name="reservation_hotel_index", methods={"GET"})
     */
    public function index(ReservationHotelRepository $repository): Response
    {
        $reservationHotels = $repository->OrderByDateDebut();

        return $this->render('reservation_hotel/index.html.twig', [
            'reservation_hotels' => $reservationHotels,
        ]);
    }

    /**
     * @Route("/new", name="reservation_hotel_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $reservationHotel = new ReservationHotel();
        $form = $this->createForm(ReservationHotelType::class, $reservationHotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($reservationHotel);
            $entityManager->flush();

            return $this->redirectToRoute('reservation_hotel_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reservation_hotel/new.html.twig', [
            'reservation_hotel' => $reservationHotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idReservation}", name="reservation_hotel_show", methods={"GET"})
     */
    public function show(ReservationHotel $reservationHotel): Response
    {
        return $this->render('reservation_hotel/show.html.twig', [
            'reservation_hotel' => $reservationHotel,
        ]);
    }

    /**
     * @Route("/{idReservation}/edit", name="reservation_hotel_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, ReservationHotel $reservationHotel): Response
    {
        $form = $this->createForm(ReservationHotelType::class, $reservationHotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('reservation_hotel_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reservation_hotel/edit.html.twig', [
            'reservation_hotel' => $reservationHotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idReservation}", name="reservation_hotel_delete", methods={"POST"})
     */
    public function delete(Request $request, ReservationHotel $reservationHotel): Response
    {
        if ($this->isCsrfTokenValid('delete' . $reservationHotel->getIdReservation(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($reservationHotel);
            $entityManager->flush();
        }

        return $this->redirectToRoute('reservation_hotel_index', [], Response::HTTP_SEE_OTHER);
    }

//    /**
//     * @Route(name="notify", methods={"GET","POST"})
//     */
//    public function notify(HotelRepository $hotels, ReservationHotel $reservationHotel,LoggerInterface $logger): Response
//    {
//        $logger->alert('test');
//        $sid = 'ACe33b768eb9108b1fec0a1fd50dba9cc7';
//        $token = '4d7ed877115de7511c9804130a658553';
//        $client = new Client($sid, $token);
//
//        // Use the client to do fun stuff like send text messages!
//        $client->messages->create(
//            '+21623446085',
//            [
//                'from' => '+17744589576',
//                'body' => 'test'
//            ]
//        );
//        return false;
//    }
}
