package edu.ucsb.cs56.w16.drawings.neutrino.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.*;
import java.lang.Math;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A Mouse
      
   @author Abhijit Kulkarni
   @version for CS56, W16, UCSB
   
*/

public class Mouse extends GeneralPathWrapper implements Shape 
{
	double xcoord;
	double ycoord;
	double width;
	double height;
	double rounded_width;
	double rounded_height;
	double button_y;
	double middle_x;
	double button_height;
	/**
       Constructor
       
       @param x x coord of lower left corner of mouse
       @param y y coord of lower left corner of mouse
       @param width width of the mouse
       @param height height of the mouse
    */
    public Mouse(double x, double y, double w, double h)
    {
      	xcoord = x;
      	ycoord = y;
      	width = w;
      	height = h;
      	rounded_width = 0.50*Math.sqrt(Math.pow(w,2)+Math.pow(h,2));
      	rounded_height = rounded_width;

      	button_y = .4*height;
      	middle_x = .5*width;
      	button_height = height-button_y; 

      	RoundRectangle2D.Double mouse = 
      					new RoundRectangle2D.Double(xcoord,ycoord,width,height,rounded_width,rounded_height);
      	Line2D.Double bottomline = 
      					new Line2D.Double(xcoord,ycoord+button_y,xcoord+width,ycoord+button_y);

      	Ellipse2D.Double wheel = new Ellipse2D.Double(xcoord + .425*width, ycoord+.15*height, width*.15,button_height*.25);

      	Line2D.Double botmidline = 
      					new Line2D.Double(xcoord+.5*width, ycoord+ button_y, xcoord+.5*width, ycoord+button_y-.1*height);

      	Line2D.Double bottopline =
      					new Line2D.Double(xcoord+.5*width,ycoord+button_y-.25*height,xcoord+.5*width,ycoord+button_y-.4*height);

      	GeneralPath wholeMouse = this.get();

      	wholeMouse.append(mouse,false);
      	wholeMouse.append(bottomline,false);
      	wholeMouse.append(wheel,false);
      	wholeMouse.append(botmidline,false);
      	wholeMouse.append(bottopline,false);



    }
}