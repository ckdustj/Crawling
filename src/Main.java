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

        }
    }
}
