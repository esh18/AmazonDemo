package testcases;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.BuyItemPage;
import resources.BaseTest;

public class BuyItemTestCase extends BaseTest {
	public WebDriver driver;
	public BuyItemPage objBuyItemPage;

	@BeforeClass
	public void openBrowser() throws InterruptedException {
		driver = setupWebDriver();

		if (driver.getPageSource().contains("Enter the characters you see below")) {
			Thread.sleep(30000);
		} else {
			Thread.sleep(5000);
		}

	}

	@Test
	public void test001searchWatch() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		objBuyItemPage.txtSearch().sendKeys("Watch");
		objBuyItemPage.btnSearch().click();
		Thread.sleep(5000);
	}

	@Test
	public void test002selectPriceRange() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value=25", objBuyItemPage.sliderLower());
		js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
				objBuyItemPage.sliderLower());
		js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				objBuyItemPage.sliderLower());

		js.executeScript("arguments[0].value=70", objBuyItemPage.sliderUpper());
		js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
				objBuyItemPage.sliderUpper());
		js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				objBuyItemPage.sliderUpper());
		Thread.sleep(2000);

		objBuyItemPage.btnPrice().click();

		Thread.sleep(5000);
	}

	@Test
	public void test003selectDialColor() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 1500).perform();

		Thread.sleep(2000);

		List<WebElement> eleBtnColor = objBuyItemPage.btnColor();
		eleBtnColor.get(1).click();
		Thread.sleep(2000);

	}

	@Test
	public void test004addToCart() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);
		Actions actions = new Actions(driver);

		do {
			actions.scrollByAmount(0, 500).perform();
			Thread.sleep(2000);
		} while (!driver.getPageSource().contains("Titan"));

		if (driver.getPageSource().contains("Titan")) {
			List<WebElement> eleLblTitan = objBuyItemPage.checkTitian();
			eleLblTitan.get(1).click();
		}

		SwitchWindowToChild();
		objBuyItemPage.btnAddToCart().click();
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Titan")) {
			objBuyItemPage.btnSkip().click();
		}

		Thread.sleep(2000);

		SwitchWindowToParent();

		List<WebElement> eleBtnAddToCartRandom = objBuyItemPage.btnAddToCartRandom();
		eleBtnAddToCartRandom.get(7).click();
		Thread.sleep(2000);

		eleBtnAddToCartRandom.get(8).click();

		Thread.sleep(10000);

	}

	@Test
	public void test005IncreaseItemNumber() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		List<WebElement> eleIncreaseItem = objBuyItemPage.ddIncreaseItem();

		Select dropdownItemNumber = new Select(eleIncreaseItem.get(1));
		dropdownItemNumber.selectByValue("2");
		Thread.sleep(5000);
	}

	@Test
	public void test005GoToCartAndBuy() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		objBuyItemPage.page1().sendKeys(Keys.HOME);
		Thread.sleep(2000);

		objBuyItemPage.btnMainCart().click();
		Thread.sleep(5000);

		objBuyItemPage.btnBuy().click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void endTest() {
		closeBrowser();
	}
}
