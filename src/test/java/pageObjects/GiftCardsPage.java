package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftCardsPage extends BasePage {

	public GiftCardsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@FindBy(xpath="//body/div[@id='root']/div[@id='top-banner']/div[@class='minContainer']/div/div[@class='gc__container']/div[@class='gc__main']/div[@class='gc__right']/div[2]/ul[1]/li[1]/div[1]")
	WebElement wedding_GiftCard;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[1]/ul/li[3]/a")
	WebElement validate_wedding_GiftCard;
	
	@FindBy(xpath="//li[@data-cy='gc_breadcrumb_Gift Cards_1']/a")
	WebElement toValidateGiftCards;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div[2]/div[6]/ul/li[1]")
	WebElement fathersDayGiftCard;
	
	@FindBy(xpath="//li[@data-cy='SingleGiftCard_57']//h3")
	WebElement onamGiftCard;
	
	@FindBy(xpath="//div[@class='gcard__dtl']/h1")
	WebElement toValidateFathersDayGC;
	
	@FindBy(xpath="//div[@class='deliver__wrap']//li[@data-cy='DeliveryModes_444'][2]/span")
	WebElement emailOption;
	
	@FindBy(xpath="//div[@class='form__field']//input[@name='name']")
	WebElement recipientsName;
	
	@FindBy(xpath="//div[@class='form__field']//input[@name='mobileNo']")
	WebElement recipientsMobileNo;
	
	@FindBy(xpath="//div[@class='form__field']//input[@name='emailId']")
	WebElement recipientsEmailId;
	
	@FindBy(xpath="//div[@class='form__field__wrap']//textarea[@name='giftMessage']")
	WebElement composeMessage;
	
	@FindBy(xpath="//div[@class='about__card__wrap']")
	WebElement aboutThisGC;
	
	@FindBy(xpath="//div[@class='form__field']//input[@name='senderName']")
	WebElement senderName;
	
	@FindBy(xpath="//div[@class='form__field']//input[@name='senderMobileNo']")
	WebElement senderMobileNo;
	
	@FindBy(xpath="//div[@class='form__field']//input[@name='senderEmailId']")
	WebElement senderEmailId;
	
	@FindBy(xpath="//button[contains(text(),'BUY')]")
	WebElement BuyOption;
	
	@FindBy(xpath="//div[@class='form__field form__field__error']/following-sibling::p")
	WebElement WarningMessage;
	
	@FindBy(xpath="//div[@class='payment__options__tab']/p/span")
	WebElement PaymentsTab;
	
	@FindBy(xpath="//li[@data-cy='menu_Hotels']//a")
	WebElement Hotels;
	
	
	//Action methods
	public void click_wedding_GiftCard() {
		wedding_GiftCard.click();		
	}
	
	public boolean validate_wedding_giftcard() {
		if(validate_wedding_GiftCard.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public void hoverActions(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public void clickingAction(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	
	public void scrollUntilElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void scrollUntilPixel(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")","");
	}
	
	public void scrollUpToTop() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	public String toValidateGiftCardsPage() {
		try {
		String GiftCardPage = toValidateGiftCards.getText();
		return GiftCardPage;
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	public void toClickFathersDayGC() {
		scrollUntilElement(onamGiftCard);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hoverActions(fathersDayGiftCard);
		clickingAction(fathersDayGiftCard);
//		fathersDayGiftCard.click();
	}
	
	public String toValidateFathersDayGCMethod() {
		try {
		String FathersDayValidation = toValidateFathersDayGC.getText();
		return FathersDayValidation;
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	public void toClickEmailOption() {
		wait.until(ExpectedConditions.visibilityOf(emailOption));
		scrollUntilElement(emailOption);
		emailOption.click();
	}
	
	public void toInputRecipientsName(String Rname) throws Exception {
		Thread.sleep(2000);
		scrollUntilPixel(0,300);
		recipientsName.sendKeys(Rname);
	}
	
	public void toInputRecipientsMobileNo(String RmobileNo) throws InterruptedException {
		Thread.sleep(2000);
		recipientsMobileNo.sendKeys(RmobileNo);
	}
	
	public void toInputRecipientsEmailID(String RemailID) {
		recipientsEmailId.sendKeys(RemailID);
	}
	
	public void toInputComposeMessage(String message) {
		composeMessage.sendKeys(message);
	}
	
	public void toInputsenderName(String Sname) {
		scrollUntilElement(senderName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		senderName.sendKeys(Sname);
	}
	
	public void toInputSendersMobileNo(String SmobileNo) {
		senderMobileNo.sendKeys(SmobileNo);
	}
	
	public void toInputSendersEmailID(String SemailID) {
		senderEmailId.sendKeys(SemailID);
	}
	
	public void toClickOnBuyNow() {
		BuyOption.click();
	}
	
	public boolean validate_warningmsg_display()
	{
		if(WarningMessage.isDisplayed())
		{
			return true;
		}
		return false;
	}
	public String warningMessageDisplayed() {
		try {
		String wMessage = WarningMessage.getText();
		return wMessage;
		} catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	public boolean toValidatePaymentsPage() throws InterruptedException {
		if(PaymentsTab.isDisplayed()) {
			System.out.println(PaymentsTab.getText());
			return true;
		}
		else {
			return false;
		}
	}
	
	public void toClickHotelsOption() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().back();
		scrollUpToTop();
		hoverActions(Hotels);
		clickingAction(Hotels);
	}
	
	public boolean toValidateHotelsOption() {
		if(Hotels.isSelected()) {
			System.out.println(Hotels.getText());
			return true;
		}
		else {
			return false;
		}
	}


	
}
