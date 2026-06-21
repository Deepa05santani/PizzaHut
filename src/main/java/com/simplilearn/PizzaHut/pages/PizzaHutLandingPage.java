package com.simplilearn.PizzaHut.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PizzaHutLandingPage {
    
    WebDriver driver;

    // Initialize Page Factory elements
    public PizzaHutLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 1. Black auto-location tracking pop-up / Close button
    @FindBy(xpath = "//button[contains(@class, 'icon-close') or contains(@data-synthetic-id, 'close')]")
    public WebElement closeAutoLocationPopUpBtn;

    // 2. Delivery address input box on the landing screen
    @FindBy(xpath = "//input[contains(@placeholder, 'Enter your location') or @type='text']")
    public WebElement deliveryLocationInput;

    // 3. First auto-populated drop-down option from location search results
    @FindBy(xpath = "//button[contains(@data-synthetic-id, 'search-item')] | //div[@role='option'] | (//div[contains(@class, 'search') or contains(@class, 'suggestion')])[1]")
    public WebElement firstLocationSuggestion;

    // 4. Vegetarian toggle radio button/flag on the menu page
    @FindBy(xpath = "//span[contains(@class, 'veg-toggle')] | //input[@type='checkbox' and contains(@id, 'veg')] | //div[contains(@class, 'veg-filter')]")
    public WebElement vegToggleButton;

    // 5. Pizzas menu category option link in the navigation side/top bar
    @FindBy(xpath = "//a[contains(@href, '/menu/pizzas') or contains(span, 'Pizzas')]")
    public WebElement pizzasMenuLink;

    // 6. Drinks menu category option link in the navigation side/top bar
    @FindBy(xpath = "//a[contains(@href, '/menu/drinks') or contains(span, 'Drinks')]")
    public WebElement drinksMenuLink;
    
 // 7. "Add" buttons specifically under the Recommended / Pizzas list
    @FindBy(xpath = "//button[contains(@data-synthetic-id, 'add-to-basket')] | //button[contains(@class, 'add-to-card')] | //button[span[contains(text(), 'Add')]] | //button[contains(., 'Add')]")
    public List<WebElement> addPizzaToBasketButtons;

    // 8. Pepsi option "Add" button inside the Drinks section
    @FindBy(xpath = "//div[contains(., 'Pepsi')]//button[contains(., 'Add')]")
    public WebElement addPepsiToBasketBtn;

    // 9. Basket items list inside the "Your Basket" section side panel
    @FindBy(xpath = "//div[contains(@class, 'basket-item') or @data-synthetic-id='basket-item']")
    public List<WebElement> basketItemsList;

    // 10. Individual item price display tags within the basket list
    @FindBy(xpath = "//span[contains(@class, 'basket-item-price')]")
    public List<WebElement> basketItemPrices;

    // 11. Subtotal / Total basket price indicator element (before final checkout)
    @FindBy(xpath = "//span[contains(@class, 'subtotal') or @data-synthetic-id='basket-subtotal']")
    public WebElement basketTotalPriceText;

    // 12. Main Checkout button showing overall item count and running total cost
    @FindBy(xpath = "//button[contains(@data-synthetic-id, 'mini-basket-checkout')] | //div[contains(@class, 'checkout-button')] | //a[contains(@class, 'checkout')] | //button[contains(., 'Checkout') or contains(., 'item')]")
    public WebElement checkoutButton;

    // 13. Remove item/Pizza button icon inside the basket listing container
    @FindBy(xpath = "//button[contains(@class, 'remove-item') or @data-synthetic-id='remove-from-basket']")
    public WebElement removePizzaFromBasketBtn;

 // 14. Minimum order required validation warning banner/pop-up window element

    @FindBy(xpath = "//div[contains(@class, 'min-order-alert')]//p | //div[contains(@class, 'popup')]//span | //*[contains(text(), 'minimum') or contains(text(), 'Minimum')]")
    public WebElement minOrderRequiredPopUpAlert;
}