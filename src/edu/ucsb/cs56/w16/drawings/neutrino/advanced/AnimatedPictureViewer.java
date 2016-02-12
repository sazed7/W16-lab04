package edu.ucsb.cs56.w16.drawings.neutrino.advanced;
import javax.swing.JFrame;
import java.awt.event.*;

/** A viewer class to see an animated picture by Abhijit Kulkarni
   
   @author Abhijit Kulkarni
   @version CS56, W16
 */

 public class AnimatedPictureViewer extends JFrame
 {
 	Thread animate;
 	AnimatedPictureComponent component;
 	static final double startingXpos = 20;
 	static final double startingYpos = 50;
 	static final double width = 100;
 	static final double height = 80;

 	/**
 		Constructs a JFrame with the animated picture inside.
 	*/
 	public AnimatedPictureViewer()
 	{
 		setSize(640, 480);
 		setTitle("Abhijit Kulkarni's Animated Mouse")
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 		component = new AnimatedPictureComponent(startingXpos, startingYpos, width, height);
 		add(component);

 		animate = new Animate();
 		animate.start();

 		setVisible(true);
 	}

 	public static void main(String [] args)
 	{
 		AnimatedPictureViewer apv = new AnimatedPictureViewer();
 	}

 	class Animate extends Thread
 	{
 		try{
 			while(true){
 				display(50);
 			}
 		}catch(Exception ex){
 			System.out.println(ex);
 			System.exit(1);
 		}

 		void display(int delay){
 			component.repaint();
 			Thread.currentThread().sleep(delay);
 		}
 	}
 }