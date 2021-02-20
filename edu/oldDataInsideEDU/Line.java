package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Objects;

public class Line extends AbstractDrawingObject{
   private Point end;
   
   // constructor 
   public Line( double x0, double y0, double x1, double y1, Color c0 ){
      super( x0, y0, c0);
      end = new Point( x1, y1, c0 ); // other endpoint in same color
   }
   
   // accessor
   public double getX1(){
      return getX();
   }
   public double getX2(){
      return end.getX();
   }
   public double getY1(){
      return getY();
   }
   public double getY2(){
      return end.getY();
   }

   // line must move both of its points, so it must change parent's behavior      
   @Override
   public void moveTo( double x1, double y1 ){
      double relX = x1 - getX();
      double relY = y1 - getY();
      super.moveBy( relX, relY );
      end.moveBy( relX, relY );
      
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
      StdDraw.line( getX(), getY(), end.getX(), end.getY() );
      // set color back to what it was before draw was called
      StdDraw.setPenColor(temp);   
   }
}