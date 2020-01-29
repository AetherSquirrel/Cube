package com.company;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Viewer extends JFrame{
    public static final int width = 600;
    public static final int height = 600;
    private Cube cube;
    public Container pane;
    public JPanel renderPanel;
    public JSlider vslider;
    public JSlider vslider1;
    public Viewer(Cube cube) {
        this.cube = cube;
        this.setSize(width, height);
        pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        renderPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics gr){
                Graphics2D g = (Graphics2D)gr;
                BasicStroke pen1 = new BasicStroke(3);
                g.setStroke(pen1);
                g.translate(Viewer.width/2, Viewer.height/2);
                g.setColor(Color.white);
                g.fillRect(-width/2,-height/2, width, height);
                //cube.draw(g);
                cube.drawPersp(g, 300);
            }
        };
        pane.add(renderPanel, BorderLayout.CENTER);
        vslider = new JSlider(SwingConstants.VERTICAL,-90,90,0);
        vslider1 = new JSlider(SwingConstants.HORIZONTAL,-90,90,0);
        pane.add(vslider, BorderLayout.EAST);
        pane.add(vslider1, BorderLayout.SOUTH);


        /*
        vslider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                int step = vslider.getValue();
                cube.rotate(step, step, 0);
                repaint();
            }
        });
         */
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Окошко");
    }
    //@Override


    /*
    public void paint(Graphics gr){
        Graphics2D g = (Graphics2D)gr;
        BasicStroke pen1 = new BasicStroke(3);
        g.setStroke(pen1);
        g.translate(Viewer.width/2, Viewer.height/2);
        g.setColor(Color.white);
        g.fillRect(-width/2,-height/2, width, height);
        //cube.draw(g);
        cube.drawPersp(g, 300);
    }
    */
}