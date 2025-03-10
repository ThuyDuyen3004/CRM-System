package pages;

import KeyWord.WebUI;
import com.anhtester.constants.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");


    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //driver = _driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    public void verifyLoginSuccess() {
        WebUI.waitForPageLoaded(driver);
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
        Assert.assertEquals(driver.getCurrentUrl(),"https://crm.anhtester.com/admin/","Fail. the current web ...");
    }


    public void verifyLoginFail(String expectedMessage) {
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(WebUI.checkElementExist(driver, errorMessage), "FAIL. The error message not display.");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), expectedMessage, "FAIL. The content of error massge not match.");
    }


    //Các hàm xử lý cho chính trang này
    public DashboardPage loginCRM(String email, String password) {

        driver.get(ConfigData.URL); //Gọi từ class ConfigData dạng biến static
        setEmail(email);
        setPassword(password);
        clickLoginButton();

        return new DashboardPage(driver);
    }


}