package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Objects;

public class Rectangle extends AbstractDrawingObject{
   private double rMajor, rMinor;
   
   // constructor 
   public Rectangle( double x0, double y0, double rx, double ry, Color c0 ){
      super( x0, y0, c0);
      checkRadius( rx );
      checkRadius( ry );
      rMajor = rx;
      rMinor = ry;
   }
   
   // accessor
   public double getMajorRadius(){
      return rMajor;
   }
   // accessor
   public double getMinorRadius(){
      return rMajor;
   }   
   // mutator
   public void setMajorRadius( double r1 ){ 
      checkRadius( r1 );
      rMajor = r1;
   }
   // mutator
   public void setMinorRadius( double r1 ){ 
      checkRadius( r1 );
      rMajor = r1;
   }   
   private void checkRadius( double r ){
      if( r <= 0 )
         throw new IllegalArgumentException( "Rectangle cannot have negative radius." );   
   }
   
   public  void draw(){
      // preserve pen color
      Color temp = StdDraw.getPenColor();
      // use point's color
      StdDraw.setPenColor(getColor());
      // draw it
      StdDraw.filledRectangle( getX(), getY(), rMajor, rMajor );
      // set color back to what it was before draw was called
      StdDraw.setPenColor(temp);   
   }
}