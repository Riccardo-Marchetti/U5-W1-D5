package riccardo.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class OggettiDelMenu {
    //  ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected String nome;

    protected double prezzo;

    protected int calorie;

    protected String informazioni;
    @ManyToOne
    @JoinColumn (name = "ordine_id")
    private Ordine ordine;

    //  COSTRUTTORE
    public OggettiDelMenu(String nome, double prezzo, int calorie, String informazioni) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
        this.informazioni = informazioni;
    }

}
