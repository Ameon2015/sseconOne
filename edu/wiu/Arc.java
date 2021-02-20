package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Objects;

public class Arc extends Circle{
   private int startAngle, endAngle;
   
   // constructor 
   public Arc( double x0, double y0, double r0, int a0, int a1, Color c0 ){
      super( x0, y0, r0, c0);
      startAngle = a0;
      endAngle = a1;;
   }
   
   // accessors
   public int getStartAngle(){
      return startAngle;
   }

   public int getEndAngle(){
      return endAngle;
   }   
   
   // mutators
   public void setStartAngle( int start ){
      startAngle = start;
   }   

   public void setEndAngle( int start ){
      endAngle = start;
   }    
   
   public  void draw(){
      // preserve pen color
      Color temp = StdDraw.getPenColor();
      // use point's color
      StdDraw.setPenColor(getColor());
      // draw it
      StdDraw.arc( getX(), getY(), getRadius(), startAngle, endAngle );
      // set color back to what it was before draw was called
      StdDraw.setPenColor(temp);   
   }
}