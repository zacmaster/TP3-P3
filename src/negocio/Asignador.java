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
		aulas = new ArrayList<Aula>();
	}
	
	public void asignar(){
		ordenarMateriasPorHorario();
		asignarMaterias(materias);
		
	}
	
	public ArrayList<Aula> getAulas() {
		return aulas;
	}


	public void asignarMaterias(ArrayList<Materia> materias){
		
		ArrayList<Integer> indicesRecorridos = new ArrayList<>();
		Aula aula = new Aula();
		aulas.add(aula);
		int indiceAulas = 0;
		
		while(indicesRecorridos.size() != materias.size()){
			
			for (int i = 0; i < materias.size(); i++) {
				
				if(!indicesRecorridos.contains(i) && !aulas.get(indiceAulas).llena()){
					
					Aula aulaActual = aulas.get(indiceAulas);
					Materia materiaActual = materias.get(i);
					
					if(sePudoagregarMateria(aulaActual, materiaActual)){
						indicesRecorridos.add(i);
					}
				}
			}
			if(indicesRecorridos.size() != materias.size()){
				aulas.add(new Aula(){});
			}
			indiceAulas++;
		}
	}
	
	private boolean sePudoagregarMateria(Aula aula, Materia materia) {
		return aula.agregarMateria(materia);
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
