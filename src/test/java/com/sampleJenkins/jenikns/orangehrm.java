package com.sampleJenkins.jenikns;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class orangehrm {
	
	WebDriver driver;
	
	@Test
	public void login() throws IOException {
		driver=new ChromeDriver();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			String path = "C:\\Users\\Nihir\\eclipse-workspace\\java_sample_programs\\jenikns\\screenshots\\screen"+timeStamp+".png";
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File DestFile=new File(path);
			FileUtils.copyFile(file, DestFile);
			driver.findElement(By.xpath(".//button[text()=' Login ']")).click();
			//driver.close();
	}

}
