package riccardo.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import riccardo.demo.entities.*;
import riccardo.demo.enums.StatoOrdine;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	private static final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D5Application.class);
	@Test
	public void verificaLunghezzaListaTavoli(){
		int lunghezza = ((List<Tavolo>) ctx.getBean("ListaTavoli")).size();
		assertEquals(4, lunghezza);
	}

	@Test
	public void verificaPrezzoCopertoOrdine(){
		Tavolo tavolo = ((Tavolo) ctx.getBean("Tavolo4"));
		Ordine ordine = new Ordine(6, tavolo, StatoOrdine.INCORSO, 3, LocalDateTime.of(2024, 3, 4, 12, 30, 0, 0));
		double sommaCoperto = ordine.prezzoCoperti(2) * ordine.getNumeroCoperti();
		assertEquals(6, sommaCoperto);
	}
	@Test
	public void verificaPrezzoPizzeMenu(){
		double a = ((List<Pizze>) ctx.getBean("ListaPizze")).stream().mapToDouble(Pizze::getPrezzo).sum();
		assertEquals(21, a);
	}
	@Test
	public void calcolo(){
		Tavolo tavolo = ((Tavolo) ctx.getBean("Tavolo4"));
		List<Pizze> pizze = ((List<Pizze>) ctx.getBean("ListaPizze"));
		List<Drinks> drinks = (List<Drinks>) ctx.getBean("ListaDrinks");
		Ordine ordine = new Ordine(6, tavolo, StatoOrdine.INCORSO, 3, LocalDateTime.of(2024, 3, 4, 12, 30, 0, 0));
		ordine.aggiungiElementoMenu(pizze.get(1));
		ordine.aggiungiElementoMenu(pizze.get(2));
		ordine.aggiungiElementoMenu(pizze.get(0));
		ordine.aggiungiElementoMenu(drinks.get(1));
		ordine.aggiungiElementoMenu(drinks.get(2));
		ordine.aggiungiElementoMenu(drinks.get(0));
		double calorie = pizze.stream().mapToDouble(Pizze::getCalorie).sum();
		assertEquals(2320, calorie);
	}
	@Test
	public void verificaPrezzoTotale(){
		Tavolo tavolo = ((Tavolo) ctx.getBean("Tavolo4"));
		List<Pizze> pizze = ((List<Pizze>) ctx.getBean("ListaPizze"));
		List<Drinks> drinks = (List<Drinks>) ctx.getBean("ListaDrinks");
		Ordine ordine = new Ordine(6, tavolo, StatoOrdine.INCORSO, 3, LocalDateTime.of(2024, 3, 4, 12, 30, 0, 0));
		ordine.aggiungiElementoMenu(pizze.get(1));
		ordine.aggiungiElementoMenu(pizze.get(2));
		ordine.aggiungiElementoMenu(pizze.get(0));
		ordine.aggiungiElementoMenu(drinks.get(1));
		ordine.aggiungiElementoMenu(drinks.get(2));
		ordine.aggiungiElementoMenu(drinks.get(0));
		double result = ordine.prezzoTotale();
		assertEquals(36, result);
	}
	@ParameterizedTest
	@CsvSource({"salsaDiPomodoro, 25", "mozzarella, 230" , "salaminoPiccante, 120"})
	void verificaCalorieTopping(String nomeTopping, int calorie){
		Toppings toppings =  ctx.getBean(nomeTopping, Toppings.class);
		assertEquals(calorie, toppings.getCalorie());
	}
	@ParameterizedTest
	@CsvSource({"pizzaMargherita, 6.00", "pizzaProsciutto, 7.50" , "pizzaSalamino, 7.50"})
	void verificaPrezzoPizze(String nomePizza, double prezzo){
		Pizze pizze = ctx.getBean(nomePizza, Pizze.class);
		assertEquals(prezzo, pizze.getPrezzo());
	}
}
