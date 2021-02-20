package edu.wiu;
import java.awt.Color;

public interface DrawingObject{

   Color getColor();
   void setColor( Color c );
   void moveTo( Point p );
   void moveTo( double x, double y );
   void draw();
}