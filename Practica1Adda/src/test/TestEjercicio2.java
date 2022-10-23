package test;

import java.util.function.Function;

import ejercicios.Ejercicio2;
import us.lsi.streams.Stream2;

import java.util.*;

public class TestEjercicio2 {
	
	private static final String fichero2 = "Ficheros/PI1Ej2DatosEntrada.txt";

	public static void main(String[] args) {
		

		record LineaFichero2(Integer a, Integer b, String s) {
			private static LineaFichero2 of(Integer a, Integer b, String s) {
				return new LineaFichero2(a,b,s);
			}
		}
		
		Function<String,LineaFichero2> parseLineaFichero2 = s -> {
			String [] s2 = s.split(",");
			return LineaFichero2.of(Integer.valueOf(s2[0]),Integer.valueOf(s2[1]), String.valueOf(s2[2]));
		};
		
		
		List<LineaFichero2> listaLineaFichero2 = Stream2.file(fichero2)
				.map(parseLineaFichero2)
				.toList();
		
		
		 Integer i = 0;
			System.out.println("EJERCICIO 2: \n");
			while(i<listaLineaFichero2.size()) {
				LineaFichero2 dato = listaLineaFichero2.get(i);
				Integer a,b;
				String s;
				a = dato.a();
				b = dato.b();
				s = dato.s();
				
				System.out.println("Test Recursivo no final "+(i+1)+ ": "+Ejercicio2.ejercicioBRecursivoNoFinal(a, b, s));
				System.out.println("Test Recursivo final "+(i+1)+ ":    "+Ejercicio2.ejercicioBRecursivoFinal(a, b, s));
				System.out.println("Test iterativo "+(i+1)+ ":          "+Ejercicio2.ejercicioBIterativo(a, b, s));
				System.out.println("Test funcional "+(i+1)+ ":          "+Ejercicio2.ejercicioBFuncional(a, b, s)+ "\n");
				i++;
			}

	}

}
