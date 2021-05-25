package es.prueba;

import myjava.util.Strings;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    BiFunction<String, String, Object> STRING_COMPARATOR_FUNCTION = Strings.STRING_COMPARATOR::compare;
    BiFunction<String, String, Object> STRING_COMPARATOR_IGNORE_CASE_FUNCTION = Strings.STRING_COMPARATOR_IGNORE_CASE::compare;

    public static void main(String[] args) {
        Main main = new Main();
        main.process();
    }

    private void process() {
        System.out.println("1. STRING_COMPARATOR");
        System.out.println();
        this.processStringComparator();
        System.out.println();

        System.out.println("2. STRING_COMPARATOR_IGNORE_CASE");
        System.out.println();
        this.processStringComparatorIgnoreCase();
        System.out.println();

        System.out.println("3. equalsIgnoreCase");
        System.out.println();
        this.processEqualsIgnoreCase();
        System.out.println();

        System.out.println("4. strip");
        System.out.println();
        this.processStrip();
        System.out.println();

        System.out.println("5. isNullOrEmpty");
        System.out.println();
        this.processIsNullOrEmpty();
        System.out.println();

        System.out.println("6. isNullOrWhitespace");
        System.out.println();
        this.processIsNullOrWhitespace();
        System.out.println();

        System.out.println("7. nonNullNorEmpty");
        System.out.println();
        this.processNonNullNorEmpty();
        System.out.println();

        System.out.println("8. nonNullNorWhitespace");
        System.out.println();
        this.processNonNullNorWhitespace();
        System.out.println();

        System.out.println("9. requireNonNullNorEmpty");
        System.out.println();
        this.processRequireNonNullNorEmpty();
        System.out.println();

        System.out.println("10. requireNonNullNorWhitespace");
        System.out.println();
        this.processRequireNonNullNorWhitespace();
        System.out.println();

        System.out.println("11. requireNonNullNorEmptyWithMessage");
        System.out.println();
        this.processRequireNonNullNorEmptyWithMessage();
        System.out.println();

        System.out.println("12. requireNonNullNorWhitespaceWithMessage");
        System.out.println();
        this.processRequireNonNullNorWhitespaceWithMessage();
        System.out.println();

        System.out.println("13. requireNonNullNorEmptyWithMessageSupplier");
        System.out.println();
        this.processRequireNonNullNorEmptyWithMessageSupplier(null, "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(this::nonNullNorEmptyMessageSupplier, "this::nonNullNorEmptyMessageSupplier");
        System.out.println();

        System.out.println("14. requireNonNullNorWhitespaceWithMessageSupplier");
        System.out.println();
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(null, "null");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(this::nonNullNorWhitespaceMessageSupplier, "this::nonNullNorWhitespaceMessageSupplier");
        System.out.println();

        System.out.println("15. requireNonNullNorEmptyElse");
        System.out.println();
        this.processRequireNonNullNorEmptyElse(null);
        this.processRequireNonNullNorEmptyElse("");
        this.processRequireNonNullNorEmptyElse("   ");
        this.processRequireNonNullNorEmptyElse(" defaultValue ");
        System.out.println();

        System.out.println("16. requireNonNullNorWhitespaceElse");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElse(null);
        this.processRequireNonNullNorWhitespaceElse("");
        this.processRequireNonNullNorWhitespaceElse("   ");
        this.processRequireNonNullNorWhitespaceElse(" defaultValue ");
        System.out.println();

        System.out.println("17. requireNonNullNorEmptyElseGet");
        System.out.println();
        this.processRequireNonNullNorEmptyElseGet(null, "null");
        this.processRequireNonNullNorEmptyElseGet(this::defaultValueNullSupplier, "this::defaultValueNullSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::defaultValueEmptySupplier, "this::defaultValueEmptySupplier");
        this.processRequireNonNullNorEmptyElseGet(this::defaultValueWhitespaceSupplier, "this::defaultValueWhitespaceSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::defaultValueSupplier, "this::defaultValueSupplier");
        System.out.println();

        System.out.println("18. requireNonNullNorWhitespaceElseGet");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElseGet(null, "null");
        this.processRequireNonNullNorWhitespaceElseGet(this::defaultValueNullSupplier, "this::defaultValueNullSupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::defaultValueEmptySupplier, "this::defaultValueEmptySupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::defaultValueWhitespaceSupplier, "this::defaultValueWhitespaceSupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::defaultValueSupplier, "this::defaultValueSupplier");
        System.out.println();
    }

    private void processStringComparator() {
        System.out.print("STRING_COMPARATOR.compare(null, null) <=> ");
        this.processAndPrintException(STRING_COMPARATOR_FUNCTION, null, null);

        System.out.print("STRING_COMPARATOR.compare(null, \"bbb\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_FUNCTION, null, "bbb");

        System.out.print("STRING_COMPARATOR.compare(\"aaa\", null) <=> ");
        this.processAndPrintException(STRING_COMPARATOR_FUNCTION, "aaa", null);

        System.out.print("STRING_COMPARATOR.compare(\"aaa\", \"aba\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_FUNCTION, "aaa", "aba");

        System.out.print("STRING_COMPARATOR.compare(\"aba\", \"aaa\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_FUNCTION, "aba", "aaa");

        System.out.print("STRING_COMPARATOR.compare(\"aaa\", \"aaa\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_FUNCTION, "aaa", "aaa");

        System.out.print("STRING_COMPARATOR.compare(\"aaa\", \"aAa\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_FUNCTION, "aaa", "aAa");

        System.out.print("STRING_COMPARATOR.compare(\"aAa\", \"aaa\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_FUNCTION, "aAa", "aaa");

        System.out.println();
    }

    private void processStringComparatorIgnoreCase() {
        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(null, null) <=> ");
        this.processAndPrintException(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, null, null);

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(null, \"bbb\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, null, "bbb");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aaa\", null) <=> ");
        this.processAndPrintException(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aaa", null);

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aaa\", \"aba\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aaa", "aba");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aba\", \"aaa\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aba", "aaa");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aaa\", \"aaa\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aaa", "aaa");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aaa\", \"aAa\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aaa", "aAa");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aAa\", \"aaa\") <=> ");
        this.processAndPrintException(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aAa", "aaa");

        System.out.println();
    }

    private void processEqualsIgnoreCase() {
        System.out.print("equalsIgnoreCase(null, null) <=> ");
        this.processAndPrintException(Strings::equalsIgnoreCase, null, null);

        System.out.print("equalsIgnoreCase(null, \"bbb\") <=> ");
        this.processAndPrintException(Strings::equalsIgnoreCase, null, "bbb");

        System.out.print("equalsIgnoreCase(\"aaa\", null) <=> ");
        this.processAndPrintException(Strings::equalsIgnoreCase, "aaa", null);

        System.out.print("equalsIgnoreCase(\"aaa\", \"aba\") <=> ");
        this.processAndPrintException(Strings::equalsIgnoreCase, "aaa", "aba");

        System.out.print("equalsIgnoreCase(\"aba\", \"aaa\") <=> ");
        this.processAndPrintException(Strings::equalsIgnoreCase, "aba", "aaa");

        System.out.print("equalsIgnoreCase(\"aaa\", \"aaa\") <=> ");
        this.processAndPrintException(Strings::equalsIgnoreCase, "aaa", "aaa");

        System.out.print("equalsIgnoreCase(\"aaa\", \"aAa\") <=> ");
        this.processAndPrintException(Strings::equalsIgnoreCase, "aaa", "aAa");

        System.out.print("equalsIgnoreCase(\"aAa\", \"aaa\") <=> ");
        this.processAndPrintException(Strings::equalsIgnoreCase, "aAa", "aaa");

        System.out.println();
    }

    private void processStrip() {
        System.out.print("strip(null) <=> ");
        this.processAndPrintException(Strings::strip, null);

        System.out.print("strip(\" aaa \") <=> ");
        this.processAndPrintException(Strings::strip, " aaa ");

        System.out.println();
    }

    private void processIsNullOrEmpty() {
        System.out.print("isNullOrEmpty(null) <=> ");
        this.processAndPrintException(Strings::isNullOrEmpty, null);

        System.out.print("isNullOrEmpty(\"\") <=> ");
        this.processAndPrintException(Strings::isNullOrEmpty, "");

        System.out.print("isNullOrEmpty(\"   \") <=> ");
        this.processAndPrintException(Strings::isNullOrEmpty, "   ");

        System.out.print("isNullOrEmpty(\" aaa \") <=> ");
        this.processAndPrintException(Strings::isNullOrEmpty, " aaa ");

        System.out.println();
    }

    private void processIsNullOrWhitespace() {
        System.out.print("isNullOrWhitespace(null) <=> ");
        this.processAndPrintException(Strings::isNullOrWhitespace, null);

        System.out.print("isNullOrWhitespace(\"\") <=> ");
        this.processAndPrintException(Strings::isNullOrWhitespace, "");

        System.out.print("isNullOrWhitespace(\"   \") <=> ");
        this.processAndPrintException(Strings::isNullOrWhitespace, "   ");

        System.out.print("isNullOrWhitespace(\" aaa \") <=> ");
        this.processAndPrintException(Strings::isNullOrWhitespace, " aaa ");

        System.out.println();
    }

    private void processNonNullNorEmpty() {
        System.out.print("nonNullNorEmpty(null) <=> ");
        this.processAndPrintException(Strings::nonNullNorEmpty, null);

        System.out.print("nonNullNorEmpty(\"\") <=> ");
        this.processAndPrintException(Strings::nonNullNorEmpty, "");

        System.out.print("nonNullNorEmpty(\"   \") <=> ");
        this.processAndPrintException(Strings::nonNullNorEmpty, "   ");

        System.out.print("nonNullNorEmpty(\" aaa \") <=> ");
        this.processAndPrintException(Strings::nonNullNorEmpty, " aaa ");

        System.out.println();
    }

    private void processNonNullNorWhitespace() {
        System.out.print("nonNullNorWhitespace(null) <=> ");
        this.processAndPrintException(Strings::nonNullNorWhitespace, null);

        System.out.print("nonNullNorWhitespace(\"\") <=> ");
        this.processAndPrintException(Strings::nonNullNorWhitespace, "");

        System.out.print("nonNullNorWhitespace(\"   \") <=> ");
        this.processAndPrintException(Strings::nonNullNorWhitespace, "   ");

        System.out.print("nonNullNorWhitespace(\" aaa \") <=> ");
        this.processAndPrintException(Strings::nonNullNorWhitespace, " aaa ");

        System.out.println();
    }

    private void processRequireNonNullNorEmpty() {
        System.out.print("requireNonNullNorEmpty(null) <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, null);

        System.out.print("requireNonNullNorEmpty(\"\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, "");

        System.out.print("requireNonNullNorEmpty(\"   \") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, "   ");

        System.out.print("requireNonNullNorEmpty(\" aaa \") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, " aaa ");

        System.out.println();
    }

    private void processRequireNonNullNorWhitespace() {
        System.out.print("requireNonNullNorWhitespace(null) <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, null);

        System.out.print("requireNonNullNorWhitespace(\"\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, "");

        System.out.print("requireNonNullNorWhitespace(\"   \") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, "   ");

        System.out.print("requireNonNullNorWhitespace(\" aaa \") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, " aaa ");

        System.out.println();
    }

    private void processRequireNonNullNorEmptyWithMessage() {
        System.out.print("requireNonNullNorEmpty(null, \"Null or empty not allowed\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, null, "Null or empty not allowed");

        System.out.print("requireNonNullNorEmpty(\"\", \"Null or empty not allowed\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, "", "Null or empty not allowed");

        System.out.print("requireNonNullNorEmpty(\"   \", \"Null or empty not allowed\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, "   ", "Null or empty not allowed");

        System.out.print("requireNonNullNorEmpty(\" aaa \", \"Null or empty not allowed\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, " aaa ", "Null or empty not allowed");

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceWithMessage() {
        System.out.print("requireNonNullNorWhitespace(null, \"Null or whitespace not allowed\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, null, "Null or whitespace not allowed");

        System.out.print("requireNonNullNorWhitespace(\"\", \"Null or whitespace not allowed\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, "", "Null or whitespace not allowed");

        System.out.print("requireNonNullNorWhitespace(\"   \", \"Null or whitespace not allowed\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, "   ", "Null or whitespace not allowed");

        System.out.print("requireNonNullNorWhitespace(\" aaa \", \"Null or whitespace not allowed\") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, " aaa ", "Null or whitespace not allowed");

        System.out.println();
    }

    private void processRequireNonNullNorEmptyWithMessageSupplier(Supplier<String> messageSupplier, String messageSupplierName) {
        System.out.print("requireNonNullNorEmpty(null, " + messageSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, null, messageSupplier);

        System.out.print("requireNonNullNorEmpty(\"\", " + messageSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, "", messageSupplier);

        System.out.print("requireNonNullNorEmpty(\"   \", " + messageSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, "   ", messageSupplier);

        System.out.print("requireNonNullNorEmpty(\" aaa \", " + messageSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmpty, " aaa ", messageSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceWithMessageSupplier(Supplier<String> messageSupplier, String messageSupplierName) {
        System.out.print("requireNonNullNorWhitespace(null, " + messageSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, null, messageSupplier);

        System.out.print("requireNonNullNorWhitespace(\"\", " + messageSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, "", messageSupplier);

        System.out.print("requireNonNullNorWhitespace(\"   \", " + messageSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, "   ", messageSupplier);

        System.out.print("requireNonNullNorWhitespace(\" aaa \", " + messageSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespace, " aaa ", messageSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorEmptyElse(String defaultValue) {
        System.out.print("requireNonNullNorEmptyElse(null, " + defaultValue + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmptyElse, null, defaultValue);

        System.out.print("requireNonNullNorEmptyElse(\"\", " + defaultValue + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmptyElse, "", defaultValue);

        System.out.print("requireNonNullNorEmptyElse(\"   \", " + defaultValue + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmptyElse, "   ", defaultValue);

        System.out.print("requireNonNullNorEmptyElse(\" aaa \", " + defaultValue + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmptyElse, " aaa ", defaultValue);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceElse(String defaultValue) {
        System.out.print("requireNonNullNorWhitespaceElse(null, " + defaultValue + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespaceElse, null, defaultValue);

        System.out.print("requireNonNullNorWhitespaceElse(\"\", " + defaultValue + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespaceElse, "", defaultValue);

        System.out.print("requireNonNullNorWhitespaceElse(\"   \", " + defaultValue + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespaceElse, "   ", defaultValue);

        System.out.print("requireNonNullNorWhitespaceElse(\" aaa \", " + defaultValue + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespaceElse, " aaa ", defaultValue);

        System.out.println();
    }

    private void processRequireNonNullNorEmptyElseGet(Supplier<String> defaultValueSupplier, String defaultValueSupplierName) {
        System.out.print("requireNonNullNorEmptyElseGet(null, " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmptyElseGet, null, defaultValueSupplier);

        System.out.print("requireNonNullNorEmptyElseGet(\"\", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmptyElseGet, "", defaultValueSupplier);

        System.out.print("requireNonNullNorEmptyElseGet(\"   \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmptyElseGet, "   ", defaultValueSupplier);

        System.out.print("requireNonNullNorEmptyElseGet(\" aaa \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorEmptyElseGet, " aaa ", defaultValueSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceElseGet(Supplier<String> defaultValueSupplier, String defaultValueSupplierName) {
        System.out.print("requireNonNullNorWhitespaceElseGet(null, " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespaceElseGet, null, defaultValueSupplier);

        System.out.print("requireNonNullNorWhitespaceElseGet(\"\", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespaceElseGet, "", defaultValueSupplier);

        System.out.print("requireNonNullNorWhitespaceElseGet(\"   \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespaceElseGet, "   ", defaultValueSupplier);

        System.out.print("requireNonNullNorWhitespaceElseGet(\" aaa \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintException(Strings::requireNonNullNorWhitespaceElseGet, " aaa ", defaultValueSupplier);

        System.out.println();
    }

    private String nonNullNorEmptyMessageSupplier() {
        return "Supplier: Null or empty not allowed";
    }

    private String nonNullNorWhitespaceMessageSupplier() {
        return "Supplier: Null or whitespace not allowed";
    }

    private String defaultValueNullSupplier() {
        return null;
    }

    private String defaultValueEmptySupplier() {
        return "";
    }

    private String defaultValueWhitespaceSupplier() {
        return "   ";
    }

    private String defaultValueSupplier() {
        return " Supplier: defaultValue ";
    }

    private void processAndPrintException(Function<String, Object> function, String param) {
        Object result;
        try {
            result = function.apply(param);
            if(result instanceof String) {
                System.out.println("\"" + result + "\"");
            } else {
                System.out.println(result);
            }
        } catch(Exception e) {
            System.out.println(e.getClass().getCanonicalName() + " " + e.getMessage());
        }
    }

    private void processAndPrintException(BiFunction<String, String, Object> function, String param1, String param2) {
        Object result;
        try {
            result = function.apply(param1, param2);
            if(result instanceof String) {
                System.out.println("\"" + result + "\"");
            } else {
                System.out.println(result);
            }
        } catch(Exception e) {
            System.out.println(e.getClass().getCanonicalName() + " " + e.getMessage());
        }
    }

    private void processAndPrintException(BiFunction<String, Supplier<String>, Object> function, String param1, Supplier<String> param2) {
        Object result;
        try {
            result = function.apply(param1, param2);
            if(result instanceof String) {
                System.out.println("\"" + result + "\"");
            } else {
                System.out.println(result);
            }
        } catch(Exception e) {
            System.out.println(e.getClass().getCanonicalName() + " " + e.getMessage());
        }
    }
}
