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
			System.out.println("Captcha found.");
		} else {
			System.out.println("No captcha found.");
		}

	}

	@Test
	public void test001searchWatch() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		objBuyItemPage.txtSearch().sendKeys("Watch");
		objBuyItemPage.btnSearch().click();
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

		objBuyItemPage.btnPrice().click();

	}

	@Test
	public void test003selectDialColor() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 1500).perform();

		List<WebElement> eleBtnColor = objBuyItemPage.btnColorList();
		eleBtnColor.get(1).click();

	}

	@Test
	public void test004addToCart() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);
		Actions actions = new Actions(driver);

		do {
			actions.scrollByAmount(0, 500).perform();
		} while (!driver.getPageSource().contains("Titan"));

		if (driver.getPageSource().contains("Titan")) {
			List<WebElement> eleLblTitan = objBuyItemPage.checkTitanList();
			eleLblTitan.get(1).click();
		}

		SwitchWindowToChild();
		objBuyItemPage.btnAddToCart().click();

		if (driver.getPageSource().contains(" Extended Warranty ")) {
			objBuyItemPage.btnSkip().click();
		}

		SwitchWindowToParent();

		closeAllChildWindows();

		List<WebElement> eleBtnAddToCartRandom = objBuyItemPage.btnAddToCartRandomList();
		eleBtnAddToCartRandom.get(7).click();

		eleBtnAddToCartRandom.get(8).click();

		Thread.sleep(5000);

	}

	@Test
	public void test005IncreaseItemNumber() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		List<WebElement> eleIncreaseItem = objBuyItemPage.ddIncreaseItemList();

		Select dropdownItemNumber = new Select(eleIncreaseItem.get(1));
		dropdownItemNumber.selectByValue("2");
	}

	@Test
	public void test006GoToCartAndBuy() throws InterruptedException {
		objBuyItemPage = new BuyItemPage(driver);

		objBuyItemPage.pageBody().sendKeys(Keys.HOME);

		objBuyItemPage.btnMainCart().click();
		Thread.sleep(2000);

		objBuyItemPage.btnBuy().click();

	}

	@AfterClass
	public void endTest() {
		closeBrowser();
	}
}
