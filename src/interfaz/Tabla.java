package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JPanel{
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	private JTable tabla;
	private String[] nombreColumnas = {"Aula","Materia","Codigo","Inicio","Fin"};
	private DefaultTableModel model;
	
	
	public Tabla(){
		super(new GridLayout(1,0));
		
		model = new DefaultTableModel(null, nombreColumnas);
		
		tabla = new JTable(model);
		tabla .setPreferredScrollableViewportSize(new Dimension(500,300));
		tabla.setFillsViewportHeight(true);
		
		if(DEBUG){
			tabla.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					printDebugData(tabla);
				}
			});
		}
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		add(scrollPane);
	}
	
	 private void printDebugData(JTable table) {
	        int numRows = table.getRowCount();
	        int numCols = table.getColumnCount();
	        javax.swing.table.TableModel model = table.getModel();

	        System.out.println("Value of data: ");
	        for (int i=0; i < numRows; i++) {
	            System.out.print("    row " + i + ":");
	            for (int j=0; j < numCols; j++) {
	                System.out.print("  " + model.getValueAt(i, j));
	            }
	            System.out.println();
	        }
	        System.out.println("--------------------------");
    }
	 
	public void cargarTabla(Object[][] rows){
		for (Object[] row : rows) {
			model.addRow(row);
		}
	}
	public void setTableBounds(int x, int y, int width,int height){
		tabla.setBounds(x, y, width, height);
	}
	
}
