<?php

namespace App\Controller;

use App\Entity\Hotel;
use App\Form\Hotel1Type;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/hotel2")
 */
class Hotel2Controller extends AbstractController
{
    /**
     * @Route("/", name="hotel2_index", methods={"GET"})
     */
    public function index(): Response
    {
        $hotels = $this->getDoctrine()
            ->getRepository(Hotel::class)
            ->findAll();

        return $this->render('hotel2/index.html.twig', [
            'hotels' => $hotels,
        ]);
    }

    /**
     * @Route("/new", name="hotel2_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $hotel = new Hotel();
        $form = $this->createForm(Hotel1Type::class, $hotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($hotel);
            $entityManager->flush();

            return $this->redirectToRoute('hotel2_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('hotel2/new.html.twig', [
            'hotel' => $hotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idHotel}", name="hotel2_show", methods={"GET"})
     */
    public function show(Hotel $hotel): Response
    {
        return $this->render('hotel2/show.html.twig', [
            'hotel' => $hotel,
        ]);
    }

    /**
     * @Route("/{idHotel}/edit", name="hotel2_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Hotel $hotel): Response
    {
        $form = $this->createForm(Hotel1Type::class, $hotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('hotel2_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('hotel2/edit.html.twig', [
            'hotel' => $hotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idHotel}", name="hotel2_delete", methods={"POST"})
     */
    public function delete(Request $request, Hotel $hotel): Response
    {
        if ($this->isCsrfTokenValid('delete'.$hotel->getIdHotel(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($hotel);
            $entityManager->flush();
        }

        return $this->redirectToRoute('hotel2_index', [], Response::HTTP_SEE_OTHER);
    }
}
