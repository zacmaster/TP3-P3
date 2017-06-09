package negocio;

import static org.junit.Assert.*;
import org.junit.Test;

public class MateriaTest {
	@Test
	public void constructor(){
		String nombre = "Matematica";
		int codigo = 16;
		int horaInicio = 10;
		int horaFin = 12;
		
		Materia materia = new Materia(nombre,codigo, horaInicio,horaFin);
		assertEquals(nombre, materia.getNombre());
		assertEquals(codigo, materia.getCodigo());
		assertEquals(horaInicio, materia.getHoraInicio());
		assertEquals(horaFin, materia.getHoraFin());
	}

}
