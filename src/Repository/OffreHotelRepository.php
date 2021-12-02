<?php

namespace App\Repository;

use App\Entity\OffreHotel;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method OffreHotel|null find($id, $lockMode = null, $lockVersion = null)
 * @method OffreHotel|null findOneBy(array $criteria, array $orderBy = null)
 * @method OffreHotel[]    findAll()
 * @method OffreHotel[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class OffreHotelRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, OffreHotel::class);
    }

    // /**
    //  * @return OffreHotel[] Returns an array of OffreHotel objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('o')
            ->andWhere('o.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('o.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?OffreHotel
    {
        return $this->createQueryBuilder('o')
            ->andWhere('o.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
