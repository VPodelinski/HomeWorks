package EX30_31_32_33;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Найти все числа и распечатать, подсчитать всю сумму , убрать повторяющиеся числа
 */
public class EX31 {
    public static void main(String... args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/viivpo2010/IT ACADEMY/EX30_31_32_33/src/EX30_31_32_33/Text31.txt"));) {
            StringBuilder sb = new StringBuilder();
            final Set<Integer> set = new LinkedHashSet();//использую LinkedHashSet для сохранения порядка добавления чисел
            String s;
            int sum =0;
            int sumSet =0;
            //В цикле построчно считываем файл
            while ((s = reader.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
            s=sb.toString();//прочитали файл построчно и сохраниди его в стринговую переменную
            String [] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                if(words[i].matches("\\d+")){
                    System.out.print(words[i]+" ");// вывод чисел
                    set.add(Integer.parseInt(words[i]));//добавляю в сет для удаления повторяющихся чисел
                    sum+=Integer.parseInt(words[i]); //подсчет суммы
                }
            }
            System.out.println();
            System.out.println("Сумма составляет: " +sum); //вывод в консоль
            //System.out.println(s);
            System.out.println();
            for (Integer digit : set) {
                System.out.print(digit + " ");
                sumSet+=digit;
            }
            System.out.println();
            System.out.println("Сумма составляет после удаления дубликатов: " + sumSet);


        } catch (IOException e) {
            System.out.println("Произошло исключение!");
            System.out.println(e.getStackTrace());
        }
    }
}
