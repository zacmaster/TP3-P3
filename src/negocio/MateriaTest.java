package negocio;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MateriaTest {
	Materia _materia = constructor();
	
	
	public Materia constructor(){
		String nombre = "Matematica";
		int codigo = 16;
		int horaInicio = 10;
		int horaFin = 12;
		return new Materia(nombre,codigo, horaInicio,horaFin);
	}
	
	@Test
	public void testConstructor(){
		assertEquals("Matematica", _materia.getNombre());
		assertEquals(16, _materia.getCodigo());
		assertEquals(10, _materia.getHoraInicio());
		assertEquals(12, _materia.getHoraFin());
	}
	 
	@Test
	public void testDuracion(){
		assertEquals(2, _materia.duracion);
	}
	@Test
	public void testToSting(){
		Pattern pattern = Pattern.compile("\\[\\w{1,30}\\(\\d{2}\\,\\d{2}\\)\\]");
		Matcher matcher = pattern.matcher(_materia.toString());
		assertTrue(matcher.matches());
	}
	
	
	

}
