import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class WebTest {

    private static final String BASE_URL = "https://ctco.lv/en";

    private String createSkills() {
        final String skills = "Ability to properly in details define Test Cases after specification review;";
        return skills.toString();
    }


    @Test
    public void testCtcoWeb() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Desktop/chrome/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        List<String> expectedResult = List.of("Ability to create/update manual Test Cases and perform qualitative manual testing;",
                "Ability to create/update automated (FIT, XML) Test Cases based on the defined ones. Knowledge of SQL;",
                "Ability to perform load and performance testing, including test plans creation/update/results analysis (JMeter);",
                "Strong analytical skills and ability to qualitatively review specifications and clarify uncertain questions with Business Analysts;",
                "Work organization and reporting skills;", "Team player with good analytical and communication skills;",
                "Good level in English reading/speaking/writing, and good understanding of Latvian and Russian.");

        WebElement careersTextButton = driver.findElement(By.xpath("//a[contains(text(),'Careers')]"));
        careersTextButton.click();
        Thread.sleep(7000);
        WebElement vacanciesTextButton = driver.findElement(By.xpath("//a[contains(text(),'Vacancies')]"));
        vacanciesTextButton.click();
        Thread.sleep(7000);
        WebElement qaTextButton = driver.findElement(By.linkText("TEST AUTOMATION ENGINEER"));
        assertEquals(qaTextButton.getText(), "TEST AUTOMATION ENGINEER");
        qaTextButton.click();
        Thread.sleep(10000);
        WebElement proSkills = driver.findElement(By.xpath("//strong[contains(text(),'Professional skills and qualification:')]"));
        assertEquals(proSkills.getText(), "Professional skills and qualification:");
        WebElement first = driver.findElement(By.xpath("//li[contains(text(),'Ability to properly in details define Test Cases a')]"));
        assertEquals(first.getText(), "Ability to properly in details define Test Cases after specification review;");
        List<String> actualResult = List.of("Ability to create/update manual Test Cases and perform qualitative manual testing;",
                "Ability to create/update automated (FIT, XML) Test Cases based on the defined ones. Knowledge of SQL;",
                "Ability to perform load and performance testing, including test plans creation/update/results analysis (JMeter);",
                "Strong analytical skills and ability to qualitatively review specifications and clarify uncertain questions with Business Analysts;",
                "Work organization and reporting skills;",
                "Team player with good analytical and communication skills;",
                "Good level in English reading/speaking/writing, and good understanding of Latvian and Russian.");


        assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    @Test
    public void testCtcoWebRefactor() throws InterruptedException {

        String expectedResult = createSkills();
        By pathSkills = By.xpath("//li[contains(text(),'Ability to properly in details define Test Cases a')]");
        By menuCareers = By.xpath("//a[contains(text(),'Careers')]");
        By menuVacancies = By.xpath("//a[contains(text(),'Vacancies')]");
        By testQA = By.linkText("TEST AUTOMATION ENGINEER");
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Desktop/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);
        driver.findElement(menuCareers).click();
        Thread.sleep(7000);//bad connection, because using mobile internet
        driver.findElement(menuVacancies).click();
        Thread.sleep(7000);
        driver.findElement(testQA).click();
        Thread.sleep(10000);

        WebElement actualResult = driver.findElement(pathSkills);
        assertEquals(expectedResult, actualResult.getText());
        driver.quit();
    }
}
