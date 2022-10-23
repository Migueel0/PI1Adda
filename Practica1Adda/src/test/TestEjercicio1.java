package test;

import java.util.function.Function;

import ejercicios.Ejercicio1;
import us.lsi.streams.Stream2;

import java.util.*;

public class TestEjercicio1 {
	
	private static final String fichero1 = "Ficheros/PI1Ej1DatosEntrada.txt";
	
	
	public static void main(String[] args) {
		
		record LineaFichero1(Integer varA, String varB, Integer varC, String varD , Integer varE) {	
			private static LineaFichero1 of(Integer varA,String varB,Integer varC,String varD,Integer varE) {
				return new LineaFichero1(varA,varB,varC,varD,varE);
			}
		}
		
		Function<String,LineaFichero1> parseLineaFichero1 = s -> {
			String [] s2 = s.split(",");
			return LineaFichero1.of(Integer.valueOf(s2[0]), String.valueOf(s2[1]),Integer.valueOf(s2[2]),String.valueOf(s2[3]),Integer.valueOf(s2[4]));
		};
	
		List<LineaFichero1> listaLineaFichero1 = Stream2.file(fichero1)
			.map(parseLineaFichero1)
			.toList();
			
		System.out.println("EJERCICIO 1: \n");
		Integer i = 0;
		while(i<listaLineaFichero1.size()) {
			LineaFichero1 dato = listaLineaFichero1.get(i);
			Integer varA,varC,varE;
			String varB,varD;
			varA = dato.varA();
			varB = dato.varB();
			varC = dato.varC();
			varD = dato.varD();
			varE = dato.varE();
			
			System.out.println("Test funcional "+(i+1)+": "+Ejercicio1.ejercicioA(varA, varB,varC, varD, varE));
			System.out.println("Test iterativo "+(i+1)+": "+Ejercicio1.ejercicioAIterativo(varA, varB,varC, varD, varE));
			System.out.println("Test recursivo "+(i+1)+": "+Ejercicio1.ejercicioARecursivo(varA, varB,varC, varD, varE)+"\n");
			
			i++;
		}
		
		
	}
}