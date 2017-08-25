import java.text.NumberFormat;
import java.util.Locale;

/**
 * Вывод денежного числа на украинском
 */
public class WB2EX4 {
    public static void main(String ... args) {
        final double chislo = 153.5;
        Locale locale = new Locale("uk", "UA");
        System.out.println(locale.getDisplayCountry(locale));
        System.out.println(locale.getDisplayLanguage(locale));
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        System.out.println(nf.format(chislo));
    }
}
