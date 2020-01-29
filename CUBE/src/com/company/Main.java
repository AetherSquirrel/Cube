package com.company;

public class Main {

    public static void main(String[] args) {
        /*Vector v = new Vector(3.0,2.0,1.0);
        Vector u = new Vector(5.0,8.0,10.0);
        v.out();
        (v.sum(v.sum(v.sum(v)))).out();
        Vector.sum(Vector.sum(v,v),Vector.sum(v,v)).out();
        v.scal(v,v);
        v.vect(v,u);
        v.mash(v);
        v.rotateX(90);
        v.rotateY(90);
        v.rotateZ(90);*/

        Facet f = new Facet(new Vector(0,0,0), new Vector(1,0,0), new Vector(1,1,0),
                new Vector(0,1,0));
        f.out();
        //f.out();
        //f.print();

        //f.scale(5);


        /*
        Cube c = new Cube();
        c.scale(400);
        c.rotate(30,40,70);
        Viewer v = new Viewer(c);
        */


        Cube cube = new Cube();
        cube.scale(100);
        cube.translate(-50,-50,-50);
        cube.rotate(0,0,0);
        Viewer viewer = new Viewer(cube);
        Controller controller = new Controller(cube,viewer);















    }

}
