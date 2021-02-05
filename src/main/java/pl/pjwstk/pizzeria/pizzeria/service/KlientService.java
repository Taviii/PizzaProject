package pl.pjwstk.pizzeria.pizzeria.service;


import org.springframework.stereotype.Service;
import pl.pjwstk.pizzeria.pizzeria.Exception.KlientException;
import pl.pjwstk.pizzeria.pizzeria.model.Klient;
//import pl.pjwstk.pizzeria.pizzeria.model.Zamowienie;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.repository.KlientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KlientService {
    private KlientRepository klientRepository;

    public  KlientService() {
        this.klientRepository = klientRepository;
    }

    public KlientService(KlientRepository klientRepository) {
        this.klientRepository =klientRepository;

    }

    public Klient save(Klient klient){
        return klientRepository.save(klient);
    }

    public Optional<Klient> findById(Long id) throws KlientException {
        if (klientRepository.findById(id).isPresent()){
            return klientRepository.findById(id);
        } else {
            throw new KlientException();
        }
    }

    public List<Klient> findAll() throws KlientException {
        if (klientRepository.findAll().size() >=1){
            return klientRepository.findAll();
        } else {
            throw new KlientException();
        }
    }

    public Optional<List<Pizza>> showClientsOrders (long id, Klient klient) throws KlientException {
        Optional<Klient> klientId = klientRepository.findById(id);
        if (klientId.isPresent()) {
            return Optional.ofNullable(klientId.get().getListaZamowien());
        } else {
            throw new KlientException();
        }
    }

    public  void deleteClientById (long id) throws KlientException {
        if (klientRepository.findById(id).isPresent()) {
            klientRepository.deleteById(id);
        } else {
            throw new KlientException();
        }
    }

//    public Klient changeNick (Long id, Klient klientNowyNick) throws  KlientException {
//        if (findById(klientNowyNick.getId()).isPresent()) {
//            return klientRepository.save(klientNowyNick);
//        } else {
//            return null;
//        }
//    }



}
