package ejercicios;

import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public record LineaFichero(Punto2D puntosLineaFichero) {
	
	public static LineaFichero of(Punto2D puntosLineaFichero) {
		return new LineaFichero(puntosLineaFichero);
	}
	
}
