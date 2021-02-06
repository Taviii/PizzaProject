package pl.pjwstk.pizzeria.pizzeria.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjwstk.pizzeria.pizzeria.Exception.KlientException;
import pl.pjwstk.pizzeria.pizzeria.model.Klient;
import pl.pjwstk.pizzeria.pizzeria.repository.KlientRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class KlientServiceTestIT {

    @Autowired
    private  KlientService klientService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KlientRepository klientRepository;

    @Test
    void should() throws KlientException {
        List<Klient>  all = klientService.findAll();
        assertThat(all).isEmpty();
    }
}
