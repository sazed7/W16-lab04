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
   A Steelseries Mouse
      
   @author Abhijit Kulkarni
   @version for CS56, W16, UCSB
   
*/

public class SteelseriesMouse extends Mouse implements Shape
{
	/** 
	 * Constructor for Steelseries Mouse
	 */
	public SteelseriesMouse(double x, double y, double w, double h){
		super(x,y,w,h);

		GeneralPath wholeMouse = this.get();
		double rad;

		if(width>height)
			rad = .2*width;
		else
			rad = .2*height;
		Ellipse2D.Double first = new Ellipse2D.Double(xcoord + .35*width, ycoord + .55*height, width*.3, height*.3);
		Ellipse2D.Double second = new Ellipse2D.Double(xcoord+ .4*width, ycoord + .6*height, width*.2, height*.2);

		Line2D.Double left = new Line2D.Double(xcoord+.35*width, ycoord+.7*height,xcoord+.25*width,ycoord+.7*height);
		Line2D.Double top = new Line2D.Double(xcoord+.5*width, ycoord+.55*height,xcoord+.5*width,ycoord+.45*height);


		wholeMouse.append(left,false);
		wholeMouse.append(first,false);
		wholeMouse.append(second,false);
		wholeMouse.append(top,false);
	}
}