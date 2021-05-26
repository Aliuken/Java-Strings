package es.prueba;

import myjava.util.Strings;
import myjava.util.function.TriFunctionWithThrowable;

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
        this.processRequireNonNullNorEmptyWithMessageSupplier(null, null, "null", "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(null, this::nonEmptyMessageSupplier, "null", "this::nonEmptyMessageSupplier");
        this.processRequireNonNullNorEmptyWithMessageSupplier(this::nonNullMessageSupplier, null, "this::nonNullMessageSupplier", "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(this::nullMessageSupplier, this::nullMessageSupplier, "this::nullMessageSupplier", "this::nullMessageSupplier");
        this.processRequireNonNullNorEmptyWithMessageSupplier(this::nonNullMessageSupplier, this::nonEmptyMessageSupplier, "this::nonNullMessageSupplier", "this::nonEmptyMessageSupplier");
        System.out.println();

        System.out.println("14. requireNonNullNorWhitespaceWithMessageSupplier");
        System.out.println();
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(null, null, "null", "null");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(null, this::nonWhitespaceMessageSupplier, "null", "this::nonWhitespaceMessageSupplier");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(this::nonNullMessageSupplier, null, "this::nonNullMessageSupplier", "null");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(this::nullMessageSupplier, this::nullMessageSupplier, "this::nullMessageSupplier", "this::nullMessageSupplier");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(this::nonNullMessageSupplier, this::nonWhitespaceMessageSupplier, "this::nonNullMessageSupplier", "this::nonWhitespaceMessageSupplier");
        System.out.println();

        System.out.println("15. requireNonNullNorEmptyElse");
        System.out.println();
        this.processRequireNonNullNorEmptyElse(null);
        this.processRequireNonNullNorEmptyElse("");
        this.processRequireNonNullNorEmptyElse("     ");
        this.processRequireNonNullNorEmptyElse(" defaultValue ");
        System.out.println();

        System.out.println("16. requireNonNullNorWhitespaceElse");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElse(null);
        this.processRequireNonNullNorWhitespaceElse("");
        this.processRequireNonNullNorWhitespaceElse("     ");
        this.processRequireNonNullNorWhitespaceElse(" defaultValue ");
        System.out.println();

        System.out.println("17. requireNonNullNorEmptyElseGet");
        System.out.println();
        this.processRequireNonNullNorEmptyElseGet(null, "null");
        this.processRequireNonNullNorEmptyElseGet(this::nullDefaultValueSupplier, "this::nullDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::emptyDefaultValueSupplier, "this::emptyDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::whitespaceDefaultValueSupplier, "this::whitespaceDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::defaultValueSupplier, "this::defaultValueSupplier");
        System.out.println();

        System.out.println("18. requireNonNullNorWhitespaceElseGet");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElseGet(null, "null");
        this.processRequireNonNullNorWhitespaceElseGet(this::nullDefaultValueSupplier, "this::nullDefaultValueSupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::emptyDefaultValueSupplier, "this::emptyDefaultValueSupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::whitespaceDefaultValueSupplier, "this::whitespaceDefaultValueSupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::defaultValueSupplier, "this::defaultValueSupplier");
        System.out.println();

        System.out.println("19. requireNonNullNorEmptyElseThrow");
        System.out.println();
        this.processRequireNonNullNorEmptyElseThrow(null, null, "null", "null");
        this.processRequireNonNullNorEmptyElseThrow(null, this::nonEmptyThrowableSupplier, "null", "this::nonEmptyThrowableSupplier");
        this.processRequireNonNullNorEmptyElseThrow(this::nonNullThrowableSupplier, null, "this::nonNullThrowableSupplier", "null");
        this.processRequireNonNullNorEmptyElseThrow(this::nullThrowableSupplier, this::nullThrowableSupplier, "this::nullThrowableSupplier", "this::nullThrowableSupplier");
        this.processRequireNonNullNorEmptyElseThrow(this::nonNullThrowableSupplier, this::nonEmptyThrowableSupplier, "this::nonNullThrowableSupplier", "this::nonEmptyThrowableSupplier");
        System.out.println();

        System.out.println("20. requireNonNullNorWhitespaceElseThrow");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElseThrow(null, null, "null", "null");
        this.processRequireNonNullNorWhitespaceElseThrow(null, this::nonWhitespaceThrowableSupplier, "null", "this::nonWhitespaceThrowableSupplier");
        this.processRequireNonNullNorWhitespaceElseThrow(this::nonNullThrowableSupplier, null, "this::nonNullThrowableSupplier", "null");
        this.processRequireNonNullNorWhitespaceElseThrow(this::nullThrowableSupplier, this::nullThrowableSupplier, "this::nullThrowableSupplier", "this::nullThrowableSupplier");
        this.processRequireNonNullNorWhitespaceElseThrow(this::nonNullThrowableSupplier, this::nonWhitespaceThrowableSupplier, "this::nonNullThrowableSupplier", "this::nonWhitespaceThrowableSupplier");
        System.out.println();
    }

    private void processStringComparator() {
        System.out.print("STRING_COMPARATOR.compare(null, null) <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_FUNCTION, null, null);

        System.out.print("STRING_COMPARATOR.compare(null, \"bbb\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_FUNCTION, null, "bbb");

        System.out.print("STRING_COMPARATOR.compare(\"aaa\", null) <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_FUNCTION, "aaa", null);

        System.out.print("STRING_COMPARATOR.compare(\"aaa\", \"aba\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_FUNCTION, "aaa", "aba");

        System.out.print("STRING_COMPARATOR.compare(\"aba\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_FUNCTION, "aba", "aaa");

        System.out.print("STRING_COMPARATOR.compare(\"aaa\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_FUNCTION, "aaa", "aaa");

        System.out.print("STRING_COMPARATOR.compare(\"aaa\", \"aAa\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_FUNCTION, "aaa", "aAa");

        System.out.print("STRING_COMPARATOR.compare(\"aAa\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_FUNCTION, "aAa", "aaa");

        System.out.println();
    }

    private void processStringComparatorIgnoreCase() {
        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(null, null) <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, null, null);

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(null, \"bbb\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, null, "bbb");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aaa\", null) <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aaa", null);

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aaa\", \"aba\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aaa", "aba");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aba\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aba", "aaa");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aaa\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aaa", "aaa");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aaa\", \"aAa\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aaa", "aAa");

        System.out.print("STRING_COMPARATOR_IGNORE_CASE.compare(\"aAa\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(STRING_COMPARATOR_IGNORE_CASE_FUNCTION, "aAa", "aaa");

        System.out.println();
    }

    private void processEqualsIgnoreCase() {
        System.out.print("equalsIgnoreCase(null, null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::equalsIgnoreCase, null, null);

        System.out.print("equalsIgnoreCase(null, \"bbb\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::equalsIgnoreCase, null, "bbb");

        System.out.print("equalsIgnoreCase(\"aaa\", null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::equalsIgnoreCase, "aaa", null);

        System.out.print("equalsIgnoreCase(\"aaa\", \"aba\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::equalsIgnoreCase, "aaa", "aba");

        System.out.print("equalsIgnoreCase(\"aba\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::equalsIgnoreCase, "aba", "aaa");

        System.out.print("equalsIgnoreCase(\"aaa\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::equalsIgnoreCase, "aaa", "aaa");

        System.out.print("equalsIgnoreCase(\"aaa\", \"aAa\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::equalsIgnoreCase, "aaa", "aAa");

        System.out.print("equalsIgnoreCase(\"aAa\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::equalsIgnoreCase, "aAa", "aaa");

        System.out.println();
    }

    private void processStrip() {
        System.out.print("strip(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::strip, null);

        System.out.print("strip(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::strip, " aaa ");

        System.out.println();
    }

    private void processIsNullOrEmpty() {
        System.out.print("isNullOrEmpty(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNullOrEmpty, (String) null);

        System.out.print("isNullOrEmpty(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNullOrEmpty, "");

        System.out.print("isNullOrEmpty(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNullOrEmpty, "   ");

        System.out.print("isNullOrEmpty(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNullOrEmpty, " aaa ");

        System.out.println();
    }

    private void processIsNullOrWhitespace() {
        System.out.print("isNullOrWhitespace(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNullOrWhitespace, (String) null);

        System.out.print("isNullOrWhitespace(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNullOrWhitespace, "");

        System.out.print("isNullOrWhitespace(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNullOrWhitespace, "   ");

        System.out.print("isNullOrWhitespace(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNullOrWhitespace, " aaa ");

        System.out.println();
    }

    private void processNonNullNorEmpty() {
        System.out.print("nonNullNorEmpty(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNullNorEmpty, (String) null);

        System.out.print("nonNullNorEmpty(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNullNorEmpty, "");

        System.out.print("nonNullNorEmpty(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNullNorEmpty, "   ");

        System.out.print("nonNullNorEmpty(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNullNorEmpty, " aaa ");

        System.out.println();
    }

    private void processNonNullNorWhitespace() {
        System.out.print("nonNullNorWhitespace(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNullNorWhitespace, (String) null);

        System.out.print("nonNullNorWhitespace(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNullNorWhitespace, "");

        System.out.print("nonNullNorWhitespace(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNullNorWhitespace, "   ");

        System.out.print("nonNullNorWhitespace(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNullNorWhitespace, " aaa ");

        System.out.println();
    }

    private void processRequireNonNullNorEmpty() {
        System.out.print("requireNonNullNorEmpty(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, (String) null);

        System.out.print("requireNonNullNorEmpty(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "");

        System.out.print("requireNonNullNorEmpty(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "   ");

        System.out.print("requireNonNullNorEmpty(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, " aaa ");

        System.out.println();
    }

    private void processRequireNonNullNorWhitespace() {
        System.out.print("requireNonNullNorWhitespace(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, (String) null);

        System.out.print("requireNonNullNorWhitespace(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "");

        System.out.print("requireNonNullNorWhitespace(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "   ");

        System.out.print("requireNonNullNorWhitespace(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, " aaa ");

        System.out.println();
    }

    private void processRequireNonNullNorEmptyWithMessage() {
        System.out.print("requireNonNullNorEmpty(null, \"Null not allowed\", \"Empty not allowed\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, (String) null, "Null not allowed", "Empty not allowed");

        System.out.print("requireNonNullNorEmpty(\"\", \"Null not allowed\", \"Empty not allowed\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "", "Null not allowed", "Empty not allowed");

        System.out.print("requireNonNullNorEmpty(\"   \", \"Null not allowed\", \"Empty not allowed\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "   ", "Null not allowed", "Empty not allowed");

        System.out.print("requireNonNullNorEmpty(\" aaa \", \"Null not allowed\", \"Empty not allowed\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, " aaa ", "Null not allowed", "Empty not allowed");

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceWithMessage() {
        System.out.print("requireNonNullNorWhitespace(null, \"Null not allowed\", \"Whitespace not allowed\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, (String) null, "Null not allowed", "Whitespace not allowed");

        System.out.print("requireNonNullNorWhitespace(\"\", \"Null not allowed\", \"Whitespace not allowed\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "", "Null not allowed", "Whitespace not allowed");

        System.out.print("requireNonNullNorWhitespace(\"   \", \"Null not allowed\", \"Whitespace not allowed\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "   ", "Null not allowed", "Whitespace not allowed");

        System.out.print("requireNonNullNorWhitespace(\" aaa \", \"Null not allowed\", \"Whitespace not allowed\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, " aaa ", "Null not allowed", "Whitespace not allowed");

        System.out.println();
    }

    private void processRequireNonNullNorEmptyWithMessageSupplier(Supplier<String> nullMessageSupplier, Supplier<String> emptyMessageSupplier, String nullMessageSupplierName, String emptyMessageSupplierName) {
        System.out.print("requireNonNullNorEmpty(null, " + nullMessageSupplierName + ", " + emptyMessageSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, (String) null, nullMessageSupplier, emptyMessageSupplier);

        System.out.print("requireNonNullNorEmpty(\"\", " + nullMessageSupplierName + ", " + emptyMessageSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "", nullMessageSupplier, emptyMessageSupplier);

        System.out.print("requireNonNullNorEmpty(\"   \", " + nullMessageSupplierName + ", " + emptyMessageSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "   ", nullMessageSupplier, emptyMessageSupplier);

        System.out.print("requireNonNullNorEmpty(\" aaa \", " + nullMessageSupplierName + ", " + emptyMessageSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, " aaa ", nullMessageSupplier, emptyMessageSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceWithMessageSupplier(Supplier<String> nullMessageSupplier, Supplier<String> whitespaceMessageSupplier, String nullMessageSupplierName, String whitespaceMessageSupplierName) {
        System.out.print("requireNonNullNorWhitespace(null, " + nullMessageSupplierName + ", " + whitespaceMessageSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, (String) null, nullMessageSupplier, whitespaceMessageSupplier);

        System.out.print("requireNonNullNorWhitespace(\"\", " + nullMessageSupplierName + ", " + whitespaceMessageSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "", nullMessageSupplier, whitespaceMessageSupplier);

        System.out.print("requireNonNullNorWhitespace(\"   \", " + nullMessageSupplierName + ", " + whitespaceMessageSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "   ", nullMessageSupplier, whitespaceMessageSupplier);

        System.out.print("requireNonNullNorWhitespace(\" aaa \", " + nullMessageSupplierName + ", " + whitespaceMessageSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, " aaa ",nullMessageSupplier, whitespaceMessageSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorEmptyElse(String defaultValue) {
        System.out.print("requireNonNullNorEmptyElse(null, " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElse, (String) null, defaultValue);

        System.out.print("requireNonNullNorEmptyElse(\"\", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElse, "", defaultValue);

        System.out.print("requireNonNullNorEmptyElse(\"   \", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElse, "   ", defaultValue);

        System.out.print("requireNonNullNorEmptyElse(\" aaa \", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElse, " aaa ", defaultValue);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceElse(String defaultValue) {
        System.out.print("requireNonNullNorWhitespaceElse(null, " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElse, (String) null, defaultValue);

        System.out.print("requireNonNullNorWhitespaceElse(\"\", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElse, "", defaultValue);

        System.out.print("requireNonNullNorWhitespaceElse(\"   \", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElse, "   ", defaultValue);

        System.out.print("requireNonNullNorWhitespaceElse(\" aaa \", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElse, " aaa ", defaultValue);

        System.out.println();
    }

    private void processRequireNonNullNorEmptyElseGet(Supplier<String> defaultValueSupplier, String defaultValueSupplierName) {
        System.out.print("requireNonNullNorEmptyElseGet(null, " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseGet, (String) null, defaultValueSupplier);

        System.out.print("requireNonNullNorEmptyElseGet(\"\", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseGet, "", defaultValueSupplier);

        System.out.print("requireNonNullNorEmptyElseGet(\"   \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseGet, "   ", defaultValueSupplier);

        System.out.print("requireNonNullNorEmptyElseGet(\" aaa \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseGet, " aaa ", defaultValueSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceElseGet(Supplier<String> defaultValueSupplier, String defaultValueSupplierName) {
        System.out.print("requireNonNullNorWhitespaceElseGet(null, " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseGet, (String) null, defaultValueSupplier);

        System.out.print("requireNonNullNorWhitespaceElseGet(\"\", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseGet, "", defaultValueSupplier);

        System.out.print("requireNonNullNorWhitespaceElseGet(\"   \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseGet, "   ", defaultValueSupplier);

        System.out.print("requireNonNullNorWhitespaceElseGet(\" aaa \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseGet, " aaa ", defaultValueSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorEmptyElseThrow(Supplier<Throwable> nullThrowableSupplier, Supplier<Throwable> emptyThrowableSupplier, String nullThrowableSupplierName, String emptyThrowableSupplierName) {
        System.out.print("requireNonNullNorEmptyElseThrow(null, " + nullThrowableSupplierName + ", " + emptyThrowableSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, (String) null, nullThrowableSupplier, emptyThrowableSupplier);

        System.out.print("requireNonNullNorEmptyElseThrow(\"\", " + nullThrowableSupplierName + ", " + emptyThrowableSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, "", nullThrowableSupplier, emptyThrowableSupplier);

        System.out.print("requireNonNullNorEmptyElseThrow(\"   \", " + nullThrowableSupplierName + ", " + emptyThrowableSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, "   ", nullThrowableSupplier, emptyThrowableSupplier);

        System.out.print("requireNonNullNorEmptyElseThrow(\" aaa \", " + nullThrowableSupplierName + ", " + emptyThrowableSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, " aaa ", nullThrowableSupplier, emptyThrowableSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceElseThrow(Supplier<Throwable> nullThrowableSupplier, Supplier<Throwable> whitespaceThrowableSupplier, String nullThrowableSupplierName, String whitespaceThrowableSupplierName) {
        System.out.print("requireNonNullNorWhitespaceElseThrow(null, " + nullThrowableSupplierName + ", " + whitespaceThrowableSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, (String) null, nullThrowableSupplier, whitespaceThrowableSupplier);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\"\", " + nullThrowableSupplierName + ", " + whitespaceThrowableSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, "", nullThrowableSupplier, whitespaceThrowableSupplier);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\"   \", " + nullThrowableSupplierName + ", " + whitespaceThrowableSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, "   ", nullThrowableSupplier, whitespaceThrowableSupplier);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\" aaa \", " + nullThrowableSupplierName + ", " + whitespaceThrowableSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, " aaa ",nullThrowableSupplier, whitespaceThrowableSupplier);

        System.out.println();
    }

    private String nullMessageSupplier() {
        return null;
    }

    private String nonNullMessageSupplier() {
        return "Message Supplier: Null not allowed";
    }

    private String nonEmptyMessageSupplier() {
        return "Message Supplier: Empty not allowed";
    }

    private String nonWhitespaceMessageSupplier() {
        return "Message Supplier: Whitespace not allowed";
    }

    private String nullDefaultValueSupplier() {
        return null;
    }

    private String emptyDefaultValueSupplier() {
        return "";
    }

    private String whitespaceDefaultValueSupplier() {
        return "     ";
    }

    private String defaultValueSupplier() {
        return " Supplier: defaultValue ";
    }

    private Throwable nullThrowableSupplier() {
        return null;
    }

    private Throwable nonNullThrowableSupplier() {
        return new Throwable("Throwable Supplier: Null not allowed");
    }

    private Throwable nonEmptyThrowableSupplier() {
        return new Throwable("Throwable Supplier: Empty not allowed");
    }

    private Throwable nonWhitespaceThrowableSupplier() {
        return new Throwable("Throwable Supplier: Whitespace not allowed");
    }

    private <I1, O> void processAndPrintResultOrThrowable(Function<I1, O> function, I1 param) {
        try {
            O result = function.apply(param);
            System.out.println(this.getObjectValueToPrint(result));
        } catch(Throwable t) {
            System.out.println(t.getClass().getCanonicalName() + " " + t.getMessage());
        }
    }

    private <I1, I2, O> void processAndPrintResultOrThrowable(BiFunction<I1, I2, O> function, I1 param1, I2 param2) {
        try {
            O result = function.apply(param1, param2);
            System.out.println(this.getObjectValueToPrint(result));
        } catch(Throwable t) {
            System.out.println(t.getClass().getCanonicalName() + " " + t.getMessage());
        }
    }

    private <I1, I2, I3, O> void processAndPrintResultOrThrowable(TriFunctionWithThrowable<I1, I2, I3, O> function, I1 param1, I2 param2, I3 param3) {
        try {
            O result = function.apply(param1, param2, param3);
            System.out.println(this.getObjectValueToPrint(result));
        } catch(Throwable t) {
            System.out.println(t.getClass().getCanonicalName() + " " + t.getMessage());
        }
    }

    private Object getObjectValueToPrint(Object obj) {
        if(obj instanceof String) {
            return "\"" + obj + "\"";
        } else {
            return obj;
        }
    }
}
