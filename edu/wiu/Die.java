/**
   Modified Die class, v.3.0; use with Homework 3 (completed Hwk 2)
   CS250 Western Illinois University
   Covert
   Spring 2020
   
   Your name:
*/
package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Random;

public class Die{
   private int currentValue;
   private static Random rand = new Random();
   
   /**
      Create a die with a random value between 1 and 6
   */
   public Die(){
      roll();
   }
   /**
      Create a die with the specified value, assuming the value falls between 1 and 6.
      @param x value to set on the die
   */   
   public Die( int x ){
      if( x < 1 || x > 6 )
         throw new IllegalArgumentException( "Die value must be between 1 and 6");
      currentValue = x;
   }
   /**
      Retrieves the current value on the die.
      @return current die value
   */    
   public int getValue(){
      return currentValue;
   }
   /**
      Rolls the die.
   */    
   public void roll(){
      currentValue = rand.nextInt(6) + 1;
   }
   
   /**
      Compares if o is a Die object and has the same value as calling Die.
      @return true if object is a Die and has the same value, returns false otherwise
   */
   @Override  // change how .equals works for this object type
   public boolean equals( Object o ){
      if( !( o instanceof Die ) )  // if o isn't a Die object, they aren't equal
         return false;
      Die d = (Die) o; // we now know o is a Die, we can safely cast to Die and access its data
      
      if( d.currentValue == this.currentValue )  // if the passed object (d) has the same value as the die the method is call on 
         return true;
      
      return false; // they weren't equal in value
   }

   /**
      Calculates the die's hashcode.
      @return hashcode for this Die
   */   
   @Override  // not strictly required, but expected for proper performance with Collections
   public int hashCode(){
      return currentValue;  // a terrible hash code, since there are only 6 different ones, but we're stuck with it due to 
                            // hash code's requirements. More on this in CS351.
   }
   
   /**
      Returns a String representation for this object
      @return a String representation for this object
   */
   @Override
   public String toString(){
      return "Die: " + currentValue;
   }
   
   public void draw( double x, double y, double r ){
      // drawing data
      double pipSize = 0.15 * r;
      double spacing = r / 2.0;
      // preserve prior color
      Color c = StdDraw.getPenColor();
      // draw Die body
      StdDraw.setPenColor( StdDraw.BLACK );
      StdDraw.filledSquare( x, y, r );
      // draw pips
      StdDraw.setPenColor( StdDraw.YELLOW );
      // center pip
      if( currentValue % 2 != 0 )
         StdDraw.filledCircle( x, y, pipSize );
      // upper right, lower left, drawn when dice value >= 2
      if( currentValue >= 2 ){
         StdDraw.filledCircle( x + spacing, y + spacing, pipSize ); 
         StdDraw.filledCircle( x - spacing, y - spacing, pipSize );               
      }
      // lower right, upper left, drawn when dice value >= 4
      if( currentValue >= 4 ){
         StdDraw.filledCircle( x - spacing, y + spacing, pipSize ); 
         StdDraw.filledCircle( x + spacing, y - spacing, pipSize );               
      }
      // center left and right, only drawn when dice value = 6  
      if( currentValue == 6 ){
         StdDraw.filledCircle( x - spacing, y , pipSize ); 
         StdDraw.filledCircle( x + spacing, y , pipSize );               
      }
      StdDraw.setPenColor( c );           
   }
    
}