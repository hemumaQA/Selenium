package com.edu.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*automate  "auto suggestive option" in a website using mouse click action-choose value from the dropdown,get all the text ,break the loop */

public class AutosuggestiveOptions {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        //location or path of the driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemum\\eclipse-workspace\\Selenium1\\src\\main\\resources\\chromedriver.exe");

        //create an object of the driver
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

        //driver.get("https://www.amazon.com/");
    }
    @Test
    public  void autoSuggestEx() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("India");

       // driver.findElement(By.name("gLFyf")).sendKeys("India"); // not working

        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        List<WebElement>  suggestions = driver.findElements(By.className("sbl1"));
        actions.click().build().perform();//to get the  "auto suggestive option"using mouse action


        for(WebElement suggest:suggestions){
            System.out.println(suggest.getText());  //for each loop to get all the elements in the  "auto suggestive option"

            if(suggest.getText().equalsIgnoreCase("Indian Bank")){
                suggest.click();//to get the"Indian Bank" element in the dropdown
                break;

            }
        }


    }
    @AfterMethod
    public void teardown() {
        driver.close();

    }

}
