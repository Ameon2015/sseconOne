
import edu.wiu.*;
import net.datastructures.SinglyLinkedList;
import java.awt.Color;
import java.util.Objects;
public  class ObjectDrawing{
public static void main(String[] args){
   Die obj =new Die();
 // obj.draw(0.5,0.5,0.3);
  // Circle c = new Circle(0.5,0.5,0.15,new Color(100,120,100));
   Arc ar = new Arc(.5,.5,.5,5,5,4,new Color(100,120,100));
   //c.draw();
    Ellipse e = new Ellipse(0.5,.5,.1,.1,new Color(250,120,100));
  // e.draw();
   Point p = new Point(.5,.5,new Color(250,120,100));
    p.draw();
    p.moveTo(0.2,0.6);
  // DrawingObject  po = new Polygon(new Color(250,120,100),0,0);
  Rectangle rec = new Rectangle(0.5,.5,.1,.1,new Color(250,0,0));
  //rec.draw();
 // Smiley s = new Smiley();
 // s.draw();
 Text tx = new Text(0.5,0.5,"Ameno...Waseem ..sroo",new Color(100,120,100));
 tx.draw();
       System.out.println(" ");

   }
/*
   void setColor( Color c );
   void moveTo( Point p );
   void moveTo( double x, double y );
   void draw();
*/
 
  

}