package WB1EX26_27_28;

import java.util.*;

/**
 * Упражнения по коллекциям
 * Ex. 26, 27, 28
 */
public class ListPupil {

    public static void main(String[] args) {
        // количество детей в классе
        final int pupilsCount = 20;
        // создаем коллекцию, лист с оценками, заполняющийся произвольно по десятибальной системе
        final List<Integer> rating = new ArrayList<>();
        Random random = new Random();
        for(int i = 1; i <= pupilsCount; i++){
            rating.add(random.nextInt(11));
        }
        //Вывод оценок
        System.out.println("Перечь оценок по десятибальной системе");
        for (Integer rat : rating) {
            System.out.print(rat + " ");

        }
        System.out.println();
        Ex26(rating); //Упражнение 26 удаление всех неудолетворительных оценок
        Ex27(rating); //Упражнение 27 Удаление повторяющихся значений
        Ex28(rating); //Упражнение 28 Удаление повторяющихся значений

    }
    /*
    Упражнения сделаны ввиде методов
    Как сказано в заданиях, удаления оценок и другие действия  производить с самой коллекции
    т. е. методы меняют сам лист, после каждого метода лист содержимое листа и его размер
    меняются в соответствии с заданием
     */

    // Упражнение 26 удаление всех неудолетворительных оценок
    static void Ex26(List<Integer> list){
        for (int i = 0; i < list.size(); ){
            if(list.get(i) < 4){
                list.remove(i);
                //при удалении оценки лист уменьшается в размере
                //и сдвигается в лево, поэтому итерация и не нужна
                continue;
            }
            //если оценка больше чем 3 смотрим коллекцию дальше
            i++;
        }
        //также можно выполнить эту задачу через итератор, метод void remove
        System.out.println("Коллекция после удаления всех неудолетворительных оценок");
        for (Integer rating : list) {
            System.out.print(rating + " ");
        }
        System.out.println();
    }
    //Упражнение 27 Удаление повторяющихся значений
    static void Ex27(List<Integer> list){
        // отправляю лист в сет где все значения уникальны, убираются дубликаты
        Set<Integer> set = new HashSet<>(list);
        //очищаю лист и заливаю в него значения
        list.clear();
        list.addAll(set);
        //Вывожу значения из set
        System.out.println("Удаление повторяющися оценок");
        for (Integer rating : list) {
            System.out.print(rating + " ");
        }
    }

    //Упражнение 28 Удаление повторяющихся значений
    static void Ex28(List<Integer> list){
        int max = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int rating = iterator.next();
            if(rating>max){
                //если текущее значение больше чем максимум, то это значение и есть максимум
                max = rating;
            }
        }
        System.out.println();
        System.out.print("Максимальная оценка " + max);
    }
}
