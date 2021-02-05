package pl.pjwstk.pizzeria.pizzeria.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjwstk.pizzeria.pizzeria.Exception.KlientException;
import pl.pjwstk.pizzeria.pizzeria.Exception.PizzaException;
import pl.pjwstk.pizzeria.pizzeria.model.Klient;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.repository.KlientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class KlientServiceTest {

    @Mock
    private KlientRepository klientRepository;

    @Mock
    private Pizza pizza;

    @Mock
    private Klient klient;

    @InjectMocks
    private KlientService klientService;


    @Test
    public void shouldSaveKlient(){
        //given
        Klient klient1 = new Klient(1L,"Maja","maja123@qp.pl","Kawowa 3",new ArrayList<>(List.of(pizza)));
        when(klientRepository.save(klient1)).thenReturn(klient);
        //when
        Klient klient = klientService.save(klient1);
        //then
        verify(klientRepository, times(1)).save(klient1);
        assertThat(klient.getId()).isEqualTo(0);
    }

    @Test
    public  void shouldFindById() throws KlientException{
        //given
        when(klientRepository.findById(1L)).thenReturn(Optional.of(klient));
        //when
        Optional<Klient> klient = klientService.findById(1L);
        //then
        assertThat(klient).isNotEmpty();
    }

    @Test
    public void shouldFindAll() throws KlientException{
        //given
        when(klientRepository.findAll()).thenReturn(List.of(klient));
        //when
        List<Klient> klients = klientService.findAll();
        //then
        assertThat(klients).isNotEmpty();
    }
//    @Test
//    public void shouldShowClientsOrders() throws KlientException {
//        //given
//        when(klientRepository.findById(klient.getId())).thenReturn(Optional.ofNullable(klient));
//        //when
//        List<Klient> zamowieniaKlienta = klientService.findAll();
//        //then
//        assertThat(zamowieniaKlienta).isNotEmpty();
//    }

//    @Test
//    public void shouldKlientDeleteById() throws KlientException, PizzaException {
//        //given
//        klientService.deleteClientById(klient.getId());
//        //when
//        when(klientRepository.findById(klient.getId())).thenReturn(Optional.ofNullable(klient));
//        //then
//        verify(klientRepository, atLeastOnce()).deleteById(klient.getId());
//    }

}
