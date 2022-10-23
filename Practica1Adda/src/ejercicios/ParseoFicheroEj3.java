package ejercicios;

import java.util.List;
import java.util.function.Function;

import us.lsi.geometria.Punto2D;
import us.lsi.streams.Stream2;

public record ParseoFicheroEj3(String fichero) {
	
public static List<LineaFichero> listaDeFichero(String fichero){
		
		Function<String,LineaFichero> parseLineaFichero = s -> {
			String [] s2 = s.split(",");
			return LineaFichero.of(Punto2D.of(Double.valueOf(s2[0]), Double.valueOf(s2[1])));
		};
		
	 List<LineaFichero> listaLineaFichero = Stream2.file(fichero)
			.map(parseLineaFichero)
			.toList();
	 
	 return listaLineaFichero;
	
	}

}
