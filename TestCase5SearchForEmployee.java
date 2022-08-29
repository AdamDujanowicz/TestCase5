package actionClassHW;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class TestCase5SearchForEmployee {
	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://opensource-demo.orangehrmlive.com";
		String key = "webdriver.chrome.driver";
		String path = "C:\\Users\\Dujanowicz\\OneDrive\\Desktop\\B7-Selenium\\chromedriver.exe";
		System.setProperty(key, path);

		// open browser
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		// maximize window
		driver.manage().window().maximize();

		// navigate to url
		driver.get(url);
		
		//WebElement un = driver.findElement(By.xpath("//input[contains(@name,'username')]"));
			WebElement un = driver.findElement(By.cssSelector("input[name = 'username']"));
				
			un.sendKeys("Admin");


			WebElement pw = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
			pw.sendKeys("admin123");
			
			
			WebElement login = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
			login.click();
			
			
			//emp id field-->
			WebElement idField =driver.findElement(By.xpath("//form[contains(@class,'oxd-form')]//div[1]//div[1]//div[2]//div[2]//input"));
			idField.sendKeys("0016");
			
			//Employment status dropbox-->//*[@id="app"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]   
			//WebElement eSDB= driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]" ));
			//eSDB.sendKeys("fff");
			
			// v correct way v
			
			WebElement bigBox = driver.findElement(By.xpath("//div[contains(@class,'oxd-select-wrapper')]"));
			bigBox.click();
			//bigBox.findElement(By.xpath(".//*[contains(text(), 'Full-Time Permanent')]"));
			WebElement listBox = driver.findElement(By.xpath("//div[@role= 'listbox']"));
			listBox.findElement(By.xpath(".//*[contains(text(), 'Full-Time Permanent')]")).click();
			
			
			//Include dropdown-->
			WebElement includeBut = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")); 
			includeBut.sendKeys("cc");
			
			//Sub Unit dropdown-->
			WebElement sU = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[1]"));
			sU.sendKeys("a");
			
			//Search Button-->
			WebElement sB=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
			sB.click();
			
			//Verify if first Name is equal to “Linda Jane”
			WebElement fName= driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div"));
			String actFN = fName.getText();
			String expFN = "Linda Jane";
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actFN, expFN, "First Name test failed");
			
			
		
			//Verify if the Last Name is equal to “Anderson”
			WebElement lName= driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]/div"));
			String actLN = lName.getText();
			String expLN = "Anderson";
			 sa = new SoftAssert();
			sa.assertEquals(actLN, expLN, "Last Name test failed");
			
				
			//Verify if the job title contains “VP-Sales & Marketing”
			WebElement jobT= driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[5]/div"));
			String actJT = jobT.getText();
			String expJT = "VP - Sales & Marketing";
			sa = new SoftAssert();
			sa.assertEquals(actJT, expJT, "Job Title test failed");
			
		
			//watch the madness******************
			//Verify Employment Status “Full-Time Permanent” or “Freelance”
			WebElement eStatus= driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div"));
			String actStatus = eStatus.getText();
			String expStatus = "Full-Time Permanen";
			sa = new SoftAssert();
			sa.assertEquals(actStatus, expStatus, "Employement Status test failed");
			
			
			
			//Verify the Sub Unit String value size equals to 2
			WebElement sUnit= driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[7]/div"));
			String admin = sUnit.getText();
			int actSUSize = admin.length();
			System.out.println(actSUSize);
			int expSUSize = 2;
			System.out.println(expSUSize);
			 sa = new SoftAssert();
			sa.assertEquals(actSUSize, expSUSize, "String Size Value test failed");
			
		
			
			//Get the first name of the supervisor using string methods and display the value on console
			WebElement supName = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[8]/div"));
			String superN= supName.getText();
			System.out.println(superN);
			
			//Close the browser		
			//sa.assertAll();
			driver.quit();
			sa.assertAll();
	}

}
