<?php

namespace App\Controller;

use App\Entity\Hotel;
use App\Form\HotelType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Mime\Email;
use Dompdf\Dompdf;
use Dompdf\Options;
use App\Repository\HotelRepository;

// Required if your environment does not handle autoloading
require __DIR__ . '\..\..\vendor\autoload.php';
use Twilio\Rest\Client;


// Use the REST API Client to make requests to the Twilio REST API

/**
 * @Route("/hotel")
 */
class HotelController extends AbstractController
{
    /**
     * @Route("/", name="hotel_index", methods={"GET"})
     */
    public function index(): Response
    {
        $hotels = $this->getDoctrine()
            ->getRepository(Hotel::class)
            ->findAll();

        return $this->render('hotel/index.html.twig', [
            'hotels' => $hotels,
        ]);
    }

    /**
     * @Route("/new", name="hotel_new", methods={"GET","POST"})
     */
    public function new(Request $request, MailerInterface $mailer): Response
    {
        $hotel = new Hotel();
        $form = $this->createForm(HotelType::class, $hotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $file = $form['image']->getData();
            $file->move("img/", $file->getClientOriginalName());
            $hotel->setImage("img/".$file->getClientOriginalName());
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($hotel);
            $entityManager->flush();
            $email = (new Email())
                ->from('tabaani.app@gmail.com')
                ->to($hotel->getEmail())
                //->cc('cc@example.com')
                //->bcc('bcc@example.com')
                //->replyTo('fabien@example.com')
                //->priority(Email::PRIORITY_HIGH)
                ->subject('Concernant l ajout de votre hotel!')
                ->text('Sending emails is fun again!')
                ->html('<p>Votre Hotel est ajouté avec succée</p>');

            $mailer->send($email);


            // Your Account SID and Auth Token from twilio.com/console
            $sid = 'ACe33b768eb9108b1fec0a1fd50dba9cc7';
            $token = '4d7ed877115de7511c9804130a658553';
            $client = new Client($sid, $token);

// Use the client to do fun stuff like send text messages!
            $client->messages->create(
            // the number you'd like to send the message to
                '+21623446085',
                [
                    // A Twilio phone number you purchased at twilio.com/console
                    'from' => '+17744589576',
                    // the body of the text message you'd like to send
                    'body' => 'Votre hotel est enregistrée avec succés'
                ]
            );

            return $this->redirectToRoute('hotel_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('hotel/new.html.twig', [
            'hotel' => $hotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idHotel}", name="hotel_show", methods={"GET"})
     */
    public function show(Hotel $hotel): Response
    {
        return $this->render('hotel/show.html.twig', [
            'hotel' => $hotel,
        ]);
    }

    /**
     * @Route("/edit/{idHotel}", name="hotel_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Hotel $hotel): Response
    {
        $form = $this->createForm(HotelType::class, $hotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('hotel_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('hotel/edit.html.twig', [
            'hotel' => $hotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idHotel}", name="hotel_delete", methods={"POST"})
     */
    public function delete(Request $request, Hotel $hotel): Response
    {
        if ($this->isCsrfTokenValid('delete'.$hotel->getIdHotel(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($hotel);
            $entityManager->flush();
        }

        return $this->redirectToRoute('hotel_index', [], Response::HTTP_SEE_OTHER);
    }

    /**
     * @Route("{id}/imprimer", name="imprimer", methods={"GET"})
     */
    public function imprimer(HotelRepository $hotelRepository): Response

    {

        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->get('defaultFont', 'Arial');

        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);

        $resmaisons = $hotelRepository->findAll();

        // Retrieve the HTML generated in our twig file
        $html = $this->renderView('hotel/imprimer.html.twig', [
            'resmaisons' => $resmaisons,
        ]);

        // Load HTML to Dompdf
        $dompdf->loadHtml($html);

        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Output the generated PDF to Browser (inline view)
        $dompdf->stream("Liste hotel.pdf", [
            "Attachment" => true
        ]);
    }
}
