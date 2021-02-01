package pl.pjwstk.pizzeria.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nazwa;
    private String rozmiar;
    private String sos;
    private String ciasto;

    public Pizza(String nazwa, String rozmiar, String sos, String ciasto) {
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
        this.sos = sos;
        this.ciasto = ciasto;
    }

    public Pizza(Long id, String nazwa, String rozmiar, String sos, String ciasto) {
        this.id = id;
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
        this.sos = sos;
        this.ciasto = ciasto;
    }

    public Pizza(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    public String getSos() {
        return sos;
    }

    public void setSos(String sos) {
        this.sos = sos;
    }

    public String getCiasto() {
        return ciasto;
    }

    public void setCiasto(String ciasto) {
        this.ciasto = ciasto;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", rozmiar='" + rozmiar + '\'' +
                ", sos='" + sos + '\'' +
                ", ciasto='" + ciasto + '\'' +
                '}';
    }
}

