import java.io.Serializable;


public class Equipo implements Serializable{
	
private String nombreEquipo;
private int golesFavor;
private int golesContra;
private int partidosGanados;
private int partidosPerdidos;

public  Equipo (String nom,int golesF, int golesC, int partidosG, int partidosP){
	nombreEquipo = "Valencia";
	golesFavor = 4;
	golesContra = 1;
	partidosGanados = 2;
	partidosPerdidos =  3;
}

public Equipo (){
	nombreEquipo = "Valencia";
	golesFavor = 4;
	golesContra = 1;
	partidosGanados = 2;
	partidosPerdidos =  3;
}

public String getNombreEquipo() {
	return nombreEquipo;
}

public void setNombreEquipo(String nombreEquipo) {
	this.nombreEquipo = nombreEquipo;
}

public int getGolesFavor() {
	return golesFavor;
}

public void setGolesFavor(int golesFavor) {
	this.golesFavor = golesFavor;
}

public int getGolesContra() {
	return golesContra;
}

public void setGolesContra(int golesContra) {
	this.golesContra = golesContra;
}

public int getPartidosGanados() {
	return partidosGanados;
}

public void setPartidosGanados(int partidosGanados) {
	this.partidosGanados = partidosGanados;
}

public int getPartidosPerdidos() {
	return partidosPerdidos;
}

public void setPartidosPerdidos(int partidosPerdidos) {
	this.partidosPerdidos = partidosPerdidos;
}

}
