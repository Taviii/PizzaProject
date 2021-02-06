//package pl.pjwstk.pizzeria.pizzeria.model;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Zamowienie {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private double cenarazem;
//
//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
//    private List<Pizza> pizzeZamowienie = new ArrayList<>();
//
//
//    public Zamowienie(Long id, double cenarazem, List<Pizza> pizzeZamowienie) {
//        this.id = id;
//        this.cenarazem = cenarazem;
//        this.pizzeZamowienie = pizzeZamowienie;
//    }
//
//    public Zamowienie(double cenarazem, List<Pizza> pizzeZamowienie) {
//        this.cenarazem = cenarazem;
//        this.pizzeZamowienie = pizzeZamowienie;
//    }
//
//    public Zamowienie() {
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public double getCenarazem() {
//        return cenarazem;
//    }
//
//    public void setCenarazem(double cenarazem) {
//        this.cenarazem = cenarazem;
//    }
//
//    public List<Pizza> getPizzeZamowienie() {
//        return pizzeZamowienie;
//    }
//
//    public void setPizzeZamowienie(List<Pizza> pizzeZamowienie) {
//        this.pizzeZamowienie = pizzeZamowienie;
//    }
//}
