package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import datos.MateriasJSON;

public class Asignador {
	private ArrayList<Aula> aulas;
	private ArrayList<Materia> materias;
	
	public Asignador(String archivo){
		MateriasJSON materiasJSON = new MateriasJSON();
		materiasJSON.leerArchivo(archivo);
		materias= materiasJSON.getMaterias();
		System.out.println(materias.size());
	}
	
	public void asignar(){
		ordenarMateriasPorHorario();
	}
	
	public void ordenarMateriasPorHorario(){
		Collections.sort(materias, new Comparator<Materia>() {
			@Override
			public int compare(Materia m1, Materia m2) {
				return m1.getHoraInicio() - m2.getHoraInicio();
			}
	    });
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	
	

}
