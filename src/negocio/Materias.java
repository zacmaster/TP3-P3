package negocio;

import java.util.ArrayList;

public class Materias {
	private ArrayList<Materia> materias;
	
	public Materias(){
		this.materias = new ArrayList<Materia>();
	}
	
	public void agregarMateria(Materia m){
		materias.add(m);
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	
}
