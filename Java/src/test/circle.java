package test;

import javax.swing.*;
import java.awt.*;


public class circle extends JPanel {
    int x,y;
    int r;

    public circle(int a,int b,int c)
    {
        x = a;
        y = b;
        r = c;
    }

    public void paint(Graphics g)
    {
        g.drawOval(x-r, y-r, 2*r, 2*r);
        g.fillOval(x, y, 1, 1);

    }
}
