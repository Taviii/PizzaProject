package pl.pjwstk.pizzeria.pizzeria.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Klient {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nick;
    private String mail;
    private String adres;

    @OneToMany (mappedBy = "id", cascade = CascadeType.ALL)
    private List<Pizza> listaZamowien = new ArrayList<>();

    public Klient(Long id, String nick, String mail, String adres, List<Pizza> listaZamowien) {
        this.id = id;
        this.nick = nick;
        this.mail = mail;
        this.adres = adres;
        this.listaZamowien = listaZamowien;
    }

    public Klient(String nick, String mail, String adres, List<Pizza> listaZamowien) {
        this.nick = nick;
        this.mail = mail;
        this.adres = adres;
        this.listaZamowien = listaZamowien;
    }

    public Klient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<Pizza> getListaZamowien() {
        return listaZamowien;
    }

    public void setListaZamowien(List<Pizza> listaZamowien) {
        this.listaZamowien = listaZamowien;
    }

}

