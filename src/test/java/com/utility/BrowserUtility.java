package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
private WebDriverWait wait ;
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait= new WebDriverWait(driver, Duration.ofSeconds(30L));
	}
	

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid Browser Name");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless=new");
				chromeOptions.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(chromeOptions));
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				
			}

		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--headless=new");
				edgeOptions.addArguments("disable-gpu");
				driver.set(new EdgeDriver(edgeOptions));
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
			driver.set(new EdgeDriver());
			wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the Website" + " " + url);
		driver.get().get(url);
	}

	public void manageWindow() {
		logger.info("Maximizing the Window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element by Locator" + " " + locator);
	//	WebElement Element = driver.get().findElement(locator);
		WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element Found now performing Click Operation");
		Element.click();
	}
	
	public void clickOnCheckbox(By locator) {
		logger.info("Finding element by Locator" + " " + locator);
	//	WebElement Element = driver.get().findElement(locator);
		WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found now performing Click Operation");
		Element.click();
	}
	
	public void clickOn(WebElement Element) {
		logger.info("Element Found now performing Click Operation");
		Element.click();
	}

	public void enterText(By locator, String text) {
		logger.info("Finding element by Locator" + " " + locator);
	//	WebElement Element = driver.get().findElement(locator);
		WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found now entering the text");
		Element.sendKeys(text);
	}
	
	public void clearText(By textBoxLocator) {
		logger.info("Finding element by Locator" + textBoxLocator);
		//WebElement Element = driver.get().findElement(textBoxLocator);
		WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		logger.info("Element Found now clearing the text");
		Element.clear();
	}
	
	public void selectFromDropdown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element by Locator" + " " + dropDownLocator);
		WebElement Element = driver.get().findElement(dropDownLocator);
		Select select = new Select(Element);
		logger.info("Element Found now selecting the option "+optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}
	
	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding element by Locator" + " " + locator);
		//WebElement Element = driver.get().findElement(locator);
		WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found now entering the special key" +keyToEnter);
		Element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element by Locator" + " " + locator);
		WebElement Element = driver.get().findElement(locator);
		logger.info("Element Found now returning the text" + Element.getText());
		return Element.getText();
	}
	
	public String getVisibleText(WebElement element) {
		logger.info("Returning the text" + element.getText());
		return element.getText();
	}
	
	public List<String> getAllText(By locator) {
		logger.info("Finding elements by Locator" + " " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Element Found now printing the list of elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
		System.out.println(getVisibleText(element));	
		visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}
	
	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding elements by Locator" + " " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Element Found now printing the list of elements");
		List<String> visibleTextList = new ArrayList<String>();
		
		return elementList;
	}

	public String takeScreenshot(String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + fileName + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

	public void quit() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
		
		
	}



}
