import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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

        driver.get("https://www.yes24.com//Product/Category/BestSeller?categoryNumber=001");


        List<WebElement> items = driver.findElements(By.className("itemUnit"));

        StringBuilder product = new StringBuilder();
        product.append("no, title, price, delivery_price, category \n");
        StringBuilder productImg = new StringBuilder();
        productImg.append("product_no, img \n");

        int count = 1;

        for(var item : items){
            Thread.sleep(2000);

            WebElement title = item.findElement(By.className("gd_name"));
            WebElement price1 = item.findElement(By.className("txt_num"));
            WebElement price2 = price1.findElement(By.className("yes_b"));
            System.out.println("////////////////////////////////////////////////////////////////////////////");
            System.out.println("제목: " + title.getText());
            System.out.println("가격: " + price2.getText());

            new Actions(driver)
                    .click(title)
                    .perform();

            WebElement photo = driver.findElement(By.className("gImg"));
            String photo1 = photo.getAttribute("src");
            System.out.println("이미지 링크: " + photo1);

            WebElement title1 = driver.findElement(By.className("infoWrap_txtInner"));
            WebElement info = title1.findElement(By.tagName("b"));
            System.out.println("상세정보: " + info.getText());

//            try{
//                WebElement select = driver.findElement(By.className("gd_infoTbArea"));
//                String option = select.getAttribute("value");
//                System.out.println(select.getText());
//                System.out.println(option);
//            }catch (Exception e){
//            }
//
//            try{
//                WebElement select = driver.findElement(By.id("SelectGoodsPartBook"));
//                WebElement option = select.findElement(By.className("txt"));
//                System.out.println(option.getText());
//
//
//            }catch (NoSuchElementException e){
//                System.out.println("옵션 X");
//                Thread.sleep(1000);
//                continue;
//            }catch (Exception a){
//                continue;
//            }

            try{
                WebElement selectElement = driver.findElement(By.id("SpanGoodsPartBook"));
                List<WebElement> options = selectElement.findElements(By.tagName("option"));
                for(int i = 1; i<options.size(); i++){
                    System.out.println("옵션: " + options.get(i).getText());
                }
            }catch (Exception e){
                System.out.println("옵션 없음");
            }

            PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");
            Sequence actions = new Sequence(mouse, 0)
                    .addAction(mouse.createPointerDown(PointerInput.MouseButton.BACK.asArg()))
                    .addAction(mouse.createPointerUp(PointerInput.MouseButton.BACK.asArg()));
            ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));




//



//            try {
//                Select option = new Select(driver.findElement(By.name("ORD_GOODS_PART")));
//                System.out.println(option.getOptions().toString());
//            }catch (Exception e){
//                System.out.println("옵션 없음");
//                continue;
//            }
//            try{
//                WebElement selectElemant = driver.findElement(By.name("ORD_GOODS_PART"));
//                Select select = new Select(selectElemant);
//                List<WebElement> allOptions = select.getOptions();
//                for(WebElement option : allOptions){
//                    String valueAttribute = option.getAttribute("value");
//                    System.out.println(valueAttribute);
//                }
//            }catch (Exception e){
//                System.out.println("업다");
//                continue;
//            }



//            Thread.sleep(1000);



//               product.append(count)
//                       .append(",")
//                       .append("\"").append(title.getText()).append("\"")
//                       .append(",")
//                       .append(price2.getText().replace(",", ""))
//                       .append(",")
//                       .append("3000")
//                       .append(",")
//                       .append(info.getText())
//                       .append(",")
//                       .append(photo1)
//                       .append("\n");
//
//                Thread.sleep(1000);

//        }

//        String p = "src/test.csv";
//        Files.writeString(Path.of(p), "\uFEFF" + product, StandardCharsets.UTF_8, StandardOpenOption.CREATE);



//        WebElement click = driver.findElement(By.className("gd_name"));





//        List<WebElement> title = driver.findElements(By.className("gd_name"));
//        WebElement priceCon = driver.findElements(By.className("txt_num"));
//        Thread.sleep(2000);
//        var itemUl = driver.findElement(By.id("yesBestList"));
//        var itemLies = itemUl.findElements(By.tagName("li"));
//        for(var itemLi : itemLies){
//            System.out.println(itemLi.findElement(By.className("item_info")).findElements(By.tagName("div")).get(3).getText());
//            System.out.println(itemLi.findElement(By.className("info_price")).getText());
//    }
//        System.out.println(driver.findElement(By.className("info_row")).findElement(By.className("yes_b")).getText());

//        List<WebElement> price = driver.findElements(By.cssSelector(".info_row > yes_b"));
//        System.out.println(price);
//        System.out.println(price.get(0).getText());
//        for(WebElement aTag : title){
//            System.out.println(aTag.getText());
//            }
//        for(WebElement aTag : price){
//            System.out.println(aTag.getText());
        }
        }
}
