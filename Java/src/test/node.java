package test;

public class node {

    protected node next;
    protected node prev;
    protected math circle;
    protected point point1;
    protected point point2;
    protected boolean mark;

    public node(node prev,node next,math a,point b,point c){
        this.next = next;
        this.prev = prev;
        this.circle = new math(a.x,a.y,a.r);
        this.point1 = new point(b.x,b.y);
        this.point2 = new point(c.x,c.y);

    }

    public node(math a,point b,point c){
        this.circle = new math(a.x,a.y,a.r);
        this.point1 = new point(b.x,b.y);
        this.point2 = new point(c.x,c.y);

    }
}
