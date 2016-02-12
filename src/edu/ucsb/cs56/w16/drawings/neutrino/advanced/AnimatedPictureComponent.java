package edu.ucsb.cs56.w16.drawings.neutrino.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles
import java.awt.geom.RoundRectangle2D; // mouse

import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;


/**
   A component that draws an animated picture by Abhijit Kulkarni
   
   @author Abhijit Kulkarni
   @version CS56, W16
   
*/

public class AnimatedPictureComponent extends JComponent
{
	private Shape mouse;
	private double startingXpos;
	private double startingYpos;
	private double xpos;
	private double ypos;
	private double width;
	private double height;
	private double dx;

	/** 
		Constructs an AnimatedPictureComponent with the specified properties.
		This has a SteelSeries Mouse doing cool stuff.

		@param startingXpos the starting x position of the mouse
		@param startingYpos the starting y position of the mouse
		@param width the starting width of the mouse
		@param height the starting height of the mouse
	*/
	public AnimatedPictureComponent(int startingXpos, int startingYpos, int width, int height)
	{
		this.startingXpos = startingXpos;
		this.startingYpos = startingYpos;
		this.xpos = startingXpos;
		this.ypos = startingYpos;
		this.width = width;
		this.height = height;
		this.dx = 5;

		mouse = new SteelSeriesMouse(this.startingXpos, this.startingYpos, this.width, this.height);
	}

	/**
		The paintComponent() method is overridden to display the animation.
		Each time this method is called, the pos of the mouse is updated.
	*/
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if(xpos >= startingXpos + 200){
			dx *= -1;
		}
		
		g2.setColor(Color.BLACK);
		g2.draw(mouse);

		xpos += dx;

		mouse = ShapeTransforms.translatedCopyOf(mouse, dx, 0);

}
