package pages;

import KeyWord.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    private WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }
    private By buttonDashboardOption= By.xpath("//div[normalize-space()='Dashboard Options']");
    private By TotalInvoicesAwaitingPayment= By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By TotalConvertedLeads= By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By TotalProjectsInProgress= By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By TotalTasksNotFinished= By.xpath("//span[normalize-space()='79 / 79']");
    private By checkboxinputQuickStatistics= By.xpath("//input[@id='widget_option_top_stats']");
    //div[@id='widget-top_stats']
    private By sectionQuickStatistics= By.xpath("//div[@id='widget-top_stats']");

    public void clickButtonDashboardOptions()
    {
        WebUI.waitForPageLoaded(driver);
        driver.findElement(buttonDashboardOption).click();
    }
    public void verifyCheckboxQuickStatistics()
    {
        WebUI.sleep(1);
        Assert.assertTrue(driver.findElement(checkboxinputQuickStatistics).isSelected(),"FAIL!!! The SectionQuickStatistics not selected");
        Assert.assertTrue(driver.findElement(sectionQuickStatistics).isDisplayed(),"FAIL!!! The SectionQuickStatistics not display");
    }

    public void checkTotalInvoicesAwaitingPayment() {
        Assert.assertTrue(WebUI.checkElementExist(driver, TotalInvoicesAwaitingPayment), "The sections InvoicesAwaitingPayment not display ");
        Assert.assertEquals(driver.findElement(TotalInvoicesAwaitingPayment).getText(), "0 / 2", "FAIL!!! InvoicesAwaitingPayment Total not match");
    }
    public void checkTotalConvertedLeads() {
        Assert.assertTrue(WebUI.checkElementExist(driver, TotalConvertedLeads), "The sections ConvertedLeads not display ");
        Assert.assertEquals(driver.findElement(TotalConvertedLeads).getText(), "0 / 0", "FAIL!!! ConvertedLead Total not match");
    }
    public void checkTotalProjectsInProgress() {
        Assert.assertTrue(WebUI.checkElementExist(driver, TotalProjectsInProgress), "The sections ProjectsInProgress not display ");
        Assert.assertEquals(driver.findElement(TotalProjectsInProgress).getText(), "57 / 61", "FAIL!!!  ProjectsInProgress Total not match");
    }
    public void checkTotalTasksNotFinished() {
        Assert.assertTrue(WebUI.checkElementExist(driver, TotalTasksNotFinished), "The sections TasksNotFinished not display ");
        Assert.assertEquals(driver.findElement(TotalTasksNotFinished).getText(), "79 / 79", "FAIL!!! TasksNotFinished Total not match");
    }
}
