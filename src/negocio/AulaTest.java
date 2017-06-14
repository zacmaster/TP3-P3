package negocio;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AulaTest {
	Aula aula = new Aula();
	
	@Test
	public void constructor(){
		assertEquals(2, aula.numero);
	}
	
	@Test
	public void MateriasSize() {
		assertEquals(0,aula.getMaterias().size());
		aula.agregarMateria(new Materia("Matematica",16, 10,12){});
		assertEquals(1,aula.getMaterias().size());
	}

}
