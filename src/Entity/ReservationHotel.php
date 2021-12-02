<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * ReservationHotel
 *
 * @ORM\Table(name="reservation_hotel", indexes={@ORM\Index(name="idH", columns={"idH"}), @ORM\Index(name="idU", columns={"idU"})})
 * @ORM\Entity
 */
class ReservationHotel
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_reservation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idReservation;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateDebut", type="date", nullable=false)
     * @Assert\NotBlank
     * @Assert\GreaterThan("today")
     */
    private $datedebut;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateFin", type="date", nullable=false)
     * @Assert\Expression(
     *     "this.getDatedebut() < this.getDatefin()",
     *     message="La date fin ne doit pas être antérieure à la date début"
     * )
     */
    private $datefin;

    /**
     * @var int
     *
     * @ORM\Column(name="nbChambres", type="integer", nullable=false)
     * @Assert\Positive
     */
    private $nbchambres;

    /**
     * @var \Hotel
     *
     * @ORM\ManyToOne(targetEntity="Hotel")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idH", referencedColumnName="id_hotel")
     * })
     */
    private $idh;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idU", referencedColumnName="id")
     * })
     */
    private $idu;

    public function getIdReservation(): ?int
    {
        return $this->idReservation;
    }

    public function getDatedebut(): ?\DateTimeInterface
    {
        return $this->datedebut;
    }

    public function setDatedebut(\DateTimeInterface $datedebut): self
    {
        $this->datedebut = $datedebut;

        return $this;
    }

    public function getDatefin(): ?\DateTimeInterface
    {
        return $this->datefin;
    }

    public function setDatefin(\DateTimeInterface $datefin): self
    {
        $this->datefin = $datefin;

        return $this;
    }

    public function getNbchambres(): ?int
    {
        return $this->nbchambres;
    }

    public function setNbchambres(int $nbchambres): self
    {
        $this->nbchambres = $nbchambres;

        return $this;
    }

    public function getIdh(): ?Hotel
    {
        return $this->idh;
    }

    public function setIdh(?Hotel $idh): self
    {
        $this->idh = $idh;

        return $this;
    }

    public function getIdu(): ?User
    {
        return $this->idu;
    }

    public function setIdu(?User $idu): self
    {
        $this->idu = $idu;

        return $this;
    }


}
