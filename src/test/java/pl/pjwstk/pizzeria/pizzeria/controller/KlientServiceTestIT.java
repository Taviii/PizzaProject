package pl.pjwstk.pizzeria.pizzeria.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjwstk.pizzeria.pizzeria.Exception.KlientException;
import pl.pjwstk.pizzeria.pizzeria.model.Klient;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.repository.KlientRepository;
import pl.pjwstk.pizzeria.pizzeria.service.KlientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class KlientServiceTestIT {

    @Autowired
    private KlientService klientService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KlientRepository klientRepository;

//    @Test
//    void shouldFindById() throws Exception{
//        List<Pizza> pizzaList = new ArrayList<>();
//        Optional<Klient> klient = Optional.of(new Klient(1L, "Kaja", "kaja123@wp.pl", "Kosowa 3", pizzaList));
//
//        Mockito.when(klientRepository.findById(klient.get().getId())).thenReturn(klient);
//        mockMvc.perform(get("/klienci/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("{\"id\":1L,\"name\":\"Kaja\",\"mail\":\"kaja123@wp.pl\",\"adres\":\"Kosowa 3\",\"pizzaList\":[]}")));
//    }

//    @Test
//    void shouldFindAll() throws Exception{
//        Klient klient = new Klient();
//        List<Klient> klientList = new ArrayList<>();
//        List<Pizza> pizzaList = new ArrayList<>();
//        klientList.add(new Klient(1L,"Maja","maja123@qp.pl","Kawowa 3", pizzaList));
//
//        when(klientRepository.findAll()).thenReturn(klientList);
//        mockMvc.perform(get("/klienci"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("{\"id\":1L,\"name\":\"Kaja\",\"mail\":\"kaja123@wp.pl\",\"adres\":\"Kosowa 3\",\"pizzaList\":[]}")));

//@Test
//    void shouldNotFindAnyone() throws Exception {
//    Klient klient = new Klient();
//    List<Klient> klientList = new ArrayList<>();
//
//    when(klientRepository.findAll()).thenReturn(klientList);
//    mockMvc.perform(get("/klienci"))
//            .andExpect(status().isNotFound())
//            .andExpect(content().string(equalTo("Brak klienta")));
//
//}

    @Test
    void shouldBeEmpty() throws KlientException {
        List<Klient> all = klientService.findAll();
        assertThat(all).isEmpty();
    }

}

