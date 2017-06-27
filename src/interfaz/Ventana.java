package interfaz;


import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import negocio.Asignador;


public class Ventana {
	JFrame frame;
	public Ventana(){
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Asignador de materias");
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 783, 21);
		contentPane.add(menuBar, BorderLayout.NORTH);
		
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
		
		Tabla tabla = new Tabla();
		Asignador asignador = new Asignador("materias.json");
		asignador.asignar();
		tabla.cargarTabla(asignador.getMatrizMaterias());
//		System.out.println(asignador.getMatrizMaterias()[1][0]);
		contentPane.add(tabla,BorderLayout.CENTER);
		
		
		
		
		
		
	}
}
