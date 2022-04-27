package examples;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondTest {
    public static void main(String[] args) {
        JButton greeterButton = new JButton("Click me !");
        greeterButton.addActionListener(event -> JOptionPane.showMessageDialog(null, "Hello !"));
        List<String> strings = Arrays.asList("hello", "world", "!");
        strings.sort(String::compareTo);
        System.out.println(strings);
    }
}
