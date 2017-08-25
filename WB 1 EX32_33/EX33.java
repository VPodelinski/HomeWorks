import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viivpo2010 on 23.7.17.
 */
public class EX33 {
    public static void main(String[] args) {
        File file = new File("/home/viivpo2010");
        System.out.println(file.getAbsolutePath());
        System.out.println("Содержимое папки");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("#################");
        List<File> list1 = new ArrayList<>();
        List<File> list2 = new ArrayList<>();
        File[] listf = file.listFiles();
        for (File file1 : listf) {
            if(file1.isDirectory()){
                list1.add(file1);
            }
            else{
                list2.add(file1);
            }
        }
        System.out.println("Каталоги");
        printList(list1);
        System.out.println("Файлы");
        printList(list2);
    }
    static void printList(List<File> f){
        for (File file1 : f) {
            System.out.println(file1);
        }
    }
}
