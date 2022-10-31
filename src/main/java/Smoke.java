import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Smoke {
    public static void main(String[] args) throws InterruptedException {

        String sotoken = "03111013010400425uqr7kizQ7VCfLZEvA5Ob1o60iKUJ17qig%2FzI6DbhkvGx%2FfxBkx9z%2F6TN0eARyWB%2FjrSIpQnXuqKD%2FMjoNuGS8Vu4klW7VIikHVVV8LJIelb3VpEIBNt2XAMxlV%2Bd6qRtjrSIpQnXuqKD%2FMjoNuGS8Y60iKUJ17qig%2FzI6DbhkvGOtIilCde6ooP8yOg24ZLxvVmCPT%2BhSeuu3PPAmkIda9mmjjgq3t20H%2FOhkTIV7ko%3DijoYFrlFGZeok3yF28hGNeBG4anAPt8W8IP9n%2BHBu7nahUJ16a5VvyACLxa8ose9m%2BU0TZGzkuuBopjW4fenjtUMxz47M4bUNom2H0%2BGADqRfDDDXruLCQxacigYng78PFK7aLDUrAVlPmpJ8c8x0XQVRds%2FDK66b7CWFKr8%2F%2BE%3D";

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        WebDriverWait driverWait = new WebDriverWait(driver,40);
        driver.get("https://bankportal.preprod-restricted.evry.com/scs-client-s1/default/jsp/salescustomerservice/common/JumpUrl.jsf?Dispatch=true&Url=https://bankportal.preprod-restricted.evry.com/scs-aml-kyc-client/aml/case-id/new&customerId=38341000009&HttpGet=true&SecureObject=true&CertificateKey=8000&UrlEncode=true&forceRefreshBrowserCaching=1658919330887&so=" + sotoken);



        Smoke.customerInformation(driver, driverWait);
        Smoke.FOT(driver, driverWait);
        Smoke.originOfFunds(driver, driverWait);
        Smoke.screening(driver, driverWait);
        Smoke.attachments(driver, driverWait);
        Smoke.riskScore(driver, driverWait);
        Smoke.summary(driver, driverWait);

    }

    public static void customerInformation(WebDriver driver, WebDriverWait driverWait) throws InterruptedException {

        driver.manage().window().maximize();

        waitSpinner(driver, driverWait);

        //String fieldXpath = "//*[@id=\"uncontrolled-tab-example-tabpane-0\"]/fieldset/section/div/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div[1]/input";

        WebDriverWait wait = new WebDriverWait(driver, 20);
        Thread.sleep(4000);
        WebElement foreignOrgNr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[1]/fieldset/section/div/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div[1]/input")));


        foreignOrgNr.click();
        clearField(foreignOrgNr);
        foreignOrgNr.sendKeys("22222");

        WebElement neste = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div"));
        neste.click();
    }

    private static void waitSpinner(WebDriver driver, WebDriverWait driverWait) {
        waitForElement("//div[@class=\'spinner\']", driverWait);
        driverWait.until(
                ExpectedConditions.stalenessOf(
                        driver.findElement(By.xpath("//div[@class=\'spinner\']"))
                )
        );
    }

    private static void clearField (WebElement field) {
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
    }

    private static void waitForElement (String xPath, WebDriverWait driverWaitElement) {
        driverWaitElement.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(xPath)
                )
        );
    }


    public static void FOT(WebDriver driver, WebDriverWait driverWait) {


        waitSpinner(driver, driverWait);

        String fieldXpath = "//*[@id=\"uncontrolled-tab-example-tabpane-1\"]/fieldset/section/div/div[2]/div[1]/div";

        waitForElement(fieldXpath, driverWait);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(250, 0)");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement expandAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-1\"]/fieldset/section/div/div[1]/span[1]")));
        expandAll.click();

        WebElement erHBhovedbank = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-1\"]/fieldset/section/div/div[3]/form/div[1]/div[2]/div/section/div/div/div/div[1]/section/div/div/div[2]/div/div[2]/div[1]/div[1]/label/input"));
        erHBhovedbank.click();

        jse.executeScript("scroll(0,250)");

        WebElement neste = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div"));
        neste.click();
    }


    public static void originOfFunds(WebDriver driver, WebDriverWait driverWait) throws InterruptedException {


        waitSpinner(driver, driverWait);

        String fieldXpath = "//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div";

        waitForElement(fieldXpath, driverWait);

        WebElement next = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div"));
        next.click();
    }

    public static void screening(WebDriver driver, WebDriverWait driverWait) throws InterruptedException {


        waitSpinner(driver, driverWait);

        String fieldXpath = "/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[4]/fieldset/div/div/div/div/div[2]/div[1]/div/div[1]";

        waitForElement(fieldXpath, driverWait);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(250, 0)");

        WebElement expandALL = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[4]/fieldset/div/div/div/div/div[1]/span[1]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(expandALL);
        actions.click();

        expandALL.click();

        WebElement noHit1 = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[4]/fieldset/div/div/div/div/div[2]/div[2]/div/div/section/div[2]/div[1]/form/div[1]/div[2]/div[2]/div[1]/div/div[2]/label/input\n"));
        noHit1.click();

        Thread.sleep(1000*1);

        WebElement noHit2 = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[4]/fieldset/div/div/div/div/div[3]/div[2]/div/div/section[2]/div[2]/div[1]/form/div[1]/div[2]/div[2]/div[1]/div/div[2]/label/input\n"));
        noHit2.click();

        Thread.sleep(1000*1);

        jse.executeScript("scroll(250, 0)");

        WebElement next = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div"));
        next.click();
    }
    public static void attachments(WebDriver driver, WebDriverWait driverWait) throws InterruptedException {


        waitSpinner(driver, driverWait);

        String fieldXpath = "/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[5]/fieldset/section/div[2]/div/table/thead/tr[1]/th[1]";

        waitForElement(fieldXpath, driverWait);

        Thread.sleep(1000*3);

        WebElement fileUploadfield = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[5]/fieldset/section/div[1]/label/input"));
        fileUploadfield.sendKeys("C:\\Selenium\\KYC\\KYCcase\\test\\image (1).png");

        WebElement attachmentType =driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[2]/div/div/div[2]/table/tbody/tr/td[2]/div/div/div/section/div/div[1]"));
        attachmentType.click();

        WebElement attachTypeCompCert = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[2]/div/div/div[2]/table/tbody/tr/td[2]/div/div/div/section/div/div[2]/div/div/table/tbody/tr[1]"));
        attachTypeCompCert.click();

        WebElement attachBelongs = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[2]/div/div/div[2]/table/tbody/tr/td[3]/div/div/div/section/div/input"));
        attachBelongs.click();

        WebElement attachBelongsCustInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[2]/div/div/div[2]/table/tbody/tr/td[3]/div/div/div/section/div/div[2]/div/div/table/tbody/tr[1]"));
        attachBelongsCustInfo.click();

        WebElement attachComment = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[2]/div/div/div[2]/table/tbody/tr/td[4]/div/div/div/textarea"));
        attachComment.click();
        attachComment.sendKeys("test");

        WebElement attachConfirm = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[3]/button[1]"));
        attachConfirm.click();

        WebElement next = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div"));
        next.click();
    }
    public static void riskScore(WebDriver driver, WebDriverWait driverWait) throws InterruptedException {


        waitSpinner(driver, driverWait);

        String fieldXpath = "/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[6]/fieldset/div/div[2]/div[2]/div/section/div[5]/div/div[3]/div/div[1]/label";

        waitForElement(fieldXpath, driverWait);

        WebElement override = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[6]/fieldset/div/div[2]/div[2]/div/section/div[7]/div/form/div/div/div[2]/div[1]/div/div[2]/label/input\n"));
        override.click();


        WebElement next = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div"));
        next.click();
    }
    public static void summary(WebDriver driver, WebDriverWait driverWait) throws InterruptedException {


        waitSpinner(driver, driverWait);

        String fieldXpath = "//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div";

        waitForElement(fieldXpath, driverWait);

        Thread.sleep(1000*1);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 0)");

        WebElement expandALL = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[7]/section/div/div[1]/span[1]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(expandALL);
        actions.click();

        expandALL.click();

        Thread.sleep(1000*1);

        WebElement checklist = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[7]/section/div/div[3]/div[2]/div/fieldset/section/div[1]/div/div/div/div[2]/div[1]/input"));
        checklist.click();

        WebElement riskAssessment = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[1]/div[7]/section/div/div[3]/div[2]/div/fieldset/section/div[2]/div/div/div/div/div/div/div[2]/textarea"));

        riskAssessment.click();
        //clearField2(riskAssessment);
        riskAssessment.sendKeys("test");

        WebElement confirmation = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/div/form/input"));
        confirmation.click();

        Thread.sleep(1000*1);

        WebElement done = driver.findElement(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div[2]/div/div/fieldset/div/div/button"));
        done.click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement alert = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/header/div[2]/div/div[2]/div/div/div/div/div[1]/div/span"))));

        String alertText = alert.getText();

        assertEquals("Saken er utført.",alertText);

        driver.quit();
    }


    /*private static void clearField2 (WebElement field) {
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
        WebDriver driver = new ChromeDriver();



    }*/
    /*public static void assertion(WebDriver driver, WebDriverWait driverWait) throws InterruptedException {

    }

     */


}





