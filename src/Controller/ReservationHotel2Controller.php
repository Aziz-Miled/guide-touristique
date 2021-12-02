<?php

namespace App\Controller;

use App\Entity\ReservationHotel;
use App\Form\ReservationHotel2Type;
use App\Repository\HotelRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Twilio\Rest\Client;

/**
 * @Route("/reservation_hotel2")
 */
class ReservationHotel2Controller extends AbstractController
{
    /**
     * @Route("/", name="reservation_hotel2_index", methods={"GET"})
     */
    public function index(): Response
    {
        $reservationHotels = $this->getDoctrine()
            ->getRepository(ReservationHotel::class)
            ->findAll();

        return $this->render('reservation_hotel2/index.html.twig', [
            'reservation_hotels' => $reservationHotels,
        ]);
    }

    /**
     * @Route("/new", name="reservation_hotel2_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $reservationHotel = new ReservationHotel();
        $form = $this->createForm(ReservationHotel2Type::class, $reservationHotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($reservationHotel);
            $entityManager->flush();

            return $this->redirectToRoute('reservation_hotel2_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reservation_hotel2/new.html.twig', [
            'reservation_hotel' => $reservationHotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idReservation}", name="reservation_hotel2_show", methods={"GET"})
     */
    public function show(ReservationHotel $reservationHotel): Response
    {
        return $this->render('reservation_hotel2/show.html.twig', [
            'reservation_hotel' => $reservationHotel,
        ]);
    }

    /**
     * @Route("/{idReservation}/edit", name="reservation_hotel2_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, ReservationHotel $reservationHotel): Response
    {
        $form = $this->createForm(ReservationHotel2Type::class, $reservationHotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('reservation_hotel2_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reservation_hotel2/edit.html.twig', [
            'reservation_hotel' => $reservationHotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idReservation}", name="reservation_hotel2_delete", methods={"POST"})
     */
    public function delete(Request $request, ReservationHotel $reservationHotel): Response
    {
        if ($this->isCsrfTokenValid('delete' . $reservationHotel->getIdReservation(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($reservationHotel);
            $entityManager->flush();
        }

        return $this->redirectToRoute('reservation_hotel2_index', [], Response::HTTP_SEE_OTHER);
    }
}