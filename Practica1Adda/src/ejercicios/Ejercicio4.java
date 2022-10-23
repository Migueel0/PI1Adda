package ejercicios;

import java.util.*;

public class Ejercicio4 {
	
	public static String ejercicio4RecursivoSinMemoria(Integer a, Integer b, Integer c) {
		String ac = "";
		TuplaEjercicio4 tupla = TuplaEjercicio4.of(a, b, c);
		
		if(tupla.baseCase1()) {
			ac = "(" + a.toString() + "+" + b.toString() + "+" + c.toString()+")";
		}else if(tupla.baseCase2()) {
			ac = "("+ c.toString() + "-" + b.toString() + "-" + a.toString() +")";
		}else if(tupla.recursiveCase1()) {
			ac = "("+ ejercicio4RecursivoSinMemoria(a-1,b/a,c-1) + "*" + ejercicio4RecursivoSinMemoria(a-2,b/2,c/2)+ ")";
		}else {
			ac = "(" + ejercicio4RecursivoSinMemoria(a/2,b-2,c/2) +"/" + ejercicio4RecursivoSinMemoria(a/3,b-1,c/3) + ")";
		}
		return ac;
		
	}
	
	public static String ejercicio4RecursivoConMemoria(Integer a, Integer b, Integer c) {
		Map<TuplaEjercicio4,String> m = new HashMap<>();
		return ejercicio4RecursivoConMemoria(m,a,b,c);
	}
	
	private static String ejercicio4RecursivoConMemoria(Map<TuplaEjercicio4,String> m,Integer a, Integer b, Integer c) {
		String ac;
		TuplaEjercicio4 key = TuplaEjercicio4.of(a,b,c);
		TuplaEjercicio4 tupla = TuplaEjercicio4.of(a, b, c);
		
		if(m.containsKey(key)) {
			ac = m.get(key);
		}else {
			if(tupla.baseCase1()) {
				ac = "(" + a.toString() + "+" + b.toString() + "+" + c.toString()+")";
			}else if(tupla.baseCase2()) {
				ac = "("+ c.toString() + "-" + b.toString() + "-" + a.toString() +")";
			}else if(tupla.recursiveCase1()) {
				ac = "("+ ejercicio4RecursivoSinMemoria(a-1,b/a,c-1) + "*" + ejercicio4RecursivoSinMemoria(a-2,b/2,c/2)+ ")";
				m.put(key, ac);
			}else {
				ac = "(" + ejercicio4RecursivoSinMemoria(a/2,b-2,c/2) +"/" + ejercicio4RecursivoSinMemoria(a/3,b-1,c/3) + ")";
				m.put(key, ac);
			}
			
		}
		
		return ac;
	}
	
	public static String ejercicio4Iterativo(Integer a, Integer b, Integer c) {
		String ac;
		Map<TuplaEjercicio4,String> m = new HashMap<>();
		for(int i = 0;i<=a;i++) {
			for(int j = 0; j<=b;j++) {
				for(int k=0;k<=c;k++) {
					TuplaEjercicio4 tupla = TuplaEjercicio4.of(i, j, k);
					
					if(tupla.baseCase1()) {
						ac = "(" + String.valueOf(i) + "+" + String.valueOf(j) + "+" +String.valueOf(k)+")";
					}else if(tupla.baseCase2()) {
						ac = "("+ String.valueOf(k) + "-" + String.valueOf(j) + "-" + String.valueOf(i) +")";
					}else if(tupla.recursiveCase1()) {
						ac = "("+ m.get(TuplaEjercicio4.of(i-1,j/i,k-1)) + "*" + m.get(TuplaEjercicio4.of(i-2,j/2,k/2))+ ")";
						
					}else {
						ac = "(" + m.get(TuplaEjercicio4.of(i/2,j-2,k/2)) +"/" + m.get(TuplaEjercicio4.of(i/3,j-1,k/3)) + ")";
						
					}
					m.put(TuplaEjercicio4.of(i, j, k), ac);
					
				}
			}
		}
		return m.get(TuplaEjercicio4.of(a,b,c));
		
	}

}
