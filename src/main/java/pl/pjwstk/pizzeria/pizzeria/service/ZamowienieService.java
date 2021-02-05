//package pl.pjwstk.pizzeria.pizzeria.service;
//
//
//import org.springframework.stereotype.Service;
//import pl.pjwstk.pizzeria.pizzeria.Exception.ZamowienieException;
//import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
//import pl.pjwstk.pizzeria.pizzeria.model.Zamowienie;
//import pl.pjwstk.pizzeria.pizzeria.repository.ZamowienieRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ZamowienieService {
//
//    private final ZamowienieRepository zamowienieRepository;
//
//    public ZamowienieService(ZamowienieRepository zamowienieRepository) {
//        this.zamowienieRepository = zamowienieRepository;
//    }
//
//    public List<Zamowienie> findAll() throws ZamowienieException {
//        if (zamowienieRepository.findAll().size() > 0){
//            return zamowienieRepository.findAll();
//        } else {
//            throw new ZamowienieException();
//        }
//    }
//
//    public Optional<Zamowienie> findById(Long id) throws ZamowienieException{
//        if (zamowienieRepository.findById(id).isPresent()){
//            return zamowienieRepository.findById(id);
//        } else {
//            throw new ZamowienieException();
//        }
//    }
//
//    public void deleteById(Long id) throws ZamowienieException{
//        if (zamowienieRepository.findById(id).isPresent()){
//            zamowienieRepository.deleteById(id);
//        } else {
//            throw  new ZamowienieException();
//        }
//    }
//
//    public Optional<List<Pizza>> showOrderedPizza(Long id, Zamowienie zamowienie) throws ZamowienieException {
//        Optional<Zamowienie> zamowienieId = zamowienieRepository.findById(id);
//        if (zamowienieId.isPresent()) {
//            return  Optional.ofNullable(zamowienieId.get().getPizzeZamowienie());
//        } else {
//            throw new ZamowienieException();
//        }
//    }
//
//
//}
