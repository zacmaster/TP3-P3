package negocio;

import java.util.ArrayList;

public class Materias {
	protected ArrayList<Materia> materias;
	
	public Materias(){
		this.materias = new ArrayList<Materia>();
	}
	
	public void agregarMateria(Materia m){
		materias.add(m);
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	
}
