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
public class Menu {
//  ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany (mappedBy = "menu")
    private List<Pizze> pizzaList;

    @OneToMany (mappedBy = "menu")
    private List<Drinks> drinkList;

    @OneToMany (mappedBy = "menu")
    private List<Toppings> toppingList;

//    COSTRUTTORE
    public Menu(List<Pizze> pizzaList, List<Drinks> drinkList, List<Toppings> toppingList) {
        this.pizzaList = pizzaList;
        this.drinkList = drinkList;
        this.toppingList = toppingList;
    }

    public Menu() {
        this.pizzaList = new ArrayList<>();
        this.drinkList = new ArrayList<>();
        this.toppingList = new ArrayList<>();
    }

    public void scriviMenu(){
        System.out.println("MENU");
        System.out.println("Pizza");
        pizzaList.forEach(a -> System.out.println(a.getNome() + ": (" + a.getInformazioni() + ") - Calorie: " +  a.getCalorie() + " - Prezzo: " + a.getPrezzo() + "€"));
        System.out.println();
        System.out.println("Condimenti");
        toppingList.forEach(a -> System.out.println(a.getNome() + ": (" + a.getInformazioni() + ") - Calorie: " +  a.getCalorie() + " - Prezzo: " + a.getPrezzo() + "€"));
        System.out.println();
        System.out.println("Drinks");
        drinkList.forEach(a -> System.out.println(a.getNome() + ": (" + a.getInformazioni() + ") - Calorie: " +  a.getCalorie() + " - Prezzo: " + a.getPrezzo() + "€"));
    }
}
