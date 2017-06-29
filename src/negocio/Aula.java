package negocio;

import java.util.ArrayList;

public class Aula {
	final int numero; 
	public ArrayList<Materia> materias;
	int horasDisponibles;
	int finUltimaMateria;

	public Aula(int numero) {
		this.numero = numero;
		horasDisponibles = 12;
		materias = new ArrayList<Materia>();
		finUltimaMateria = 8;
		
	}

	public int getNumero(){
		return numero;
	}
	//Agrega materia y devuelve un booleano, también modifica las horas disponibles segun la materia agregada
	public boolean agregarMateria(Materia materia) {
		if(materia == null)return false;
		if(materia.duracion <= horasDisponibles && finUltimaMateria <= materia.horaInicio){
			materias.add(materia);
			horasDisponibles -= materia.duracion;
			finUltimaMateria = materia.horaFin; 
			return true;
		}
		return false;
	}
	
	//Si las horas disponibles son cero, entonces el aula está llena
	public boolean llena(){
		return (horasDisponibles == 0)? true:false;
	}

}
