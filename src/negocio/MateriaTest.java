package negocio;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

public class MateriaTest {
	Materia _materia;
	
	@Before
	public void constructor(){
		_materia = new Materia("Matematica",16, 10,12);
	}
	
	@Test
	public void testConstructor(){
		assertEquals("Matematica", _materia.nombre);
		assertEquals(16, _materia.codigo);
		assertEquals(10, _materia.horaInicio);
		assertEquals(12, _materia.horaFin);
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
