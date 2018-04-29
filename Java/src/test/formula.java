package test;

public class formula {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double r1;
    private double r2;
    protected double distance;
    protected double k;
    protected double angle,angle1;

    public formula(math a,math b)
    {
        x1 = a.x;
        y1 = a.y;
        x2 = b.x;
        y2 = b.y;
        r1 = a.r;
        r2 = b.r;
        distance = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
        k = (y1 - y2)/(x1 - x2);
        angle1 = Math.atan(k);//angle 1
        angle = Math.asin(Math.abs(r1 - r2)/distance);
    }

    public point find_secant(math a){
        double k = -1 * (1/Math.tan(angle1 - angle));
//        double angle_1 = Math.atan(k) + Math.toRadians(180);
//        double k = Math.tan(angle1 - angle);
//        double b1 = Math.sqrt(k*k+1)*a.r - a.x*k+a.y;
//        double b2 = -1*Math.sqrt(k*k+1)*a.r - a.x*k+a.y;
        double angle_1 = angle1 + Math.toRadians(90) - angle;
        point point_on = new point(a.x + a.r * Math.cos(angle_1),a.y + a.r * Math.sin(angle_1));
        return point_on;
    }

    public point find_anthor(math a){
//        double k = -1 * (1/Math.tan(angle1 + angle));
//        double angle_1 = Math.atan(k);
//        double k = Math.tan(angle1 - angle);
        double angle_1 =  angle1 + angle - Math.toRadians(90);
        point point_on = new point(a.x + a.r * Math.cos(angle_1),a.y + a.r * Math.sin(angle_1));
        return point_on;
    }





}
