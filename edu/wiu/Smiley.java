package edu.wiu;
import net.datastructures.SinglyLinkedList;
import java.awt.Color;

public class Smiley extends AbstractDrawingObject{
   private SinglyLinkedList<DrawingObject> stuff;
   
   public Smiley(){
      super( 0.5, 0.5, new Color( 0, 0, 0 ));
      stuff = new SinglyLinkedList<>();
      
      // "head"
      stuff.addLast( new Circle( 0.5, 0.5, 0.26, new Color( 0, 0, 0 )));
      stuff.addLast( new Circle( 0.5, 0.5, 0.25, new Color(255,255,0)));
      
      // eyes
      stuff.addLast( new Circle( 0.4, 0.55, 0.05, new Color( 0, 0, 0 )));
      stuff.addLast( new Circle( 0.6, 0.55, 0.05, new Color( 0, 0, 0 )));
      stuff.addLast( new Circle( 0.4, 0.55, 0.045, new Color( 255, 255, 255)));
      stuff.addLast( new Circle( 0.6, 0.55, 0.045, new Color( 255, 255, 255)));
      stuff.addLast( new Circle( 0.4, 0.565, 0.03, new Color( 0, 0, 0 )));
      stuff.addLast( new Circle( 0.6, 0.565, 0.03, new Color( 0, 0, 0 )));
      
      //mouth
      stuff.addLast( new Arc( 0.5, 0.45, 0.1, 220, 320, new Color( 255, 0, 0 )));
   }
   
   public void draw(){
        for( DrawingObject d : stuff )
           d.draw();
   }
   
   @Override
   public void moveTo( double x, double y ){
      double relX = x - getX();
      double relY = y - getY();
      
      super.moveTo( x, y );
       
        for( DrawingObject d : stuff )
            ((AbstractDrawingObject) d).moveBy( relX, relY ); 
   }
}