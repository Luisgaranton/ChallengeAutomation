package com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static final String SCREENSHOT_FOLDER = "target/screenshots/";

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        File folder = new File(SCREENSHOT_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = SCREENSHOT_FOLDER + screenshotName + "_" + timestamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile.getAbsolutePath(); // Retorna la ruta de la captura
    }

    public static byte[] getScreenshotAsBytes(WebDriver driver, String screenshotName) {
        File folder = new File(SCREENSHOT_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = SCREENSHOT_FOLDER + screenshotName + "_" + timestamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return FileUtils.readFileToByteArray(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}