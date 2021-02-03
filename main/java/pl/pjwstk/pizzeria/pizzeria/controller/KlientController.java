package pl.pjwstk.pizzeria.pizzeria.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjwstk.pizzeria.pizzeria.Exception.KlientException;
import pl.pjwstk.pizzeria.pizzeria.model.Klient;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.service.KlientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/klienci")
public class KlientController {


    private KlientService klientService;

    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping("/{klientId}")
    public ResponseEntity<Optional<Klient>> findById(@PathVariable long klientId) throws KlientException {
        Optional<Klient> findById = klientService.findById(klientId);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wszyscyKlienci")
    public  ResponseEntity<List<Klient>> findAllClients() throws KlientException {
        return ResponseEntity.ok(klientService.findAll());
    }

    @GetMapping("/{klientId}/zamowieniaKlienta")
    public ResponseEntity<Optional<List<Pizza>>> showClientsOrders(@RequestBody Klient klient, @PathVariable long klientId) throws KlientException{
        return ResponseEntity.ok(klientService.showClientsOrders(klientId, klient));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable long id) throws KlientException {
        klientService.deleteClientById(id);
        return ResponseEntity.ok().build();
    }
}
