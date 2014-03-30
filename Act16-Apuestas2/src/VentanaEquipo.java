import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField nomEquipo;
	private JTextField Gfavor;
	private JTextField Gcontra;
	private JTextField Pganados;
	private JTextField Pperdidos;
	private Equipo equipo;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private JComboBox jLiga;
	private boolean modifica;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipo frame = new VentanaEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaEquipo(Equipo equipoAModificar,JComboBox jLiga,boolean modifica){
		equipo = equipoAModificar;//asignacion Equipo
		this.jLiga=jLiga;
		this.modifica=modifica;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreEquipo = new JLabel("Nombre Equipo");
		lblNombreEquipo.setBounds(41, 41, 119, 14);
		contentPane.add(lblNombreEquipo);
		
		JLabel lblDsd = new JLabel("Nombre equipo");
		lblDsd.setBounds(41, 41, 46, 14);
		contentPane.add(lblDsd);
		
		JLabel lblGolesAFavor = new JLabel("Goles a Favor");
		lblGolesAFavor.setBounds(41, 85, 119, 14);
		contentPane.add(lblGolesAFavor);
		
		JLabel lblGolesEnContr = new JLabel("Goles en Contra");
		lblGolesEnContr.setBounds(41, 118, 119, 14);
		contentPane.add(lblGolesEnContr);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados");
		lblPartidosGanados.setBounds(41, 154, 119, 14);
		contentPane.add(lblPartidosGanados);
		
		JLabel lblPartidosPerdidos = new JLabel("Partidos Perdidos");
		lblPartidosPerdidos.setBounds(41, 189, 119, 14);
		contentPane.add(lblPartidosPerdidos);
		
		nomEquipo = new JTextField();
		nomEquipo.setBounds(207, 38, 86, 20);
		contentPane.add(nomEquipo);
		nomEquipo.setColumns(10);
		
		Gfavor = new JTextField();
		Gfavor.setColumns(10);
		Gfavor.setBounds(207, 82, 86, 20);
		contentPane.add(Gfavor);
		
		Gcontra = new JTextField();
		Gcontra.setColumns(10);
		Gcontra.setBounds(207, 115, 86, 20);
		contentPane.add(Gcontra);
		
		Pganados = new JTextField();
		Pganados.setColumns(10);
		Pganados.setBounds(207, 151, 86, 20);
		contentPane.add(Pganados);
		
		Pperdidos = new JTextField();
		Pperdidos.setColumns(10);
		Pperdidos.setBounds(207, 186, 86, 20);
		contentPane.add(Pperdidos);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 guardarEquipo();
				 guardarEnFichero();
				
			}
		});
		btnNewButton.setBounds(110, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton leer = new JButton("Leer");
		leer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pganados.setText(String.valueOf(equipo.getPartidosGanados()));
				Pperdidos.setText(String.valueOf(equipo.getPartidosPerdidos()));
				Gfavor.setText(String.valueOf(equipo.getGolesFavor()));
				Gcontra.setText(String.valueOf(equipo.getGolesContra()));
				nomEquipo.setText(equipo.getNombreEquipo());
				recuperarFichero();
			}
		});
		leer.setBounds(218, 228, 89, 23);
		contentPane.add(leer);
	}

	private void guardarEquipo(){
		equipo.setPartidosGanados(Integer.valueOf(Pganados.getText()));
		equipo.setPartidosPerdidos(Integer.valueOf(Pperdidos.getText()));
		equipo.setGolesFavor(Integer.valueOf(Gfavor.getText()));
		equipo.setGolesContra(Integer.valueOf(Gcontra.getText()));
		equipo.setNombreEquipo(nomEquipo.getText());
		if(!modifica)
			jLiga.addItem(equipo);
		else{
			Equipo equipoElegido=(Equipo)jLiga.getSelectedItem();
			equipoElegido.setNombreEquipo(equipo.getNombreEquipo());
		}
	}
	private void guardarEnFichero(){
		
		try{			
			salida = new ObjectOutputStream(new FileOutputStream("equipo.ser"));
			salida.writeObject(equipo);
			if(salida !=null)
				salida.close();
		}
		catch (IOException ioException){
			System.out.println("Error al abrir el archivo");
		}
	}

	
	private void recuperarFichero(){
		try{
			entrada = new ObjectInputStream(new FileInputStream("equipo.ser"));
			equipo=(Equipo)entrada.readObject();
			if(entrada !=null)
				entrada.close();
		}
		catch(IOException ioException)
		{
			System.out.println("Error al abrir el archivo");
		}
		catch(ClassNotFoundException clException){
			System.out.println("Error al crear la clase");
		}
	}
}
