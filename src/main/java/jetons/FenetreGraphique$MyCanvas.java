package jetons;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

class FenetreGraphique$MyCanvas extends Canvas implements MouseListener, MouseMotionListener, KeyListener {
    public BufferedImage image;
    private static final long serialVersionUID = 2L;

    public FenetreGraphique$MyCanvas(FenetreGraphique var1) {
        this.this$0 = var1;
        this.image = null;
        this.setSize(FenetreGraphique.access$700(var1), FenetreGraphique.access$800(var1));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    public void update(Graphics var1) {
        FenetreGraphique.access$902(this.this$0, true);
        this.paint(var1);
    }

    private void wait(int var1) {
        try {
            Thread.sleep((long)var1);
        } catch (Exception var3) {
        }

    }

    public void paint(Graphics var1) {
        FenetreGraphique.access$902(this.this$0, true);
        this.image = new BufferedImage(FenetreGraphique.access$700(this.this$0), FenetreGraphique.access$800(this.this$0), 5);
        WritableRaster var2 = this.image.getRaster();
        var2.setPixels(0, 0, FenetreGraphique.access$700(this.this$0), FenetreGraphique.access$800(this.this$0), FenetreGraphique.access$1000(this.this$0));
        this.setSize(FenetreGraphique.access$700(this.this$0), FenetreGraphique.access$800(this.this$0));
        var1.drawImage(this.image, 0, 0, this);
        FenetreGraphique.access$902(this.this$0, false);
        this.wait(1);
    }

    public void mouseClicked(MouseEvent var1) {
        FenetreGraphique.access$102(this.this$0, 2);
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        FenetreGraphique.access$402(this.this$0, var1.getButton());
        this.wait(1);
    }

    public void mouseEntered(MouseEvent var1) {
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        this.wait(1);
    }

    public void mouseExited(MouseEvent var1) {
        FenetreGraphique.access$202(this.this$0, -1);
        FenetreGraphique.access$302(this.this$0, -1);
        this.wait(1);
    }

    public void mousePressed(MouseEvent var1) {
        FenetreGraphique.access$102(this.this$0, 1);
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        FenetreGraphique.access$402(this.this$0, var1.getButton());
        this.wait(1);
    }

    public void mouseReleased(MouseEvent var1) {
        FenetreGraphique.access$102(this.this$0, 0);
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        FenetreGraphique.access$402(this.this$0, var1.getButton());
        this.wait(1);
    }

    public void mouseDragged(MouseEvent var1) {
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        FenetreGraphique.access$402(this.this$0, var1.getButton());
        this.wait(1);
    }

    public void mouseMoved(MouseEvent var1) {
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        this.wait(1);
    }

    public void keyPressed(KeyEvent var1) {
        this.wait(1);
    }

    public void keyReleased(KeyEvent var1) {
        if (var1.isActionKey()) {
            FenetreGraphique.access$500(this.this$0).add(new Integer(var1.getKeyCode()));
        }

        this.wait(1);
    }

    public void keyTyped(KeyEvent var1) {
        FenetreGraphique.access$600(this.this$0).add(new Character(var1.getKeyChar()));
        this.wait(1);
    }
}

