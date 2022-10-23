package ejercicios;

public record TuplaEjercicio4(Integer a, Integer b, Integer c) {
	
	
	public static TuplaEjercicio4 of(Integer a, Integer b, Integer c) {
		return new TuplaEjercicio4(a,b,c);
	}
	public boolean baseCase1() {
		return a<2 && b<=2 || c <2;
	}
	public boolean baseCase2() {
		return a<3 || b <3 && c<=3;
	}
	
	public boolean recursiveCase1() {
		return b%a == 0 && (a%2 == 0 || b%3==0);
	}

	

}
