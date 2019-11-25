package TeamCity.TeamCity_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TeanCity {
	static WebDriver driver;
	String path = "src\\main\\java\\ChromeDriver\\chromedriver.exe";
	String siteURL = "http://qa-app0/Kovair9.6/Views/Accounts/Login.aspx";
	String title,status,errormsg;
	
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver",path);
		driver= new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get(siteURL);
	}
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		title="";
		status="";
		errormsg="";
	}
	
	
	@DataProvider(name = "Login-Credentials")
    public Object[][] data()
    {
        Object[][] data = new Object[1][2];
        
        data[0][0] = "pa";
        data[0][1] = "pa";    
        return data;
    }
	
	
	@Test(dataProvider="Login-Credentials")
	public void validateLogin(String uname, String pass) throws InterruptedException {
		
		driver.findElement(By.id("USERNAME")).clear();
		driver.findElement(By.id("PWD")).clear();
		driver.findElement(By.id("USERNAME")).sendKeys(uname);
		driver.findElement(By.id("PWD")).sendKeys(pass);
		driver.findElement(By.id("Button1")).click();
		
	}
	@Test
	public void logout() throws Exception {
		Thread.sleep(3000);
		try {
            driver.findElement(By.id("UserDrp_imgDrp")).click();
            WebElement Logout_btn = driver.findElement(By.xpath("//div[@id='UserDrp_mainDiv']/div/ul/li/div/span[@title='Logout']"));
            Logout_btn.click();
        } catch (Exception e) {
            System.out.println("Page Level Error");
        }
    }
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}	
}