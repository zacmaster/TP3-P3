package datos;

	

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import negocio.Materia;
import negocio.Materias;

public class MateriasJSON {
	private ArrayList<Materia> materias;
	public MateriasJSON(){
		materias = null;
	}
	
	public void escribirArchivo(String archivo,ArrayList<Materia> materias){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(materias);
		try{
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		}
		catch (Exception ex){}
	}
	
	public void leerArchivo(String archivo){
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			Type tipoObjeto = new TypeToken<ArrayList<Materia>>(){}.getType();
			materias = gson.fromJson(br, tipoObjeto);
			
		} catch (Exception e) {}
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}
//	public static void main(String[] args) {
//		Materia m1 = new Materia("Historia", 0, 10, 12);
//		Materia m2= new Materia("Matemática", 0, 12, 16);
//		Materia m3 = new Materia("Lengua", 0, 8, 10);
//		Materias materias = new Materias();
//		materias.agregarMateria(m1);
//		materias.agregarMateria(m2);
//		materias.agregarMateria(m3);
//		MateriasJSON materiasJSON = new MateriasJSON();
//		materiasJSON.escribirArchivo("materias.json", materias.getMaterias());
//	}
}


