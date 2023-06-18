package MyStore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignInTest {



        private static WebDriver driver;
        @BeforeAll // wird immer zu beginn ausgeführt
        static void globalSetup(){ // immer static
            WebDriverManager.chromedriver().setup(); // hier wird passende Version geholt
        }

        // das war Set Up

        // jetzt kommt driver

        @BeforeEach
            //vor jedem testfall in der testklasse wird eine neue Crome Driver Instanz erstellt
        void setup(){
            driver = new ChromeDriver(); // hier bestimmen wir den driver
        }

        // Setup ist hiermit beendet

        @AfterEach
        void teardown(){
            if (driver !=null){
                driver.quit();
            }  }

        @Test
        @DisplayName("Should register a new user")
        void registrationTest() throws InterruptedException {
            //arrange
            String email = "zp@gmx.com";
            String vorname = "Zhanna";
            String nachname = "Banana";
            String password = "blablabla";
            String expectedUsername = "Zhanna Banana";



            // Act (für Testimplementierung)
            driver.get("http://automationpractice.pl/");
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email_create")).sendKeys(email);
            driver.findElement(By.id("SubmitCreate")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("uniform-id_gender1")).click();
            driver.findElement(By.id("customer_firstname")).sendKeys(vorname);
            driver.findElement(By.id("customer_lastname")).sendKeys(nachname);
            driver.findElement(By.id("passwd")).sendKeys(password);

            Select daySelect = new Select(driver.findElement(By.id("days")));
            daySelect.selectByIndex(10);
            Select monthSelect = new Select(driver.findElement(By.id("months")));
            monthSelect.selectByIndex(2);
            Select yearSelect = new Select(driver.findElement(By.id("years")));
            yearSelect.selectByIndex(5);

            driver.findElement(By.id("submitAccount")).click();
            Thread.sleep(9000);
            String actualUsername = driver.findElement(By.className("header_user_info")).getText().trim();


            // Asserts
            Assertions.assertEquals("Zhanna Banana", actualUsername);

            //Teardown - schließen von Chrome Fenstern

        }}


