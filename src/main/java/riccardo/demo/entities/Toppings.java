package riccardo.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Toppings extends OggettiDelMenu {

    @ManyToOne
    @JoinColumn (name = "menu_id")
    private Menu menu;

    @ManyToMany (mappedBy = "toppings")
    private List<Pizze> pizze = new ArrayList<>();

//    COSTRUTTORE
    public Toppings(String nome, double prezzo, int calorie, String informazioni) {
        super(nome, prezzo, calorie, informazioni);
    }

}
