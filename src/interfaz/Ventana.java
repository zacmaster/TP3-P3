package interfaz;


import javax.swing.JFrame;


public class Ventana {
	JFrame frame;
	public Ventana(){
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Al sum de la biblioteca");
		frame.setBounds(100, 100, 600, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	}
}
