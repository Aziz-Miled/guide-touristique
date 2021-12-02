<?php

namespace App\Controller;

use App\Entity\Offreh;
use App\Form\OffrehType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/offreh")
 */
class OffrehController extends AbstractController
{
    /**
     * @Route("/", name="offreh_index", methods={"GET"})
     */
    public function index(): Response
    {
        $offrehs = $this->getDoctrine()
            ->getRepository(Offreh::class)
            ->findAll();

        return $this->render('offreh/index.html.twig', [
            'offrehs' => $offrehs,
        ]);
    }

    /**
     * @Route("/new", name="offreh_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $offreh = new Offreh();
        $form = $this->createForm(OffrehType::class, $offreh);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($offreh);
            $entityManager->flush();

            return $this->redirectToRoute('offreh_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('offreh/new.html.twig', [
            'offreh' => $offreh,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idOffreh}", name="offreh_show", methods={"GET"})
     */
    public function show(Offreh $offreh): Response
    {
        return $this->render('offreh/show.html.twig', [
            'offreh' => $offreh,
        ]);
    }

    /**
     * @Route("/{idOffreh}/edit", name="offreh_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Offreh $offreh): Response
    {
        $form = $this->createForm(OffrehType::class, $offreh);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('offreh_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('offreh/edit.html.twig', [
            'offreh' => $offreh,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idOffreh}", name="offreh_delete", methods={"POST"})
     */
    public function delete(Request $request, Offreh $offreh): Response
    {
        if ($this->isCsrfTokenValid('delete'.$offreh->getIdOffreh(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($offreh);
            $entityManager->flush();
        }

        return $this->redirectToRoute('offreh_index', [], Response::HTTP_SEE_OTHER);
    }
}
