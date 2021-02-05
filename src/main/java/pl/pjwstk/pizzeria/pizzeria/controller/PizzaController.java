package pl.pjwstk.pizzeria.pizzeria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjwstk.pizzeria.pizzeria.Exception.PizzaException;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.service.PizzaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> findAll() throws PizzaException {
        return ResponseEntity.ok(pizzaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pizza>> findById(@PathVariable long id) {
        Optional<Pizza> byId = pizzaService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Pizza> save(@RequestBody Pizza pizza){
        return ResponseEntity.ok(pizzaService.save(pizza));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable long id) throws PizzaException{
        pizzaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> update(@RequestBody Pizza pizza, @PathVariable long id){
        return ResponseEntity.ok(pizzaService.update(id, pizza));
    }

    @GetMapping("/lessExpensive/{cena}")
    public ResponseEntity<List<Pizza>> showLessExpensive(@PathVariable double cena){
        return ResponseEntity.ok(PizzaService.showLessExpensive(cena));
    }

    @GetMapping("/moreExpensive/{cena}")
    public ResponseEntity<List<Pizza>> showMoreExpensive(@PathVariable double cena){
        return ResponseEntity.ok(PizzaService.showMoreExpensive(cena));
    }

}
