package pl.pjwstk.pizzeria.pizzeria.service;


import org.springframework.stereotype.Service;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;

import java.util.List;

@Service
public class PizzaService {

    public List<Pizza> findAll(){
        return  List.of(
                new Pizza("Marinara", "mała", "czosnkowy", "cienkie"),
                new Pizza("Cztery Sery", "średnia", "czosnkowy", "średnie"),
                new Pizza("Carbonara", "duża", "pomidorowy", "cienkie"));
    }
}
