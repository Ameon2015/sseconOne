package edu.wiu;
import edu.princeton.StdDraw;
import java.awt.Color;
import java.util.Objects;

public class Text extends AbstractDrawingObject{
   private String s;
   
   // constructor 
   public Text( double x0, double y0, String t0, Color c0 ){
      super( x0, y0, c0);
      Objects.requireNonNull( t0, "String cannot be null." );      
      s = t0;
   }
   
   // accessor
   public String getText(){
      return s;
   }
   // mutator
   public void setText( String s1 ){ 
      Objects.requireNonNull( s1, "String cannot be null." );
      s = s1;
   }

   
   public  void draw(){
      // preserve pen color
      Color temp = StdDraw.getPenColor();
      // use point's color
      StdDraw.setPenColor(getColor());
      // draw it
      StdDraw.text( getX(), getY(), s );
      // set color back to what it was before draw was called
      StdDraw.setPenColor(temp);   
   }
}