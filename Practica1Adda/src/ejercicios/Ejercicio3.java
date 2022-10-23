package ejercicios;

import us.lsi.geometria.*;
import us.lsi.geometria.Punto2D.Cuadrante;

import java.util.*;
import java.util.stream.Stream;

import us.lsi.common.*;


public class Ejercicio3 {
	
	

	public static List<Punto2D> ejercicio3Iterativo(List<Punto2D> fichero1,List<Punto2D> fichero2){
			List<Punto2D> ac = List2.empty();
			Iterator<Punto2D>it1 = fichero1.iterator();
			Iterator<Punto2D>it2 = fichero2.iterator();
			while(it1.hasNext() || it2.hasNext()) {
				if(it1.hasNext()) {
					Punto2D puntoA = it1.next();
					if(puntoA.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoA.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
						ac.add(puntoA);
					}
				}else{
					Punto2D puntoB = it2.next();
					if(puntoB.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoB.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
						ac.add(puntoB);
					}				
				}
				
				ac.sort(new Comparator<Punto2D>() {
				    public int compare(Punto2D puntoA, Punto2D puntoB) {
				        return puntoA.compareTo(puntoB);
				    }
				});
			}
			return ac;
	}
	
	public static List<Punto2D> ejercicio3Recursivo(List<Punto2D> fichero1,List<Punto2D> fichero2){
		List<Punto2D> ac = List2.empty();
		List<Punto2D> ficheroA = List2.empty();
		List<Punto2D> ficheroB = List2.empty();
		ficheroA.addAll(fichero1);
		ficheroB.addAll(fichero2);
		
		return ejercicio3Recursivo(ac,ficheroA,ficheroB);
	}
	
	private static List<Punto2D> ejercicio3Recursivo(List<Punto2D> ac,List<Punto2D> fichero1,List<Punto2D> fichero2){
		
		Iterator<Punto2D> it1 = fichero1.iterator();
		Iterator<Punto2D> it2 = fichero2.iterator();
		if(it1.hasNext()) {
			Punto2D puntoA = it1.next();
			if(puntoA.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoA.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			ac.add(puntoA);
			}
			fichero1.remove(0);
			ac = ejercicio3Recursivo(ac,fichero1,fichero2);
		}else if(it2.hasNext()) {
			Punto2D puntoB = it2.next();
			if(puntoB.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoB.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			ac.add(puntoB);
			}
			fichero2.remove(0);
			ac = ejercicio3Recursivo(ac,fichero1,fichero2);
			
		}
		
		ac.sort(new Comparator<Punto2D>() {
		   public int compare(Punto2D puntoA, Punto2D puntoB) {
		        return puntoA.compareTo(puntoB);
		    }
		});
	
		return ac;
		
	}
	
	public static List<Punto2D> ejercicio3Funcional(List<Punto2D> fichero1,List<Punto2D> fichero2){	
		
		
		Iterator<Punto2D> it1 = fichero1.iterator();
		Iterator<Punto2D> it2 = fichero2.iterator();
		
		TuplaEjercicio3 ultimoElemento = Stream.iterate(TuplaEjercicio3.first(fichero1, fichero2, it1, it2), x -> x.next())
				.dropWhile(x -> x.predicado())
				.findFirst()
				.get();
		
		ultimoElemento.ac().sort((puntoA,puntoB) -> puntoA.compareTo(puntoB));
		
		return ultimoElemento.ac();
	}
	
}
	