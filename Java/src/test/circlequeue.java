package test;

public class circlequeue{

    protected node head;
    protected node rear;
    int count;
    protected node a;

    public circlequeue(){
        init();
    }

    public void init(){
        count = 0;
        head = rear = null;
    }



    public void add(math a,point b,point c){
        node e = new node(null,null,a,b,c);

        if (rear != null)
            rear.next = e;
        rear = e;

        if (head == null)
            head = e;

        count++;
    }

    public void delete(node a){
       // if (!isEmpty())
        a.prev.next = a.next;
        count--;

    }

    public  boolean isEmpty(){
        return count ==0;
    }

//    public class node{
//
//        protected node next;
//        protected node prev;
//        protected math circle;
//        protected point point1;
//        protected point point2;
//        protected boolean mark;
//
//        public node(node prev,node next,math a,point b,point c){
//            this.next = next;
//            this.prev = prev;
//            this.circle = new math(a.x,a.y,a.r);
//            this.point1 = new point(b.x,b.y);
//            this.point2 = new point(c.x,c.y);
//
//        }
//    }
}