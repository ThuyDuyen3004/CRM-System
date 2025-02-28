package Bai20.TestCases;

import Bai20.common.BaseTest;
//import Bai19.pages.CustomerPage;
//import Bai19.pages.DashboardPage;
//import Bai19.pages.LoginPage;
import KeyWord.WebUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Bai20.common.BaseTest;
import Bai20.pages.CustomerPage;
import Bai20.pages.DashboardPage;
import Bai20.pages.LoginPage;
//import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void TestAddNewCustomer() {
        //loginPage = new LoginPage(driver);
        // dashboardPage = loginPage.loginCRM("admin@example.com","123456");
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        customerPage = dashboardPage.ClickMenuCustomer();//Hàm này nằm bên CommonPage
       customerPage.clickAddNewButton();
       WebUI.sleep(3);
        customerPage.enterDataAddNewCustomer("Anh Tester 07062024A3");
        customerPage.checkCustomerDetail("An");
    }
}

