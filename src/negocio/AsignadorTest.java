package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class AsignadorTest {
	Asignador _asignador;
	ArrayList<Materia> _materias;
	@Before
	public void construir(){
		  _asignador = new Asignador();
		  _materias = materias();
	}
	
	
	@Test
	public void asignar(){
		_asignador.setMateriasPrueba();
		_asignador.asignar();
		assertEquals(2, _asignador.getAulas().size());
		
	}
	@Test (expected = NullPointerException.class)
	public void asignarSinCargarMaterias(){
		_asignador.asignar();
	}

	@Test (expected = NullPointerException.class)
	public void archivoNull(){
		_asignador.leerArchivo(null);
	}
	
	@Test
	public void leerArchivo(){
		assertFalse(_asignador.leerArchivo("imagen.jpg"));
		assertTrue(_asignador.leerArchivo("materias.json"));
	}
	
	
	private ArrayList<Materia> materias() {
		ArrayList<Materia> materias = new ArrayList<>();
		Materia m1 = new Materia("Matematica", 0, 8, 12);
		Materia m2 = new Materia("Matematica 2", 1, 13, 17);
		Materia m3 = new Materia("Matematica 3", 2, 18, 22);
		Materia m4 = new Materia("Matematica 4", 3, 8, 12);
		materias.add(m1);
		materias.add(m2);
		materias.add(m3);
		materias.add(m4);
		return materias;
	}
}
