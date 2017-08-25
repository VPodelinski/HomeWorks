/**
 * Поиск всех тегов абзацев <p>  в том числе с параметрами <p id = "p1"></>
 */
public class WBEX3 {
    public static void main(String... args) {
        //исходный текст
        String str = "1 тег с параметрам: <p y = \"hhg\">\n" +
                "2 тег с двумя параметрами: <p id = \"e1\", ie = \"p2\">\n" +
                "3 тег <p id = \"54\"> Текст внутри тега </p>\n"+
                "4 тег с одним параметра <p id = \"p1\">\n" +
                "  Какойто текст и цифры +1-(800)-555-2468\n" +
                "5 тег с параметрам <p id = \"p2\">";
        System.out.println("Строка до обработки тегов:");
        System.out.println(str + "\n");
        String str2 = str.replaceAll("<p[^>]*>","<p>");
        System.out.println("Строка после замены:");
        System.out.println(str2);

    }
}
