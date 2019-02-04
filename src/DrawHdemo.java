/* DrawHdemo.Java
 * Computer Science 112, Spring 2014
 * Last edited Jan. 20, 2014 by C. Herbert
 * 
 * This code demonstrates how to draw an H-shaped fractal antenna 
 * using Java Graphics class objects and recursion
 * 
 * It has two mutually recursive methods to draw the horizontal lines 
 * and vertical line of an H to form an H-shaped antenna.
 * 
 * The end points of a line in one direction become the midpoints for two 
 * lines in the other diirection.
 * 
 * The recursion starts wiht a horizontal line 200 units long and stops
 * when the line length would be less than 10
 * 
 * It has five levels of recursion, with lines of length 
 * 
 * 200 - 100 - 50 - 25 - 12
 * 
 */
package drawhdemo;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DrawHdemo {

    public static void main(String[] args) {

        // create HCanvas object
        HCanvas canvas1 = new HCanvas();

        // set up a JFrame to hold the canvas
        JFrame frame = new JFrame();
        frame.setTitle("H-shaped Fractal Antenna");

        // the JFrame size is 500 x 500; the midpoint will be 250,250
        frame.setSize(500, 500);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the canvas to the frame as a content panel
        frame.getContentPane().add(canvas1);
        frame.setVisible(true);
    } // end main()
} // end class

class HCanvas extends Canvas {


    // HCanvas() constructor
    public HCanvas() {
    }

    public void paint(Graphics graphics) {
    double x1;      // x coordinate for point 1
    double y1;      // y coordinate for point 1
    double x2;      // x coordinate for point 2
    double y2;      // y coordinate for point 2
    
    //set the midpoint for the first line in the center of the canvas
    double xMid = 250;
    double yMid = 250;
    double length = 200;      // the length of the first line to be drawn

        String title;       // a ttitle for the image on the canvas
        
        // Put a title on the Canvas
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font("Arial", Font.PLAIN, 18));
        title = "H-shaped Fractal Antenna";
        graphics.drawString(title, 150, 30);

        // set drawing color back to black
        graphics.setColor(Color.BLACK);

        //draw the first line
        drawH(graphics, xMid, yMid, length );

        
    }  // end paint()


    //***********************************************************************************************

    public void drawH(Graphics graphics, double xMid, double yMid, double length)
    {
        // find horizontal left endpoint
        double x1 = xMid - (length / 2);
        double y1 = yMid;

        // find horizontal right endpoint
        double x2 = xMid + (length / 2);
        double y2 = yMid;


        // find lower left vertical endpoint
        double x3 = x1;
        double y3 = yMid - (length / 2);

        // find upper left vertical endpoint
        double x4 = x1;
        double y4 = yMid + (length / 2);

        // find lower right vertical endpoint
        double x5 = x2;
        double y5 = yMid - (length / 2);

        // find upper right vertical endpoint
        double x6 = x2;
        double y6 = yMid + (length / 2);

//        graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
//        graphics.drawLine((int) x3, (int) y3, (int) x4, (int) y4);

        if (length > 5)
        {
            graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            graphics.drawLine((int) x3, (int) y3, (int) x4, (int) y4);
            try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            graphics.drawLine((int) x5, (int) y5, (int) x6, (int) y6);

            drawH(graphics,(int) x3, (int) y3,(length/2));
            drawH(graphics,(int) x4, (int) y4,(length/2));
            drawH(graphics,(int) x5, (int) y5,(length/2));
            drawH(graphics,(int) x6, (int) y6,(length/2));



        }//end if

    } // end drawH


} // end class MyCanvas



