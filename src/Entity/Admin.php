<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Admin
 *
 * @ORM\Table(name="admin")
 * @ORM\Entity
 */
class Admin
{
    /**
     * @var int
     *
     * @ORM\Column(name="idadmin", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idadmin;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=30, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="cin_passport", type="string", length=30, nullable=false)
     */
    private $cinPassport;

    public function getIdadmin(): ?int
    {
        return $this->idadmin;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getCinPassport(): ?string
    {
        return $this->cinPassport;
    }

    public function setCinPassport(string $cinPassport): self
    {
        $this->cinPassport = $cinPassport;

        return $this;
    }


}
