package negocio;

public class Materia{
	private String nombre;
	private int codigo;
	private int horaInicio;
	private int horaFin;
	
	public Materia(String nombre, int codigo, int horaInicio, int horaFin) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
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


}
