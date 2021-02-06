package pl.pjwstk.pizzeria.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Pizza {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nazwa;
    private String rozmiar;
    private String sos;
    private String ciasto;
    private double cena;


    @ManyToOne
    @JoinColumn(name = "klient_id")
    @JsonIgnore
    private Klient klient;


    public Pizza(String nazwa, String rozmiar, String sos, String ciasto, double cena, Klient klient) {
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
        this.sos = sos;
        this.ciasto = ciasto;
        this.cena = cena;
        this.klient = klient;
    }

    public Pizza(Long id, String nazwa, String rozmiar, String sos, String ciasto, double cena, Klient klient) {
        this.id = id;
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
        this.sos = sos;
        this.ciasto = ciasto;
        this.cena = cena;
        this.klient = klient;
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
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }



//    public Zamowienie getZamowienie() {
//        return zamowienie;
//    }
//
//    public void setZamowienie(Zamowienie zamowienie) {
//        this.zamowienie = zamowienie;
//    }

}

