package negocio;

public class Aula {
	private Materias materias = null;

	public Aula(Materias materias) {
		this.materias = materias;
	}

	public Materias getMaterias() {
		return materias;
	}
	public String verMaterias(){
		if(!materias.equals(null)){
			for (Materia materia : materias.materias) {
				System.out.println(materia.getNombre()+" ");
			}
		}
		return null;
	}

	

}
