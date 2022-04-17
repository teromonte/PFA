package examples;

import java.util.Collections ; import java.util.List ; import java.util.Arrays ;
import javax.swing.JButton ; import javax.swing.JOptionPane ;

public class SecondTest {
    public static void main(String[] args) {
	JButton greeterButton = new JButton("Click me !") ;
	greeterButton.
	    addActionListener(event -> 
			      JOptionPane.showMessageDialog(null, "Hello !")) ;
	List<String> strings = Arrays.asList("hello","world","!") ;
	Collections.sort(strings,(s1,s2) -> s1.compareTo(s2)) ;
	System.out.println(strings) ;
    }
}
