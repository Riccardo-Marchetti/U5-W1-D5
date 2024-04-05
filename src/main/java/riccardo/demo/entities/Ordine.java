package riccardo.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import riccardo.demo.enums.StatoOrdine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany (mappedBy = "ordine")
    private List<OggettiDelMenu> oggettiDelMenu;

    private int numeroOrdine;

    @OneToOne (mappedBy = "ordine")
    private Tavolo tavolo;

    @Enumerated (EnumType.STRING)
    private StatoOrdine statoOrdine;

    private int numeroCoperti;

    private LocalDateTime localTime;

    private double importoTotale;

    public Ordine( int numeroOrdine, Tavolo tavolo, StatoOrdine statoOrdine, int numeroCoperti, LocalDateTime localTime) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.statoOrdine = statoOrdine;
        this.numeroCoperti = numeroCoperti;
        this.localTime = localTime;
        this.oggettiDelMenu = new ArrayList<>();
    }

    public void aggiungiElementoMenu(OggettiDelMenu elemento) {
        this.oggettiDelMenu.add(elemento);
    }
    public double prezzoCoperti(@Value("${prezzo.coperto}") double coperto){
        return coperto;
    }
    public double prezzoTotale(){
        return this.oggettiDelMenu.stream().mapToDouble(OggettiDelMenu::getPrezzo).sum() + (this.prezzoCoperti(2) * this.numeroCoperti);
    }

}
