package com.company;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Random;

public class Facet {
    private Vector[] vertex;
    private Color color;
    private Random r = new Random();
    public Facet(Vector v1, Vector v2, Vector v3, Vector v4){
        vertex = new Vector[4];
        vertex[0]=v1;
        vertex[1]=v2;
        vertex[2]=v3;
        vertex[3]=v4;
        color = new Color(r.nextInt(255), r.nextInt(255) , r.nextInt(255));
    }
    public void print(){
        for (int i = 0; i<3; i++){
            vertex[i].out();
            System.out.print("---");
            vertex[i+1].out();
            System.out.println();
        }
    }

    public void out(){
        for(int i = 0; i<vertex.length; i++) {
            vertex[i].out();
            System.out.print(" - ");
            if(i==3){
                vertex[0].out();
            }else{
                vertex[i + 1].out();
            }
            System.out.print("\n");
        }
    }

    public void drawPersp(Graphics2D g, double focus){
        Path2D path = new Path2D.Double();
        double[] t = new double[4];
        t[0] = focus/(vertex[0].getZ()+focus);
        t[1] = focus/(vertex[1].getZ()+focus);
        t[2] = focus/(vertex[2].getZ()+focus);
        t[3] = focus/(vertex[3].getZ()+focus);
        path.moveTo(vertex[0].getX()*t[0], vertex[0].getY()*t[0]);
        path.lineTo(vertex[1].getX()*t[1], vertex[1].getY()*t[1]);
        path.lineTo(vertex[2].getX()*t[2], vertex[2].getY()*t[2]);
        path.lineTo(vertex[3].getX()*t[3], vertex[3].getY()*t[3]);
        path.lineTo(vertex[0].getX()*t[0], vertex[0].getY()*t[0]);
        path.closePath();

        Facet f = new Facet(new Vector(vertex[0].getX()*t[0], vertex[0].getY()*t[0], vertex[0].getZ()),
                new Vector(vertex[1].getX()*t[1], vertex[1].getY()*t[1], vertex[1].getZ()),
                new Vector(vertex[2].getX()*t[2], vertex[2].getY()*t[2], vertex[2].getZ()),
                new Vector(vertex[3].getX()*t[3], vertex[3].getY()*t[3], vertex[3].getZ()));

        if(f.light()) {
            g.setColor(this.color);
            g.fill(path);

        }
    }

    public boolean light(){
        if(Vector.normal(Vector.diagonals(vertex[0], vertex[1]),Vector.diagonals(vertex[0], vertex[3])).getZ()>0){
            return true;
        }else
            return false;
    }

    public void rotate(double ux, double uy, double uz){
        for(int i=0; i<vertex.length; i++){
            vertex[i].rotate(ux,uy,uz);
        }
    }





    public void scale(double k){
        for(int i=0; i<vertex.length; i++){
            vertex[i].scale(k);
        }
    }

    public void translate(double dx, double dy, double dz){
        for(int i=0; i<vertex.length; i++){
            vertex[i].translate(dx,dy,dz);
        }
    }

    public void draw(Graphics2D g){
        Path2D path = new Path2D.Double();
        path.moveTo(vertex[0].getX(), vertex[0].getY());
        path.lineTo(vertex[1].getX(), vertex[1].getY());
        path.lineTo(vertex[2].getX(), vertex[2].getY());
        path.lineTo(vertex[3].getX(), vertex[3].getY());
        path.lineTo(vertex[0].getX(), vertex[0].getY());
        path.closePath();
        if(light()) {
            g.setColor(this.color);
            g.fill(path);
        }
    }

}

