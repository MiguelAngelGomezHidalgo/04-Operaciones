import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * @author MiguelAngelGomezHidalgo 
 *
 */

public class Ventana extends JFrame implements ActionListener {
	// Cajas de texto
	private JTextField txt1 = new JTextField();
	private JTextField txt2 = new JTextField();
	// etiquetas
	private JLabel lb1 = new JLabel("Número 1");
	private JLabel lb2 = new JLabel("Número 2");
	private JLabel lbResultado = new JLabel("Resultado");
	// botones
	private JButton btnSumar = new JButton("+");
	private JButton btnRestar = new JButton("-");
	private JButton btnMultiplicar = new JButton("x");
	private JButton btnDividir = new JButton("÷");

	// Panel
	private Container c = getContentPane();
	// objeto de la clase operaciones
	private Operaciones op = new Operaciones();
	/**
	 * constructor con los atributos de la ventana
	 */

	public Ventana() {
		super.setTitle("Operaciones");
		super.setSize(340, 480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}
/**
 * metodo para agragar los componentes a la ventana
 */
	private void cargarControles() {
		c.setLayout(null);
		lb1.setBounds(10, 10, 300, 30);
		txt1.setBounds(10, 40, 300, 30);
		lb2.setBounds(10, 80, 300, 30);
		txt2.setBounds(10, 110, 300, 30);

		btnSumar.setBounds(10, 150, 60, 35);
		btnRestar.setBounds(90, 150, 60, 35);
		btnMultiplicar.setBounds(170, 150, 60, 35);
		btnDividir.setBounds(250, 150, 60, 35);
		lbResultado.setBounds(10, 190, 300, 30);

		c.add(lb1);
		c.add(txt1);
		c.add(lb2);
		c.add(txt2);
		c.add(btnSumar);
		c.add(btnRestar);
		c.add(btnMultiplicar);
		c.add(btnDividir);
		c.add(lbResultado);
		btnSumar.addActionListener(this);
		btnRestar.addActionListener(this);
		btnMultiplicar.addActionListener(this);
		btnDividir.addActionListener(this);

	}
/**
 * 
 * @param e es un parametro con el cual se puede saber q boton se ha presionado
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		float r;
		JButton opcion = (JButton) e.getSource();

		switch (opcion.getText()) {
		case "+":
			r = op.sumar(Integer.parseInt(txt1.getText()), Integer.parseInt(txt2.getText()));

			lbResultado.setText(String.format("%s + %s = %G", txt1.getText(), txt2.getText(), r));
			break;
		case "-":
			r = op.restar(Integer.parseInt(txt1.getText()), Integer.parseInt(txt2.getText()));

			lbResultado.setText(String.format("%s - %s = %G", txt1.getText(), txt2.getText(), r));

			break;

		case "x":
			r = op.multiplicar(Integer.parseInt(txt1.getText()), Integer.parseInt(txt2.getText()));

			lbResultado.setText(String.format("%s x %s = %G", txt1.getText(), txt2.getText(), r));
			break;
		case "÷":
			r = op.dividir(Integer.parseInt(txt1.getText()), Integer.parseInt(txt2.getText()));

			lbResultado.setText(String.format("%s ÷ %s = %G", txt1.getText(), txt2.getText(), r));
			break;
		default:
			break;
		}

	}
}
