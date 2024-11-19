package ReportProject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Project_1 {
	ChromeDriver driver;
	ExtentReports report;
	@BeforeMethod
	public void Start() {

				driver=new ChromeDriver();
				driver.manage().window().maximize();
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter reporter=new ExtentSparkReporter(path);
				reporter.config().setReportName("shopping website report");
				reporter.config().setDocumentTitle("tutorialsninja");
				report=new ExtentReports();
				report.attachReporter(reporter);
				report.setSystemInfo("created by", "gdfchg");
				report.setSystemInfo("operating system", "windows");
	}
	@Test
	public void begin() throws InterruptedException {
		ExtentTest etest = report.createTest("test1");
				driver.get("https://tutorialsninja.com/demo/");
				etest.info("website opened");
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		
		//driver.findElement(By.xpath("//button[@data-ux-btn=\"primary\"]")).click();
		//driver.findElement(By.xpath("//span[@id=\"n-2566125698-membership-icon\"]")).click();
		driver.findElement(By.linkText("Register")).click();
		etest.info("registration started");
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("sana");
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("gowda");
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("sana945@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"telephone\"]")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("S@123");
		driver.findElement(By.xpath("//input[@name=\"confirm\"]")).sendKeys("S@123");
		driver.findElement(By.xpath("//input[@name=\"newsletter\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		driver.findElement(By.linkText("Continue")).click();
		etest.info("registration completed");
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		driver.findElement(By.xpath("//span[text()=\"Add to Cart\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id=\"cart-total\"]")).click();
		driver.findElement(By.linkText("View Cart")).click();
		driver.findElement(By.linkText("Checkout")).click();
		String text = driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText();
//		Assert.assertEquals(text, "Products marked with *** are not available in the desired quantity or not in stock!×");
		etest.info("text copied");
	}
	@AfterMethod
	public void end() {
		driver.quit();
		report.flush();
			}
		

}
