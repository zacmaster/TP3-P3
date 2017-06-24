package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import negocio.Aula;



public class Tabla extends JPanel{
	
	private static final long serialVersionUID = 1L;



	public Tabla(ArrayList<Aula> aulas){
		super(new GridLayout(1,0));
		
		String[] nombreColumnas = {"Aula",
                "Materia",
                "Codigo",
                "Inicio",
                "Fin"};
		
		JTable tabla = new JTable(llenarData(aulas), nombreColumnas);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabla.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(tabla);

        add(scrollPane);
        
	}
	
	
	private Object[][] llenarData(ArrayList<Aula> aulas){
	    	
	    	int filas = 0;
	    	final int columnas = 5;
	    	int indiceFila = 0;
	    	for(Aula aula: aulas){
	    		filas += aula.materias.size();
	    	}
	    	Object[][] objetos = new Object[filas][columnas];
	    	
	    	for (int i = 0; i < aulas.size(); i++) {
	    		
	    		for (int j = 0; j < aulas.get(i).materias.size(); j++) {
	    			
	    			objetos[indiceFila][0] = aulas.get(i).getNumero();
	    			
	    			for (int j2 = 1; j2 < columnas; j2++) {
	    				if(j2 == 1)objetos[indiceFila][j2] = aulas.get(i).materias.get(j).getNombre(); 
	    				if(j2 == 2)objetos[indiceFila][j2] = aulas.get(i).materias.get(j).getCodigo(); 
	    				if(j2 == 3)objetos[indiceFila][j2] = aulas.get(i).materias.get(j).getHoraInicio(); 
	    				if(j2 == 4)objetos[indiceFila][j2] = aulas.get(i).materias.get(j).getHoraFin(); 
					}
	    			indiceFila++;
				}
			}
			return objetos;
	    }
}
