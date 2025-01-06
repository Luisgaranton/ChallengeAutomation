package com.hooks;

import com.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static com.utils.ScreenshotUtil.SCREENSHOT_FOLDER;

public class ScreenshotHooks {
    private WebDriver driver;
    private BaseTest baseTest;
    //private static final String SCREENSHOT_FOLDER = "../../../../target/screenshots";

    public ScreenshotHooks(BaseTest baseTest) {
        this.baseTest = baseTest; // Inicializamos BaseTest aquí
    }

    // Metodo para limpiar la carpeta de capturas UNA VEZ al inicio de la suite
    @BeforeAll
    public static void cleanScreenshotsFolder() {
        File folder = new File(SCREENSHOT_FOLDER);

        // Verificar si la carpeta existe, si no, crearla
        if (!folder.exists()) {
            boolean created = folder.mkdirs(); // Crear la carpeta
            if (created) {
                System.out.println("Carpeta de capturas creada: " + SCREENSHOT_FOLDER);
            } else {
                System.out.println("No se pudo crear la carpeta de capturas: " + SCREENSHOT_FOLDER);
                return; // Si no se pudo crear, no intentar limpiar
            }
        }

        // Limpiar la carpeta si ya existe
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".png")) { // Elimina solo archivos .png
                    boolean deleted = file.delete();
                    if (deleted) {
                        System.out.println("Archivo eliminado: " + file.getName());
                    } else {
                        System.out.println("No se pudo eliminar el archivo: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("La ruta especificada no es un directorio.");
        }
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        this.driver = baseTest.getDriver(); // Obtén el WebDriver de BaseTest

        if (driver != null && scenario.isFailed()) {
            // Si la prueba falló, tomar la captura de pantalla
            String stepName = scenario.getName().replaceAll(" ", "_"); // Usa el nombre del escenario
            String screenshotName = "Screenshot_" + stepName + "_" + System.currentTimeMillis();

            // Verificar si la carpeta de capturas existe antes de guardar
            File folder = new File(SCREENSHOT_FOLDER);
            if (!folder.exists()) {
                boolean created = folder.mkdirs(); // Crear la carpeta
                if (created) {
                    System.out.println("Carpeta de capturas creada: " + SCREENSHOT_FOLDER);
                } else {
                    System.out.println("No se pudo crear la carpeta de capturas: " + SCREENSHOT_FOLDER);
                    return; // Si no se puede crear, no intentar guardar la captura
                }
            }

            // Tomar la captura de pantalla
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, screenshotName);

            // Log de la ruta donde se guardó la captura
            System.out.println("Captura de pantalla guardada en: " + screenshotPath);

            // Agregar la captura de pantalla al reporte de Cucumber
            byte[] screenshot = ScreenshotUtil.getScreenshotAsBytes(driver, screenshotName);
            scenario.attach(screenshot, "image/png", screenshotName);  // Adjuntar al reporte de Cucumber
        }
    }
}