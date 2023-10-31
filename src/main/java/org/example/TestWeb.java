package org.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWeb {
    @Test
    public void testWebPage1() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/basic-web-page-test.html");
        WebElement para1 = driver.findElement(By.id("para1"));
        System.out.println(para1.getText());
        WebElement para2 = driver.findElement(By.id("para2"));
        System.out.println(para2.getText());
        String para1ExpectedText = "A paragraph of text";
        Assertions.assertThat(para1.getText()).isEqualTo(para1ExpectedText);
        String para2ExpectedText = "Another paragraph of text";
        Assertions.assertThat(para2.getText()).isEqualTo(para2ExpectedText);

        driver.quit();
    }

    @Test
    public void testWebPage2() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/attributes-test.html");
        WebElement para1 = driver.findElement(By.xpath("//*[@custom-attrib=\"attrib in source at load\"]"));
        System.out.println(para1.getText());
        WebElement addAttributeButton = driver.findElement(By.cssSelector(".styled-click-button"));
        addAttributeButton.click();
        WebElement dynamicAttr = driver.findElement(By.xpath("//*[@custom-1=\"value-1\"]"));
        System.out.println(dynamicAttr.getText());
        String parDynamicAttExp = "This paragraph has dynamic attributes";
        Assertions.assertThat(dynamicAttr.getText()).isEqualTo(parDynamicAttExp);
        WebElement dynamicUpdates = driver.findElement(By.xpath("//p[contains(@name,'paradyn')]"));
        System.out.println(dynamicUpdates.getText());
        String dynamicUpdatesExptText = "This paragraph has dynamic attributes";
        Assertions.assertThat(dynamicUpdates.getText()).isEqualTo(dynamicUpdatesExptText);
        driver.quit();

    }

    @Test
    public void testWebPage3() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");
        WebElement para1=driver.findElement(By.id("p4"));
        System.out.println(para1.getText());
        String para1Text = "This is d paragraph text";
        Assertions.assertThat(para1.getText()).isEqualTo(para1Text);
        WebElement para2=driver.findElement(By.name("pName36"));
        System.out.println(para2.getText());
        String para2Text = "nested para text";
        Assertions.assertThat(para2.getText()).isEqualTo(para2Text);

        driver.quit();

    }
    @Test
    public void testWebPage4(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/webdriver-example-page");
        WebElement textBox = driver.findElement(By.cssSelector("#numentry"));
        textBox.sendKeys("87");
        WebElement showAsPara = driver.findElement(By.cssSelector("#show-as-para"));
        showAsPara.click();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        WebElement message = driver.findElement(By.cssSelector("#message"));
        System.out.println(message.getText());
        String messageDisplay = "eight, seven";
        Assertions.assertThat(message.getText()).isEqualTo(messageDisplay);

        driver.quit();

    }
}
