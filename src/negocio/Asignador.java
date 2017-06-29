package negocio;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import datos.MateriasJSON;

public class Asignador {
	private ArrayList<Aula> aulas;
	private ArrayList<Materia> materias;
	private MateriasJSON materiasJSON;
	public Asignador(){
		aulas = new ArrayList<Aula>();
		materiasJSON = new MateriasJSON();
	}
	
	
	public boolean leerArchivo(String archivo){
		if(esJSON(archivo)){
			materiasJSON.leerArchivo(archivo);
			materias= materiasJSON.getMaterias();
			return true;
		}
		return false;
	}
	
	
	public void asignar(){
		ordenarMateriasPorHorario();
		asignarMaterias(materias);
		
	}
	
	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	private boolean esJSON(String archivo){
		Pattern pattern = Pattern.compile("[\\w\\d]{1,25}\\.json");
		Matcher matcher = pattern.matcher(archivo);
		return (matcher.matches() ? true : false);
		
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
	private int cantidadMaterias(){
		int cantidad =  0;
		for (Aula aula : aulas) {
			cantidad += aula.materias.size(); 
		}
		return cantidad;
	}
	public String[][] getMatrizMaterias(){
		if(aulas != null){
			int cantidadMaterias = cantidadMaterias();
			int contador = 0;
			final int cantidadColumnas = 5;
			String[][] matriz = new String[cantidadMaterias][cantidadColumnas];
			for (int i = 0; i < aulas.size(); i++) {
				for (int j = 0; j < aulas.get(i).materias.size(); j++) {
					matriz[contador][0] = aulas.get(i).numero + "";
					for (int j2 = 1; j2 < cantidadColumnas; j2++) {
						if(j2 == 1)matriz[contador][j2] = aulas.get(i).materias.get(j).nombre;
						if(j2 == 2)matriz[contador][j2] = aulas.get(i).materias.get(j).codigo + "";
						if(j2 == 3)matriz[contador][j2] = aulas.get(i).materias.get(j).horaInicio + "";
						if(j2 == 4)matriz[contador][j2] = aulas.get(i).materias.get(j).horaFin + "";
					}
					contador++;
				}
			}
			return matriz;
		}
		return null;
	}

}
