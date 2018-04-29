
package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class form {


    private JButton button1;
    private JPanel gra_field;
    private JPanel txt_field;
    private JTextArea textArea1;
    private JPanel hold;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;
    private JButton Button5;
    private JButton Button6;
    private JButton button2;
    private int i;
    private int j;
    private JLabel labels;
    private circle my;
    private line lines,lines_1,lines_2,l1,l2;
    private math[] record = new math[100];
    private math[] record_fix = new math[100];
    private double[] distance;
    private node[] nodes = new node[100];
    private circlequeue Q = new circlequeue();





    public form() {

        JFrame frame = new JFrame();
        initialize();
        frame.setLayout(null);
        txt_field.setBounds(450,0,400,400);
        frame.add(txt_field);
        frame.setSize(900,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int count = 0;
                math point = new math();
                record[i] = new math(point.x, point.y, point.r);
                /////////
                //circle my;
                if(i==0) {
                    my = new circle(point.x, point.y, point.r);
                    record_fix[j] = new math(point.x, point.y, point.r);
                    j++;
                    my.setBounds(0,0,400,400);
//                    labels = new JLabel("1");
//                    labels.setBounds(point.x+5,point.y+5,5,5);
//                    my.add(labels);
                    frame.add(my);
                    //frame.add(labels);

                }
                else {
                    for (int j = 0; j < i; j++) {
                        if (Math.sqrt((point.x-record[j].x)*(point.x-record[j].x) + (point.y-record[j].y)*(point.y-record[j].y)) > (point.r+record[j].r))
                            count++;
                        else
                            break;
                    }
                    if(count == i) {
                        my = new circle(point.x, point.y, point.r);
                        record_fix[j] = new math(point.x, point.y, point.r);
                        j++;
                        my.setBounds(0,0,400,400);
//                        labels = new JLabel((j+1)+"");
//                        labels.setBounds(point.x+5,point.y+5,5,5);
                        frame.add(my);
//                        frame.add(labels);

                    }
                }
                //textArea1.append(point.x+" "+point.y+" "+point.r+" "+count+" ");
                //textArea1.append("J的大小："+j+" ");
                i++;

                for (int i = 0;i<j;i++){
                    labels = new JLabel((i+1)+"");
                    labels.setBounds(record_fix[i].x+1,record_fix[i].y
                            +1,10,10);
                    frame.add(labels);
                }
                frame.repaint();
            }
        });

        Button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int count = 0;
                double distance = 0;
                point[] circle_point = new point[j];
                for (int i = 0;i < j;i++)
                {
                    if (!nodes[i].mark) {
                        circle_point[count++] = new point(nodes[i].circle.x, nodes[i].circle.y, nodes[i].circle.r);
                    }
                    else
                        continue;
                }

                for (int i = 1;i < count;i++) {
                    distance = distance + Distance(circle_point[i-1], circle_point[i]);
                    lines = new line(circle_point[i-1], circle_point[i]);
                    lines.setBounds(0,0,400,400);
                    frame.add(lines);
                }
                distance = distance + Distance(circle_point[count-1],circle_point[0]);
                line last = new line(circle_point[count-1],circle_point[0]);
                last.setBounds(0,0,400,400);
                frame.add(last);
                //textArea1.append("初始随机距离：" + distance);
                frame.repaint();
            }
        });
        Button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                formula[] lin = new formula[j];
                for (int i = 0;i < j-1;i++){
                    lin[i] = new formula(record_fix[i],record_fix[i+1]);

                    //textArea1.append("圆心距1："+ lin.distance + "斜率k：" + lin.k + " ");
                }
                lin[j-1] = new formula(record_fix[j-1],record_fix[0]);
                for (int i = 0;i < j-1;i++) {
//                    textArea1.append("圆心距：" + lin[i].distance+"斜率k: "+ lin[i].k + "旋转之后的k1:" + Math.tan(lin[i].angle1 - lin[i].angle)
//                    + "旋转后的k1:" + Math.tan(lin[i].angle1 + lin[i].angle) + " ");
                    ;
//                    textArea1.append("圆1：" + "（"+lin[i].find_secant(record_fix[i]).x+","+lin[i].find_secant(record_fix[i]).y+")"
//                    +"圆1："+ "（"+lin[i].find_anthor(record_fix[i]).x+","+lin[i].find_anthor(record_fix[i]).y+")");
//                    textArea1.append(j+" " +(lin[i-1].angle + lin[i-1].angle1)+" "+(lin[i-1].angle1 - lin[i-1].angle)+ " ");
//                    if(lin[i-1].Judege(record_fix[i-1],lin[i-1].find_anthor(record_fix[i-1]),lin[i-1].find_anthor(record_fix[i])))
//                    {
                        lines_1 = new line(lin[i].find_anthor(record_fix[i]),lin[i].find_anthor(record_fix[i+1]));
                        nodes[i] = new node(record_fix[i],lin[i].find_anthor(record_fix[i]),lin[i].find_secant(record_fix[i]));
                        Q.add(record_fix[i],lin[i].find_anthor(record_fix[i]),lin[i].find_secant(record_fix[i]));
                        lines_1.setBounds(0,0,400,400);
                        frame.add(lines_1);
//                    }
//                    else
//                    {
//                        line lines_1 = new line(lin[i-1].find_anthor1(record_fix[i-1]),lin[i-1].find_anthor1(record_fix[i]));
//                        lines_1.setBounds(0,0,400,400);
//                        frame.add(lines_1);
//                    }
//                    if(lin[i-1].Judege(record_fix[i-1],lin[i-1].find_anthor(record_fix[i-1]),lin[i-1].find_anthor(record_fix[i])))
//                    {
                        lines_2 = new line(lin[i].find_secant(record_fix[i]),lin[i].find_secant(record_fix[i+1]));
                        lines_2.setBounds(0,0,400,400);
                        frame.add(lines_2);
//                    }
//                    else
//                    {
//                        line lines_2 = new line(lin[i-1].find_secant1(record_fix[i-1]),lin[i-1].find_secant1(record_fix[i]));
//                        lines_2.setBounds(0,0,400,400);
//                        frame.add(lines_2);
//                    }
//                    point yuanxin_1 = new point(record_fix[i].x,record_fix[i].y);
//                    point yuanxin_2 = new point(record_fix[i+1].x,record_fix[i+1].y);
//                    line a = new line(yuanxin_1,yuanxin_2);
//                    a.setBounds(0,0,400,400);
//                    frame.add(a);
                }
                l1 = new line(lin[j-1].find_secant(record_fix[j-1]),lin[j-1].find_secant(record_fix[0]));
                frame.add(l1);
                l1.setBounds(0,0,400,400);
                l2 = new line(lin[j-1].find_anthor(record_fix[j-1]),lin[j-1].find_anthor(record_fix[0]));
                frame.add(l2);
                l2.setBounds(0,0,400,400);
                Q.add(record_fix[j-1],lin[j-1].find_anthor(record_fix[j-1]),lin[j-1].find_secant(record_fix[j-1]));
                nodes[j-1] = new node(record_fix[j-1],lin[j-1].find_anthor(record_fix[j-1]),lin[j-1].find_secant(record_fix[j-1]));
                Q.rear.next = Q.head;
                frame.repaint();
            }
        });
        Button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                circle fixed;
                int count = 0;
                frame.getContentPane().removeAll();
                txt_field.setBounds(450,0,400,400);
                frame.add(txt_field);
                frame.repaint();
