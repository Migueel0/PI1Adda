package test;

import java.util.List;

import ejercicios.Ejercicio3;
import ejercicios.LineaFichero;
import ejercicios.ParseoFicheroEj3;


public class TestEjercicio3 {

	
	public static void main(String [] args) {
		
		System.out.println("EJERCICIO 3: \n\n");
		
		Integer i =1;
		while(i<=3) {
			List<Punto2D> fichero1 = ParseoFicheroEj3.listaDeFichero("Ficheros/PI1Ej3DatosEntrada" + i + "A.txt");
			List<Punto2D> fichero2 = ParseoFicheroEj3.listaDeFichero("Ficheros/PI1Ej3DatosEntrada" + i + "B.txt");
		
			System.out.println("Test"+ i+ ":\nLos siguientes "+Ejercicio3.ejercicio3Funcional(fichero1, fichero2).size()+" puntos:\n");
			System.out.println("Test Iterativo" +(i)+":\n"+Ejercicio3.ejercicio3Iterativo(fichero1, fichero2)+"\n");
			System.out.println("Test Recursivo" +(i)+":\n"+Ejercicio3.ejercicio3Recursivo(fichero1, fichero2)+"\n");
			System.out.println("Test Funcional" +(i)+":\n"+Ejercicio3.ejercicio3Funcional(fichero1, fichero2)+ "\n\n");
			i++;
			}
			
			
		}

	}

