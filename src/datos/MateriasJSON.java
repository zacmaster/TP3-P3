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

public class MateriasJSON {
	ArrayList<Materia> materias;
	MateriasJSON(){
		materias = null;
	}
	
	public void escribirArchivo(String archivo,ArrayList<Materia> empleados){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(empleados);
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

}


