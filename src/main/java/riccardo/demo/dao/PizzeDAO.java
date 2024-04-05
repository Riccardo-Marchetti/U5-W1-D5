package riccardo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardo.demo.entities.Pizze;

import java.util.List;

@Repository
public interface PizzeDAO extends JpaRepository<Pizze, Long> {

    List<Pizze> findByPrezzo(double prezzo);
}
