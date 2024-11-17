package utils;

import java.time.format.DateTimeFormatter;

public class Utils {

    private Utils() {

    }

    static {
    }

    public static final DateTimeFormatter PADRAO_DATA_BRASIL = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static boolean hasLenght(String value) {
        return value != null && !value.isEmpty();
    }

    public static boolean nullabeObject(Object o) {
        return o == null;
    }
}
