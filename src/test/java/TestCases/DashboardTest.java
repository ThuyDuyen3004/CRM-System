package TestCases;

import common.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {
   LoginPage loginPage;
   DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testcheckTotalSectionQuickStatisticsselected()
    {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com","123456");
        dashboardPage=new DashboardPage(driver);
        dashboardPage.clickButtonDashboardOptions();
        dashboardPage.verifyCheckboxQuickStatistics();
    }

    @Test (priority = 2)
    public void testcheckTotalSectionQuickStatistics()
    {
       loginPage = new LoginPage(driver);
       loginPage.loginCRM("admin@example.com","123456");
       dashboardPage=new DashboardPage(driver);
       dashboardPage.checkTotalInvoicesAwaitingPayment();
       dashboardPage.checkTotalConvertedLeads();
       dashboardPage.checkTotalProjectsInProgress();
       dashboardPage.checkTotalTasksNotFinished();
    }

}
