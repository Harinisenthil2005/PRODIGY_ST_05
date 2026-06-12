import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationScript {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open Homepage
        driver.get("https://shoplane-by-lassie.netlify.app/");
        Thread.sleep(5000);

        // 2. Click a product (first valid product image)
        driver.findElement(By.xpath("(//img)[10]")).click();
        System.out.println("Product Opened");
        Thread.sleep(4000);

        // 3. Add to Cart
        driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
        System.out.println("Product Added To Cart");
        Thread.sleep(3000);

        // 4. Open Cart
        driver.findElement(By.xpath("//a[@href='/cart']")).click();
        System.out.println("Cart Opened");
        Thread.sleep(3000);

        // 5. Place Order
        driver.findElement(By.linkText("Place Order")).click();
        System.out.println("Order Placed");
        Thread.sleep(3000);

        // 6. Verify Success Message
        WebElement msg = driver.findElement(By.tagName("h1"));
        String text = msg.getText();

        System.out.println("Success Message: " + text);

        if (text.contains("Order Placed Successfully")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}