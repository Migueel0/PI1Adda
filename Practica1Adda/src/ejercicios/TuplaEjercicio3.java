package ejercicios;

import java.util.*;

import us.lsi.common.List2;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public record TuplaEjercicio3(List<Punto2D> ac,List<Punto2D> fichero1, List<Punto2D> fichero2, Iterator<Punto2D>it1, Iterator<Punto2D>it2) {

	public static TuplaEjercicio3 of(List<Punto2D> ac,List<Punto2D> fichero1, List<Punto2D> fichero2, Iterator<Punto2D>it1, Iterator<Punto2D>it2) {
		return new TuplaEjercicio3(ac,fichero1,fichero2,it1,it2);
	}
	
	public static TuplaEjercicio3 first(List<Punto2D> fichero1, List<Punto2D> fichero2, Iterator<Punto2D>it1, Iterator<Punto2D>it2) {
		return new TuplaEjercicio3(List2.empty(),fichero1,fichero2,it1,it2);
	}
	
	public TuplaEjercicio3 next() {
		if(it1.hasNext()) {
			Punto2D puntoA = it1.next();
			if(puntoA.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoA.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			ac.add(puntoA);
			}
		}else if(it2.hasNext()) {
			Punto2D puntoB = it2.next();
			if(puntoB.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || puntoB.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			ac.add(puntoB);
			}
			
		}
		return of(ac,fichero1,fichero2,it1,it2);
		
	}
	
	public boolean predicado() {
		return it1.hasNext() || it2.hasNext();
	}
	
	
}