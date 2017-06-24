package negocio;

public class Materia{
	String nombre;
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}

	int codigo;
	int horaInicio;
	int horaFin;
	int duracion;
	
	public Materia(String nombre, int codigo, int horaInicio, int horaFin) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.duracion = horaFin - horaInicio;
	}
	
	public String getNombre() {
		return nombre;
	}


	public int getCodigo() {
		return codigo;
	}


	public int getHoraInicio() {
		return horaInicio;
	}


	public int getHoraFin() {
		return horaFin;
	}

	@Override
	public String toString() {
		return "["+nombre+"("+horaInicio+","+horaFin+")]";
	}
	


}
