package com.pixated.crm.generic.webDriverUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility_Mine {
  public void waitForPageLoad(WebDriver driver) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  public void waitForElementToClickable(WebDriver driver,WebElement element) {
	   WebDriverWait wait=new  WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.elementToBeClickable(element));
  }
  
  public void waitForElementPresent(WebDriver driver,WebElement element) {
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
     wait.until(ExpectedConditions.visibilityOf(element));
  }

public void switchToTabOnURL(WebDriver driver,String partialUrl) {
	  Set<String>set=driver.getWindowHandles();
	  Iterator<String>it=set.iterator();
	  while (it.hasNext()) {
		String windowID=it.next();
		driver.switchTo().window(windowID);
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains(partialUrl)) {
			break;
		}
	}
  }
  public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
	  Set<String>set=driver.getWindowHandles();
	  Iterator<String>it=set.iterator();
	  while (it.hasNext()) {
		String windowID=it.next();
		driver.switchTo().window(windowID);
		String actUrl=driver.getTitle();
		if(actUrl.contains(partialTitle)) {
			break;
		}
	}
  }
  public void switchToChildTabOnTitle(WebDriver driver,String partialTitle) {
	  Set<String>set=driver.getWindowHandles();
	  for(String windowID:set) {
		  driver.switchTo().window(windowID);  
			  if(windowID.contains(partialTitle)) {
			  break;
		}
	}
  }
  public void switchToChildTabOnURL(WebDriver driver,String partialURL) {
	  Set<String>set=driver.getWindowHandles();
	  for(String windowID:set) {
		  driver.switchTo().window(windowID);  
			  if(windowID.contains(partialURL)) {
			  break;
		}
	}
  }
  public void switchToFrame(WebDriver driver,int index) {
	  driver.switchTo().frame(index);
  }
  
  public void switchToFrame(WebDriver driver,String nameID) {
	  driver.switchTo().frame(nameID);
  }
  
  public void switchToFrame(WebDriver driver,WebElement element) {
	  driver.switchTo().frame(element);
  }
  public void switchToParentFrame(WebDriver driver) {
	   driver.switchTo().parentFrame();
  }
  public void switchToMainFrame(WebDriver driver) {
	   driver.switchTo().defaultContent();
  }
  public void switchToAlertAndAccept(WebDriver driver) {
	  driver.switchTo().alert().accept();
  }
  
  public void switchToAlertAndCancel(WebDriver driver) {
	  driver.switchTo().alert().dismiss();
  }
  
  public void switchToAlertAndWrite(WebDriver driver,String data) {
	  driver.switchTo().alert().sendKeys(data);
  }
  public void switchToAlertAndFetchMessage(WebDriver driver) {
	   driver.switchTo().alert().getText();
	   
  }
  public void selectByValue(WebElement element,String text) {
	  Select sel=new Select(element);
	  sel.selectByValue(text);
  }
  public void selectOption(WebElement element ,int indexvalue) {
	   Select s=new Select(element);
	   s.selectByIndex(indexvalue);
  }
  public void selectOptionByVisibleText(WebElement element ,String visibleText) {
	   Select s=new Select(element);
	   s.selectByVisibleText(visibleText);
  }
  public void selectDynamicDropDown(WebDriver driver,By locator ,String visibleText) {
	   List<WebElement>options=driver.findElements(locator);
	   for(WebElement option:options) {
		   if(option.getText().equals(visibleText)) {
			   option.click();
			   break;
		   }
	   }
 }
  public void selectDynamicDropDown(WebElement element ,String visibleText) {
	  Select s=new Select(element);
	   List<WebElement>options=s.getOptions();
	   for(WebElement option:options) {
		   if(option.getText().equals(visibleText)) {
			   option.click();
			   break;
		   }
	   }
}
  public void deselectByAll(WebElement element) {
	   Select s=new Select(element);
	   s.deselectAll();
  }
  public void deselectOption(WebElement element ,int indexvalue) {
	   Select s=new Select(element);
	   s.deselectByIndex(indexvalue);
  }
  public void deselectOption(WebElement element, String value) {
	   Select s=new Select(element);
	   
	   s.deselectByValue(value);
  }
  public void deselectOptionByVisibleText(WebElement element ,String visibleText) {
	   Select s=new Select(element);
	   s.deselectByVisibleText(visibleText);
  }
  public void checkDropdownmultiselected(WebElement element) {
	   Select s=new Select(element);
	   s.isMultiple();
  }
  
  public void mouseOverElement(WebDriver driver,WebElement element) {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).perform();
  }
  public void rightClickOperation(WebDriver driver) {
	   Actions act=new Actions(driver);
	   act.contextClick().perform();
  }
  
  public void rightClickOperation(WebDriver driver,WebElement element) {
	   Actions act=new Actions(driver);
	   act.contextClick(element).perform();
  }
  public void clickOperation(WebDriver driver) {
	   Actions act=new Actions(driver);
	   act.click().perform();
	   }
  
  public void clickOperation(WebDriver driver,WebElement element) {
	   Actions act=new Actions(driver);
	   act.click(element).perform();
	   }
  
  public void doubleClickOperation(WebDriver driver) {
	   Actions act=new Actions(driver);
	   act.doubleClick().perform();
  }
  
  public void doubleClickOperation(WebDriver driver,WebElement element) {
	   Actions act=new Actions(driver);
	   act.doubleClick(element).perform();
  }
  
  public void dragAndDropOperation(WebDriver driver,WebElement src,WebElement target) {
	   Actions act=new Actions(driver);
	   act.dragAndDrop(src, target).perform();
  }
 
  public void dragAndDropSlider(WebDriver driver,WebElement src,int x,int y) {
	   Actions act=new Actions(driver);
	   act.dragAndDropBy(src, x, y).perform();
  }
  
  public void scrollDownOperation(WebDriver driver,WebElement element) {
	   Actions act=new Actions(driver);
	   act.scrollToElement(element).perform();
  }
  public void scrollDownOperation(WebDriver driver,String jsvalue) {
	   JavascriptExecutor jse=(JavascriptExecutor)driver;
	   jse.executeScript(jsvalue);
  }
  
  public void switchToWindow(WebDriver driver,String ParentId) {
	   Set<String>childIds=driver.getWindowHandles();
	   Iterator<String> itr=childIds.iterator();
	   
	   while(itr.hasNext()) {
		   String IDS=itr.next();
		   String ALLIDS=driver.switchTo().window(IDS).getTitle();
		   if(ParentId.contains(ALLIDS)) {
			   break;
		   }
	     }
	   }
 
  public String screenShotCaptueMethod(WebDriver driver,String ScreenShotName) throws Exception {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File src=ts.getScreenshotAs(OutputType.FILE);
	   String path=".\\ScreenShot\\"+ScreenShotName+".png";
	   File dest=new File(path);
	   Files.copy(src, dest);
	   String finalPath=dest.getAbsolutePath();
	return finalPath;
	   }
  
  public void customizeClickOnElement(WebElement element) throws Exception {
	   int count =1;
	   while(count<10) {
		   try {
			  element.click();
			  break;
		   }
		   catch (Exception e) {
			Thread.sleep(2000);
			count++;
		}
	 }
   }
}
