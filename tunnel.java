package firstproj;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	 
	public class tunnel {

	   public String username = "shwetas";
	  public String accesskey = "YnEDaVUxsgBVeMegRPVgbpcvmRYVeYsLLqLAMwStByMmcCF5PK";
	  public RemoteWebDriver driver = null;
	  public String gridURL = "@hub.lambdatest.com/wd/hub";
	  boolean status = false;
	 
	  @BeforeTest
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setCapability("browserName", browser);
	      capabilities.setCapability("version", version);
	      capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
	      capabilities.setCapability("build", "tunnel");
	      capabilities.setCapability("name", "version f2");
	      capabilities.setCapability("network", true); // To enable network logs
	      capabilities.setCapability("visual", true); // To enable step by step screenshot
	      capabilities.setCapability("video", true); // To enable video recording
	      capabilities.setCapability("console", true); // To capture console logs
	      capabilities.setCapability("tunnel", true); // To capture console logs
	      try {
	          driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	      } catch (MalformedURLException e) {
	          System.out.println("Invalid grid URL");
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
	  }
	 
	 
	  @Test
	  public void testSimple() throws Exception {
	     try {
	            //Change it to production page
	          driver.get("https://www.localhost.lambdatest.com");
	           Thread.sleep(3000);
	            
	         
	          
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
	  }
	      
	  
	 
	  @AfterTest
	  public void tearDown() throws Exception {
	     if (driver != null) {
	          ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
	          driver.quit();
	      }
	  }
	}


