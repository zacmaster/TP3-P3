package interfaz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import negocio.Asignador;

public class Ventana extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	static private final String newline = "\n";
	JFrame frame;
	JMenuBar menuBar;
	JMenu mnNewMenu;
	JMenuItem mntmCargar;
	JMenuItem mntmSalir;
	JFileChooser fc;
	Tabla tabla;
	JTextArea log;
	File file;
	
	public Ventana(){
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Asignador de materias");
		frame.setBounds(100, 100, 800, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
		
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 783, 21);
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmCargar = new JMenuItem("Abrir");
		mntmCargar.setIcon(new ImageIcon(Ventana.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mntmCargar.setSelectedIcon(new ImageIcon(Ventana.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		mntmCargar.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmCargar);
		mntmCargar.addActionListener(this);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Ventana.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnNewMenu.add(mntmSalir);
		mntmSalir.addActionListener(this);
		
		tabla = new Tabla();
		contentPane.add(tabla,BorderLayout.CENTER);
		
		fc = new JFileChooser();
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mntmCargar) {
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
              file = fc.getSelectedFile();
              Asignador asignador = new Asignador();
              if(asignador.leerArchivo(file.toString())){
            	  tabla.limpiarTabla();
            	  asignador.asignar();
            	  tabla.cargarTabla(asignador.getMatrizMaterias());
              }
            }
        } else if (e.getSource() == mntmSalir) {
        	System.exit(0);
        }
	}
	
}
