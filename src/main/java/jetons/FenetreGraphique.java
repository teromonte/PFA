package jetons;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Button;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Vector;
import javax.imageio.ImageIO;

public class FenetreGraphique {
    public static final int SYMBOL8x13 = 1;
    public static final int COLABA8x13 = 3;
    private Vector<Character> key = new Vector();
    private Vector<Integer> specialKey = new Vector();
    private int mouseButton = -1;
    private int mouseState = 0;
    private int xMouse = -1;
    private int yMouse = -1;
    private boolean xorState = false;
    private boolean alphaBlendingState = false;
    private boolean isActive = false;
    private static short[][] symbol = new short[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 16, 0, 0, 16, 16, 16, 16, 16, 16, 16, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 40, 40, 40, 0, 0}, {0, 0, 0, 72, 252, 72, 72, 252, 72, 0, 0, 0, 0}, {0, 40, 124, 170, 42, 42, 92, 168, 168, 170, 124, 40, 0}, {0, 12, 18, 146, 76, 32, 16, 8, 100, 146, 144, 96, 0}, {0, 118, 136, 148, 146, 96, 32, 32, 64, 64, 48, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 48, 24, 24, 0, 0}, {0, 4, 8, 8, 16, 16, 16, 16, 16, 8, 8, 4, 0}, {0, 16, 8, 8, 4, 4, 4, 4, 4, 8, 8, 16, 0}, {0, 0, 16, 84, 56, 254, 56, 84, 16, 0, 0, 0, 0}, {0, 0, 16, 16, 16, 254, 16, 16, 16, 0, 0, 0, 0}, {48, 24, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 126, 0, 0, 0, 0, 0, 0, 0}, {0, 24, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 128, 128, 64, 32, 32, 16, 8, 8, 4, 2, 2, 0}, {0, 56, 68, 130, 194, 162, 146, 138, 134, 130, 68, 56, 0}, {0, 254, 16, 16, 16, 16, 16, 16, 144, 80, 48, 16, 0}, {0, 254, 128, 64, 32, 16, 8, 4, 2, 2, 130, 124, 0}, {0, 124, 130, 2, 2, 2, 124, 2, 2, 2, 130, 124, 0}, {4, 4, 4, 4, 4, 254, 68, 36, 36, 20, 12, 4, 0}, {0, 124, 130, 2, 2, 2, 252, 128, 128, 128, 128, 254, 0}, {0, 124, 130, 130, 130, 130, 252, 128, 128, 128, 130, 126, 0}, {0, 64, 64, 64, 64, 32, 16, 8, 4, 2, 2, 254, 0}, {0, 124, 130, 130, 130, 130, 124, 130, 130, 130, 130, 124, 0}, {0, 124, 130, 2, 2, 2, 126, 130, 130, 130, 130, 124, 0}, {0, 0, 0, 24, 24, 0, 0, 24, 24, 0, 0, 0, 0}, {48, 24, 24, 0, 0, 24, 24, 0, 0, 0, 0, 0, 0}, {0, 4, 8, 16, 32, 64, 128, 64, 32, 16, 8, 4, 0}, {0, 0, 0, 0, 0, 252, 0, 252, 0, 0, 0, 0, 0}, {0, 128, 64, 32, 16, 8, 4, 8, 16, 32, 64, 128, 0}, {0, 16, 0, 16, 16, 8, 4, 2, 2, 130, 130, 124, 0}, {0, 62, 64, 156, 162, 162, 154, 130, 124, 0, 0, 0, 0}, {0, 0, 195, 195, 195, 195, 255, 195, 195, 195, 102, 60, 24}, {0, 0, 254, 199, 195, 195, 199, 254, 199, 195, 195, 199, 254}, {0, 0, 126, 231, 192, 192, 192, 192, 192, 192, 192, 231, 126}, {0, 0, 252, 206, 199, 195, 195, 195, 195, 195, 199, 206, 252}, {0, 0, 255, 192, 192, 192, 192, 252, 192, 192, 192, 192, 255}, {0, 0, 192, 192, 192, 192, 192, 192, 252, 192, 192, 192, 255}, {0, 0, 126, 231, 195, 195, 207, 192, 192, 192, 192, 231, 126}, {0, 0, 195, 195, 195, 195, 195, 255, 195, 195, 195, 195, 195}, {0, 0, 126, 24, 24, 24, 24, 24, 24, 24, 24, 24, 126}, {0, 0, 124, 238, 198, 6, 6, 6, 6, 6, 6, 6, 6}, {0, 0, 195, 198, 204, 216, 240, 224, 240, 216, 204, 198, 195}, {0, 0, 255, 192, 192, 192, 192, 192, 192, 192, 192, 192, 192}, {0, 0, 195, 195, 195, 195, 195, 195, 219, 255, 255, 231, 195}, {0, 0, 199, 199, 207, 207, 223, 219, 251, 243, 243, 227, 227}, {0, 0, 126, 231, 195, 195, 195, 195, 195, 195, 195, 231, 126}, {0, 0, 192, 192, 192, 192, 192, 254, 199, 195, 195, 199, 254}, {0, 0, 63, 110, 223, 219, 195, 195, 195, 195, 195, 102, 60}, {0, 0, 195, 198, 204, 216, 240, 254, 199, 195, 195, 199, 254}, {0, 0, 126, 231, 3, 3, 7, 126, 224, 192, 192, 231, 126}, {0, 0, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 255}, {0, 0, 126, 231, 195, 195, 195, 195, 195, 195, 195, 195, 195}, {0, 0, 24, 60, 60, 102, 102, 195, 195, 195, 195, 195, 195}, {0, 0, 195, 231, 255, 255, 219, 219, 195, 195, 195, 195, 195}, {0, 0, 195, 102, 102, 60, 60, 24, 60, 60, 102, 102, 195}, {0, 0, 24, 24, 24, 24, 24, 24, 60, 60, 102, 102, 195}, {0, 0, 255, 192, 192, 96, 48, 126, 12, 6, 3, 3, 255}, {0, 0, 28, 16, 16, 16, 16, 16, 16, 16, 16, 28, 0}, {0, 2, 2, 4, 8, 8, 16, 32, 32, 64, 128, 128, 0}, {0, 0, 112, 16, 16, 16, 16, 16, 16, 16, 16, 112, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 130, 68, 40, 16, 0}, {0, 254, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 12, 24, 24, 0, 0}, {0, 114, 138, 132, 132, 138, 74, 48, 0, 0, 0, 0, 0}, {128, 156, 162, 66, 66, 68, 88, 100, 34, 34, 28, 0, 0}, {0, 140, 72, 72, 48, 48, 48, 40, 40, 68, 196, 0, 0}, {0, 112, 136, 136, 136, 136, 80, 32, 64, 72, 48, 0, 0}, {0, 112, 136, 128, 64, 48, 64, 72, 56, 0, 0, 0, 0}, {32, 32, 32, 120, 148, 146, 146, 82, 60, 8, 8, 8, 0}, {32, 32, 16, 16, 24, 24, 24, 36, 164, 68, 0, 0, 0}, {8, 8, 8, 36, 36, 36, 18, 18, 178, 76, 0, 0, 0}, {0, 0, 0, 16, 40, 32, 32, 16, 16, 16, 0, 0, 0}, {0, 64, 64, 120, 164, 162, 146, 146, 82, 76, 0, 0, 0}, {0, 0, 0, 152, 144, 240, 80, 80, 72, 72, 0, 0, 0}, {0, 0, 140, 136, 136, 80, 80, 80, 32, 32, 64, 192, 0}, {0, 128, 128, 128, 116, 74, 72, 72, 36, 36, 36, 0, 0}, {0, 0, 0, 192, 160, 144, 144, 72, 72, 200, 0, 0, 0}, {0, 0, 0, 96, 144, 136, 136, 136, 72, 48, 0, 0, 0}, {0, 0, 0, 140, 72, 72, 36, 36, 164, 126, 0, 0, 0}, {0, 48, 72, 132, 132, 132, 252, 132, 132, 132, 72, 48, 0}, {0, 128, 128, 128, 112, 72, 68, 36, 36, 36, 24, 0, 0}, {0, 0, 0, 96, 144, 136, 136, 136, 72, 62, 0, 0, 0}, {0, 0, 12, 64, 32, 32, 32, 32, 160, 120, 0, 0, 0}, {0, 0, 0, 192, 160, 144, 144, 72, 72, 200, 0, 0, 0}, {0, 0, 0, 108, 146, 145, 137, 73, 65, 255, 0, 0, 0}, {0, 0, 0, 108, 146, 145, 137, 73, 65, 34, 0, 0, 0}, {48, 8, 112, 128, 128, 112, 176, 128, 128, 112, 176, 128, 0}, {0, 32, 32, 32, 120, 148, 148, 82, 74, 202, 8, 8, 0}, {48, 8, 112, 128, 128, 128, 128, 128, 64, 112, 176, 128, 0}, {0, 12, 16, 16, 16, 16, 96, 16, 16, 16, 16, 12, 0}, {0, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 0}, {0, 96, 16, 16, 16, 16, 12, 16, 16, 16, 16, 96, 0}, {0, 0, 0, 0, 0, 0, 0, 6, 137, 145, 96, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private static short[][] regular8x13 = new short[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 24, 24, 0, 0, 24, 24, 24, 24, 24, 24, 24}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 54, 54, 54, 54}, {0, 0, 0, 102, 102, 255, 102, 102, 255, 102, 102, 0, 0}, {0, 0, 24, 126, 255, 27, 31, 126, 248, 216, 255, 126, 24}, {0, 0, 14, 27, 219, 110, 48, 24, 12, 118, 219, 216, 112}, {0, 0, 127, 198, 207, 216, 112, 112, 216, 204, 204, 108, 56}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 28, 12, 14}, {0, 0, 12, 24, 48, 48, 48, 48, 48, 48, 48, 24, 12}, {0, 0, 48, 24, 12, 12, 12, 12, 12, 12, 12, 24, 48}, {0, 0, 0, 0, 153, 90, 60, 255, 60, 90, 153, 0, 0}, {0, 0, 0, 24, 24, 24, 255, 255, 24, 24, 24, 0, 0}, {0, 0, 48, 24, 28, 28, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 127, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 56, 56, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 96, 96, 48, 48, 24, 24, 12, 12, 6, 6, 3, 3}, {0, 0, 60, 102, 195, 227, 243, 219, 207, 199, 195, 102, 60}, {0, 0, 126, 24, 24, 24, 24, 24, 24, 24, 120, 56, 24}, {0, 0, 255, 192, 192, 96, 48, 24, 12, 6, 3, 231, 126}, {0, 0, 126, 231, 3, 3, 7, 126, 7, 3, 3, 231, 126}, {0, 0, 12, 12, 12, 12, 12, 255, 204, 108, 60, 28, 12}, {0, 0, 126, 231, 3, 3, 7, 254, 192, 192, 192, 192, 255}, {0, 0, 126, 231, 195, 195, 199, 254, 192, 192, 192, 231, 126}, {0, 0, 48, 48, 48, 48, 24, 12, 6, 3, 3, 3, 255}, {0, 0, 126, 231, 195, 195, 231, 126, 231, 195, 195, 231, 126}, {0, 0, 126, 231, 3, 3, 3, 127, 231, 195, 195, 231, 126}, {0, 0, 0, 56, 56, 0, 0, 56, 56, 0, 0, 0, 0}, {0, 0, 48, 24, 28, 28, 0, 0, 28, 28, 0, 0, 0}, {0, 0, 6, 12, 24, 48, 96, 192, 96, 48, 24, 12, 6}, {0, 0, 0, 0, 255, 255, 0, 255, 255, 0, 0, 0, 0}, {0, 0, 96, 48, 24, 12, 6, 3, 6, 12, 24, 48, 96}, {0, 0, 24, 0, 0, 24, 24, 12, 6, 3, 195, 195, 126}, {0, 0, 63, 96, 207, 219, 211, 221, 195, 126, 0, 0, 0}, {0, 0, 195, 195, 195, 195, 255, 195, 195, 195, 102, 60, 24}, {0, 0, 254, 199, 195, 195, 199, 254, 199, 195, 195, 199, 254}, {0, 0, 126, 231, 192, 192, 192, 192, 192, 192, 192, 231, 126}, {0, 0, 252, 206, 199, 195, 195, 195, 195, 195, 199, 206, 252}, {0, 0, 255, 192, 192, 192, 192, 252, 192, 192, 192, 192, 255}, {0, 0, 192, 192, 192, 192, 192, 192, 252, 192, 192, 192, 255}, {0, 0, 126, 231, 195, 195, 207, 192, 192, 192, 192, 231, 126}, {0, 0, 195, 195, 195, 195, 195, 255, 195, 195, 195, 195, 195}, {0, 0, 126, 24, 24, 24, 24, 24, 24, 24, 24, 24, 126}, {0, 0, 124, 238, 198, 6, 6, 6, 6, 6, 6, 6, 6}, {0, 0, 195, 198, 204, 216, 240, 224, 240, 216, 204, 198, 195}, {0, 0, 255, 192, 192, 192, 192, 192, 192, 192, 192, 192, 192}, {0, 0, 195, 195, 195, 195, 195, 195, 219, 255, 255, 231, 195}, {0, 0, 199, 199, 207, 207, 223, 219, 251, 243, 243, 227, 227}, {0, 0, 126, 231, 195, 195, 195, 195, 195, 195, 195, 231, 126}, {0, 0, 192, 192, 192, 192, 192, 254, 199, 195, 195, 199, 254}, {0, 0, 63, 110, 223, 219, 195, 195, 195, 195, 195, 102, 60}, {0, 0, 195, 198, 204, 216, 240, 254, 199, 195, 195, 199, 254}, {0, 0, 126, 231, 3, 3, 7, 126, 224, 192, 192, 231, 126}, {0, 0, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 255}, {0, 0, 126, 231, 195, 195, 195, 195, 195, 195, 195, 195, 195}, {0, 0, 24, 60, 60, 102, 102, 195, 195, 195, 195, 195, 195}, {0, 0, 195, 231, 255, 255, 219, 219, 195, 195, 195, 195, 195}, {0, 0, 195, 102, 102, 60, 60, 24, 60, 60, 102, 102, 195}, {0, 0, 24, 24, 24, 24, 24, 24, 60, 60, 102, 102, 195}, {0, 0, 255, 192, 192, 96, 48, 126, 12, 6, 3, 3, 255}, {0, 0, 60, 48, 48, 48, 48, 48, 48, 48, 48, 48, 60}, {0, 3, 3, 6, 6, 12, 12, 24, 24, 48, 48, 96, 96}, {0, 0, 60, 12, 12, 12, 12, 12, 12, 12, 12, 12, 60}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 195, 102, 60, 24}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 56, 48, 112}, {0, 0, 127, 195, 195, 127, 3, 195, 126, 0, 0, 0, 0}, {0, 0, 254, 195, 195, 195, 195, 254, 192, 192, 192, 192, 192}, {0, 0, 126, 195, 192, 192, 192, 195, 126, 0, 0, 0, 0}, {0, 0, 127, 195, 195, 195, 195, 127, 3, 3, 3, 3, 3}, {0, 0, 127, 192, 192, 254, 195, 195, 126, 0, 0, 0, 0}, {0, 0, 48, 48, 48, 48, 48, 252, 48, 48, 48, 51, 30}, {126, 195, 3, 3, 127, 195, 195, 195, 126, 0, 0, 0, 0}, {0, 0, 195, 195, 195, 195, 195, 195, 254, 192, 192, 192, 192}, {0, 0, 24, 24, 24, 24, 24, 24, 24, 0, 0, 24, 0}, {56, 108, 12, 12, 12, 12, 12, 12, 12, 0, 0, 12, 0}, {0, 0, 198, 204, 248, 240, 216, 204, 198, 192, 192, 192, 192}, {0, 0, 126, 24, 24, 24, 24, 24, 24, 24, 24, 24, 120}, {0, 0, 219, 219, 219, 219, 219, 219, 254, 0, 0, 0, 0}, {0, 0, 198, 198, 198, 198, 198, 198, 252, 0, 0, 0, 0}, {0, 0, 124, 198, 198, 198, 198, 198, 124, 0, 0, 0, 0}, {192, 192, 192, 254, 195, 195, 195, 195, 254, 0, 0, 0, 0}, {3, 3, 3, 127, 195, 195, 195, 195, 127, 0, 0, 0, 0}, {0, 0, 192, 192, 192, 192, 192, 224, 254, 0, 0, 0, 0}, {0, 0, 254, 3, 3, 126, 192, 192, 127, 0, 0, 0, 0}, {0, 0, 28, 54, 48, 48, 48, 48, 252, 48, 48, 48, 0}, {0, 0, 126, 198, 198, 198, 198, 198, 198, 0, 0, 0, 0}, {0, 0, 24, 60, 60, 102, 102, 195, 195, 0, 0, 0, 0}, {0, 0, 195, 231, 255, 219, 195, 195, 195, 0, 0, 0, 0}, {0, 0, 195, 102, 60, 24, 60, 102, 195, 0, 0, 0, 0}, {192, 96, 96, 48, 24, 60, 102, 102, 195, 0, 0, 0, 0}, {0, 0, 255, 96, 48, 24, 12, 6, 255, 0, 0, 0, 0}, {0, 0, 15, 24, 24, 24, 56, 240, 56, 24, 24, 24, 15}, {24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24}, {0, 0, 240, 24, 24, 24, 28, 15, 28, 24, 24, 24, 240}, {0, 0, 0, 0, 0, 0, 6, 143, 241, 96, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private FenetreGraphique$MyFrame mf = new FenetreGraphique$MyFrame(this, (FenetreGraphique$1)null);
    private int btx;
    private int bty;
    private int rouge = 255;
    private int vert = 255;
    private int bleu = 255;
    private double alpha = 1.0;
    private double malpha = 1.0;
    private int clearRouge = 0;
    private int clearVert = 0;
    private int clearBleu = 0;
    private int[] buffer;
    private boolean dessin = false;

    FenetreGraphique(int var1, int var2, int var3, int var4, int var5, int var6, String var7) {
        this.btx = var5;
        this.bty = var6;
        this.buffer = new int[var5 * var6 * 3];
        this.isActive = true;
        this.mf.ouvre(var1, var2, var3, var4, var5, var6, var7);
        this.clear();
    }

    public void setColor(int var1, int var2, int var3) {
        this.rouge = var1;
        this.vert = var2;
        this.bleu = var3;
    }

    public void setAlpha(double var1) {
        this.alpha = var1;
        this.malpha = 1.0 - this.alpha;
        if (this.alpha < 0.0) {
            this.alpha = 0.0;
        }

        if (this.alpha > 1.0) {
            this.alpha = 1.0;
        }

    }

    public void drawPixel(int var1, int var2) {
        this.drawPixelClip(var1, var2);
    }

    public void drawLine(int var1, int var2, int var3, int var4) {
        double var5 = (double)var1;
        double var7 = (double)var2;
        double var9 = (double)var3;
        double var11 = (double)var4;
        int var13 = this.code(var5, var7, 0, 0, this.btx - 1, this.bty - 1);

        int var14;
        for(var14 = this.code(var9, var11, 0, 0, this.btx - 1, this.bty - 1); (!this.code_nul(var13) || !this.code_nul(var14)) && this.pas1commun(var13, var14); var13 = this.code(var5, var7, 0, 0, this.btx - 1, this.bty - 1)) {
            if (this.code_nul(var13)) {
                double var15 = var5;
                var5 = var9;
                var9 = var15;
                var15 = var7;
                var7 = var11;
                var11 = var15;
                int var17 = var13;
                var13 = var14;
                var14 = var17;
            }

            if (this.code1(var13)) {
                var7 = this.intersection(var5, var7, var9, var11, (double)(this.btx - 1));
                var5 = (double)(this.btx - 1);
            } else if (this.code0(var13)) {
                var7 = this.intersection(var5, var7, var9, var11, 0.0);
                var5 = 0.0;
            } else if (this.code3(var13)) {
                var5 = this.intersection(var7, var5, var11, var9, (double)(this.bty - 1));
                var7 = (double)(this.bty - 1);
            } else if (this.code2(var13)) {
                var5 = this.intersection(var7, var5, var11, var9, 0.0);
                var7 = 0.0;
            }
        }

        if (this.code_nul(var13) && this.code_nul(var14)) {
            this.lineSansClip((int)var5, (int)var7, (int)var9, (int)var11);
        }

    }

    public void drawRect(int var1, int var2, int var3, int var4) {
        this.drawLine(var1, var2, var1 + var3, var2);
        this.drawLine(var1, var2, var1, var2 + var4);
        this.drawLine(var1 + var3, var2 + var4, var1 + var3, var2);
        this.drawLine(var1 + var3, var2 + var4, var1, var2 + var4);
    }

    public void fillRect(int var1, int var2, int var3, int var4) {
        if (var3 > 0) {
            for(int var5 = 0; var5 < var4; ++var5) {
                this.drawLine(var1, var2 + var5, var1 + var3 - 1, var2 + var5);
            }
        }

    }

    public void fillCircle(int var1, int var2, int var3) {
        int[] var4 = new int[var3 + 1];
        int var5 = 0;
        int var6 = var3;
        int var7 = 1 - var3;
        var4[var3] = var5;

        for(var4[var5] = var3; var6 > var5; var4[var5] = var6) {
            if (var7 < 0) {
                var7 += 2 * var5 + 3;
            } else {
                var7 += 2 * (var5 - var6) + 5;
                --var6;
            }

            ++var5;
            var4[var6] = var5;
        }

        this.drawLine(var1 + var4[0], var2, var1 - var4[0], var2);

        for(int var8 = 1; var8 <= var3; ++var8) {
            this.drawLine(var1 + var4[var8], var2 + var8, var1 - var4[var8], var2 + var8);
            this.drawLine(var1 + var4[var8], var2 - var8, var1 - var4[var8], var2 - var8);
        }

    }

    public void drawCircle(int var1, int var2, int var3) {
        int[] var4 = new int[var3 + 1];
        int var5 = 0;
        int var6 = var3;
        int var7 = 1 - var3;
        this.drawPixelClip(var1, var2 + var3);
        this.drawPixelClip(var1, var2 - var3);
        this.drawPixelClip(var1 + var3, var2);
        this.drawPixelClip(var1 - var3, var2);

        while(var6 > var5) {
            if (var7 < 0) {
                var7 += 2 * var5 + 3;
            } else {
                var7 += 2 * (var5 - var6) + 5;
                --var6;
            }

            ++var5;
            this.drawPixelClip(var1 + var5, var2 + var6);
            this.drawPixelClip(var1 + var5, var2 - var6);
            this.drawPixelClip(var1 + var6, var2 + var5);
            this.drawPixelClip(var1 - var6, var2 + var5);
            this.drawPixelClip(var1 - var5, var2 + var6);
            this.drawPixelClip(var1 - var5, var2 - var6);
            this.drawPixelClip(var1 + var6, var2 - var5);
            this.drawPixelClip(var1 - var6, var2 - var5);
            var4[var6] = var5;
            var4[var5] = var6;
        }

    }

    public void setClearColor(int var1, int var2, int var3) {
        this.clearRouge = var1;
        this.clearVert = var2;
        this.clearBleu = var3;
    }

    public void drawString(int var1, int var2, int var3, String var4) {
        char[] var5 = var4.toCharArray();
        byte var6 = 0;
        byte var7 = 0;
        switch (var3) {
            case 1:
            case 3:
                var6 = 8;
                var7 = 13;
                break;
            case 2:
                var6 = 7;
                var7 = 10;
        }

        int var8;
        switch (var3) {
            case 1:
                for(var8 = 0; var8 < var5.length; ++var8) {
                    this.drawCaractere(var1 + (var6 + 1) * var8, var2, var6, var7, symbol[var5[var8] - 32]);
                }

                return;
            case 3:
                for(var8 = 0; var8 < var5.length; ++var8) {
                    this.drawCaractere(var1 + (var6 + 1) * var8, var2, var6, var7, regular8x13[var5[var8] - 32]);
                }
        }

    }

    public void drawText(int var1, int var2, int var3, Object... var4) {
        String var5 = "";
        Object[] var6 = var4;
        int var7 = var4.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Object var9 = var6[var8];
            var5 = var5 + var9.toString();
        }

        this.drawString(var1, var2, var3, var5);
    }

    public void drawText(int var1, int var2, int var3, String var4, Object... var5) {
        ByteArrayOutputStream var6 = new ByteArrayOutputStream();
        PrintStream var7 = new PrintStream(var6);
        var7.printf(var4, var5);
        this.drawText(var1, var2, var3, var6);
    }

    public void drawImage(int var1, int var2, int[][] var3) {
        int var4 = var3.length;
        int var5 = var3[0].length;

        for(int var6 = 0; var6 < var5; ++var6) {
            for(int var7 = 0; var7 < var4; ++var7) {
                int var8 = var7 + var1;
                int var9 = var6 + var2;
                if (var8 >= 0 && var9 >= 0 && var8 < this.btx && var9 < this.bty) {
                    int var10 = var3[var7][var6] % 256;
                    int var11 = var3[var7][var6] / 256 % 256;
                    int var12 = var3[var7][var6] / 65536;
                    int var13 = (var8 + var9 * this.btx) * 3;
                    this.buffer[var13] = var10;
                    this.buffer[var13 + 1] = var11;
                    this.buffer[var13 + 2] = var12;
                }
            }
        }

    }

    public void clear() {
        int var1 = 0;

        for(int var2 = 0; var2 < this.btx; ++var2) {
            for(int var3 = 0; var3 < this.bty; ++var3) {
                this.buffer[var1] = this.clearRouge;
                this.buffer[var1 + 1] = this.clearVert;
                this.buffer[var1 + 2] = this.clearBleu;
                var1 += 3;
            }
        }

    }

    public void flush() {
        synchronized(this.mf.mc) {
            while(this.dessin) {
                try {
                    Thread.sleep(0L, 1000);
                } catch (Exception var5) {
                }
            }

            this.dessin = true;
            this.mf.mc.repaint();

            while(this.dessin) {
                try {
                    Thread.sleep(0L, 1000);
                } catch (Exception var4) {
                }
            }

        }
    }

    public void close() {
        this.isActive = false;
        this.mf.dispose();
    }

    public boolean notClosed() {
        return this.isActive;
    }

    public static void exit() {
        System.exit(0);
    }

    public char getKey() {
        if (this.key.size() == 0) {
            return '\u0000';
        } else {
            Character var1 = (Character)this.key.remove(0);
            return var1;
        }
    }

    public int getSpecialKey() {
        if (this.specialKey.size() == 0) {
            return 0;
        } else {
            Integer var1 = (Integer)this.specialKey.remove(0);
            return var1;
        }
    }

    public int getMouseState() {
        int var1 = this.mouseState;
        if (this.mouseState == 2) {
            this.mouseState = 0;
        }

        return var1;
    }

    public int getMouseButton() {
        return this.mouseButton;
    }

    public int getMouseX() {
        return this.xMouse;
    }

    public int getMouseY() {
        return this.yMouse;
    }

    public void setXorMode(boolean var1) {
        this.xorState = var1;
        if (var1) {
            this.alphaBlendingState = false;
        }

    }

    public void setAlphaBlendingMode(boolean var1) {
        this.alphaBlendingState = var1;
        if (var1) {
            this.xorState = false;
        }

    }

    public int getBufferWidth() {
        return this.btx;
    }

    public int getBufferHeight() {
        return this.bty;
    }

    public static void wait(int var0) {
        try {
            Thread.sleep((long)var0);
        } catch (Exception var2) {
        }

    }

    private void drawPixelClip(int var1, int var2) {
        if (var1 >= 0 && var2 >= 0 && var1 < this.btx && var2 < this.bty) {
            this.drawPixelSansClip(var1, var2);
        }
    }

    private void drawPixelSansClip(int var1, int var2) {
        if (this.xorState) {
            this.buffer[(var1 + var2 * this.btx) * 3] ^= this.rouge;
            this.buffer[(var1 + var2 * this.btx) * 3 + 1] ^= this.vert;
            this.buffer[(var1 + var2 * this.btx) * 3 + 2] ^= this.bleu;
        } else if (this.alphaBlendingState) {
            double var3 = (double)this.buffer[(var1 + var2 * this.btx) * 3] * this.malpha + (double)this.rouge * this.alpha;
            if (var3 < 0.0) {
                var3 = 0.0;
            }

            if (var3 > 255.0) {
                var3 = 255.0;
            }

            this.buffer[(var1 + var2 * this.btx) * 3] = (int)var3;
            var3 = (double)this.buffer[(var1 + var2 * this.btx) * 3 + 1] * this.malpha + (double)this.vert * this.alpha;
            if (var3 < 0.0) {
                var3 = 0.0;
            }

            if (var3 > 255.0) {
                var3 = 255.0;
            }

            this.buffer[(var1 + var2 * this.btx) * 3 + 1] = (int)var3;
            var3 = (double)this.buffer[(var1 + var2 * this.btx) * 3 + 2] * this.malpha + (double)this.bleu * this.alpha;
            if (var3 < 0.0) {
                var3 = 0.0;
            }

            if (var3 > 255.0) {
                var3 = 255.0;
            }

            this.buffer[(var1 + var2 * this.btx) * 3 + 2] = (int)var3;
        } else {
            this.buffer[(var1 + var2 * this.btx) * 3] = this.rouge;
            this.buffer[(var1 + var2 * this.btx) * 3 + 1] = this.vert;
            this.buffer[(var1 + var2 * this.btx) * 3 + 2] = this.bleu;
        }
    }

    private void drawPixelClip(int var1, int var2, int var3, int var4, int var5) {
        if (var1 >= 0 && var2 >= 0 && var1 < this.btx && var2 < this.bty) {
            this.drawPixelSansClip(var1, var2, var3, var4, var5);
        }
    }

    private void drawPixelSansClip(int var1, int var2, int var3, int var4, int var5) {
        if (this.xorState) {
            this.buffer[(var1 + var2 * this.btx) * 3] ^= var3;
            this.buffer[(var1 + var2 * this.btx) * 3 + 1] ^= var4;
            this.buffer[(var1 + var2 * this.btx) * 3 + 2] ^= var5;
        } else {
            this.buffer[(var1 + var2 * this.btx) * 3] = var3;
            this.buffer[(var1 + var2 * this.btx) * 3 + 1] = var4;
            this.buffer[(var1 + var2 * this.btx) * 3 + 2] = var5;
        }

    }

    private void drawCaractere(int var1, int var2, int var3, int var4, short[] var5) {
        for(int var6 = 0; var6 < var4; ++var6) {
            short var7 = var5[var6];

            for(int var8 = 0; var8 < var3; ++var8) {
                int var9 = var7 >> var8 & 1;
                if (var9 == 1) {
                    this.drawPixelClip(var1 + var3 - var8, var2 - var6);
                }
            }
        }

    }

    private void lineSansClip(int var1, int var2, int var3, int var4) {
        int var10 = var1;
        int var11 = var2;
        int var5 = var3 - var1;
        int var6 = var4 - var2;
        int var7 = var5 > 0 ? 1 : -1;
        int var8 = var6 > 0 ? 1 : -1;
        var5 = Math.abs(var5);
        var6 = Math.abs(var6);
        this.drawPixelSansClip(var1, var2);
        int var9;
        int var12;
        if (var5 > var6) {
            var9 = var5 / 2;

            for(var12 = 1; var12 <= var5; ++var12) {
                var10 += var7;
                var9 += var6;
                if (var9 >= var5) {
                    var9 -= var5;
                    var11 += var8;
                }

                this.drawPixelSansClip(var10, var11);
            }
        } else {
            var9 = var6 / 2;

            for(var12 = 1; var12 <= var6; ++var12) {
                var11 += var8;
                var9 += var5;
                if (var9 >= var6) {
                    var9 -= var6;
                    var10 += var7;
                }

                this.drawPixelSansClip(var10, var11);
            }
        }

    }

    private int code(double var1, double var3, int var5, int var6, int var7, int var8) {
        int var9;
        if (var1 < (double)var5) {
            var9 = 1;
        } else {
            var9 = 0;
        }

        if (var1 > (double)var7) {
            var9 += 2;
        }

        if (var3 < (double)var6) {
            var9 += 4;
        }

        if (var3 > (double)var8) {
            var9 += 8;
        }

        return var9;
    }

    private boolean code_nul(int var1) {
        return var1 == 0;
    }

    private boolean pas1commun(int var1, int var2) {
        return (var1 & var2) == 0;
    }

    private boolean code0(int var1) {
        return (var1 & 1) != 0;
    }

    private boolean code1(int var1) {
        return (var1 & 2) != 0;
    }

    private boolean code2(int var1) {
        return (var1 & 4) != 0;
    }

    private boolean code3(int var1) {
        return (var1 & 8) != 0;
    }

    private double intersection(double var1, double var3, double var5, double var7, double var9) {
        double var11 = 0.0;
        if (var5 != var1) {
            var11 = var3 + (var9 - var1) / (var5 - var1) * (var7 - var3);
        } else {
            var11 = 1.0E10;
        }

        return var11;
    }

    private BufferedImage conversion(BufferedImage var1) {
        if (var1.getType() == 1) {
            return var1;
        } else {
            var1 = this.convertion(var1);
            return var1;
        }
    }

    private BufferedImage convertion(BufferedImage var1) {
        BufferedImage var2 = new BufferedImage(var1.getWidth(), var1.getHeight(), 1);
        Graphics2D var3 = var2.createGraphics();
        var3.drawImage(var1, 0, 0, new Button());
        return var2;
    }

    public int[][] loadPNGFile(String var1) {
        BufferedImage var2;
        try {
            var2 = this.conversion(ImageIO.read(new File(var1)));
        } catch (IOException var10) {
            var2 = null;
        }

        if (var2 == null) {
            return null;
        } else {
            int var3;
            while((var3 = var2.getWidth(this.mf)) == -1) {
            }

            int var4 = var2.getHeight(this.mf);
            int[] var5 = var2.getRaster().getPixels(0, 0, var3, var4, (int[])null);
            int[][] var6 = new int[var3][var4];
            int var7 = 0;

            for(int var8 = 0; var8 < var4; ++var8) {
                for(int var9 = 0; var9 < var3; ++var9) {
                    var6[var9][var8] = var5[var7 + 2] * 65536 + var5[var7 + 1] * 256 + var5[var7];
                    var7 += 3;
                }
            }

            return var6;
        }
    }

    public int[][] downloadPNGFile(String var1) {
        BufferedImage var2;
        try {
            var2 = this.conversion(ImageIO.read(new URL(var1)));
        } catch (Exception var10) {
            var2 = null;
        }

        if (var2 == null) {
            return null;
        } else {
            int var3;
            while((var3 = var2.getWidth(this.mf)) == -1) {
            }

            int var4 = var2.getHeight(this.mf);
            int[] var5 = var2.getRaster().getPixels(0, 0, var3, var4, (int[])null);
            int[][] var6 = new int[var3][var4];
            int var7 = 0;

            for(int var8 = 0; var8 < var4; ++var8) {
                for(int var9 = 0; var9 < var3; ++var9) {
                    var6[var9][var8] = var5[var7 + 2] * 65536 + var5[var7 + 1] * 256 + var5[var7];
                    var7 += 3;
                }
            }

            return var6;
        }
    }

    public void setWindowSize(int var1, int var2) {
        this.mf.setSize(var1, var2);
    }

    public void setWindowResizable(boolean var1) {
        this.mf.setResizable(var1);
    }
}
