package com.company;
import javax.swing.JSlider;
import javax.swing.event.*;

public class Controller{
    private JSlider vslider;
    private JSlider vslider1;
    private int laststep = 0;
    public Controller(Cube cube, Viewer v){
        this.vslider = v.vslider;
        vslider.addChangeListener(new ChangeListener(){
            private int i =0;
            public void stateChanged(ChangeEvent e){
                int step = vslider.getValue();

                try{
                    i = ( (step-laststep) / Math.abs(step-laststep));
                }
                catch(Exception Ex){
                    return;
                }

                cube.rotate(-5*i, 0, 0);
                v.repaint();
                laststep=step;
            }
        });
        this.vslider1 = v.vslider1;
        vslider1.addChangeListener(new ChangeListener(){
            private int i =0;
            public void stateChanged(ChangeEvent e){
                int step = vslider1.getValue();

                try{
                    i = ( (step-laststep) / Math.abs(step-laststep));
                }
                catch(Exception Ex){
                    return;
                }

                cube.rotate(0, 5*i, 0);
                v.repaint();
                laststep=step;
            }
        });
    }
}
