package EX30_31_32_33;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * EX30 Прочитать файл с текстом, подсчитать в тексте количество знаков
 * препинания и словю
 */
public class EX30 {
    public static void main(String... args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/viivpo2010/IT ACADEMY/EX30_31_32_33/src/EX30_31_32_33/Text30.txt"));) {
            StringBuilder sb = new StringBuilder();
            //В цикле построчно считываем файл
            String s;
            while ((s = reader.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
            s=sb.toString();//сохраняю весь текст из файла в стринговую переменную
            int before = s.length();
            int after = s.replaceAll("[,.]", "").length();//регулярное выражения
            System.out.println(s);
            System.out.println("Количество знаков препинания в тексте: " + (before - after));
            String[] words = s.split(" ");
            System.out.println("Количество слов в тексте: " + words.length);
        } catch (IOException e) {
            System.out.println("Произошло исключение!");
            System.out.println(e.getStackTrace());
        }
    }
}
