package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Objects;

public class Point implements DrawingObject{
   private double x, y;  // no longer immutable!
   private Color c;
   
   // constructors
   public Point( double x, double y, Color c ){// you can name the parameters the same as the member variables
      this.x = x;  // but then you must do this
      this.y = y;
      this.c = c;
   }
   
   public Point( double x, double y ){ // Point with no color specified
      this( x, y, new Color(0,0,0)); // no reason to repeat code, just call our other constructor
                                     // Color(0,0,0) has no red, blue, or green, it is black.
   }
   
   // accessor
   public Color getColor(){
      return c;
   }
   
   // accessor
   public double getX(){
      return x;
   }
   
   // accessor
   public double getY(){
      return y;   
   } 
     
   // mutator
   public void setColor( Color c1 ){ // can also use a slightly different name for parameters
      Objects.requireNonNull(c1, "Point color cannot be null.");
      c = c1;
   }
   // mutator 
   public void moveTo( Point p ){
      Objects.requireNonNull( p, "Cannot move to a null point.");
      this.x = p.x;
      this.y = p.y;
   }
   // mutator
   public void moveTo( double x1, double y1 ){
      x = x1;
      y = y1;
   }
   
   // mutator, use to add passed values to point's location
   public void moveBy( double dx, double dy ){
      x += dx;
      y += dy;
   }
   
   // utility method, not really an accessor or mutator. Has side effect in StdDraw!
   public void draw(){
      // preserve pen color
      Color temp = StdDraw.getPenColor();
      // use point's color
      StdDraw.setPenColor(c);
      // draw it
      StdDraw.point( x, y );
      // set color back to what it was before draw was called
      StdDraw.setPenColor(temp);
   }
   // distance methods
   // distance in x between 2 points
   public static double dx( Point p1, Point p2 ){
      return p2.x - p1.x;
   }
   // distance in y between 2 points
   public static double dy( Point p1, Point p2 ){
      return p2.y - p1.y;
   }
   // straight line (Euclidian) distance between two points
   public static double distance( Point p1, Point p2 ){
      double dx = Point.dx( p1, p2 );
      double dy = Point.dy( p1, p2 );
      // Pythagorean theorem ( a^2 + b^2 = c^2, we're finding c from a and b)
      return Math.sqrt( dx * dx + dy * dy );
   }   
}