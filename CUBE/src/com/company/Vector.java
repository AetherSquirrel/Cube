package com.company;

public class Vector {
    private double x,y,z;
    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    /*
    public void sum(Vector v){
        System.out.println((x+v.x)+","+(y+v.y)+","+(z+v.z));
    }
    */
    public Vector sum(Vector v){
        return new Vector(x+v.x,y+v.y,z+v.z);
    }
    public static Vector sum(Vector a, Vector b){
        return new Vector(a.x+b.x,a.y+b.y,a.z+b.z);
    }

    public double cos(Vector a, Vector b){
        return (((a.x*b.x)+(a.y*b.y)+(a.z*b.z))/( Math.sqrt((a.x*a.x)+(a.y+a.y)+(a.z*a.z))*Math.sqrt((b.x*b.x)+(b.y+b.y)+(b.z*b.z))));
    }

    public void scale(double k){
        this.x = this.x*k;
        this.y = this.y*k;
        this.z = this.z*k;
    }

    public static Vector vect(Vector a, Vector b){
        return new Vector((a.y*b.z-a.z*b.y), a.z*b.x-a.x*b.z, a.x*b.y-a.y*b.x);
    }

    int k = 3;

    public void multiple(double k){
        x*=k;
        y*=k;
        z*=k;
    }

    public void out(){
        System.out.print("("+this.x + ", " + this.y + ", " + this.z+")");
    }

    public void rotateX(double deg){
        double z0; double y0;
        z0 = z*Math.cos(Math.toRadians(deg))+y*Math.sin(Math.toRadians(deg));
        y0 = y*Math.cos(Math.toRadians(deg))-z*Math.sin(Math.toRadians(deg));
        this.z=z0; this.y=y0;
    }

    public void rotateY(double deg){
        double z0; double x0;
        z0 = z*Math.cos(Math.toRadians(deg))+x*Math.sin(Math.toRadians(deg));
        x0 = x*Math.cos(Math.toRadians(deg))-z*Math.sin(Math.toRadians(deg));
        this.z=z0; this.x=x0;
    }

    public static double Scalar(Vector a, Vector b){
        return (a.x*b.x + a.y*b.y + a.z*b.z);
    }


    public void rotateZ(double deg){
        double x0; double y0;
        x0 = x*Math.cos(Math.toRadians(deg))+y*Math.sin(Math.toRadians(deg));
        y0 = y*Math.cos(Math.toRadians(deg))-x*Math.sin(Math.toRadians(deg));
        this.x=x0; this.y=y0;
    }

    public void rotate(double ux, double uy, double uz){
        rotateX(ux);
        rotateY(uy);
        rotateZ(uz);
    }

    public void moveX(double dx){x+=dx;}
    public void moveY(double dy){y+=dy;}
    public void moveZ(double dz){z+=dz;}

    public void move(double dx, double dy, double dz){
        moveX(dx);
        moveY(dy);
        moveZ(dz);
    }

    public void translate(double dx, double dy, double dz){
        this.x = this.x+dx;
        this.y = this.y+dy;
        this.z = this.z+dz;
    }

    public static Vector toVector(Vector v1, Vector v2){
        return new Vector(v2.x-v1.x, v2.y-v1.y, v2.z-v1.z);
    }
    public static Vector diagonals(Vector vector1, Vector vector2){
        return new Vector(vector2.x-vector1.x, vector2.y-vector1.y, vector2.z-vector1.z);
    }
    public static Vector normal(Vector vector1, Vector vector2){
        return Vector.Vector(vector1, vector2);
    }

    public static Vector Vector(Vector a, Vector b){
        return new Vector((a.y*b.z-a.z*b.y), a.z*b.x-a.x*b.z, a.x*b.y-a.y*b.x);
    }
}