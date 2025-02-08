package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyItemPage {

	public WebDriver driver;
	private By txtSearch = By.id("twotabsearchtextbox");
	private By btnSearch = By.id("nav-search-submit-button");
	private By sliderLower = By.id("p_36/range-slider_slider-item_lower-bound-slider");
	private By sliderUpper = By.id("p_36/range-slider_slider-item_upper-bound-slider");
	private By btnAddToCart = By.id("add-to-cart-button");
	private By checkTitan = By.xpath("//a[contains(@href,'Titan')]");
	private By btnGoToCart = By.id("nav-cart-count-container");
	private By btnProceedToBuy = By.name("proceedToRetailCheckout");
	private By btnPrice = By.xpath("//input[@aria-label='Go - Submit price range']");
	private By btnSkip = By.xpath(
			"//span[@class='a-button-inner']/input[@class='a-button-input' and @aria-labelledby='attachSiNoCoverage-announce']");
	private By page1 = By.tagName("body");
	private By btnMainCart = By.id("nav-cart-count-container");
	private By btnBuy = By.xpath("//input[@value='Proceed to checkout']");

	public BuyItemPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement txtSearch() {
		return driver.findElement(txtSearch);
	}

	public WebElement btnSearch() {
		return driver.findElement(btnSearch);
	}

	public WebElement sliderLower() {
		return driver.findElement(sliderLower);
	}

	public WebElement sliderUpper() {
		return driver.findElement(sliderUpper);
	}

	public WebElement btnAddToCart() {
		return driver.findElement(btnAddToCart);
	}

	public WebElement checkTitan() {
		return driver.findElement(checkTitan);
	}

	public List<WebElement> checkTitian() {
		List<WebElement> eleCheckTitan = driver.findElements(By.xpath("//a[contains(@href,'Titan')]"));
		return eleCheckTitan;
	}

	public List<WebElement> ddItem() {
		List<WebElement> eleddItem = driver.findElements(By.xpath("//span[@class='a-button-text a-declarative']"));
		return eleddItem;
	}

	public List<WebElement> btnColor() {
		List<WebElement> elebtnColor = driver.findElements(By.xpath("//a[@title='Grey']/child::span/child::div"));
		return elebtnColor;
	}

	public List<WebElement> lblTitan() {
		List<WebElement> elelblTitan = driver.findElements(By.xpath("//a[contains(@href,'Titan')]"));
		return elelblTitan;
	}

	public List<WebElement> btnAddToCartRandom() {
		List<WebElement> elebtnAddToCartRandom = driver.findElements(By.xpath("//button[text()='Add to cart']"));
		return elebtnAddToCartRandom;
	}

	public List<WebElement> ddIncreaseItem() {
		List<WebElement> eleddIncreaseItem = driver.findElements(By.xpath("//select[@id='quantity-selector']"));
		return eleddIncreaseItem;
	}

	public WebElement btnGoToCart() {
		return driver.findElement(btnGoToCart);
	}

	public WebElement btnProceedToBuy() {
		return driver.findElement(btnProceedToBuy);
	}

	public WebElement btnPrice() {
		return driver.findElement(btnPrice);
	}

	public WebElement btnSkip() {
		return driver.findElement(btnSkip);
	}

	public WebElement page1() {
		return driver.findElement(page1);
	}

	public WebElement btnMainCart() {
		return driver.findElement(btnMainCart);
	}

	public WebElement btnBuy() {
		return driver.findElement(btnBuy);
	}

}
