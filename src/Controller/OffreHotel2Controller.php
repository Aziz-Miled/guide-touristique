<?php

namespace App\Controller;

use App\Entity\OffreHotel;
use App\Form\OffreHotel1Type;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/offre/hotel2")
 */
class OffreHotel2Controller extends AbstractController
{
    /**
     * @Route("/", name="offre_hotel2_index", methods={"GET"})
     */
    public function index(): Response
    {
        $offreHotels = $this->getDoctrine()
            ->getRepository(OffreHotel::class)
            ->findAll();

        return $this->render('offre_hotel2/index.html.twig', [
            'offre_hotels' => $offreHotels,
        ]);
    }

    /**
     * @Route("/new", name="offre_hotel2_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $offreHotel = new OffreHotel();
        $form = $this->createForm(OffreHotel1Type::class, $offreHotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($offreHotel);
            $entityManager->flush();

            return $this->redirectToRoute('offre_hotel2_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('offre_hotel2/new.html.twig', [
            'offre_hotel' => $offreHotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idH}", name="offre_hotel2_show", methods={"GET"})
     */
    public function show(OffreHotel $offreHotel): Response
    {
        return $this->render('offre_hotel2/show.html.twig', [
            'offre_hotel' => $offreHotel,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="offre_hotel2_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, OffreHotel $offreHotel): Response
    {
        $form = $this->createForm(OffreHotel1Type::class, $offreHotel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('offre_hotel2_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('offre_hotel2/edit.html.twig', [
            'offre_hotel' => $offreHotel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="offre_hotel2_delete", methods={"POST"})
     */
    public function delete(Request $request, OffreHotel $offreHotel): Response
    {
        if ($this->isCsrfTokenValid('delete'.$offreHotel->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($offreHotel);
            $entityManager->flush();
        }

        return $this->redirectToRoute('offre_hotel2_index', [], Response::HTTP_SEE_OTHER);
    }
}
