package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Objects;

public class Polygon extends AbstractDrawingObject{
   private double[] xVals, yVals; // arrays of doubles to store point data
   
   // constructor 
   public Polygon( Color c0, Point... p ){
      // no basepoint for this object, must make superclass object first
      // give bogus (0,0) for location
      super( 0, 0, c0 );

      int n = p.length; // number of points supplied
      xVals = new double[n];
      yVals = new double[n];
      
      // find centerpoint of polygon as average of supplied points
      double x = 0, y = 0;
      for( Point c : p ){
         x+= c.getX();
         y+= c.getY();
      }
      x/=n;
      y/=n;
      moveTo( x, y );
      
      for( int i = 0; i < n; i++ ){
         xVals[i] = p[i].getX();
         yVals[i] = p[i].getY();
      }
   }
   


   // Polygon must move ALL of its points      
   @Override
   public void moveTo( double x1, double y1 ){
      double relX = x1 - getX();
      double relY = y1 - getY();
      
      // move base point by this amount
      super.moveBy( relX, relY );
      
      // move all stored points by this amount too
      for( int i = 0; i < xVals.length; i++ ){
         xVals[i] += relX;
         yVals[i] += relY;
      }   
   }       
   
   // same idea as above, use it to perform this related action
   @Override
   public void moveTo( Point p1 ){
      moveTo( p1.getX(), p1.getY() ); // uses the overridden method above   
   }     
   
   public  void draw(){
      // preserve pen color
      Color temp = StdDraw.getPenColor();
      // use point's color
      StdDraw.setPenColor(getColor());
      // draw it
      StdDraw.filledPolygon( xVals, yVals );
      // set color back to what it was before draw was called
      StdDraw.setPenColor(temp);   
   }
}