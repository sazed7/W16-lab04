package edu.ucsb.cs56.w16.drawings.neutrino.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Abhijit Kulkarni 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few mice 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
    Mouse m1 = new Mouse(100,250,50,75);
	g2.setColor(new Color(0xB0171F)); g2.draw(m1);
	
	// Make a black mouse that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);
	
	// Here's a mouse that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2); 
	
	g2.setStroke(orig);
	// Draw two mouses with designs
	
	SteelseriesMouse hw1 = new SteelseriesMouse(50,350,40,75);
	SteelseriesMouse hw2 = new SteelseriesMouse(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ Mice, Created by Abhijit Kulkarni
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Mice by Abhijit Kulkarni", 20,20);
    }
    
    
    /** Draw a picture with a few mice 
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	Mouse large = new Mouse(100,50,225,150);
	Mouse smallM = new Mouse(20,50,40,30);
	Mouse tallSkinny = new Mouse(20,150,20,40);
	Mouse shortFat = new Mouse(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallM);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Mouse m1 = new Mouse(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(m1);
	
	// Make a black mouse that's half the size, 
	// and moved over 150 pixels in x direction
	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.BLACK); g2.draw(m2);
	
	// Here's a mouse that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,250,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2); 
	
	// Draw two houses with Windows
	
	SteelseriesMouse ss1 = new SteelseriesMouse(50,350,40,75);
	SteelseriesMouse ss2 = new SteelseriesMouse(200,350,200,100);
	
	g2.draw(ss1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape ss3 = ShapeTransforms.rotatedCopyOf(ss2, Math.PI/4.0);
	ss3 = ShapeTransforms.translatedCopyOf(ss3,150,-10);
	
	g2.draw(ss3);
	
	// @@@ Computer mice, by Abhijit Kulkarni
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Computer mice by Abhijit Kulkarni", 20,20);
    }
    
    /** Draw a different picture with a steelseries mice
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Computer Mice by Abhijit Kulkarni", 20,20);
	
	
	// Draw some steelserires mice
	
	SteelseriesMouse large = new SteelseriesMouse(100,50,225,150);
	SteelseriesMouse small = new SteelseriesMouse(20,50,40,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);

	g2.setColor(new Color(0x8FF00FF));

	Shape ss1 = ShapeTransforms.rotatedCopyOf(large,Math.PI/16.0);
	ss1 = ShapeTransforms.translatedCopyOf(ss1, 20,150);
	g2.draw(ss1);

	g2.setColor(new Color(0x002FA7));
	Shape ss2 = ShapeTransforms.scaledCopyOfLL(ss1, .1,.1);
	ss2 = ShapeTransforms.rotatedCopyOf(ss2,Math.PI/7.0);
	ss2 = ShapeTransforms.translatedCopyOf(ss1,200,10);
	g2.draw(ss2);


    }       
}
