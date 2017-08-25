import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Приветствие на 3 языках
 * Выбор языка вводим через аргументы main
 */
public class WB2EX5 {
    public static void main(String ... args) {
        String s1 = "en";
        String s2 = "EN";
        try {
            if (!args[0].isEmpty() && !args[1].isEmpty()) {
                s1 = args[0];
                s2 = args[1];
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Параметры аргументов не введены");
            System.out.println("По умолчанию приветствие на английском \n");
        }
        Locale loc = new Locale(s1, s2);
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc);
        System.out.println(rb.getString("greetings"));
    }
}
