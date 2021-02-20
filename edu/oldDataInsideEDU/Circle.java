package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Objects;

public class Circle extends AbstractDrawingObject{
   private double r;
   
   // constructor 
   public Circle( double x0, double y0, double r0, Color c0 ){
      super( x0, y0, c0);
      checkRadius( r0 );
      r = r0;
   }
   
   // accessor
   public double getRadius(){
      return r;
   }
   // mutator
   public void setRadius( double r1 ){ 
      checkRadius( r1 );
      r = r1;
   }
   private void checkRadius( double r ){
      if( r <= 0 )
         throw new IllegalArgumentException( "Circle cannot have negative radius." );   
   }
   
   public  void draw(){
      // preserve pen color
      Color temp = StdDraw.getPenColor();
      // use point's color
      StdDraw.setPenColor(getColor());
      // draw it
      StdDraw.filledCircle( getX(), getY(), r );
      // set color back to what it was before draw was called
      StdDraw.setPenColor(temp);   
   }
}