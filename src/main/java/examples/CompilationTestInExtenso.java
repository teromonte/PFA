package examples;

public class CompilationTestInExtenso {
    interface IntFunction {
	int applyFn(int n) ;
        default public int applyConstantFn() { return 1 ; }
    }
    public static void main(String[] args) {
	final int factor = 2 ;
	IntFunction 
	    f = new IntFunction() {
		    @Override public int applyFn(int n) { return n * factor ; }
		},
	    f0 = new IntFunction() {
		    @Override public int applyFn(int n) {
			return 2 * n * factor ;
		    }
		} ;
	System.out.println(f.applyFn(2017)) ;
	System.out.println(f0.applyFn(2017)) ;
	Runnable
	    ending = new Runnable() {
		    @Override public void run() {
			System.out.println("That's the end, my friend!") ;
		    }
		} ;
    	ending.run() ;
    }
}
