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

public class MateriasJSON{
	private ArrayList<Materia> materias;
	public MateriasJSON(){
		materias = null;
	}
	//Escribe archivo JSON
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
	//Lee archivo JSON
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
}


