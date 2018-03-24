package com.epul.metier;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "baseoeuvre", catalog = "")
@IdClass(ReservationEntityPK.class)
public class ReservationEntity {
    private int idOeuvrevente;
    private int idAdherent;
    private Date dateReservation;
    private String statut;
    private OeuvreventeEntity oeuvreventeByIdOeuvrevente;
    private AdherentEntity adherentByIdAdherent;

    @Id
    @Column(name = "id_oeuvrevente")
    public int getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    @Id
    @Column(name = "id_adherent")
    public int getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(int idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Basic
    @Column(name = "date_reservation")
    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Basic
    @Column(name = "statut")
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return idOeuvrevente == that.idOeuvrevente &&
                idAdherent == that.idAdherent &&
                Objects.equals(dateReservation, that.dateReservation) &&
                Objects.equals(statut, that.statut);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOeuvrevente, idAdherent, dateReservation, statut);
    }

    @ManyToOne
    @JoinColumn(name = "id_oeuvrevente", referencedColumnName = "id_oeuvrevente", nullable = false)
    public OeuvreventeEntity getOeuvreventeByIdOeuvrevente() {
        return oeuvreventeByIdOeuvrevente;
    }

    public void setOeuvreventeByIdOeuvrevente(OeuvreventeEntity oeuvreventeByIdOeuvrevente) {
        this.oeuvreventeByIdOeuvrevente = oeuvreventeByIdOeuvrevente;
    }

    @ManyToOne
    @JoinColumn(name = "id_adherent", referencedColumnName = "id_adherent", nullable = false)
    public AdherentEntity getAdherentByIdAdherent() {
        return adherentByIdAdherent;
    }

    public void setAdherentByIdAdherent(AdherentEntity adherentByIdAdherent) {
        this.adherentByIdAdherent = adherentByIdAdherent;
    }
}
