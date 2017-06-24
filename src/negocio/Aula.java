package negocio;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Aula {
	private static final AtomicInteger count = new AtomicInteger(0); 
	final int numero; 
	ArrayList<Materia> materias;
	int horasDisponibles;
//	int finUltimaMateria;

	public Aula() {
		numero = count.incrementAndGet();
		this.horasDisponibles = 12;
		this.materias = new ArrayList<Materia>();
//		this.finUltimaMateria = 8; //el aula esta disponible a partir de las 8
		
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

	public boolean agregarMateria(Materia materia) {
		if(materia.duracion <= horasDisponibles){
			materias.add(materia);
			horasDisponibles -= materia.duracion;
//			finUltimaMateria = materia.horaFin;
			return true;
		}
		return false;
	}
	
	public boolean llena(){
		return (horasDisponibles == 0)? true:false;
	}
//	public static void main(String[] args) {
//		Aula aula = new Aula();
//		System.out.println(aula.llena());
//		Materia m1 = new Materia("A", 00, 8, 12);
//		Materia m2 = new Materia("B", 00, 13, 17);
//		Materia m3 = new Materia("C", 00, 18, 20);
//		Materia m4 = new Materia("A", 00, 20, 23);
//		aula.agregarMateria(m1);
//		aula.agregarMateria(m2);
//		aula.agregarMateria(m3);
//		aula.agregarMateria(m4);
//		System.out.println(aula.materias);
//		
//		
//	}

}
