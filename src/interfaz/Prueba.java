package interfaz;

import datos.MateriasJSON;
import negocio.Asignador;
import negocio.Materia;

public class Prueba {
	public static void main(String[] args) {
//		Materia m1 = new Materia("Historia", 0, 10, 12);
//		Materia m2= new Materia("Matemática", 0, 12, 16);
//		Materia m3 = new Materia("Lengua", 0, 8, 10);
//		Materias materias = new Materias();
//		materias.agregarMateria(m1);
//		materias.agregarMateria(m2);
//		materias.agregarMateria(m3);
//		MateriasJSON materiasJSON = new MateriasJSON();
//		materiasJSON.escribirArchivo("materias.json", materias.getMaterias());
		Asignador asignador = new Asignador("materias.json");
		System.out.println(asignador.getMaterias().get(0).getNombre());
		asignador.asignar();
		System.out.println(asignador.getMaterias().get(0).getNombre());
		
		
	}

}
