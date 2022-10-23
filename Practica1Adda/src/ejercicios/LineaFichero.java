package ejercicios;

import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public record LineaFichero(Punto2D puntosLineaFichero) {
	
	public static LineaFichero of(Punto2D puntosLineaFichero) {
		return new LineaFichero(puntosLineaFichero);
	}
	
	public boolean predicado() {
		return puntosLineaFichero.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntosLineaFichero.getCuadrante() == Cuadrante.TERCER_CUADRANTE;
		
	}
	
}
