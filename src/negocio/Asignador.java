package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import datos.MateriasJSON;

public class Asignador {
	private ArrayList<Aula> aulas;
	private ArrayList<Materia> materias;
	private ArrayList<Materia> materiasAgregadas;
	
	public Asignador(String archivo){
		MateriasJSON materiasJSON = new MateriasJSON();
		materiasJSON.leerArchivo(archivo);
		materias= materiasJSON.getMaterias();
		aulas = new ArrayList<Aula>();
	}
	
	public void asignar(){
		ordenarMateriasPorHorario();
		asignarMaterias(materias);
		
	}
	
	public void asignarMaterias(ArrayList<Materia> materias){
		int indiceMateria = 0;
		aulas.add(new Aula(){});
		for (Materia materia : materias) {
			if(aulas.get(indiceMateria).finUltimaMateria <=  materia.horaInicio ){
				aulas.get(indiceMateria).agregarMateria(materia);
			}
			else{
				aulas.add(new Aula(){});
				
			}
		}
		
		for (Materia materia : aulas.get(0).materias) {
			System.out.println(materia);
		}
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
	public static void main(String[] args) {
		Asignador asig = new Asignador("materias.json");
		asig.asignar();
	}
	
	

}
