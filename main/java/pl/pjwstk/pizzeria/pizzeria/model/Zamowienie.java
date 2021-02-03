package pl.pjwstk.pizzeria.pizzeria.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zamowienia")
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
//    private List<Pizza> pizzaZamowienie = new ArrayList<>();

}
