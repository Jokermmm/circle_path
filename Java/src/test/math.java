package test;

import java.util.Random;

public class math {
    protected int x,y;
    protected int r;
    private int min_r,max_r;
    protected boolean mark;

    public  math(int a,int b,int c)
    {
        x = a;
        y = b;
        r = c;
    }

    public math()
    {
        int tem1,tem2;
        Random rand = new Random();
        x = rand.nextInt(300) + 50;
        y = rand.nextInt(300) + 50;
//        x = 40 + (int)(Math.random()*360);
//        y = 40 + (int)(Math.random()*360);
//        tem1 = Math.min(x,y);
//        tem2 = Math.min(tem1,400-x);
//        max_r = Math.min(tem2,400-y);
        min_r = 10;
        r = rand.nextInt(40) + min_r;
//        r = min_r + (int)(Math.random()*40);

    }
}
