package edu.ucsb.cs56.w16.drawings.neutrino.advanced;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.Color;

/** A viewer class to see an animated picture by Abhijit Kulkarni
   
   @author Abhijit Kulkarni
   @version CS56, W16
 */

 public class AnimatedPictureViewer extends JFrame
 {
 	Thread animate;
 	AnimatedPictureComponent component;
 	static final double startingXpos = 125;
 	static final double startingYpos = 150;
 	static final double width = 50;
 	static final double height = 100;
 	int mouseX = -5;
 	int mouseY = -5;

 	/**
 		Constructs a JFrame with the animated picture inside.
 	*/
 	public AnimatedPictureViewer()
 	{
 		setSize(640, 480);
 		setTitle("Abhijit Kulkarni's Animated Mouse");
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 		component = new AnimatedPictureComponent(startingXpos, startingYpos, width, height);
 		add(component);

 		getContentPane().addMouseListener(
 					new MouseAdapter(){
 						public void mouseEntered(MouseEvent e){
 							animate = new Animate();
 							animate.start();
 						}
 						public void mouseExited(MouseEvent e){
 							animate.interrupt();
 							while(animate.isAlive()){}
 							animate = null;
 						}
 						public void mouseClicked(MouseEvent e){
 							mouseX = e.getX();
 							mouseY = e.getY();
 							component.mouseClicked(mouseX, mouseY);
 						}
 					}
 				);
 		getContentPane().setBackground(new Color(102,153,255));
 		setVisible(true);
 	}

 	public static void main(String [] args)
 	{
 		AnimatedPictureViewer apv = new AnimatedPictureViewer();
 	}

 	class Animate extends Thread
 	{
 		public void run(){
	 		try{
	 			while(true)
	 			{
	 				display(40);
	 			}
	 		}catch(Exception ex){
	 			if(ex instanceof InterruptedException){
	 				//do nothing
	 			}
	 			else{
		 			System.out.println(ex);
		 			System.exit(1);
		 		}
	 		}

	 	}
	 	void display(int delay) throws InterruptedException{
	 			component.repaint();
	 			if(Thread.currentThread().interrupted())
	 				throw(new InterruptedException());
	 			Thread.currentThread().sleep(delay);
	 	}
 	}
 }