package riccardo.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Drinks extends OggettiDelMenu {

    @ManyToOne
    @JoinColumn (name = "menu_id")
    private Menu menu;
//  COSTRUTTORE
    public Drinks(String nome, double prezzo, int calorie, String informazioni) {
        super(nome, prezzo, calorie, informazioni);
    }
}
