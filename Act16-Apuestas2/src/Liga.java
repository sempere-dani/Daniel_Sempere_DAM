import java.io.Serializable;
import java.util.ArrayList;


public class Liga implements Serializable{

	private int numEquipos;
	private String nombreLiga;
	//private Equipo equipos[];
		private ArrayList <Equipo> equipos = new ArrayList <Equipo>();
	
	public Liga (){
	
		nombreLiga = "Liga Española";
		numEquipos = 20;
		 /*equipos = new Equipo[numEquipos];
				for (int i=0;i<numEquipos;i++)
				{
					equipos[i]=new Equipo();
				}*/
		for (int i=0;i<numEquipos;i++)
		equipos.add(new Equipo());
	}
public Liga (int numero, String nombreLiga){
	
	nombreLiga = nombreLiga;
	numEquipos = numero;
	/*equipos = new Equipo[numEquipos];
	
	for (int i=0;i<numEquipos;i++)
	{
		equipos[i]=new Equipo();
	}*/
	for (int i=0;i<numEquipos;i++)
		equipos.add(new Equipo());
	
}

public void  setnombreLiga(String nombre){
	nombreLiga = nombre;
}
public String getnombreLiga(){
	return nombreLiga;
}
public int getnumEquipos(){
	return numEquipos;
	
}

public Equipo getEquipo(int posicion){
	//return equipos[numero];
	return equipos.get(posicion);
}

public void setEquipo (Equipo numero){
	//equipos=numero;
	equipos.get(numEquipos);
}
	public void newEquipo(){
		equipos.add(new Equipo());
		numEquipos++;
	}
	public void deleteEquipo (int posicion){
		equipos.remove(posicion);
}
/*
public int getNumEquipos() {
	return numEquipos;
}
public void setNumEquipos(int numEquipos) {
	this.numEquipos = numEquipos;
}
public String getNombreLiga() {
	return nombreLiga;
}
public void setNombreLiga(String nombreLiga) {
	this.nombreLiga = nombreLiga;
}
public Equipo[] getEquipos() {
	return equipos;
}
public void setEquipos(Equipo[] equipos) {
	this.equipos = equipos;
}
public Equipo getEquipos(Integer valueOf) {
	// TODO Auto-generated method stub
	return null;
}*/


}

