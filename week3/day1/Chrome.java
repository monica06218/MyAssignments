package week3.day1;


//Chrome browser subclass extending Browser
public class Chrome extends Browser {

 // Constructor: calls the superclass constructor with "Chrome" as the name
 public Chrome(String version) {
     super("Chrome", version);
 }

 // Chrome-specific method: open in incognito mode
 public void openIncognito() {
     System.out.println("Chrome is now in Incognito mode.");
 }

 // Chrome-specific method: clear cache
 public void clearCache() {
     System.out.println("Chrome cache has been cleared.");
 }
}
