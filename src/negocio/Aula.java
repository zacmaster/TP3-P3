package negocio;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Aula {
	private static final AtomicInteger count = new AtomicInteger(0); 
	final int numero; 
	ArrayList<Materia> materias;
	int horasDisponibles;
	int finUltimaMateria;
	boolean estaLLena;

	public Aula() {
		numero = count.incrementAndGet();
		this.horasDisponibles = 12;
		this.materias = new ArrayList<Materia>();
		this.finUltimaMateria = 8;
		
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
//		horasDisponibles -= materia.duracion;
		finUltimaMateria = materia.horaFin;
	}
	public boolean llena(){
		return (horasDisponibles > 0)? true:false;
	}
//
//	public static void main(String[] args) {
//		Aula a1 = new Aula();
//		Aula a2 = new Aula();
//		System.out.println(a1.numero);
//		System.out.println(a2.numero);
//	}

}
