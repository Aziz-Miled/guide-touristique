<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

// DON'T forget the following use statement!!!
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;
/**
 * Hotel
 *
 * @ORM\Table(name="hotel")
 * @ORM\Entity
 * * @UniqueEntity(
 * fields={"email"},message="L'émail que vous avez tapé est déjà utilisé !"
 * )
 */
class Hotel
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_hotel", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idHotel;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=30, nullable=false)
     * @Assert\Length(
     * min = 3,
     * max = 20,
     * minMessage = "Votre nom doit contenir au moins {{limit }} caract`eres",
     * maxMessage = "Votre nom doit contenir au plus {{limit }} caract`eres",
     * allowEmptyString = false
     * )
     * @Assert\Type(
     * type={"alpha", "digit"},
     * message="Votre nom {{ value }} doit contenir
    seulement des lettres alphabétiques"
     * )
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="adresse", type="string", length=30, nullable=false)
     */
    private $adresse;

    /**
     * @var string
     *
     * @ORM\Column(name="tel", type="string", length=30, nullable=false)
     *  @Assert\Length(
     * min = 8,
     * max = 8,
     * minMessage = "Votre tel doit contenir au moins {{limit }} chifres",
     * maxMessage = "Votre tel doit contenir au plus {{limit }} chifres",
     * allowEmptyString = false
     * )
     */
    private $tel;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=30, nullable=false)
     * @Assert\Email(
     *     message="l email n est pas valide")
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="page_web", type="string", length=30, nullable=false)
     */
    private $pageWeb;

    /**
     * @var float
     *
     * @ORM\Column(name="prix_nuite", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixNuite;

    /**
     * @var int
     *
     * @ORM\Column(name="nombre_etoile", type="integer", nullable=false)
     * @Assert\LessThanOrEqual(5)
     *@Assert\GreaterThanOrEqual(1)
     */
    private $nombreEtoile;

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=255, nullable=false, options={"default"="active"})
     */
    private $etat = 'active';

    /**
     * @var int
     *
     * @ORM\Column(name="nbChambres_max", type="integer", nullable=false)
     */
    private $nbchambresMax;

    /**
     * @var int
     *
     * @ORM\Column(name="nbChambres_reserve", type="integer", nullable=false)
     * @Assert\Expression(
     *     "this.getNbchambresReserve() < this.getNbchambresMax()",
     *     message="Le NbchambresReserve ne doit pas etre  superieur à le NbchambresMax"
     * )
     */
    private $nbchambresReserve;

    /**
     * @var string
     *
     * @ORM\Column(name="image", type="string", length=255, nullable=false)
     */
    private $image;

    public function getIdHotel(): ?int
    {
        return $this->idHotel;
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

    public function getAdresse(): ?string
    {
        return $this->adresse;
    }

    public function setAdresse(string $adresse): self
    {
        $this->adresse = $adresse;

        return $this;
    }

    public function getTel(): ?string
    {
        return $this->tel;
    }

    public function setTel(string $tel): self
    {
        $this->tel = $tel;

        return $this;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getPageWeb(): ?string
    {
        return $this->pageWeb;
    }

    public function setPageWeb(string $pageWeb): self
    {
        $this->pageWeb = $pageWeb;

        return $this;
    }

    public function getPrixNuite(): ?float
    {
        return $this->prixNuite;
    }

    public function __toString(){
        return $this->nom;
    }
    public function setPrixNuite(float $prixNuite): self
    {
        $this->prixNuite = $prixNuite;

        return $this;
    }

    public function getNombreEtoile(): ?int
    {
        return $this->nombreEtoile;
    }

    public function setNombreEtoile(int $nombreEtoile): self
    {
        $this->nombreEtoile = $nombreEtoile;

        return $this;
    }

    public function getEtat(): ?string
    {
        return $this->etat;
    }

    public function setEtat(string $etat): self
    {
        $this->etat = $etat;

        return $this;
    }

    public function getNbchambresMax(): ?int
    {
        return $this->nbchambresMax;
    }

    public function setNbchambresMax(int $nbchambresMax): self
    {
        $this->nbchambresMax = $nbchambresMax;

        return $this;
    }

    public function getNbchambresReserve(): ?int
    {
        return $this->nbchambresReserve;
    }

    public function setNbchambresReserve(int $nbchambresReserve): self
    {
        $this->nbchambresReserve = $nbchambresReserve;

        return $this;
    }

    public function getImage(): ?string
    {
        return $this->image;
    }

    public function setImage(string $image): self
    {
        $this->image = $image;

        return $this;
    }


}
