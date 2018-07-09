package com.peng.functions;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonOperations {
    public byte[] takeScreenshot(WebDriver webDriver) throws IOException {
        int pixelRatio = 1;
        if (webDriver.toString().contains("MAC")) {
            pixelRatio = 2;
        }

        final Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies
                .viewportRetina(200, 0,0,pixelRatio))
                .takeScreenshot(webDriver);
        final BufferedImage image = screenshot.getImage();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        ImageIO.write(image,"PNG",new File("target/cucumber-reports/"
                + dateFormat.format(date) + ".png"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image,"png",outputStream);

        return outputStream.toByteArray();
    }

    public void takeScreenshot(WebDriver webDriver, String path, String name) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("output == null!");
        }

        if (name == null) {
            throw new IllegalArgumentException("name == null!");
        }

        File screenShots = new File(path);
        if (!screenShots.exists()) screenShots.mkdir();

        int pixelRatio = 1;
        if (webDriver.toString().contains("MAC")) {
            pixelRatio = 2;
        }

        final Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies
                .viewportRetina(200, 0,0,pixelRatio))
                .takeScreenshot(webDriver);
        final BufferedImage image = screenshot.getImage();

        ImageIO.write(image,"PNG",new File(path + name + ".png"));
    }
}
