<?php

namespace App\Repository;

use App\Entity\Offreh;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Offreh|null find($id, $lockMode = null, $lockVersion = null)
 * @method Offreh|null findOneBy(array $criteria, array $orderBy = null)
 * @method Offreh[]    findAll()
 * @method Offreh[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class OffrehRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Offreh::class);
    }

    // /**
    //  * @return Offreh[] Returns an array of Offreh objects
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
    public function findOneBySomeField($value): ?Offreh
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
