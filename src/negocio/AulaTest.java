package negocio;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AulaTest {
	@Test
	public void constructor(){
		int numero = 1;
		Aula aula = new Aula(numero);
		assertEquals(numero, aula.getNumero());
	}
	
	@Test
	public void MateriasSize() {
		Aula aula = new Aula(1);
		assertEquals(0,aula.getMaterias().size());
//		Materia materia = new Materia("Matematica",16, 10,12);
//		Materia materia = new Materia("Matematica",16, 10,12);
		aula.agregarMateria(new Materia("Matematica",16, 10,12){});
		assertEquals(1,aula.getMaterias().size());
//		assertNull(aula.getMaterias());
	}

}
