//: polymorphism/shape/Square.java
package shape;
import static utils.Print.*;

public class Square extends Shape {
  public void draw() { print("Square.draw()"); }
  public void erase() { print("Square.erase()"); }
  @Override
  public void crop() { print("Square.crop()"); }
} ///:~
