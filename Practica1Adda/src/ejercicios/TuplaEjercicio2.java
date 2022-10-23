package ejercicios;

public record TuplaEjercicio2(Integer ac,Integer a, Integer b, String s) {
	
	public static TuplaEjercicio2 of(Integer ac,Integer a, Integer b, String s) {
		return new TuplaEjercicio2(ac,a,b,s);
	}
	public static TuplaEjercicio2 first(Integer a ,Integer b, String s) {
		return new TuplaEjercicio2(0,a,b,s);
	}
	
	public boolean isBaseCase() {
		return s.length() == 0 || (a<2 || b<2);
	}


	public  TuplaEjercicio2 next() {
		if(a%s.length() < b%s.length()) {
			return of(ac + a+b,a-1,b/2,s.substring(a%s.length(),b%s.length()));
		}else {
			return of(ac+a*b,a/2,b-1,s.substring(b%s.length(),a%s.length()));
		}
	}
}
