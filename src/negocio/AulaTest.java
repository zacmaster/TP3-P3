package negocio;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

public class AulaTest {	
	Aula aula = new Aula(1);
	
	
	@Test
	public void MateriasSize() {
		assertEquals(0,aula.materias.size());
		aula.agregarMateria(new Materia("Matematica",16, 10,12){});
		assertEquals(1,aula.materias.size());
	}
	
	@Test
	public void aulaLlena(){
		Aula a1 = new Aula(1);
		assertFalse(a1.llena());
		a1.agregarMateria(new Materia("A", 0, 8, 12));
		a1.agregarMateria(new Materia("B", 0, 13, 17));
		a1.agregarMateria(new Materia("C", 0, 18, 22));
		System.out.println(a1.horasDisponibles);
		assertTrue(a1.llena());
	}
	@Test
	public void agregarMateria(){
		Materia m1 = new Materia("A", 00, 8, 12);
		Materia m2 = new Materia("B", 00, 13, 17);
		Materia m3 = new Materia("C", 00, 18, 20);
		Materia m4 = new Materia("A", 00, 20, 23);
		aula.agregarMateria(m1);
		aula.agregarMateria(m2);
		aula.agregarMateria(m3);
		assertFalse(aula.agregarMateria(m4));
		assertEquals(3, aula.materias.size());
	}

}
