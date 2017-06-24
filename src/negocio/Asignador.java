package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import datos.MateriasJSON;

public class Asignador {
	private ArrayList<Aula> aulas;
	private ArrayList<Materia> materias;
//	private ArrayList<Materia> materiasAgregadas;
	
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
		ArrayList<Integer> indicesRecorridos = new ArrayList<>();
		Aula aula = new Aula();
		aulas.add(aula);
		int indiceAulas = 0;
		
//		while(indicesRecorridos.size() != materias.size()){
		for (int h = 0; h < 5; h++) {
			System.out.println(h);
			for (int i = 0; i < materias.size(); i++) {
//				System.out.println(aulas.get(0).llena());
//				System.out.println(!aulas.get(indiceAulas).llena()+": "+i );
				if(!indicesRecorridos.contains(i) && !aulas.get(indiceAulas).llena()){
					System.out.println("entro al primer if");
					if(aulas.get(indiceAulas).agregarMateria(materias.get(i))){
						indicesRecorridos.add(i);
					}
				}
			}
			if(indicesRecorridos.size() != aulas.size()){
				aulas.add(new Aula(){});
			}
			indiceAulas++;
			
		}
			
//		}
		
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
		System.out.println(asig.aulas.get(2).materias);
		
	}
	
	

}
