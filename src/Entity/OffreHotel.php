<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * OffreHotel
 *
 * @ORM\Table(name="offre_hotel", indexes={@ORM\Index(name="cfo", columns={"id_O"}), @ORM\Index(name="cbo", columns={"id_H"})})
 * @ORM\Entity
 */
class OffreHotel
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
     * @ORM\Column(name="etat_offre_hotel", type="string", length=255, nullable=false, options={"default"="active"})
     */
    private $etatOffreHotel = 'active';

    /**
     * @var \Hotel
     *
     * @ORM\ManyToOne(targetEntity="Hotel")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_H", referencedColumnName="id_hotel")
     * })
     */
    private $idH;

    /**
     * @var \Offreh
     *
     * @ORM\ManyToOne(targetEntity="Offreh")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_O", referencedColumnName="id_offreH")
     * })
     */
    private $idO;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getEtatOffreHotel(): ?string
    {
        return $this->etatOffreHotel;
    }

    public function setEtatOffreHotel(string $etatOffreHotel): self
    {
        $this->etatOffreHotel = $etatOffreHotel;

        return $this;
    }

    public function getIdH(): ?Hotel
    {
        return $this->idH;
    }

    public function setIdH(?Hotel $idH): self
    {
        $this->idH = $idH;

        return $this;
    }

    public function getIdO(): ?Offreh
    {
        return $this->idO;
    }

    public function setIdO(?Offreh $idO): self
    {
        $this->idO = $idO;

        return $this;
    }


}
