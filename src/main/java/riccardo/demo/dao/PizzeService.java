package riccardo.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import riccardo.demo.U5W1D5Application;
import riccardo.demo.entities.Menu;
import riccardo.demo.entities.Pizze;

import java.util.List;

@Service
@Slf4j
public class PizzeService {
    @Autowired
    PizzeDAO pizzeDAO;

    public void savePizza(Pizze pizze){
        pizzeDAO.save(pizze);
        log.info("Pizza salvata correttamente");
    }

    public List<Pizze> filterByPrice(double prezzo){
       return pizzeDAO.findByPrezzo(prezzo);
    }
}
