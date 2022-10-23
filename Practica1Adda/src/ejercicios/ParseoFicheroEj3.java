package ejercicios;

import java.util.List;
import java.util.function.Function;

import us.lsi.common.List2;
import us.lsi.geometria.Punto2D;
import us.lsi.streams.Stream2;

public record ParseoFicheroEj3(String fichero) {
	
public static List<Punto2D> listaDeFichero(String fichero){
		
		Function<String,LineaFichero> parseLineaFichero = s -> {
			String [] s2 = s.split(",");
			return LineaFichero.of(Punto2D.of(Double.valueOf(s2[0]), Double.valueOf(s2[1])));
		};
		
	 List<LineaFichero> listaLineaFichero = Stream2.file(fichero)
			.map(parseLineaFichero)
			.toList();
	 
	 Integer i = 0;
	 List<Punto2D> listaPuntos = List2.empty();
	 while(i<listaLineaFichero.size()) {
		 listaPuntos.add(listaLineaFichero.get(i).puntosLineaFichero());
		 i = i+1;
	 }
	 
	 return listaPuntos;
	
	}

}