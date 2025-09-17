package week3.day1.inheritance;

import week3.day1.Chrome;
import week3.day1.Edge;
import week3.day1.Safari;

//Main class to test and demonstrate the functionality
public class Main {
 public static void main(String[] args) {

     // Creating a Chrome object
     Chrome chrome = new Chrome("118.0");
     chrome.openURL("https://openai.com");
     chrome.openIncognito();         // Chrome-specific method
     chrome.clearCache();            // Chrome-specific method
     chrome.navigateBack();          // Inherited from Browser
     chrome.closeBrowser();          // Inherited from Browser

     System.out.println("-----------------------------");

     // Creating an Edge object
     Edge edge = new Edge("117.0");
     edge.openURL("https://bing.com");
     edge.takeSnap();                // Edge-specific method
     edge.clearCookies();            // Edge-specific method
     edge.navigateBack();            // Inherited from Browser
     edge.closeBrowser();            // Inherited from Browser

     System.out.println("-----------------------------");

     // Creating a Safari object
     Safari safari = new Safari("16.5");
     safari.openURL("https://apple.com");
     safari.readerMode();            // Safari-specific method
     safari.fullScreenMode();        // Safari-specific method
     safari.navigateBack();          // Inherited from Browser
     safari.closeBrowser();          // Inherited from Browser
 }
}
