package edu.ifes;
import edu.ifes.view.Menu;
import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Menu menu = new Menu();
        menu.exibir();
    }
}