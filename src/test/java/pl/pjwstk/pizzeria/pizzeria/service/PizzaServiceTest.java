package pl.pjwstk.pizzeria.pizzeria.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjwstk.pizzeria.pizzeria.Exception.PizzaException;
import pl.pjwstk.pizzeria.pizzeria.model.Klient;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.repository.PizzaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {

    @Mock
    private PizzaRepository pizzaRepository;

    @Mock
    private Pizza pizza;

    @Mock
    private Klient klient;

    @InjectMocks
    private PizzaService pizzaService;


    @BeforeEach
    public void setUpBefore() {
        pizza = new Pizza("Meksyk", "S","pomidorowy","grube",13.20, klient);
    }

    public List<Pizza> makeNewListaZamowien() {
        Pizza pizza1 = new Pizza("Neapoli", "M", "ostry","hot-dog",15.50, klient);
        Pizza pizza2 = new Pizza("Cztery Sery", "XL", "czosnkowy","serowe brzegi",20.90, klient);
        Pizza pizza3 = new Pizza("Formicetta", "L", "pomidorowy","hot-dog",18.50, klient);
    List<Pizza> listaZamowien = new ArrayList<>();
        listaZamowien.add(pizza1);
        listaZamowien.add(pizza2);
        listaZamowien.add(pizza3);
    return listaZamowien;
    }

    @Test
    public void shouldFindAll() throws PizzaException {
        //given
        when(pizzaRepository.findAll()).thenReturn(List.of(new Pizza()));
        //when
        List<Pizza> newListaZamowien = pizzaService.findAll();
        //then
        assertThat(newListaZamowien).isNotEmpty();
    }
//    @Test
//    void shouldFindAllException(){
//        assertThat(pizzaRepository.findAll().size()).isEqualTo(0);
//        assertThatExceptionOfType(PizzaException.class).isThrownBy(() -> pizzaService.findAll());
//    }

    @Test
    public void shouldFindById() throws PizzaException{
        //given
        when(pizzaRepository.findById(1L)).thenReturn(Optional.of(pizza));
        //when
        Optional<Pizza> pizza = pizzaService.findById(1L);
        //then
        assertThat(pizza).isNotEmpty();
    }

//    @Test
//    public void shouldFindByIdPizzaException(){
//        assertThatExceptionOfType(PizzaException.class).isThrownBy(() -> pizzaService.findById(pizza.getId()));
//    }

//    @Test
//    public void shouldSavePizza(){
//        //given
//        Pizza pizza3 = new Pizza("Formicetta", "L", "pomidorowy","hot-dog",18.50, klient);
//        //when
//        when(pizzaRepository.save(pizza3)).thenReturn(pizza);
//        Pizza pizza = pizzaService.save(pizza3);
//        //then
//        verify(pizzaRepository, times(1)).save(pizza3);
//        assertThat(pizza.getId()).isEqualTo(2);
//    }



}
