package Bai19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    private final WebDriver driver;

    CommonPage(WebDriver driver){
        this.driver=driver;
    }

    public By menuDashBoard= By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomer= By.xpath("//span[normalize-space()='Customers']");
    public By menuSales= By.xpath("//span[@class='menu-text'][normalize-space()='Sales']");
    public By menuProjects= By.xpath("//span[normalize-space()='Projects']");
    public By iconNotify= By.xpath("//a[contains(@class,\"notifications-icon\")]");


    public CustomerPage clickMenuCustomer()
    {
        driver.findElement(menuCustomer).click();
        return new CustomerPage(driver);
    }
    public DashboardPage clickMenuDashboard()
    {
        driver.findElement(menuDashBoard).click();
        return new DashboardPage(driver);
    }
}