package riccardo.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import riccardo.demo.enums.Stato;
@Entity
@Getter
@Setter
@ToString
public class Tavolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numero;

    private int numeroCopertiMassimo;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @OneToOne
    private Ordine ordine;

    public Tavolo(int numero, int numeroCopertiMassimo, Stato stato) {
        this.numero = numero;
        this.numeroCopertiMassimo = numeroCopertiMassimo;
        this.stato = stato;
    }


}