//                node a = Q.head;
//                while (a != Q.rear){
//                    //textArea1.append("R: "+a.circle.r+" ");
//                    a.next.mark = Judege(a.next.circle,a.point1,a.next.point1)&&Judege(a.circle,a.prev.point2,a.next.point2);
//                    if (a.next.mark)
//                        a = a.next;
//
//                }
                nodes[0].mark = Judege(nodes[0].circle,nodes[j-1].point1,nodes[1].point1)&&Judege(nodes[0].circle,nodes[j-1].point2,nodes[1].point2);
                for (int i = 1;i <= j-2;i++){
                    if (nodes[0].mark)
                        nodes[i].mark = Judege(nodes[i].circle,nodes[i-1].point1,nodes[i+1].point1)&&Judege(nodes[i].circle,nodes[i-1].point2,nodes[i+1].point2);
                    else
                        nodes[i].mark = Judege(nodes[0].circle,nodes[i-1].point1,nodes[i+1].point1)&&Judege(nodes[i].circle,nodes[i-1].point2,nodes[i+1].point2);
                }
                nodes[j-1].mark = Judege(nodes[j-1].circle,nodes[j-2].point1,nodes[0].point1)&&Judege(nodes[j-1].circle,nodes[j-2].point2,nodes[0].point2);
                for (int i = 0;i < j;i++){
                    if (!nodes[i].mark) {
                        fixed = new circle(nodes[i].circle.x, nodes[i].circle.y, nodes[i].circle.r);
                        fixed.setBounds(0, 0, 400, 400);
                        frame.add(fixed);
                        count++;
                    }

                }
                for (int i = 0;i < j;i++){
                    if (!nodes[i].mark) {
                        labels = new JLabel((i+1)+"");
                        labels.setBounds(nodes[i].circle.x+1,nodes[i].circle.y
                                +1,10,10);
                        frame.add(labels);
                    }
                }

                //j = count;
                frame.repaint();


            }
        });
        Button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                circle circles;
                frame.getContentPane().removeAll();
                txt_field.setBounds(450,0,400,400);
                frame.add(txt_field);
                for (int i = 0;i < j;i++){
                    if (!nodes[i].mark) {
                        circles = new circle(nodes[i].circle.x, nodes[i].circle.y, nodes[i].circle.r);
                        circles.setBounds(0, 0, 400, 400);
                        frame.add(circles);
                    }

                }
                for (int i = 0;i < j;i++){
                    if (!nodes[i].mark) {
                        labels = new JLabel((i+1)+"");
                        labels.setBounds(nodes[i].circle.x+1,nodes[i].circle.y
                                +1,10,10);
                        frame.add(labels);
                    }
                }
                frame.repaint();
                int count = 0;
                int Iteration_count = 1;
