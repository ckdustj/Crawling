import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
//        driver.get("https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=100");
//        WebElement webElement = driver.findElement(By.cssSelector("ul.sh_list"));
//        List<WebElement> webElements = webElement.findElements(By.cssSelector("div.sh_text > a"));
//        for(WebElement aTag : webElements){
//            System.out.println("제목: " + aTag.getText());
//            System.out.println("링크: " + aTag.getAttribute("href"));

//        driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/");
//        WebElement idInput = driver.findElement(By.id("id"));
//        WebElement pwInput = driver.findElement(By.id("pw"));
//        idInput.sendKeys("아이디입니다");
//        pwInput.sendKeys("비밀번호입니다");
//        idInput.sendKeys(Keys.ENTER);


        //        driver.quit();

        driver.get("https://www.yes24.com/Product/Category/RealTimeBestSeller?categoryNumber=001");

        List<WebElement> items = driver.findElements(By.className("itemUnit"));
        for(var item : items){
            WebElement title = item.findElement(By.className("gd_name"));
            WebElement price1 = item.findElement(By.className("txt_num"));
            WebElement price2 = price1.findElement(By.className("yes_b"));
            System.out.println(title.getText());
            System.out.println(price2.getText());
        }

        WebElement click = driver.findElement(By.className("gd_name"));
        new Actions(driver)
                .click(click)
                .perform();
        WebElement title1 = driver.findElement(By.className("bgYUI bl_dot"));
        System.out.println(title1);



        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");

        Sequence actions = new Sequence(mouse, 0)
                .addAction(mouse.createPointerDown(PointerInput.MouseButton.BACK.asArg()))
                .addAction(mouse.createPointerUp(PointerInput.MouseButton.BACK.asArg()));

        ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));

//        List<WebElement> title = driver.findElements(By.className("gd_name"));
//        WebElement priceCon = driver.findElements(By.className("txt_num"));
//        Thread.sleep(2000);
//        var itemUl = driver.findElement(By.id("yesBestList"));
//        var itemLies = itemUl.findElements(By.tagName("li"));
//        for(var itemLi : itemLies){
//            System.out.println(itemLi.findElement(By.className("item_info")).findElements(By.tagName("div")).get(3).getText());
//            System.out.println(itemLi.findElement(By.className("info_price")).getText());
        }
//        System.out.println(driver.findElement(By.className("info_row")).findElement(By.className("yes_b")).getText());

//        List<WebElement> price = driver.findElements(By.cssSelector(".info_row > yes_b"));
//        System.out.println(price);
//        System.out.println(price.get(0).getText());
//        for(WebElement aTag : title){
//            System.out.println(aTag.getText());
//            }
//        for(WebElement aTag : price){
//            System.out.println(aTag.getText());
//        }
//        }
    }
