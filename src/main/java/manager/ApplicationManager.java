package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper userHelper;
    CarHelper car;




    public void init(){
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("Tests starts on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        userHelper =new UserHelper(wd);
        car = new CarHelper(wd);
        wd.register(new MyListener());

    }
    public void stop(){

        logger.info("Tests passed");
        wd.quit();
    }

    public UserHelper getUserHelper() {

        return userHelper;
    }
    public CarHelper getCar() {

        return car;
    }
}
