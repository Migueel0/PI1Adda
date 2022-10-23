package ejercicios;

import us.lsi.geometria.*;
import us.lsi.geometria.Punto2D.Cuadrante;

import java.util.*;

import us.lsi.common.*;


public class Ejercicio3 {
	
	

	public static List<Punto2D> ejercicio3Iterativo(List<LineaFichero> fichero1,List<LineaFichero> fichero2){
			List<Punto2D> ac = List2.empty();
			Iterator<LineaFichero>it1 = fichero1.iterator();
			Iterator<LineaFichero>it2 = fichero2.iterator();
			while(it1.hasNext() || it2.hasNext()) {
				if(it1.hasNext()) {
					Punto2D puntoA = it1.next().puntosLineaFichero();
					if(puntoA.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoA.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
						ac.add(puntoA);
					}
				}else{
					Punto2D puntoB = it2.next().puntosLineaFichero();
					if(puntoB.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoB.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
						ac.add(puntoB);
					}				
				}
				
				ac.sort(new Comparator<Punto2D>() {
				    public int compare(Punto2D o1, Punto2D o2) {
				        return o1.compareTo(o2);
				    }
				});
			}
			return ac;
	}
	
	public static List<Punto2D> ejercicio3Recursivo(List<LineaFichero> fichero1,List<LineaFichero> fichero2){
		List<Punto2D> ac = List2.empty();
		List<LineaFichero> ficheroA = List2.empty();
		List<LineaFichero> ficheroB = List2.empty();
		ficheroA.addAll(fichero1);
		ficheroB.addAll(fichero2);
		
		return ejercicio3Recursivo(ac,ficheroA,ficheroB);
	}
	
	private static List<Punto2D> ejercicio3Recursivo(List<Punto2D> ac,List<LineaFichero> fichero1,List<LineaFichero> fichero2){
		
		Iterator<LineaFichero> it1 = fichero1.iterator();
		Iterator<LineaFichero> it2 = fichero2.iterator();
		if(it1.hasNext()) {
			Punto2D puntoA = it1.next().puntosLineaFichero();
			if(puntoA.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoA.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			ac.add(puntoA);
			}
			fichero1.remove(0);
			ac = ejercicio3Recursivo(ac,fichero1,fichero2);
		}else if(it2.hasNext()) {
			Punto2D puntoB = it2.next().puntosLineaFichero();
			if(puntoB.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoB.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			ac.add(puntoB);
			}
			fichero2.remove(0);
			ac = ejercicio3Recursivo(ac,fichero1,fichero2);
			
		}
		
		ac.sort(new Comparator<Punto2D>() {
		   public int compare(Punto2D o1, Punto2D o2) {
		        return o1.compareTo(o2);
		    }
		});
	
		return ac;
		
	}
	
	public static List<Punto2D> ejercicio3Funcional(List<LineaFichero> fichero1,List<LineaFichero> fichero2){	
		
		
		Iterator<LineaFichero> it1 = fichero1.iterator();
		Iterator<LineaFichero> it2 = fichero2.iterator();
		
		List<Punto2D> ac = List2.empty();
		
		it1.forEachRemaining(x ->{
			if(LineaFichero.of(x.puntosLineaFichero()).predicado()) {
				ac.add(x.puntosLineaFichero());
			}
			
		});
		
		it2.forEachRemaining(x ->{
			if(LineaFichero.of(x.puntosLineaFichero()).predicado()) {
				ac.add(x.puntosLineaFichero());
			}
			
		});
		
		Collections.sort(ac);
		
		return ac;
	}
	
	}
	