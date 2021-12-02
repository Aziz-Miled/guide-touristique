<?php

namespace App\Form;

use App\Entity\Hotel;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\FileType;

class HotelType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom')
            ->add('adresse')
            ->add('tel')
            ->add('email')
            ->add('pageWeb')
            ->add('prixNuite')
            ->add('nombreEtoile')
            ->add('etat')
            ->add('nbchambresMax')
            ->add('nbchambresReserve')
            ->add('image', FileType::class,array('data_class' => null,'attr' => array(
                'class'=>'form-control border-color-6'
            )))
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Hotel::class,
        ]);
    }
}