//                double[] distance = new double[1000];
                math[] fixed = new math[j];
                point[] circle_point = new point[j];
                for (int i = 0;i < j;i++)
                {
                    if (!nodes[i].mark) {
                        circle_point[count] = new point(nodes[i].circle.x, nodes[i].circle.y, nodes[i].circle.r);//随机初始点
                        fixed[count] = nodes[i].circle;//过滤后的圆
                        count++;
                    }
                    else
                        continue;
                }
                do{
                    double distance_tem = 0;
                    for (int i = 1;i<count-1;i++){
                            circle_point[i] = Iteration(fixed[i],circle_point[i-1],circle_point[i+1]);
                    }
                        circle_point[count-1] = Iteration(fixed[count-1],circle_point[count-2],circle_point[0]);//一次迭代

                        circle_point[0] = Iteration(fixed[0],circle_point[count-1],circle_point[1]);

                    for (int i = 1;i < count;i++) {
                        distance_tem = distance_tem + Distance(circle_point[i-1], circle_point[i]);
                    }//计算距离
                    distance_tem = distance_tem + Distance(circle_point[count-1],circle_point[0]);
                    distance[Iteration_count] = distance_tem;
                    Iteration_count++;
                }while (Math.abs(distance[Iteration_count-2]-distance[Iteration_count-1])>Double.MIN_VALUE);

                distance = new double[1000];
                Iteration_count = 1;
                do{
                    double distance_tem1 = 0;
                    for (int i = 1;i<count-1;i++){
                        circle_point[i] = Iteration(fixed[i],circle_point[i-1],circle_point[i+1]);
                    }
                    circle_point[count-1] = Iteration(fixed[count-1],circle_point[count-2],circle_point[0]);

                    circle_point[0] = Iteration(fixed[0],circle_point[count-1],circle_point[1]);

                    for (int i = 1;i < count;i++) {
                        distance_tem1 = distance_tem1 + Distance(circle_point[i-1], circle_point[i]);
                    }//计算距离
                    distance_tem1 = distance_tem1 + Distance(circle_point[count-1],circle_point[0]);
                    distance[Iteration_count] = distance_tem1;
                    Iteration_count++;
                }while (Math.abs(distance[Iteration_count-2]-distance[Iteration_count-1])>Double.MIN_VALUE);

                textArea1.append("最终随机距离：" + distance[Iteration_count-1]+"迭代次数："+(Iteration_count-1));
                for (int i = 1;i < count;i++) {
                    lines = new line(circle_point[i-1], circle_point[i]);
                    lines.setBounds(0,0,400,400);
                    frame.add(lines);
                }
                line last = new line(circle_point[count-1],circle_point[0]);
                last.setBounds(0,0,400,400);
                frame.add(last);
                frame.repaint();

            }
        });

        Button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.getContentPane().removeAll();
                txt_field.setBounds(450,0,400,400);
                frame.add(txt_field);
                frame.repaint();
                textArea1.setText("");
                initialize();
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                point point1 = new point(-2,1);
                point point2 = new point(-2,-5);
                math circle = new math(0,0,1);
                point find;
                find = Iteration(circle,point1,point2);
                textArea1.append("find:"+find.x+","+find.y);
            }
        });
    }

    public double Distance(point a,point b){

        return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
    }

    public point Iteration(math circle,point a,point b){//算法核心
//        point c;
//        double k = -1/(a.y-b.y)/(a.x-b.x);
//        double angle = Math.atan(k);
//        double x,y;
//        x = circle.x + circle.r*Math.cos(angle);
//        y = circle.y + circle.r*Math.sin(angle);
//        double distance = Math.abs((a.y-b.y)/(a.x-b.x)*x-y+(a.y-a.x*(a.y-b.y)/(a.x-b.x)))/Math.sqrt(Math.pow((a.y-b.y)/(a.x-b.x),2)+1);
//        double m,n;
//        m = circle.x + circle.r*Math.cos(angle+Math.toRadians(180));
//        n = circle.y + circle.r*Math.sin(angle+Math.toRadians(180));
//        double distance1 = Math.abs((a.y-b.y)/(a.x-b.x)*m-n+(a.y-a.x*(a.y-b.y)/(a.x-b.x)))/Math.sqrt(Math.pow((a.y-b.y)/(a.x-b.x),2)+1);
//        if (distance < distance1)
//            c = new point(x,y);
//        else
//            c = new point(m,n);
//        return c;
        ///////////
        double b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
        double r2 = circle.r*circle.r;
        double a1,a2,a3,a4;
        double k;
        point[] points = new point[8];
        double[] angle = new double[8];
        double[] distance1 = new double[8];
        int mark=0;
        point a_fix;
        point b_fix;
        point circle_po,final_point;
        a_fix = new point(a.x-circle.x,a.y-circle.y);
        b_fix = new point(b.x-circle.x,b.y-circle.y);
        b1 = Math.pow(a_fix.x,2) + Math.pow(a_fix.y,2);
        b2 = Math.pow(b_fix.x,2) + Math.pow(b_fix.y,2);
        b3 = 2*Math.pow(circle.r,2)*a_fix.x*b_fix.x+Math.pow(circle.r,2)*Math.pow(a_fix.y,2)+Math.pow(b_fix.x,2)*(Math.pow(circle.r,2)-4*Math.pow(a_fix.y,2))+
                2*Math.pow(circle.r,2)*a_fix.y*b_fix.y+Math.pow(circle.r,2)*Math.pow(b_fix.y,2)-4*Math.pow(a_fix.y,2)*Math.pow(b_fix.y,2)+Math.pow(a_fix.x,2)*(Math.pow(circle.r,2)-4*b2);
//        b3 = 2*r2*a.x*b.x+r2*a.y*a.y+b.x*b.x*(r2-4*a.y*a.y)+2*r2*a.y*b.y+r2*b.y*b.y-4*a.y*a.y*b.y*b.y+a.y*a.y*(r2-4*b2);
        b4 = 2*Math.pow(a_fix.x,2)*b_fix.x+b_fix.x*a_fix.y*(a_fix.y-b_fix.y)+a_fix.x*(2*Math.pow(b_fix.x,2)-b_fix.y*(a_fix.y-b_fix.y));
        b5 = Math.pow(b_fix.x,2)*(-1*Math.pow(circle.r,2)+Math.pow(a_fix.y,2))-2*a_fix.x*b_fix.x*(Math.pow(circle.r,2)-a_fix.y*b_fix.y)+Math.pow(a_fix.x,2)*(Math.pow(b_fix.y,2)-Math.pow(circle.r,2));
//        b5 = b.x*b.x*(a.y*a.y-r2)-2*a.x*b.x*(r2-a.y*b.y)+a.x*a.x*(b.y*b.y-r2);
        b6 = 36*Math.pow(circle.r,2)*(6*b5*Math.pow(b1*b_fix.x+b2*a_fix.x,2)+b3*b4*(b1*b_fix.x+b2*a_fix.x)+6*b1*b2*Math.pow(b4,2));
//        b6 = 36*r2*(6*b5*(b1*b.x+b2*a.x)*(b1*b.x+b2*a.x)+b3*b4*(b1*b.x+b2*a.x)+6*b1*b2*b4*b4);
        b7 = Math.pow(b3,2)+48*b1*b2*b5+24*Math.pow(circle.r,2)*b4*(b1*b_fix.x+b2*a_fix.x);
//        b7 = b3*b3+48*b1*b2*b5+24*r2*b4*(b1*b.x+b2*a.x);
        k = -4*Math.pow(b7,3)+4*Math.pow(Math.pow(b3,3)-144*b1*b2*b3*b5+b6,2);
        if (k<0)
            k = 0;
        b8 = (1/Math.cbrt(2))* Math.cbrt(2*Math.pow(b3,3)-288*b1*b2*b3*b5+2*b6+Math.sqrt(k));
        b9 = 12*b1*b2;
        b10 = -1*b3/(3*b1*b2)+Math.pow(circle.r,2)*Math.pow(b1*b_fix.x+b2*a_fix.x,2)/(2*Math.pow(b1,2)*Math.pow(b2,2));
        b11 = circle.r*(Math.pow(circle.r,2)*Math.pow(b1*b_fix.x+b2*a_fix.x,3)-b1*b2*b3*(b1*b_fix.x+b2*a_fix.x)-4*Math.pow(b1,2)*Math.pow(b2,2)*b4);
        a1 = circle.r*(b1*b_fix.x+b2*a_fix.x)/(b1*b2);
        double k2 = b10/2+(b7/b8+b8)/b9;
        a2 = Math.sqrt(k2)/2;
        a3 = b10-(b7/b8+b8)/b9;
        a4 = b11/(8*Math.pow(b1,3)*Math.pow(b2,3)*a2);
        double[] m = new double[4];
        m[0] = a1 / 4 - a2 - Math.sqrt(a3 - a4) / 2;
        m[1] = a1 / 4 - a2 + Math.sqrt(a3 - a4) / 2;
        m[2] = a1 / 4 + a2 - Math.sqrt(a3 + a4) / 2;
        m[3] = a1 / 4 + a2 + Math.sqrt(a3 + a4) / 2;
        for (int i = 0;i<4;i++)
        {
            if (m[i]>1)
                m[i]=1;
            if (m[i]<-1)
                m[i]=-1;
        }
//        points[0] = new point(circle.r*(a1/4-a2-Math.sqrt(a3-a4)/2),-1*circle.r*Math.sqrt(1-Math.pow(a1/4-a2-Math.sqrt(a3-a4)/2,2)));
//        points[1] = new point(circle.r*(a1/4-a2-Math.sqrt(a3-a4)/2),circle.r*Math.sqrt(1-Math.pow(a1/4-a2-Math.sqrt(a3-a4)/2,2)));
//        points[2] = new point(circle.r*(a1/4-a2+Math.sqrt(a3-a4)/2),-1*circle.r*Math.sqrt(1-Math.pow(a1/4-a2+Math.sqrt(a3-a4)/2,2)));
//        points[3] = new point(circle.r*(a1/4-a2+Math.sqrt(a3-a4)/2),circle.r*Math.sqrt(1-Math.pow(a1/4-a2+Math.sqrt(a3-a4)/2,2)));
//        points[4] = new point(circle.r*(a1/4+a2-Math.sqrt(a3+a4)/2),-1*circle.r*Math.sqrt(1-Math.pow(a1/4+a2-Math.sqrt(a3+a4)/2,2)));
//        points[5] = new point(circle.r*(a1/4+a2-Math.sqrt(a3+a4)/2),circle.r*Math.sqrt(1-Math.pow(a1/4+a2-Math.sqrt(a3+a4)/2,2)));
//        points[6] = new point(circle.r*(a1/4+a2+Math.sqrt(a3+a4)/2),-1*circle.r*Math.sqrt(1-Math.pow(a1/4+a2+Math.sqrt(a3+a4)/2,2)));
//        points[7] = new point(circle.r*(a1/4+a2+Math.sqrt(a3+a4)/2),circle.r*Math.sqrt(1-Math.pow(a1/4+a2+Math.sqrt(a3+a4)/2,2)));
        if ((a3-a4)>=0&&k2>0){
            angle[0] = -1*Math.acos(m[0]);
            angle[1] = Math.acos(m[0]);
            angle[2] = -1*Math.acos(m[1]);
            angle[3] = Math.acos(m[1]);
        }
        else {
            if (a.x<circle.x&&b.x<circle.x)
                angle[0] = angle[1] = angle[2] = angle[3] = Math.toRadians(180);
            if (a.x>circle.x&&b.x>circle.x)
                angle[0] = angle[1] = angle[2] = angle[3] = Math.toRadians(0);
            if (a.y>circle.y&&b.y>circle.y)
                angle[0] = angle[1] = angle[2] = angle[3] = Math.toRadians(90);
            if (a.y<circle.y&&b.y<circle.y)
                angle[0] = angle[1] = angle[2] = angle[3] = Math.toRadians(270);
        }
        if ((a3+a4)>=0&&k2>0) {
            angle[4] = -1 * Math.acos(m[2]);
            angle[5] = Math.acos(m[2]);
            angle[6] = -1 * Math.acos(m[3]);
            angle[7] = Math.acos(m[3]);
        }
        else {
            if (a.x<circle.x&&b.x<circle.x)
                angle[4] = angle[5] = angle[6] = angle[7] = Math.toRadians(180);
            if (a.x>circle.x&&b.x>circle.x)
                angle[4] = angle[5] = angle[6] = angle[7] = Math.toRadians(0);
            if (a.y>circle.y&&b.y>circle.y)
                angle[4] = angle[5] = angle[6] = angle[7] = Math.toRadians(90);
            if (a.y<circle.y&&b.y<circle.y)
                angle[4] = angle[5] = angle[6] = angle[7] = Math.toRadians(270);
        }
        //

        for (int i=0;i<8;i++){
            circle_po = new point(circle.r*Math.cos(angle[i]),circle.r*Math.sin(angle[i]));
            distance1[i]=Distance(circle_po,a_fix)+Distance(circle_po,b_fix);
//            textArea1.append("angle: "+angle[i]+" ");
        }
        for (int i = 1;i<8;i++){
            if (distance1[mark]>distance1[i])
                mark = i;
            else
                continue;
        }
        if ((a3-a4)<0)
            textArea1.append("mark：0-3 "+mark+"");
        if ((a3+a4)<0)
            textArea1.append("mark: 4-7 "+mark+"");
//        if (k2<0)
//            textArea1.append("k2:"+k2+"");

        //textArea1.append("angle:"+angle[mark]+" ");
        //textArea1.append("-- "+"b8="+b8+"  "+"b9="+b9+"  "+"k2="+k2+"  "+"a2="+a2+"  ");
//        if (angle[mark]==0)
//            textArea1.append("a3-a4= "+(a3-a4)+" "+"a3+a4= "+(a3+a4)+" "+"mark: "+mark+" ");
//        textArea1.append("mark: "+(a1 / 4 + a2 - Math.sqrt(a3 + a4) / 2)+" ");
//        b1+" // "+b2+" // "+b3+" // "+b4+" // "+b5+" // "+b6+" // "+b7+" // "+b8+" // "+b9+" // "+b10+" // "+b11+" // "+
        final_point = new point(circle.x+circle.r*Math.cos(angle[mark]),circle.y+circle.r*Math.sin(angle[mark]));
//        textArea1.append(k2+" // "+a1+" // "+a2+" // "+a3+" // "+a4+" // ");
//        textArea1.append((a3+a4)+" ---"+(a3-a4)+"    "+(a1/4+a2-Math.sqrt(a3+a4)/2)+"k= "+(-4*Math.pow(b7,3)+4*Math.pow(Math.pow(b3,3)-144*b1*b2*b3*b5+b6,2)));
        //textArea1.append(1/Math.pow(2,1.0/3.0)*Math.pow(2*Math.pow(b3,3)-288*b1*b2*b3*b5+2*b6+Math.sqrt(-4*Math.pow(b7,3)+4*Math.pow(Math.pow(b3,3)-144*b1*b2*b3*b5+b6,2)),1.0/3.0)+"  ");
        return final_point;
    }


    public void initialize(){
        i = j = 0;
        record = new math[100];
        record_fix = new math[100];
        nodes = new node[100];
        Q = new circlequeue();
        distance = new double[1000];

    }

    public point find_point(point point1,point point2,math circle){
        double k = (point1.y-point2.y)/(point1.x-point2.x);
        double m = point1.y-k*point1.x;
        double a = k*k+1;
        double b = 2*k*m-2*k*circle.y-2*circle.x;
        double c = circle.x*circle.x+(m-circle.y)*(m-circle.y)-circle.r*circle.r;
        double x = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
        double y = k*x+m;
        return new point(x,y);
    }

    public boolean Judege(math a,point b,point c){
        double distance1 ;
        double k = (b.y - c.y)/(b.x - c.x);
        double l = c.y - c.x * k;
        distance1 = Math.abs(a.x * k - a.y + l)/Math.sqrt(Math.pow(k,2) + 1);
        if(distance1 < a.r){
            return true;
        }
        else
            return false;

    }

    public static void main(String[] args) {
        form dc = new form();

    }

}
