package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Objects;

public abstract class AbstractDrawingObject implements DrawingObject{
   private Color c;
   private Point basePoint;
   
   // constructor 
   public AbstractDrawingObject( double x0, double y0, Color c0 ){
      basePoint = new Point( x0, y0 );
      Objects.requireNonNull( c0, "" + this.getClass() + " requires a non-null color. " );
      c = c0;
   }
   
   // accessor
   public Color getColor(){
      return c;
   }
   // mutator
   public void setColor( Color c1 ){ // can also use a slightly different name for parameters
      Objects.requireNonNull(c1, "" + this.getClass() + " requires a non-null color. ");
      c = c1;
   }

   // accessor
   public double getX(){
      return basePoint.getX();
   }
   
   // accessor
   public double getY(){
      return basePoint.getY();
      
   }
   // mutator 
   public void moveTo( Point p ){
      basePoint.moveTo( p );
   }
   
   // mutator
   public void moveTo( double x1, double y1 ){
      basePoint.moveTo( x1, y1 );
   }
   
   // added mutator
   public void moveBy( double dx, double dy ){
      basePoint.moveBy( dx, dy );
   }
   
   // leave this for subclasses to implement!
   public abstract void draw();
}