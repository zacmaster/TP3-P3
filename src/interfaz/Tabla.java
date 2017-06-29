package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable _tabla;
	private String[] _nombreColumnas = {"Aula","Materia","Codigo","Inicio","Fin"};
	private DefaultTableModel _model;
	
	
	public Tabla(){
		super(new GridLayout(1,0));
		
		_model = new DefaultTableModel(null, _nombreColumnas);
		
		_tabla = new JTable(_model);
		_tabla .setPreferredScrollableViewportSize(new Dimension(500,300));
		_tabla.setFillsViewportHeight(true);
		
		
		JScrollPane scrollPane = new JScrollPane(_tabla);
		add(scrollPane);
	}
	
	public void cargarTabla(Object[][] rows){
		for (Object[] row : rows) {
			_model.addRow(row);
		}
	}
	//Limpia la tabla
	public void limpiarTabla(){
		_model.setRowCount(0);
	}
	public void setTableBounds(int x, int y, int width,int height){
		_tabla.setBounds(x, y, width, height);
	}
	
}
