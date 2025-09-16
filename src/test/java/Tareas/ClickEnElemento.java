package Tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickEnElemento implements Task {

    private final String xpath;

    public ClickEnElemento(String xpath) {
        this.xpath = xpath;
    }

    public static ClickEnElemento enXpath(String xpath) {
        return instrumented(ClickEnElemento.class, xpath);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target boton = Target.the("botón con xpath").located(By.xpath(xpath));
        actor.attemptsTo(Click.on(boton));
    }
}
