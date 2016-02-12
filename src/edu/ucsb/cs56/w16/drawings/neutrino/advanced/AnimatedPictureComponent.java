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
	private double startingWidth;
	private double startingHeight;
	private double xpos;
	private double ypos;
	private double width;
	private double height;
	private double dx;
	private int mouseX;
	private int mouseY;
	private boolean clicked;
	private boolean shrink;
	private double rotate_factor;

	/** 
		Constructs an AnimatedPictureComponent with the specified properties.
		This has a SteelSeries Mouse doing cool stuff.

		@param startingXpos the starting x position of the mouse
		@param startingYpos the starting y position of the mouse
		@param width the starting width of the mouse
		@param height the starting height of the mouse
	*/
	public AnimatedPictureComponent(double startingXpos, double startingYpos, double width, double height)
	{
		this.startingXpos = startingXpos;
		this.startingYpos = startingYpos;
		this.xpos = startingXpos;
		this.ypos = startingYpos;
		this.width = width;
		this.height = height;
		this.startingWidth = width;
		this.startingHeight = height;
		this.dx = 5;
		this.mouseX = -5;
		this.mouseY = -5;
		this.clicked = false;
		shrink = false;
		rotate_factor = 1;
		mouse = new SteelseriesMouse(this.startingXpos, this.startingYpos, this.width, this.height);
	}

	/**
		Updates mouse coordinates if user clicks inside the mouse
		@param mouseX the x coordinate clicked
		@param mouseY the y coordinated clicked
	*/
	public void mouseClicked(int mouseX, int mouseY){
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		if(mouseX >=xpos && mouseX <= xpos+width && mouseY >=ypos && mouseY <= ypos+height)
			clicked = true;
		else
			clicked = false;
	}
	/**
		The paintComponent() method is overridden to display the animation.
		Each time this method is called, the pos of the mouse is updated.
	*/
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if(xpos >= startingXpos + 270 || xpos < startingXpos){
			dx *= -1;
		}
		if(clicked){
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random()*256);
			int blue = (int)(Math.random()*256);
			Color c = new Color(red,green,blue);

			g2.setColor(c);
			if(shrink == false){
				width *= 1.05;
				height *= 1.05;
				rotate_factor += .5*1.15;
				mouse = ShapeTransforms.scaledCopyOf(mouse,1.05,1.05);
				if(width >= startingWidth * 3)
					shrink = true;
			}
			else if(shrink == true){
				width *= .95;
				height *= .95;
				mouse = ShapeTransforms.scaledCopyOf(mouse,.95,.95);
				rotate_factor -= (.5/1.5);
				if(width <= startingWidth*.3333)
					shrink = false;
			}
			mouse = ShapeTransforms.rotatedCopyOf(mouse,Math.PI/(rotate_factor));

		}
		else
			g2.setColor(Color.LIGHT_GRAY);
		g2.fill(mouse);
		g2.setColor(Color.BLACK);
		g2.draw(mouse);
		g2.drawString("Click the mouse to see something fun!", 190, 50);
		xpos += dx;

		mouse = ShapeTransforms.translatedCopyOf(mouse, dx, 0);
	}

}
