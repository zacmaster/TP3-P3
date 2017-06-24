package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class Ejemplo {
	

	private JFrame frmAsignadorDeMaterias;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo window = new Ejemplo();
					window.frmAsignadorDeMaterias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejemplo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String[] columnNames ={	"Aula",
								"Materia",
								"Inicio",
								"Fin"};
		
		Object[][] data ={
				
		};
		frmAsignadorDeMaterias = new JFrame();
		frmAsignadorDeMaterias.setTitle("Asignador de Aulas");
		frmAsignadorDeMaterias.setBounds(100, 100, 799, 600);
		frmAsignadorDeMaterias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsignadorDeMaterias.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 783, 21);
		frmAsignadorDeMaterias.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCargar = new JMenuItem("Abrir");
		mntmCargar.setIcon(new ImageIcon(Ejemplo.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mntmCargar.setSelectedIcon(new ImageIcon(Ejemplo.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		mntmCargar.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmCargar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Ejemplo.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnNewMenu.add(mntmSalir);
		
		table = new JTable(data,columnNames);
		table.setBounds(10, 32, 763, 518);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
		frmAsignadorDeMaterias.getContentPane().add(table);
	}
}
