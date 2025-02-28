package Bai10_AnnotationTestNG;

import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoCRM_BaseTest extends BaseTest {
    @Test
    public void testLoginCRM()

    {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);
    }

    @Test
    public void testLoginCMS()

    {
        driver.get("http://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);
    }
}

