package test;

import java.util.List;
import java.util.function.Function;
import ejercicios.Ejercicio4;
import us.lsi.streams.Stream2;

public class TestEjercicio4 {


		private static final String fichero4 = "Ficheros/PI1Ej4DatosEntrada.txt";

		public static void main(String[] args) {
			

			record LineaFichero4(Integer a, Integer b, Integer c) {
				private static LineaFichero4 of(Integer a, Integer b, Integer c) {
					return new LineaFichero4(a,b,c);
				}
			}
			
			Function<String,LineaFichero4> parseLineaFichero2 = s -> {
				String [] s2 = s.split(",");
				return LineaFichero4.of(Integer.valueOf(s2[0]),Integer.valueOf(s2[1]), Integer.valueOf(s2[2]));
			};
			
			
			List<LineaFichero4> listaLineaFichero2 = Stream2.file(fichero4)
					.map(parseLineaFichero2)
					.toList();
			
			
			 Integer i = 0;
				System.out.println("EJERCICIO 2: \n");
				while(i<listaLineaFichero2.size()) {
					LineaFichero4 dato = listaLineaFichero2.get(i);
					Integer a,b,c;
					a = dato.a();
					b = dato.b();
					c = dato.c();
					
					System.out.println("Test Recursivo sin memoria "+(i+1)+ ": "+Ejercicio4.ejercicio4RecursivoSinMemoria(a, b, c));
					System.out.println("Test Recursivo con memoria "+(i+1)+ ": "+Ejercicio4.ejercicio4RecursivoConMemoria(a, b, c));
					System.out.println("Test Recursivo iterativo "+(i+1)+ ":   "+Ejercicio4.ejercicio4Iterativo(a, b, c)+ "\n\n");
					i++;
				}

		

	}

}
