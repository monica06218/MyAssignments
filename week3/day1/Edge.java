package week3.day1;



//Edge browser subclass extending Browser
public class Edge extends Browser {

 // Constructor: calls the superclass constructor with "Edge" as the name
 public Edge(String version) {
     super("Edge", version);
 }

 // Edge-specific method: take a screenshot
 public void takeSnap() {
     System.out.println("Edge took a screenshot.");
 }

 // Edge-specific method: clear cookies
 public void clearCookies() {
     System.out.println("Edge cookies cleared.");
 }
}
