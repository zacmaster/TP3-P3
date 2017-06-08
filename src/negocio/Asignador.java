package negocio;

import java.util.ArrayList;

import datos.MateriasJSON;

public class Asignador {
	private ArrayList<Aula> aulas;
	private Materias materias;
	
	public Asignador(String archivo){
		MateriasJSON materiasJSON = new MateriasJSON();
		materiasJSON.leerArchivo(archivo);
	}

}
