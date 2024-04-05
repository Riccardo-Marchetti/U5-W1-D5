package riccardo.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@Setter
@ToString
public class Pizze extends OggettiDelMenu {
//    ATTRIBUTI
    @ManyToOne
    @JoinColumn (name = "menu_id")
    private Menu menu;

    @ManyToMany
    @JoinTable (name = "Pizze_Toppings",
    joinColumns = @JoinColumn (name = "pizze_id"),
    inverseJoinColumns = @JoinColumn (name = "toppings_id"))
    private List<Toppings> toppings;

//    COSTRUTTORE
    public Pizze(String nome, double prezzo, int calorie, String informazioni) {
        super(nome, prezzo, calorie, informazioni);
    }

    public Pizze(String nome, double prezzo, int calorie, String informazioni, List<Toppings> toppings) {
        super(nome, prezzo, calorie, informazioni);
        this.toppings = toppings;
    }

}
