
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Equipo equipo = new Equipo ("",0,0,0,0);
		//Equipo equipo2 = new Equipo ();
		
		Liga liga = new Liga();
		
		VentanaLiga frame = new VentanaLiga (liga);
				frame.setVisible(true);
		
		//VentanaEquipo frame = new VentanaEquipo (equipo);
		//frame.setVisible(true);
		
		
		
	}

}
