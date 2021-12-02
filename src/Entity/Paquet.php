<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Paquet
 *
 * @ORM\Table(name="paquet", indexes={@ORM\Index(name="nom", columns={"nom"})})
 * @ORM\Entity
 */
class Paquet
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=30, nullable=false)
     */
    private $nom;

    /**
     * @var int
     *
     * @ORM\Column(name="prix", type="integer", nullable=false)
     */
    private $prix;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_dÃ©b", type="date", nullable=false)
     */
    private $dateDã©b;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_fin", type="date", nullable=false)
     */
    private $dateFin;

    /**
     * @var int
     *
     * @ORM\Column(name="id_resto", type="integer", nullable=false)
     */
    private $idResto;

    /**
     * @var int
     *
     * @ORM\Column(name="id_cafÃ©", type="integer", nullable=false)
     */
    private $idCafã©;

    /**
     * @var int
     *
     * @ORM\Column(name="id_restocafÃ©", type="integer", nullable=false)
     */
    private $idRestocafã©;

    /**
     * @var int
     *
     * @ORM\Column(name="id_zarch", type="integer", nullable=false)
     */
    private $idZarch;

    /**
     * @var int
     *
     * @ORM\Column(name="id_ztour", type="integer", nullable=false)
     */
    private $idZtour;

    /**
     * @var int
     *
     * @ORM\Column(name="id_hotel", type="integer", nullable=false)
     */
    private $idHotel;

    /**
     * @var int
     *
     * @ORM\Column(name="id_transport", type="integer", nullable=false)
     */
    private $idTransport;

    public function getId(): ?int
    {
        return $this->id;
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

    public function getPrix(): ?int
    {
        return $this->prix;
    }

    public function setPrix(int $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function getDateDã©b(): ?\DateTimeInterface
    {
        return $this->dateDã©b;
    }

    public function setDateDã©b(\DateTimeInterface $dateDã©b): self
    {
        $this->dateDã©b = $dateDã©b;

        return $this;
    }

    public function getDateFin(): ?\DateTimeInterface
    {
        return $this->dateFin;
    }

    public function setDateFin(\DateTimeInterface $dateFin): self
    {
        $this->dateFin = $dateFin;

        return $this;
    }

    public function getIdResto(): ?int
    {
        return $this->idResto;
    }

    public function setIdResto(int $idResto): self
    {
        $this->idResto = $idResto;

        return $this;
    }

    public function getIdCafã©(): ?int
    {
        return $this->idCafã©;
    }

    public function setIdCafã©(int $idCafã©): self
    {
        $this->idCafã© = $idCafã©;

        return $this;
    }

    public function getIdRestocafã©(): ?int
    {
        return $this->idRestocafã©;
    }

    public function setIdRestocafã©(int $idRestocafã©): self
    {
        $this->idRestocafã© = $idRestocafã©;

        return $this;
    }

    public function getIdZarch(): ?int
    {
        return $this->idZarch;
    }

    public function setIdZarch(int $idZarch): self
    {
        $this->idZarch = $idZarch;

        return $this;
    }

    public function getIdZtour(): ?int
    {
        return $this->idZtour;
    }

    public function setIdZtour(int $idZtour): self
    {
        $this->idZtour = $idZtour;

        return $this;
    }

    public function getIdHotel(): ?int
    {
        return $this->idHotel;
    }

    public function setIdHotel(int $idHotel): self
    {
        $this->idHotel = $idHotel;

        return $this;
    }

    public function getIdTransport(): ?int
    {
        return $this->idTransport;
    }

    public function setIdTransport(int $idTransport): self
    {
        $this->idTransport = $idTransport;

        return $this;
    }


}
