import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Principal extends JFrame {

	private JPanel contentPane;
	protected JButton btnNewButton;
	protected JTextField textField;
	protected JLabel lblNewLabel;
	protected JLabel lblContrasea;
	protected JButton btnCargarProductos;
	protected JButton btnSalir;
	protected JButton btnNewButton_1;
	SegundaVentaa ventana;
	protected JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.btnNewButton = new JButton("Ingreso");
			this.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// NO SE USAR EL JPASSWORD
					
					
					if(textField.getText().toLowerCase().equals("admin") && textField_1.getText().toLowerCase().equals("admin"))
					{
						btnSalir.setVisible(true);
						btnCargarProductos.setVisible(true);
						btnNewButton.setEnabled(false);
					
					}
					
									
				
				
				}
			});
			this.btnNewButton.setBounds(148, 133, 89, 23);
			this.contentPane.add(this.btnNewButton);
		}
		{
			this.textField = new JTextField();
			this.textField.setBounds(148, 58, 86, 20);
			this.contentPane.add(this.textField);
			this.textField.setColumns(10);
		}
		{
			this.lblNewLabel = new JLabel("Usuario");
			this.lblNewLabel.setBounds(97, 61, 46, 14);
			this.contentPane.add(this.lblNewLabel);
		}
		{
			this.lblContrasea = new JLabel("Contraseña");
			this.lblContrasea.setBounds(97, 92, 46, 14);
			this.contentPane.add(this.lblContrasea);
		}
		{
			this.btnCargarProductos = new JButton("Cargar productos");
			this.btnCargarProductos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ventana = new SegundaVentaa();
					ventana.setVisible(true);
					
					
				}
			});
			btnCargarProductos.setVisible(false);
			this.btnCargarProductos.setBounds(134, 167, 125, 23);
			this.contentPane.add(this.btnCargarProductos);
		}
		{
			this.btnSalir = new JButton("Salir");
			this.btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textField.setText(null);
					textField_1.setText(null);
					if(ventana!=null) 
					{
						ventana.dispose();
						btnCargarProductos.setVisible(false);
						btnNewButton.setEnabled(true);
						btnSalir.setVisible(false);
						//SE ROMPIO EL PROGRAMA, ESTO SUPUESTAMENTE ESTA BIEN
					}
					/*textField.setText(null);
					textField_1.setText(null);
					if(ventana!= null) 
					{
						ventana.dispose();
						btnCargarProductos.setVisible(false);
						btnNewButton.setEnabled(true);
						btnSalir.setVisible(false);
					}*/
					
				}
			});
			btnSalir.setVisible(false);
			this.btnSalir.setBounds(148, 201, 89, 23);
			this.contentPane.add(this.btnSalir);
		}
		{
			this.btnNewButton_1 = new JButton("Cerrar");
			this.btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
			this.btnNewButton_1.setBounds(335, 227, 89, 23);
			this.contentPane.add(this.btnNewButton_1);
		}
		{
			this.textField_1 = new JTextField();
			this.textField_1.setColumns(10);
			this.textField_1.setBounds(151, 89, 86, 20);
			this.contentPane.add(this.textField_1);
		}
	}
}
