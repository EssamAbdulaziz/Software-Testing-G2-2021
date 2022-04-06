package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshots extends TestBase{
    public static int screenshoutNumber = 0;
    public String captureScreenShot(String screenshotName)
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dest = Paths.SCREENSHOTS+screenshotName+ screenshoutNumber++ +".png";
        //Adding time stamp else it will replace the previous screenshots
        try
        {
            FileUtils.copyFile(src, new File(dest));
        }
        catch (IOException e) {
            System.out.println("Failed to get screenshot"+e.getMessage());
            e.printStackTrace();
        }
        return dest;
    }
}
