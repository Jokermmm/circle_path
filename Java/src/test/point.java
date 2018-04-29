package test;

public class point {
    protected double x;
    protected double y;
    protected double angel;

    public point(double a,double b)
    {
        x = a;
        y = b;
    }

    public point(int a,int b,int c)
    {

        angel = 0 + (double)(Math.random()*360);
        x = a + c * Math.cos(Math.toRadians(angel));
        y = b + c * Math.sin(Math.toRadians(angel));

    }
}
