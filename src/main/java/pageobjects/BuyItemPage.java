package pageobjects;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BuyItemPage {

	public WebDriver driver;
	private WebDriverWait wait; // Add WebDriverWait

	public BuyItemPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Initialize wait
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement txtSearch;

	@FindBy(id = "nav-search-submit-button")
	private WebElement btnSearch;

	@FindBy(id = "p_36/range-slider_slider-item_lower-bound-slider")
	private WebElement sliderLower;

	@FindBy(id = "p_36/range-slider_slider-item_upper-bound-slider")
	private WebElement sliderUpper;

	@FindBy(id = "add-to-cart-button")
	private WebElement btnAddToCart;

	@FindBy(xpath = "//a[contains(@href,'Titan')]")
	private WebElement checkTitan;

	@FindBy(id = "nav-cart-count-container")
	private WebElement btnGoToCart;

	@FindBy(name = "proceedToRetailCheckout")
	private WebElement btnProceedToBuy;

	@FindBy(xpath = "//input[@aria-label='Go - Submit price range']")
	private WebElement btnPrice;

	@FindBy(xpath = "//span[@class='a-button-inner']/input[@class='a-button-input' and @aria-labelledby='attachSiNoCoverage-announce']")
	private WebElement btnSkip;

	@FindBy(tagName = "body")
	private WebElement pageBody;

	@FindBy(id = "nav-cart-count-container")
	private WebElement btnMainCart;

	@FindBy(xpath = "//input[@value='Proceed to checkout']")
	private WebElement btnBuy;

	@FindBy(xpath = "//a[contains(@href,'Titan')]")
	private List<WebElement> checkTitanList;

	@FindBy(xpath = "//span[@class='a-button-text a-declarative']")
	private List<WebElement> ddItemList;

	@FindBy(xpath = "//a[@title='Grey']/child::span/child::div")
	private List<WebElement> btnColorList;

	@FindBy(xpath = "//a[contains(@href,'Titan')]")
	private List<WebElement> lblTitanList;

	@FindBy(xpath = "//button[text()='Add to cart']")
	private List<WebElement> btnAddToCartRandomList;

	@FindBy(xpath = "//select[@id='quantity-selector']")
	private List<WebElement> ddIncreaseItemList;

	// Methods with wait before returning elements

	public WebElement txtSearch() {
		return wait.until(ExpectedConditions.visibilityOf(txtSearch));
	}

	public WebElement btnSearch() {
		return wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
	}

	public WebElement sliderLower() {
		return wait.until(ExpectedConditions.visibilityOf(sliderLower));
	}

	public WebElement sliderUpper() {
		return wait.until(ExpectedConditions.visibilityOf(sliderUpper));
	}

	public WebElement btnAddToCart() {
		return wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
	}

	public WebElement checkTitan() {
		return wait.until(ExpectedConditions.visibilityOf(checkTitan));
	}

	public WebElement btnGoToCart() {
		return wait.until(ExpectedConditions.elementToBeClickable(btnGoToCart));
	}

	public WebElement btnProceedToBuy() {
		return wait.until(ExpectedConditions.elementToBeClickable(btnProceedToBuy));
	}

	public WebElement btnPrice() {
		return wait.until(ExpectedConditions.elementToBeClickable(btnPrice));
	}

	public WebElement btnSkip() {
		return wait.until(ExpectedConditions.elementToBeClickable(btnSkip));
	}

	public WebElement pageBody() {
		return wait.until(ExpectedConditions.visibilityOf(pageBody));
	}

	public WebElement btnMainCart() {
		return wait.until(ExpectedConditions.elementToBeClickable(btnMainCart));
	}

	public WebElement btnBuy() {
		return wait.until(ExpectedConditions.elementToBeClickable(btnBuy));
	}

	public List<WebElement> checkTitanList() {
		wait.until(ExpectedConditions.visibilityOfAllElements(checkTitanList));
		return checkTitanList;
	}

	public List<WebElement> ddItemList() {
		wait.until(ExpectedConditions.visibilityOfAllElements(ddItemList));
		return ddItemList;
	}

	public List<WebElement> btnColorList() {
		wait.until(ExpectedConditions.visibilityOfAllElements(btnColorList));
		return btnColorList;
	}

	public List<WebElement> lblTitanList() {
		wait.until(ExpectedConditions.visibilityOfAllElements(lblTitanList));
		return lblTitanList;
	}

	public List<WebElement> btnAddToCartRandomList() {
		wait.until(ExpectedConditions.visibilityOfAllElements(btnAddToCartRandomList));
		return btnAddToCartRandomList;
	}

	public List<WebElement> ddIncreaseItemList() {
		wait.until(ExpectedConditions.visibilityOfAllElements(ddIncreaseItemList));
		return ddIncreaseItemList;
	}
}
