package Tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.AppiumDriver.driver;

public class IngresarTextoYEnter implements Task {

    private final String xpath;
    private final String texto;

    public IngresarTextoYEnter(String xpath, String texto) {
        this.xpath = xpath;
        this.texto = texto;
    }

    public static IngresarTextoYEnter enCampo(String xpath, String texto) {
        return Tasks.instrumented(IngresarTextoYEnter.class, xpath, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver webDriver = BrowseTheWeb.as(actor).getDriver();

        // Espera explícita hasta que el campo esté visible
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        // Click en el campo y envío de texto
        webDriver.findElement(By.xpath(xpath)).click();
        actor.attemptsTo(Enter.theValue(texto).into(By.xpath(xpath)));

        // Cierra el teclado si está abierto
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            // No hacer nada si ya está cerrado
        }

        // Presiona Enter si es necesario (opcional)
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
