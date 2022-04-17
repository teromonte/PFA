package examples;

public class Averages {
    //
    @FunctionalInterface interface FloatFunction { float applyFn(float y) ; }
    //
    public static FloatFunction makeAverageF(float x) {
	return y -> (x + y) / 2 ;
    }
    //
    public static void main(String[] args) {
	FloatFunction averageWith10 = makeAverageF(10.0f) ;
	System.out.println(averageWith10.applyFn(12.0f)) ;
	System.out.println(makeAverageF(12.0f).applyFn(14.0f)) ;
	System.out.println("Vivement miam-miam bouffe-bouffe !") ;
    }
    //
}
