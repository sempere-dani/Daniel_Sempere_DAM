import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private JTextField nomLiga;
	private JTextField numEquipo;
	private Liga liga;
	private Equipo equipo;
	private JFrame frameEquipo;
	private JComboBox <Equipo> comboBox;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLiga frame = new VentanaLiga();
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
	public VentanaLiga(Liga ligaModificar) {
		liga=ligaModificar;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreLiga = new JLabel("Nombre Liga");
		lblNombreLiga.setBounds(51, 36, 105, 14);
		contentPane.add(lblNombreLiga);
		
		JLabel lblNumeroEquipos = new JLabel("Numero Equipos");
		lblNumeroEquipos.setBounds(206, 36, 105, 14);
		contentPane.add(lblNumeroEquipos);
		
		JLabel lblEquipoAModificar = new JLabel("Equipos");
		lblEquipoAModificar.setBounds(46, 124, 105, 14);
		contentPane.add(lblEquipoAModificar);
		
		nomLiga = new JTextField();
		nomLiga.setBounds(46, 73, 86, 20);
		contentPane.add(nomLiga);
		nomLiga.setColumns(10);
		
		numEquipo = new JTextField();
		numEquipo.setEnabled(false);
		numEquipo.setText("0");
		numEquipo.setColumns(10);
		numEquipo.setBounds(206, 73, 86, 20);
		contentPane.add(numEquipo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEquipoWindow(liga.getEquipo(comboBox.getSelectedIndex()),true);
				//VentanaEquipo frameEquipo = new VentanaEquipo(liga.getEquipo(Integer.valueOf(modificar.getText())));
				//frameEquipo.setVisible(true);
				//frameEquipo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
			}
		});
		btnModificar.setBounds(190, 187, 89, 23);
		contentPane.add(btnModificar);
		
		comboBox = new JComboBox<Equipo>();
		comboBox.setBounds(34, 149, 122, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liga.newEquipo();
				openEquipoWindow(liga.getEquipo(liga.getnumEquipos()-1),false);
			}
		});
		btnNewButton_1.setBounds(10, 187, 55, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		button.setBounds(96, 187, 55, 23);
		contentPane.add(button);
		
		
	}
	private void openEquipoWindow(Equipo equipo, boolean modifica)
	{
		frameEquipo = new VentanaEquipo(equipo,this.comboBox,modifica);
		frameEquipo.setVisible(true);
		frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
