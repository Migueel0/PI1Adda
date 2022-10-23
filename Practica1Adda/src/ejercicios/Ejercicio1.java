package ejercicios;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.List2;
import us.lsi.common.Map2;


public class Ejercicio1 {
	
	public static Map<Integer,List<String>> ejercicioA (Integer varA, String varB, Integer varC, String
			varD, Integer varE) {
		
				UnaryOperator<EnteroCadena> nx = elem ->
			{
				return EnteroCadena.of(elem.a()+2,
						elem.a()%3==0?elem.s()+elem.a().toString():
							
						elem.s().substring(elem.a()%elem.s().length()));
			};
			
			return Stream.iterate(EnteroCadena.of(varA,varB), elem -> elem.a() < varC, nx)
					.map(elem -> elem.s()+varD)
					.filter(nom -> nom.length() < varE)
					.collect(Collectors.groupingBy(String::length));
			}
	
	
	public static Map<Integer,List<String>> ejercicioAIterativo(Integer varA, String varB,Integer varC, String varD, Integer varE){
		
		Map<Integer,List<String>> ac = Map2.empty();
		EnteroCadena tupla = EnteroCadena.of(varA, varB);
		while(tupla.a()<varC) {
			String cadena = tupla.s() + varD;
			
			List<String> cadenas = new ArrayList<>();
			if (cadena.length() < varE) {
				if(ac.containsKey(cadena.length())) {
					ac.get(cadena.length()).add(cadena);
				}else {
					cadenas.add(cadena);
					ac.put(cadena.length(),cadenas);
				}
			}
			
			if(tupla.a()%3==0){
				tupla = EnteroCadena.of(tupla.a() + 2, tupla.s() + tupla.a().toString());
			}else {
				tupla = EnteroCadena.of(tupla.a() + 2, tupla.s().substring(tupla.a()%tupla.s().length()));
			}
		}
		return ac;
	}
	
	public static Map<Integer,List<String>> ejercicioARecursivo(Integer varA, String varB,Integer varC, String varD, Integer varE){
		Map<Integer,List<String>> ac = Map2.empty();
		EnteroCadena tupla = EnteroCadena.of(varA, varB);
		return ejercicioARecursivo(ac,tupla,varA,varB,varC,varD,varE);
		
	}
	private static Map<Integer,List<String>> ejercicioARecursivo(Map<Integer,List<String>> ac,EnteroCadena tupla,Integer varA, String varB,Integer varC, String varD, Integer varE){
		
		if(tupla.a() < varC) {
			String cadena = tupla.s() + varD;
			List<String> cadenas = List2.empty();
			if (cadena.length() < varE) {
				if(ac.containsKey(cadena.length())) {
					ac.get(cadena.length()).add(cadena);
				}else {
					cadenas.add(cadena);
					ac.put(cadena.length(), cadenas);	
				}
			}
			Integer entero = tupla.a() + 2;
			if(tupla.a()%3==0) {
				ac = ejercicioARecursivo(ac,EnteroCadena.of(entero, tupla.s() + tupla.a().toString()),varA,varB,varC,varD,varE);
			}else {
				ac = ejercicioARecursivo(ac,EnteroCadena.of(entero, tupla.s().substring(tupla.a()%tupla.s().length())),varA,varB,varC,varD,varE);
			}
		}
		return ac;
		}
	}
	
 