package negocio;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AulaTest {	
	Aula _aula;
	Aula _aulaNull;
	
	@Before
	public void construirAulas(){
		_aula = new Aula(1);
	}
	
	
	@Test
	public void MateriasSize() {
		assertEquals(0,_aula.materias.size());
		_aula.agregarMateria(new Materia("Matematica",16, 10,12){});
		assertEquals(1,_aula.materias.size());
	}
	
	@Test 
	public void agregarMateriaNull(){
		assertFalse(_aula.agregarMateria(null));
	}
	
	@Test
	public void agregarMateriaLargaDuracion(){
		Materia materia = new Materia("A", 00, 8, 23);
		assertFalse(_aula.agregarMateria(materia));
	}
	
	@Test
	public void aulaLlena(){
		assertFalse(_aula.llena());
		llenarAula();
		assertTrue(_aula.llena());
	}
	@Test
	public void superPonerMateria(){
		llenarAula();
		Materia materia = new Materia("A", 00, 8, 2);
		assertFalse(_aula.agregarMateria(materia));
		assertEquals(3, _aula.materias.size());
	}
	
	private void llenarAula(){
		_aula.agregarMateria(new Materia("A", 0, 8, 12));
		_aula.agregarMateria(new Materia("B", 0, 13, 17));
		_aula.agregarMateria(new Materia("C", 0, 18, 22));
	}
}
