package com.company;

import java.awt.*;

public class Cube {
    private Facet[] facets;
    public Cube(){
        facets = new Facet[6];
        facets[0] = new Facet(new Vector(0,0,0),
                new Vector(1,0,0),
                new Vector(1,1,0),
                new Vector(0,1,0));
        facets[1] = new Facet(new Vector(1,0,1),
                new Vector(1,1,1),
                new Vector(1,1,0),
                new Vector(1,0,0));
        facets[2] = new Facet(new Vector(0,0,0),
                new Vector(0,1,0),
                new Vector(0,1,1),
                new Vector(0,0,1));
        facets[3] = new Facet(new Vector(0,0,0),
                new Vector(0,0,1),
                new Vector(1,0,1),
                new Vector(1,0,0));
        facets[4] = new Facet(new Vector(0,1,0),
                new Vector(1,1,0),
                new Vector(1,1,1),
                new Vector(0,1,1));
        facets[5] = new Facet(new Vector(0,0,1),
                new Vector(0,1,1),
                new Vector(1,1,1),
                new Vector(1,0,1));
    }

    public void scale(double k){
        for(int i=0; i<facets.length; i++){
            facets[i].scale(k);
        }
    }

    public void translate(double dx, double dy, double dz){
        for(int i=0; i<facets.length; i++){
            facets[i].translate(dx,dy,dz);
        }
    }

    public void rotate(double ux, double uy, double uz){
        for(int i=0; i<facets.length; i++){
            facets[i].rotate(ux,uy,uz);
        }
    }

    public void draw(Graphics2D g){
        for(int i = 0; i<facets.length; i++){
            facets[i].draw(g);
        }
    }

    public void drawPersp(Graphics2D g, double focus){
        for(int i = 0; i<facets.length; i++){
            facets[i].drawPersp(g, focus);
        }
    }
}