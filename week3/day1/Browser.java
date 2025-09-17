package week3.day1;

//Superclass representing a general web browser
public class Browser {
 String browserName;
 String browserVersion;

 // Constructor to initialize browser name and version
 public Browser(String name, String version) {
     this.browserName = name;
     this.browserVersion = version;
 }

 // Method for opening a URL
 public void openURL(String url) {
     System.out.println(browserName + " v" + browserVersion + " is opening: " + url);
 }

 // Method for closing the browser
 public void closeBrowser() {
     System.out.println(browserName + " is shutting down.");
 }

 // Method for navigating back in the browser
 public void navigateBack() {
     System.out.println(browserName + " is going back to the previous page.");
 }
}

