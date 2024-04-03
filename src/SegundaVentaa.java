import java.awt.EventQueue;
import java.util.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SegundaVentaa extends JFrame {

	private JPanel contentPane;
	protected JScrollPane scrollPane;
	protected JTable table;
	protected JTextField textField;
	protected JTextField textField_1;
	protected JTextField textField_2;
	protected JTextField textField_3;
	protected JTextField textField_4;
	protected JLabel lblNewLabel;
	protected JLabel lblMarca;
	protected JLabel lblNombreProduto;
	protected JLabel lblStock;
	protected JLabel lblStock_1;
	protected JButton btnNewButton;
	protected JButton btnQuitar;
	protected JButton btnModificar;
	protected JButton btnGuardar;
	protected JButton btnLeer;
	protected HashSet<Productos> lista = new HashSet<>();
	protected JButton btnNewButton_1;
	protected JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SegundaVentaa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 340);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.scrollPane = new JScrollPane();
			this.scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					
				}
			});
			this.scrollPane.setBounds(10, 11, 397, 109);
			this.contentPane.add(this.scrollPane);
			{
				this.table = new JTable();
				this.table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int casilla = table.getSelectedRow();
						textField.setText(table.getValueAt(casilla, 0).toString());
						textField_1.setText(table.getValueAt(casilla, 1).toString());
						textField_2.setText(table.getValueAt(casilla, 2).toString());
						textField_3.setText(table.getValueAt(casilla, 3).toString());
						textField_4.setText(table.getValueAt(casilla, 4).toString());
						
					}
				});
				this.table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null},
						{null, null, null, null, null},
					},
					new String[] {
						"Codigo", "Marca", "Nombre Producto", "Precio", "Stock"
					}
				));
				this.scrollPane.setViewportView(this.table);
			}
		}
		{
			this.textField = new JTextField();
			this.textField.setBounds(70, 131, 86, 20);
			this.contentPane.add(this.textField);
			this.textField.setColumns(10);
		}
		{
			this.textField_1 = new JTextField();
			this.textField_1.setColumns(10);
			this.textField_1.setBounds(70, 162, 86, 20);
			this.contentPane.add(this.textField_1);
		}
		{
			this.textField_2 = new JTextField();
			this.textField_2.setColumns(10);
			this.textField_2.setBounds(70, 193, 86, 20);
			this.contentPane.add(this.textField_2);
		}
		{
			this.textField_3 = new JTextField();
			this.textField_3.setColumns(10);
			this.textField_3.setBounds(70, 224, 86, 20);
			this.contentPane.add(this.textField_3);
		}
		{
			this.textField_4 = new JTextField();
			this.textField_4.setColumns(10);
			this.textField_4.setBounds(231, 131, 86, 20);
			this.contentPane.add(this.textField_4);
		}
		{
			this.lblNewLabel = new JLabel("Codigo");
			this.lblNewLabel.setBounds(10, 134, 46, 14);
			this.contentPane.add(this.lblNewLabel);
		}
		{
			this.lblMarca = new JLabel("Marca");
			this.lblMarca.setBounds(14, 165, 46, 14);
			this.contentPane.add(this.lblMarca);
		}
		{
			this.lblNombreProduto = new JLabel("Nombre produto");
			this.lblNombreProduto.setBounds(10, 196, 46, 14);
			this.contentPane.add(this.lblNombreProduto);
		}
		{
			this.lblStock = new JLabel("Precio");
			this.lblStock.setBounds(10, 227, 46, 14);
			this.contentPane.add(this.lblStock);
		}
		{
			this.lblStock_1 = new JLabel("Stock");
			this.lblStock_1.setBounds(177, 134, 46, 14);
			this.contentPane.add(this.lblStock_1);
		}
		{
			this.btnNewButton = new JButton("Agregar");
			this.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int c = Integer.parseInt(textField.getText()) ;
					String marca = textField_1.getText();
					String np = textField_2.getText();
					double pr = Double.parseDouble(textField_3.getText());
					int s = Integer.parseInt(textField_4.getText()) ;
					
					
					Productos p = new Productos(c,marca,np,pr,s);
					if(lista.contains(p)) 
					{
						JOptionPane.showMessageDialog(rootPane, "El produto ya existe!");
						lista.remove(p);
					}
					lista.add(p);
					MostrarTabla();
					Limpiar();
					
				}
			});
			this.btnNewButton.setBounds(177, 192, 89, 23);
			this.contentPane.add(this.btnNewButton);
		}
		{
			this.btnQuitar = new JButton("Quitar");
			this.btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int casilla = table.getSelectedRow();
					int c = (int) table.getValueAt(casilla, 0);
					String m = table.getValueAt(casilla, 1).toString();
					String np = table.getValueAt(casilla, 2).toString();
					double d = (double) (table.getValueAt(casilla, 3));
					int stock = (int) table.getValueAt(casilla, 4);
					
					Productos p = new Productos(c,m,np,d,stock);
					lista.remove(p);
					MostrarTabla();
					Limpiar();
					
				}
			});
			this.btnQuitar.setBounds(177, 223, 89, 23);
			this.contentPane.add(this.btnQuitar);
		}
		{
			this.btnModificar = new JButton("Modificar");
			this.btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int casilla = table.getSelectedRow();
					int c = (int) table.getValueAt(casilla, 0);
					String m = table.getValueAt(casilla, 1).toString();
					String np = table.getValueAt(casilla, 2).toString();
					double d = (double) (table.getValueAt(casilla, 3));
					int stock = (int) table.getValueAt(casilla, 4);
					
					Productos p = new Productos(c,m,np,d,stock);
					if(lista.contains(p)) 
					{
						lista.remove(p);
						p.setCodigo(Integer.parseInt(textField.getText()));
						p.setMarca(textField_1.getText());
						p.setNombreProducto(textField_2.getText());
						p.setPrecio(Double.parseDouble(textField_3.getText()));
						p.setStock(Integer.parseInt(textField_4.getText()));
					}
					lista.add(p);
					MostrarTabla();
					Limpiar();
					
					
				}
			});
			this.btnModificar.setBounds(276, 192, 89, 23);
			this.contentPane.add(this.btnModificar);
		}
		{
			this.btnGuardar = new JButton("Guardar");
			this.btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						Guardar();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			this.btnGuardar.setBounds(276, 223, 89, 23);
			this.contentPane.add(this.btnGuardar);
		}
		{
			this.btnLeer = new JButton("Leer");
			this.btnLeer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						Leer();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			this.btnLeer.setBounds(231, 161, 89, 23);
			this.contentPane.add(this.btnLeer);
		}
		{
			this.btnNewButton_1 = new JButton("Cargar 100 productos");
			this.btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					CargarP(lista);
					MostrarTabla();
					
				}
			});
			this.btnNewButton_1.setBounds(197, 257, 155, 23);
			this.contentPane.add(this.btnNewButton_1);
		}
		{
			this.btnNewButton_2 = new JButton("Cerrar app");
			this.btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
			this.btnNewButton_2.setBounds(10, 267, 89, 23);
			this.contentPane.add(this.btnNewButton_2);
		}
	}
	private void MostrarTabla() 
	{
		Object [] [] aux = new Object[lista.size()][5];
		int i = 0;
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Productos p = (Productos) iterator.next();
			aux[i][0] = p.getCodigo();
			aux[i][1] = p.getMarca();
			aux[i][2] = p.getNombreProducto();
			aux[i][3] = p.getPrecio();
			aux[i][4] = p.getStock();
			i++;
		}
		String [] col = {"Codigo", "Marca", "Nombre Producto", "Precio", "Stock"};
		table.setModel(new DefaultTableModel(aux,col));
		table.setAutoCreateRowSorter(true);
	}
	private void Limpiar() 
	{
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
	}
	public void Leer() throws IOException, ClassNotFoundException 
	{
		String archivo = "archivo.txt";
		try 
		{
			FileInputStream input = new FileInputStream(archivo);
			ObjectInputStream input2 = new ObjectInputStream(input);
			var arr = (Object[])input2.readObject();
			for(Object c: arr) 
			{
				Productos p1 = ((Productos)c);
				lista.add(p1);
			}
			MostrarTabla();
		}
		catch(FileNotFoundException ex) 
		{
			JOptionPane.showMessageDialog(btnLeer, ex.getMessage());
		}
	}
	private void Guardar() throws IOException 
	{
		String archivo = "archivo.txt";
		try 
		{
			FileOutputStream out = new FileOutputStream(archivo);
			ObjectOutputStream outO = new ObjectOutputStream(out);
			outO.writeObject(lista.toArray());
			lista.clear();
			MostrarTabla();
		}
		catch(FileNotFoundException ex) 
		{
			JOptionPane.showMessageDialog(btnGuardar, ex.getMessage());
		}
	}
	private void CargarP(HashSet<Productos> lista) 
	{
		for (int i = 0; i < 100; i++) {
			
			Productos p = new Productos(i,"Marca"+ i,"NombreP" + i, i*2, i*5 );
			lista.add(p);
			
		}
	}
	
	
}
