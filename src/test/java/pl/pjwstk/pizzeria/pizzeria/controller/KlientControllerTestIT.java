package pl.pjwstk.pizzeria.pizzeria.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjwstk.pizzeria.pizzeria.model.Klient;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;
import pl.pjwstk.pizzeria.pizzeria.repository.KlientRepository;
import pl.pjwstk.pizzeria.pizzeria.service.KlientService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class KlientControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KlientService klientService;

    @MockBean
    private KlientRepository klientRepository;



    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAllClients() throws Exception{
        Klient klient = new Klient();
        List<Klient> klientList = new ArrayList<>();
        List<Pizza> pizzaList = new ArrayList<>();
        klientList.add(new Klient(1L,"Maja","maja123@qp.pl","Kawowa 3", pizzaList));

        when(klientRepository.findAll()).thenReturn(klientList);
        mockMvc.perform(get("/klienci"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1L,\"name\":\"Kaja\",\"mail\":\"kaja123@wp.pl\",\"adres\":\"Kosowa 3\",\"pizzaList\":[]}")));
    }

    @Test
    void showClientsOrders() {
    }

    @Test
    void delete() {
    }
}