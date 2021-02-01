package pl.pjwstk.pizzeria.pizzeria.service;


import org.springframework.stereotype.Service;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.repository.PizzaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    public PizzaRepository pizzaRepository;

    private PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> findAll(){
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> findById(long id){
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza(1L,"Marinara", "mała", "czosnkowy", "cienkie"));
        pizzas.add(new Pizza(2L,"Cztery Sery", "średnia", "czosnkowy", "średnie"));
        pizzas.add(new Pizza( 3L,"Carbonara", "duża", "pomidorowy", "cienkie"));

        return pizzas.stream().filter(pizza -> pizza.getId() == id).findFirst();
//        for (Pizza pizza: pizzas) {
//            if (pizza.getId()==id){
//                return pizza;
//            }
//        }
//        return  new Pizza();
    }

    public Pizza save(Pizza pizza){
        return  pizzaRepository.save(pizza);
    }
}
