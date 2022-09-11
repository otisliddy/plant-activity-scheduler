package otisliddy.plant;

import java.time.Month;

public class StringUtils {

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean equalsThreeLetterMonth(Month month, String threeLetterMonth) {
        return month.name().substring(0, 3).equals(threeLetterMonth.substring(0, 3).toUpperCase());
    }

    public static String toThreeLetterMonth(Month month) {
        return month.name().substring(0, 3);
    }

}
