package ejercicios;

import java.util.stream.Stream;

public class Ejercicio2 {
	
	public static Integer ejercicioBRecursivoNoFinal(Integer a, Integer b, String s){
		Integer ac = 0;
		if (s.length() == 0){ // Caso base 1
			ac = a*a + b*b;
		}else if(a<2 || b <2) { // Caso base 2
			ac = s.length() + a + b;
		}
		else if(a%s.length() < b%s.length()) { //Caso recursivo 1
			ac = a + b + ejercicioBRecursivoNoFinal(a-1,b/2,s.substring(a%s.length(),b%s.length()));
		}else { //Caso recursivo 2
			ac = a*b + ejercicioBRecursivoNoFinal(a/2,b-1,s.substring(b%s.length(),a%s.length()));
		}
		return ac;
		
	}
	
	
	public static Integer ejercicioBRecursivoFinal(Integer a, Integer b, String s) { //Funcion principal
		Integer ac = 0;
		return ejercicioBRecursivoFinal(ac,a,b,s); //Llamada a la funcion recursiva
	}
	
	private static Integer ejercicioBRecursivoFinal(Integer ac, Integer a, Integer b, String s) { //Funcion recursiva final
		
		if(TuplaEjercicio2.of(ac,a, b, s).isBaseCase()) { // Caso base
			if (s.length() == 0){
				ac = ac + a*a + b*b;	
			}else if(a<2 || b<2){
				ac = ac + s.length() + a + b;
			}
		}else{ // Caso recursivo
			if(a%s.length() < b%s.length()){
				ac = ejercicioBRecursivoFinal(ac + a+b,a-1,b/2,s.substring(a%s.length(),b%s.length()));
			}else {
			ac = ejercicioBRecursivoFinal(ac + a*b,a/2,b-1,s.substring(b%s.length(),a%s.length()));
			}
		}

		return ac;
		
	}
	
	public static Integer ejercicioBIterativo(Integer a, Integer b, String s) {
		Integer ac = 0;
		
		while(!TuplaEjercicio2.of(ac,a, b, s).isBaseCase()) {  //Caso recursivo de la definicion
			if(a%s.length() < b%s.length()) {
				ac = ac + a + b;
				s = s.substring(a%s.length(),b%s.length());
				a = a - 1;
				b = b/2;
			}else {
				ac = ac + a * b;
				s = s.substring(b%s.length(),a%s.length());
				a = a/2;
				b = b - 1;
			}
		}
		
		if(s.length() == 0) { //Caso base de la definicion
			ac = ac + a*a + b*b;
		}else{
			ac = ac + s.length() + a + b;
		}
		return ac;	
	}
	
	public static Integer ejercicioBFuncional(Integer a, Integer b, String s) {
		
		TuplaEjercicio2 elementoFinal = Stream.iterate(TuplaEjercicio2.first(a, b, s), x -> x.next())
				.dropWhile(x -> !x.isBaseCase())
				.findFirst()
				.get();
		
		if(elementoFinal.s().length() == 0) { 
			return elementoFinal.ac() + elementoFinal.a()*elementoFinal.a() + elementoFinal.b()*elementoFinal.b();
		}else{
			return elementoFinal.ac() + elementoFinal.s().length() + elementoFinal.a() + elementoFinal.b();
		}
	}
}