package interfaz;

import java.awt.BorderLayout;
import java.awt.Container;
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
import javax.swing.SwingConstants;

import negocio.Asignador;

public class Ventana extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	JFrame _frame;
	JMenuBar _barraMenu;
	JMenu _menu;
	JMenuItem _menuAbrir;
	JMenuItem _menuSalir;
	JFileChooser _fc;
	Tabla _tabla;
	File _file;
	
	public Ventana(){
		initialize();
	}
	private void initialize() {
		_frame = new JFrame();
		_frame.setTitle("Asignador de materias");
		_frame.setBounds(100, 100, 800, 300);
		_frame.setResizable(false);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = _frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		
		_barraMenu = new JMenuBar();
		_barraMenu.setBounds(0, 0, 783, 21);
		contentPane.add(_barraMenu, BorderLayout.NORTH);
		
		_menu = new JMenu("Archivo");
		_barraMenu.add(_menu);
		
		_menuAbrir = new JMenuItem("Abrir");
		_menuAbrir.setIcon(new ImageIcon(Ventana.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		_menuAbrir.setSelectedIcon(new ImageIcon(Ventana.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		_menuAbrir.setHorizontalAlignment(SwingConstants.LEFT);
		_menu.add(_menuAbrir);
		_menuAbrir.addActionListener(this);
		
		_menuSalir = new JMenuItem("Salir");
		_menuSalir.setIcon(new ImageIcon(Ventana.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		_menu.add(_menuSalir);
		_menuSalir.addActionListener(this);
		
		_tabla = new Tabla();
		contentPane.add(_tabla,BorderLayout.CENTER);
		
		_fc = new JFileChooser();
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _menuAbrir) {
            int returnVal = _fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
              _file = _fc.getSelectedFile();
              Asignador asignador = new Asignador();
              if(asignador.leerArchivo(_file.toString())){
            	  _tabla.limpiarTabla();
            	  asignador.asignar();
            	  _tabla.cargarTabla(asignador.getMatrizMaterias());
              }
            }
        } else if (e.getSource() == _menuSalir) {
        	System.exit(0);
        }
	}
	
}
