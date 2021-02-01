package pl.pjwstk.pizzeria.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjwstk.pizzeria.pizzeria.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
