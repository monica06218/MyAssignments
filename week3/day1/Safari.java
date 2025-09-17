package week3.day1;


//Safari browser subclass extending Browser
public class Safari extends Browser {

 // Constructor: calls the superclass constructor with "Safari" as the name
 public Safari(String version) {
     super("Safari", version);
 }

 // Safari-specific method: enable reader mode
 public void readerMode() {
     System.out.println("Safari is now in Reader Mode.");
 }

 // Safari-specific method: enable full screen
 public void fullScreenMode() {
     System.out.println("Safari is now in Full Screen mode.");
 }
}
