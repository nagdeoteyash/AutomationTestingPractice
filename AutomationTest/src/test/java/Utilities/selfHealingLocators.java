package Utilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class selfHealingLocators 
{
	 public static WebElement findElementWithRetry(WebDriver driver, By primaryLocator, By... alternativeLocators) {
         try {
             return driver.findElement(primaryLocator);
         } catch (NoSuchElementException e) {
             System.out.println("Primary locator failed. Trying alternatives…");
             for (By altLocator : alternativeLocators) {
                 try {
                     WebElement altElement = driver.findElement(altLocator);
                     System.out.println("Found element using alternative: " + altLocator.toString());
                     return altElement;
                 } catch (NoSuchElementException ignored) {
                     // Continue to the next alternative
                 }
             }
             throw new NoSuchElementException("Element not found with any locator");
         }
     }

}
