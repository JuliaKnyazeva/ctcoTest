import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;



public class WebTest {
    @Test
    public  void testCtcoWeb() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Desktop/chrome/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://ctco.lv/en");

        List<String> expectedResult = List.of("Ability to create/update manual Test Cases and perform qualitative manual testing;",
                "Ability to create/update automated (FIT, XML) Test Cases based on the defined ones. Knowledge of SQL;",
                "Ability to perform load and performance testing, including test plans creation/update/results analysis (JMeter);",
                "Strong analytical skills and ability to qualitatively review specifications and clarify uncertain questions with Business Analysts;",
                "Work organization and reporting skills;", "Team player with good analytical and communication skills;",
                "Good level in English reading/speaking/writing, and good understanding of Latvian and Russian.");

        WebElement careersTextButton = driver.findElement(By.xpath("//a[contains(text(),'Careers')]"));
        careersTextButton.click();
        Thread.sleep(1000);
        WebElement vacanciesTextButton = driver.findElement(By.xpath("//a[contains(text(),'Vacancies')]"));
        vacanciesTextButton.click();
        Thread.sleep(2000);
        WebElement qaTextButton = driver.findElement(By.linkText("TEST AUTOMATION ENGINEER"));
        Assert.assertEquals(qaTextButton.getText(), "TEST AUTOMATION ENGINEER");
        qaTextButton.click();
        Thread.sleep(10000);
        WebElement nameTextHead = driver.findElement(By.xpath("//h1[contains(text(),'TEST AUTOMATION ENGINEER')]"));
        Assert.assertEquals(nameTextHead.getText(), "TEST AUTOMATION ENGINEER");
        WebElement proSkills = driver.findElement(By.xpath("//strong[contains(text(),'Professional skills and qualification:')]"));
        Assert.assertEquals(proSkills.getText(), "Professional skills and qualification:");
        WebElement first = driver.findElement(By.xpath("//li[contains(text(),'Ability to properly in details define Test Cases a')]"));
        Assert.assertEquals(first.getText(), "Ability to properly in details define Test Cases after specification review;");
        List<String> actualResult = List.of("Ability to create/update manual Test Cases and perform qualitative manual testing;",
                "Ability to create/update automated (FIT, XML) Test Cases based on the defined ones. Knowledge of SQL;",
                "Ability to perform load and performance testing, including test plans creation/update/results analysis (JMeter);",
                "Strong analytical skills and ability to qualitatively review specifications and clarify uncertain questions with Business Analysts;",
                "Work organization and reporting skills;",
                "Team player with good analytical and communication skills;",
                "Good level in English reading/speaking/writing, and good understanding of Latvian and Russian.");
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}
