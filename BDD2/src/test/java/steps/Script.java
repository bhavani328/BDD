package steps;


	import java.awt.AWTException;
	import java.awt.Dimension;
	import java.awt.Rectangle;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;



	import javax.imageio.ImageIO;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;



	public class Script {
	WebDriver d1;
	@Given("Open chrome browser and url of the application")
	public void open_chrome_browser_and_url_of_the_application() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\govindolla.bhavani\\Downloads\\chromedriver_win32 1\\chromedriver.exe");
	d1=new ChromeDriver();
	d1.get("https://phptravels.org/register.php");
	d1.manage().window().maximize();
	System.out.println("Given done");
	}



	@When("Register, Enter Username , password and click on login button")
	public void register_Enter_Username_password_and_click_on_login_button() throws InterruptedException, AWTException, IOException {
	d1.findElement(By.id("inputFirstName")).sendKeys("bhavani");
	d1.findElement(By.id("inputLastName")).sendKeys("govindolla");
	d1.findElement(By.id("inputEmail")).sendKeys("bhavanigovindolla@gmail.com");
	d1.findElement(By.xpath("//div[@class='selected-dial-code']")).click();
	d1.findElement(By.xpath("//*[@id='containerNewUserSignup']/div[1]/div[2]/div/div[4]/div/div/div/ul/li[102]")).click();
	d1.findElement(By.xpath("//*[@placeholder='81234 56789']")).sendKeys("8367349804");
	d1.findElement(By.xpath("//*[@id='inputAddress1']")).sendKeys("shakkarnagar");
	d1.findElement(By.xpath("//*[@id='inputCity']")).sendKeys("bodhan");
	Select drop2 = new Select(d1.findElement(By.name("country")));
	drop2.selectByValue("IN");
	Thread.sleep(2000);
	d1.findElement(By.xpath("//*[@id='inputNewPassword1']")).sendKeys("Bhavani@123");
	d1.findElement(By.xpath("//*[@id='inputNewPassword2']")).sendKeys("Bhavani@123");
	Thread.sleep(20000);
	d1.findElement( By.xpath("//*[@id='frmCheckout']/div[5]/input")).click();
	Robot robot2=new Robot();
	Dimension sc_size=Toolkit.getDefaultToolkit().getScreenSize();
	Rectangle rect=new Rectangle(sc_size);
	BufferedImage Source=robot2.createScreenCapture(rect);
	File destination=new File("C:\\Users\\govindolla.bhavani\\OneDrive - HCL Technologies Ltd\\Pictures\\Screenshots\\ss1.png");
	ImageIO.write(Source, "png", destination);
	Thread.sleep(3000);
	d1.get("https://phptravels.org/login");
	d1.manage().window().maximize();
	d1.findElement(By.id("inputEmail")).sendKeys("bhavanigovindolla@gmail.com");
	d1.findElement(By.id("inputPassword")).sendKeys("Bhavani@123");
	Thread.sleep(30000);
	d1.findElement(By.xpath("//*[@id=\"login\"]")).click();
	Robot robot1=new Robot();
	Dimension sc_size1=Toolkit.getDefaultToolkit().getScreenSize();
	Rectangle rect1=new Rectangle(sc_size1);
	BufferedImage Source1=robot1.createScreenCapture(rect1);
	File destination1=new File("C:\\Users\\govindolla.bhavani\\OneDrive - HCL Technologies Ltd\\Pictures\\Screenshots\\ss2.png");
	ImageIO.write(Source1, "png", destination1);


	System.out.println("When done");
	}



	@Then("Login successful")
	public void login_successful() {
	System.out.println("Then done");
	}




	}

