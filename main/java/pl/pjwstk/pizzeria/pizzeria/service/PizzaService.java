package pl.pjwstk.pizzeria.pizzeria.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.repository.PizzaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequestMapping("/pizzas")
public class PizzaService {

    private static PizzaRepository pizzaRepository;


    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> findAll(){
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> findById(long id){
//        List<Pizza> pizzas = new ArrayList<>();
//        pizzas.add(new Pizza(1L,"Marinara", "mała", "czosnkowy", "cienkie"));
//        pizzas.add(new Pizza(2L,"Cztery Sery", "średnia", "czosnkowy", "średnie"));
//        pizzas.add(new Pizza( 3L,"Carbonara", "duża", "pomidorowy", "cienkie"));
//
//        return pizzas.stream().filter(pizza -> pizza.getId() == id).findFirst();
//        for (Pizza pizza: pizzas) {
//            if (pizza.getId()==id){
//                return pizza;
//            }
//        }
//        return  new Pizza();
        return pizzaRepository.findById(id);
    }

    public Pizza save(Pizza pizza){
        return  pizzaRepository.save(pizza);
    }

    public void deleteById(Long id){
        pizzaRepository.deleteById(id);
    }

    public Pizza update(long id, Pizza updatedPizza){
        updatedPizza.setId(id);
        return pizzaRepository.save(updatedPizza);

    }
//        if ( findById(updatedPizza.getId()).isPresent()) {
//            return pizzaRepository.save(updatedPizza);
//        } else {
//            return null;
//        }
//
//    }
    public static List<Pizza> showLessExpensive(double cena){
        List<Pizza> pizzaLista = pizzaRepository.findAll();
        return pizzaLista.stream().filter(pizza -> pizza.getCena() < cena).collect(Collectors.toList());
    }

    public static List<Pizza> showMoreExpensive(double cena){
        List<Pizza> pizzaLista = pizzaRepository.findAll();
        return pizzaLista.stream().filter(pizza -> pizza.getCena() > cena).collect(Collectors.toList());
    }
}
