package negocio;

import java.util.ArrayList;

public class Aula {
	private int numero; 
	private ArrayList<Materia> materias;

	public Aula(int numero) {
		this.numero = numero;
		this.materias = new ArrayList<Materia>();
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}
//	public String verMaterias(){
//		if(!materias.equals(null)){
//			for (Materia materia : materias) {
//				System.out.println(materia.getNombre()+" ");
//			}
//		}
//		return null;
//	}
	public int getNumero(){
		return numero;
	}

	public void agregarMateria(Materia materia) {
		materias.add(materia);
	}

	

}
