package test;

import javax.swing.*;
import java.awt.*;

public class line extends JPanel {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public line(point a,point b){
        x1 = a.x;
        x2 = b.x;
        y1 = a.y;
        y2 = b.y;

    }

    public void paint(Graphics g)
    {
//        int min_x = (int)(Math.min(x1,x2));
//        int min_y = (int)(Math.min(y1,y2));
//        int max_x = (int)(Math.max(x1,x2));
//        int max_y = (int)(Math.max(y1,y2));

        g.drawLine((int)(x1),(int)(y1),(int)(x2),(int)(y2));


    }
}
