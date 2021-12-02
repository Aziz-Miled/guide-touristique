<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Tourist
 *
 * @ORM\Table(name="tourist")
 * @ORM\Entity
 */
class Tourist
{
    /**
     * @var int
     *
     * @ORM\Column(name="idtourist", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idtourist;

    /**
     * @var int
     *
     * @ORM\Column(name="nom", type="integer", nullable=false)
     */
    private $nom;

    /**
     * @var int
     *
     * @ORM\Column(name="cin_passport", type="integer", nullable=false)
     */
    private $cinPassport;

    public function getIdtourist(): ?int
    {
        return $this->idtourist;
    }

    public function getNom(): ?int
    {
        return $this->nom;
    }

    public function setNom(int $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getCinPassport(): ?int
    {
        return $this->cinPassport;
    }

    public function setCinPassport(int $cinPassport): self
    {
        $this->cinPassport = $cinPassport;

        return $this;
    }


}
