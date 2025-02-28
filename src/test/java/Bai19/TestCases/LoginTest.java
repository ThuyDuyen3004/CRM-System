package Bai19.TestCases;

import common.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();
    }
    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage(driver);

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail("Invalid email or password");

    }
    @Test
    public void testLoginFailWithPassWordInvalid(){
        loginPage = new LoginPage(driver);

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin@example.com", "1234567");
        loginPage.verifyLoginFail("Invalid email or password");


    }
    @Test
    public void testLoginFailWithPassWordNull(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com","");
        loginPage.verifyLoginFail("The Password field is required.");
    }
    @Test
    public void testLoginFailWithEmailNull(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("","123");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }
}



