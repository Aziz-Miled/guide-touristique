<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Offreh
 *
 * @ORM\Table(name="offreh")
 * @ORM\Entity
 */
class Offreh
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_offreH", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idOffreh;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_offre", type="string", length=255, nullable=false)
     */
    private $nomOffre;

    /**
     * @var float
     *
     * @ORM\Column(name="prix_offre", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixOffre;

    /**
     * @var string
     *
     * @ORM\Column(name="etat_offre", type="string", length=255, nullable=false, options={"default"="active"})
     */
    private $etatOffre = 'active';

    public function getIdOffreh(): ?int
    {
        return $this->idOffreh;
    }

    public function getNomOffre(): ?string
    {
        return $this->nomOffre;
    }

    public function setNomOffre(string $nomOffre): self
    {
        $this->nomOffre = $nomOffre;

        return $this;
    }

    public function getPrixOffre(): ?float
    {
        return $this->prixOffre;
    }

    public function setPrixOffre(float $prixOffre): self
    {
        $this->prixOffre = $prixOffre;

        return $this;
    }

    public function getEtatOffre(): ?string
    {
        return $this->etatOffre;
    }

    public function setEtatOffre(string $etatOffre): self
    {
        $this->etatOffre = $etatOffre;

        return $this;
    }
    public function __toString(){
        return $this->nomOffre;
    }

}
