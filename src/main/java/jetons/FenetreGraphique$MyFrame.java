package jetons;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class FenetreGraphique$MyFrame extends Frame implements WindowListener, ActionListener, MouseListener, MouseMotionListener, KeyListener {
    public boolean open;
    public FenetreGraphique$MyCanvas mc;
    public ScrollPane sp;
    private MenuBar mb;
    private Menu m1;
    private MenuItem mff;
    private static final long serialVersionUID = 1L;

    private FenetreGraphique$MyFrame(FenetreGraphique var1) {
        this.this$0 = var1;
        this.open = false;
        this.mb = new MenuBar();
        this.m1 = new Menu("Fenêtre");
        this.mff = new MenuItem("Fermer");
    }

    public void ouvre(int var1, int var2, int var3, int var4, int var5, int var6, String var7) {
        if (!this.open) {
            this.open = true;
            this.mc = new FenetreGraphique$MyCanvas(this.this$0);
            this.setMenuBar(this.mb);
            this.mb.add(this.m1);
            this.m1.add(this.mff);
            this.mff.addActionListener(this);
            this.addWindowListener(this);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.addKeyListener(this);
            this.setTitle(var7);
            this.setSize(var3, var4);
            this.setLocation(var1, var2);
            this.sp = new ScrollPane(1);
            this.sp.add(this.mc);
            this.add(this.sp);
            this.setVisible(true);
        }

    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.dispose();
        FenetreGraphique.access$002(this.this$0, false);
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.mff) {
            FenetreGraphique.access$002(this.this$0, false);
            this.dispose();
        }

    }

    public void mouseClicked(MouseEvent var1) {
        FenetreGraphique.access$102(this.this$0, 2);
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        FenetreGraphique.access$402(this.this$0, var1.getButton());
    }

    public void mouseEntered(MouseEvent var1) {
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
    }

    public void mouseExited(MouseEvent var1) {
        FenetreGraphique.access$202(this.this$0, -1);
        FenetreGraphique.access$302(this.this$0, -1);
    }

    public void mousePressed(MouseEvent var1) {
        FenetreGraphique.access$102(this.this$0, 1);
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        FenetreGraphique.access$402(this.this$0, var1.getButton());
    }

    public void mouseReleased(MouseEvent var1) {
        FenetreGraphique.access$102(this.this$0, 0);
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        FenetreGraphique.access$402(this.this$0, var1.getButton());
    }

    public void mouseDragged(MouseEvent var1) {
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
        FenetreGraphique.access$402(this.this$0, var1.getButton());
    }

    public void mouseMoved(MouseEvent var1) {
        FenetreGraphique.access$202(this.this$0, var1.getX());
        FenetreGraphique.access$302(this.this$0, var1.getY());
    }

    public void keyPressed(KeyEvent var1) {
    }

    public void keyReleased(KeyEvent var1) {
        if (var1.isActionKey()) {
            FenetreGraphique.access$500(this.this$0).add(new Integer(var1.getKeyCode()));
        }

    }

    public void keyTyped(KeyEvent var1) {
        FenetreGraphique.access$600(this.this$0).add(new Character(var1.getKeyChar()));
    }
}
