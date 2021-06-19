package myjava.tests;

import myjava.util.Strings;
import myjava.util.function.FourParameterFunctionWithThrowable;
import myjava.util.function.OneParameterFunctionWithThrowable;
import myjava.util.function.ThreeParameterFunctionWithThrowable;
import myjava.util.function.TwoParameterFunctionWithThrowable;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Main {
    public static final TwoParameterFunctionWithThrowable<String, String, Object> STRING_COMPARATOR_FUNCTION = Strings.STRING_COMPARATOR::compare;
    public static final TwoParameterFunctionWithThrowable<String, String, Object> STRING_COMPARATOR_IGNORE_CASE_FUNCTION = Strings.STRING_COMPARATOR_IGNORE_CASE::compare;

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

        System.out.println("3. equals");
        System.out.println();
        this.processEquals();
        System.out.println();

        System.out.println("4. equalsIgnoreCase");
        System.out.println();
        this.processEqualsIgnoreCase();
        System.out.println();

        System.out.println("5. strip");
        System.out.println();
        this.processStrip();
        System.out.println();

        System.out.println("6. isNull");
        System.out.println();
        this.processIsNull();
        System.out.println();

        System.out.println("7. isNullOrEmpty");
        System.out.println();
        this.processIsNullOrEmpty();
        System.out.println();

        System.out.println("8. isNullOrWhitespace");
        System.out.println();
        this.processIsNullOrWhitespace();
        System.out.println();

        System.out.println("9. nonNull");
        System.out.println();
        this.processNonNull();
        System.out.println();

        System.out.println("10. nonNullNorEmpty");
        System.out.println();
        this.processNonNullNorEmpty();
        System.out.println();

        System.out.println("11. nonNullNorWhitespace");
        System.out.println();
        this.processNonNullNorWhitespace();
        System.out.println();

        System.out.println("12. requireNonNull");
        System.out.println();
        this.processRequireNonNull();
        System.out.println();

        System.out.println("13. requireNonNullNorEmpty");
        System.out.println();
        this.processRequireNonNullNorEmpty();
        System.out.println();

        System.out.println("14. requireNonNullNorWhitespace");
        System.out.println();
        this.processRequireNonNullNorWhitespace();
        System.out.println();

        System.out.println("15. requireNonNullWithMessage");
        System.out.println();
        this.processRequireNonNullWithMessage(null);
        this.processRequireNonNullWithMessage("Null not allowed");
        System.out.println();

        System.out.println("16. requireNonNullNorEmptyWithMessage");
        System.out.println();
        this.processRequireNonNullNorEmptyWithMessage(null, null);
        this.processRequireNonNullNorEmptyWithMessage(null, "Empty not allowed");
        this.processRequireNonNullNorEmptyWithMessage("Null not allowed", null);
        this.processRequireNonNullNorEmptyWithMessage("Null not allowed", "Empty not allowed");
        System.out.println();

        System.out.println("17. requireNonNullNorWhitespaceWithMessage");
        System.out.println();
        this.processRequireNonNullNorWhitespaceWithMessage(null, null, null);
        this.processRequireNonNullNorWhitespaceWithMessage(null, "Empty not allowed", "Whitespace not allowed");
        this.processRequireNonNullNorWhitespaceWithMessage("Null not allowed", null, "Whitespace not allowed");
        this.processRequireNonNullNorWhitespaceWithMessage("Null not allowed", "Empty not allowed", null);
        this.processRequireNonNullNorWhitespaceWithMessage("Null not allowed", "Empty not allowed", "Whitespace not allowed");
        System.out.println();

        System.out.println("18. requireNonNullWithMessageSupplier");
        System.out.println();
        this.processRequireNonNullWithMessageSupplier(null, "null");
        this.processRequireNonNullWithMessageSupplier(this::nullMessageSupplier, "this::nullMessageSupplier");
        this.processRequireNonNullWithMessageSupplier(this::nonNullMessageSupplier, "this::nonNullMessageSupplier");
        System.out.println();

        System.out.println("19. requireNonNullNorEmptyWithMessageSupplier");
        System.out.println();
        this.processRequireNonNullNorEmptyWithMessageSupplier(null, null, "null", "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(null, this::nonEmptyMessageSupplier, "null", "this::nonEmptyMessageSupplier");
        this.processRequireNonNullNorEmptyWithMessageSupplier(this::nonNullMessageSupplier, null, "this::nonNullMessageSupplier", "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(this::nullMessageSupplier, this::nullMessageSupplier, "this::nullMessageSupplier", "this::nullMessageSupplier");
        this.processRequireNonNullNorEmptyWithMessageSupplier(this::nonNullMessageSupplier, this::nonEmptyMessageSupplier, "this::nonNullMessageSupplier", "this::nonEmptyMessageSupplier");
        System.out.println();

        System.out.println("20. requireNonNullNorWhitespaceWithMessageSupplier");
        System.out.println();
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(null, null, null, "null", "null", "null");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(null, this::nonEmptyMessageSupplier, this::nonWhitespaceMessageSupplier, "null", "this::nonEmptyMessageSupplier", "this::nonWhitespaceMessageSupplier");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(this::nonNullMessageSupplier, null, this::nonWhitespaceMessageSupplier, "this::nonNullMessageSupplier", "null", "this::nonWhitespaceMessageSupplier");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(this::nonNullMessageSupplier, this::nonEmptyMessageSupplier, null, "this::nonNullMessageSupplier", "this::nonEmptyMessageSupplier", "null");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(this::nullMessageSupplier, this::nullMessageSupplier, this::nullMessageSupplier, "this::nullMessageSupplier", "this::nullMessageSupplier", "this::nullMessageSupplier");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(this::nonNullMessageSupplier, this::nonEmptyMessageSupplier, this::nonWhitespaceMessageSupplier, "this::nonNullMessageSupplier", "this::nonEmptyMessageSupplier", "this::nonWhitespaceMessageSupplier");
        System.out.println();

        System.out.println("21. requireNonNullElseThrow");
        System.out.println();
        this.processRequireNonNullElseThrow(null, "null");
        this.processRequireNonNullElseThrow(this::nullThrowableSupplier, "this::nullThrowableSupplier");
        this.processRequireNonNullElseThrow(this::nonNullThrowableSupplier, "this::nonNullThrowableSupplier");
        System.out.println();

        System.out.println("22. requireNonNullNorEmptyElseThrow");
        System.out.println();
        this.processRequireNonNullNorEmptyElseThrow(null, null, "null", "null");
        this.processRequireNonNullNorEmptyElseThrow(null, this::nonEmptyThrowableSupplier, "null", "this::nonEmptyThrowableSupplier");
        this.processRequireNonNullNorEmptyElseThrow(this::nonNullThrowableSupplier, null, "this::nonNullThrowableSupplier", "null");
        this.processRequireNonNullNorEmptyElseThrow(this::nullThrowableSupplier, this::nullThrowableSupplier, "this::nullThrowableSupplier", "this::nullThrowableSupplier");
        this.processRequireNonNullNorEmptyElseThrow(this::nonNullThrowableSupplier, this::nonEmptyThrowableSupplier, "this::nonNullThrowableSupplier", "this::nonEmptyThrowableSupplier");
        System.out.println();

        System.out.println("23. requireNonNullNorWhitespaceElseThrow");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElseThrow(null, null, null, "null", "null", "null");
        this.processRequireNonNullNorWhitespaceElseThrow(null, this::nonEmptyThrowableSupplier, this::nonWhitespaceThrowableSupplier, "null", "this::nonEmptyThrowableSupplier", "this::nonWhitespaceThrowableSupplier");
        this.processRequireNonNullNorWhitespaceElseThrow(this::nonNullThrowableSupplier, null, this::nonWhitespaceThrowableSupplier, "this::nonNullThrowableSupplier", "null", "this::nonWhitespaceThrowableSupplier");
        this.processRequireNonNullNorWhitespaceElseThrow(this::nonNullThrowableSupplier, this::nonEmptyThrowableSupplier, null, "this::nonNullThrowableSupplier", "this::nonEmptyThrowableSupplier", "null");
        this.processRequireNonNullNorWhitespaceElseThrow(this::nullThrowableSupplier, this::nullThrowableSupplier, this::nullThrowableSupplier, "this::nullThrowableSupplier", "this::nullThrowableSupplier", "this::nullThrowableSupplier");
        this.processRequireNonNullNorWhitespaceElseThrow(this::nonNullThrowableSupplier, this::nonEmptyThrowableSupplier, this::nonWhitespaceThrowableSupplier, "this::nonNullThrowableSupplier", "this::nonEmptyThrowableSupplier", "this::nonWhitespaceThrowableSupplier");
        System.out.println();

        System.out.println("24. requireNonNullElse");
        System.out.println();
        this.processRequireNonNullElse(null);
        this.processRequireNonNullElse("");
        this.processRequireNonNullElse("     ");
        this.processRequireNonNullElse(" defaultValue ");
        System.out.println();

        System.out.println("25. requireNonNullNorEmptyElse");
        System.out.println();
        this.processRequireNonNullNorEmptyElse(null);
        this.processRequireNonNullNorEmptyElse("");
        this.processRequireNonNullNorEmptyElse("     ");
        this.processRequireNonNullNorEmptyElse(" defaultValue ");
        System.out.println();

        System.out.println("26. requireNonNullNorWhitespaceElse");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElse(null);
        this.processRequireNonNullNorWhitespaceElse("");
        this.processRequireNonNullNorWhitespaceElse("     ");
        this.processRequireNonNullNorWhitespaceElse(" defaultValue ");
        System.out.println();

        System.out.println("27. requireNonNullElseGet");
        System.out.println();
        this.processRequireNonNullElseGet(null, "null");
        this.processRequireNonNullElseGet(this::nullDefaultValueSupplier, "this::nullDefaultValueSupplier");
        this.processRequireNonNullElseGet(this::emptyDefaultValueSupplier, "this::emptyDefaultValueSupplier");
        this.processRequireNonNullElseGet(this::whitespaceDefaultValueSupplier, "this::whitespaceDefaultValueSupplier");
        this.processRequireNonNullElseGet(this::defaultValueSupplier, "this::defaultValueSupplier");
        System.out.println();

        System.out.println("28. requireNonNullNorEmptyElseGet");
        System.out.println();
        this.processRequireNonNullNorEmptyElseGet(null, "null");
        this.processRequireNonNullNorEmptyElseGet(this::nullDefaultValueSupplier, "this::nullDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::emptyDefaultValueSupplier, "this::emptyDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::whitespaceDefaultValueSupplier, "this::whitespaceDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::defaultValueSupplier, "this::defaultValueSupplier");
        System.out.println();

        System.out.println("29. requireNonNullNorWhitespaceElseGet");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElseGet(null, "null");
        this.processRequireNonNullNorWhitespaceElseGet(this::nullDefaultValueSupplier, "this::nullDefaultValueSupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::emptyDefaultValueSupplier, "this::emptyDefaultValueSupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::whitespaceDefaultValueSupplier, "this::whitespaceDefaultValueSupplier");
        this.processRequireNonNullNorWhitespaceElseGet(this::defaultValueSupplier, "this::defaultValueSupplier");
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

    private void processEquals() {
        System.out.print("equals(null, null) <=> ");
        this.processAndPrintResultOrThrowable((String a, String b) -> Strings.equals(a, b), null, null);

        System.out.print("equals(null, \"bbb\") <=> ");
        this.processAndPrintResultOrThrowable((String a, String b) -> Strings.equals(a, b), null, "bbb");

        System.out.print("equals(\"aaa\", null) <=> ");
        this.processAndPrintResultOrThrowable((String a, String b) -> Strings.equals(a, b), "aaa", null);

        System.out.print("equals(\"aaa\", \"aba\") <=> ");
        this.processAndPrintResultOrThrowable((String a, String b) -> Strings.equals(a, b), "aaa", "aba");

        System.out.print("equals(\"aba\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable((String a, String b) -> Strings.equals(a, b), "aba", "aaa");

        System.out.print("equals(\"aaa\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable((String a, String b) -> Strings.equals(a, b), "aaa", "aaa");

        System.out.print("equals(\"aaa\", \"aAa\") <=> ");
        this.processAndPrintResultOrThrowable((String a, String b) -> Strings.equals(a, b), "aaa", "aAa");

        System.out.print("equals(\"aAa\", \"aaa\") <=> ");
        this.processAndPrintResultOrThrowable((String a, String b) -> Strings.equals(a, b), "aAa", "aaa");

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

    //------------------------------------------------------------------------------------------------------------------

    //BOOLEAN METHODS

    private void processIsNull() {
        System.out.print("isNull(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNull, (String) null);

        System.out.print("isNull(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNull, "");

        System.out.print("isNull(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNull, "   ");

        System.out.print("isNull(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::isNull, " aaa ");

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

    private void processNonNull() {
        System.out.print("nonNull(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNull, (String) null);

        System.out.print("nonNull(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNull, "");

        System.out.print("nonNull(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNull, "   ");

        System.out.print("nonNull(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::nonNull, " aaa ");

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

    //------------------------------------------------------------------------------------------------------------------

    //DEFAULT EXCEPTION METHODS

    private void processRequireNonNull() {
        System.out.print("requireNonNull(null) <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, (String) null);

        System.out.print("requireNonNull(\"\") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, "");

        System.out.print("requireNonNull(\"   \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, "   ");

        System.out.print("requireNonNull(\" aaa \") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, " aaa ");

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

    //------------------------------------------------------------------------------------------------------------------

    //DEFAULT EXCEPTION WITH MESSAGE METHODS

    private void processRequireNonNullWithMessage(String nullStringMessage) {
        String params = getObjectValueToPrint(nullStringMessage);

        System.out.print("requireNonNull(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, (String) null, nullStringMessage);

        System.out.print("requireNonNull(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, "", nullStringMessage);

        System.out.print("requireNonNull(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, "   ", nullStringMessage);

        System.out.print("requireNonNull(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, " aaa ", nullStringMessage);

        System.out.println();
    }

    private void processRequireNonNullNorEmptyWithMessage(String nullStringMessage, String emptyStringMessage) {
        String params = getObjectValueToPrint(nullStringMessage) + ", " + getObjectValueToPrint(emptyStringMessage);

        System.out.print("requireNonNullNorEmpty(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, (String) null, nullStringMessage, emptyStringMessage);

        System.out.print("requireNonNullNorEmpty(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "", nullStringMessage, emptyStringMessage);

        System.out.print("requireNonNullNorEmpty(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "   ", nullStringMessage, emptyStringMessage);

        System.out.print("requireNonNullNorEmpty(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, " aaa ", nullStringMessage, emptyStringMessage);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceWithMessage(String nullStringMessage, String emptyStringMessage, String whitespaceStringMessage) {
        String params = getObjectValueToPrint(nullStringMessage) + ", " + getObjectValueToPrint(emptyStringMessage) + ", " + getObjectValueToPrint(whitespaceStringMessage);

        System.out.print("requireNonNullNorWhitespace(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, (String) null, nullStringMessage, emptyStringMessage, whitespaceStringMessage);

        System.out.print("requireNonNullNorWhitespace(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "", nullStringMessage, emptyStringMessage, whitespaceStringMessage);

        System.out.print("requireNonNullNorWhitespace(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "   ", nullStringMessage, emptyStringMessage, whitespaceStringMessage);

        System.out.print("requireNonNullNorWhitespace(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, " aaa ", nullStringMessage, emptyStringMessage, whitespaceStringMessage);

        System.out.println();
    }

    //------------------------------------------------------------------------------------------------------------------

    //DEFAULT EXCEPTION WITH MESSAGE SUPPLIER METHODS

    private void processRequireNonNullWithMessageSupplier(Supplier<String> nullStringMessageSupplier, String nullMessageSupplierName) {
        String params = nullMessageSupplierName;

        System.out.print("requireNonNull(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, (String) null, nullStringMessageSupplier);

        System.out.print("requireNonNull(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, "", nullStringMessageSupplier);

        System.out.print("requireNonNull(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, "   ", nullStringMessageSupplier);

        System.out.print("requireNonNull(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNull, " aaa ", nullStringMessageSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorEmptyWithMessageSupplier(Supplier<String> nullStringMessageSupplier, Supplier<String> emptyStringMessageSupplier, String nullMessageSupplierName, String emptyMessageSupplierName) {
        String params = nullMessageSupplierName + ", " + emptyMessageSupplierName;

        System.out.print("requireNonNullNorEmpty(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, (String) null, nullStringMessageSupplier, emptyStringMessageSupplier);

        System.out.print("requireNonNullNorEmpty(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "", nullStringMessageSupplier, emptyStringMessageSupplier);

        System.out.print("requireNonNullNorEmpty(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "   ", nullStringMessageSupplier, emptyStringMessageSupplier);

        System.out.print("requireNonNullNorEmpty(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, " aaa ", nullStringMessageSupplier, emptyStringMessageSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceWithMessageSupplier(Supplier<String> nullStringMessageSupplier, Supplier<String> emptyStringMessageSupplier, Supplier<String> whitespaceStringMessageSupplier, String nullMessageSupplierName, String emptyMessageSupplierName, String whitespaceMessageSupplierName) {
        String params = nullMessageSupplierName + ", " + emptyMessageSupplierName + ", " + whitespaceMessageSupplierName;

        System.out.print("requireNonNullNorWhitespace(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, (String) null, nullStringMessageSupplier, emptyStringMessageSupplier, whitespaceStringMessageSupplier);

        System.out.print("requireNonNullNorWhitespace(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "", nullStringMessageSupplier, emptyStringMessageSupplier, whitespaceStringMessageSupplier);

        System.out.print("requireNonNullNorWhitespace(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "   ", nullStringMessageSupplier, emptyStringMessageSupplier, whitespaceStringMessageSupplier);

        System.out.print("requireNonNullNorWhitespace(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, " aaa ", nullStringMessageSupplier, emptyStringMessageSupplier, whitespaceStringMessageSupplier);

        System.out.println();
    }

    //------------------------------------------------------------------------------------------------------------------

    //ELSE THROW METHODS

    private void processRequireNonNullElseThrow(Supplier<Throwable> nullStringThrowableSupplier, String nullThrowableSupplierName) {
        String params = nullThrowableSupplierName;

        System.out.print("requireNonNullElseThrow(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElseThrow, (String) null, nullStringThrowableSupplier);

        System.out.print("requireNonNullElseThrow(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElseThrow, "", nullStringThrowableSupplier);

        System.out.print("requireNonNullElseThrow(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElseThrow, "   ", nullStringThrowableSupplier);

        System.out.print("requireNonNullElseThrow(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElseThrow, " aaa ", nullStringThrowableSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorEmptyElseThrow(Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, String nullThrowableSupplierName, String emptyThrowableSupplierName) {
        String params = nullThrowableSupplierName + ", " + emptyThrowableSupplierName;

        System.out.print("requireNonNullNorEmptyElseThrow(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, (String) null, nullStringThrowableSupplier, emptyStringThrowableSupplier);

        System.out.print("requireNonNullNorEmptyElseThrow(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, "", nullStringThrowableSupplier, emptyStringThrowableSupplier);

        System.out.print("requireNonNullNorEmptyElseThrow(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, "   ", nullStringThrowableSupplier, emptyStringThrowableSupplier);

        System.out.print("requireNonNullNorEmptyElseThrow(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, " aaa ", nullStringThrowableSupplier, emptyStringThrowableSupplier);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceElseThrow(Supplier<Throwable> nullStringThrowableSupplier, Supplier<Throwable> emptyStringThrowableSupplier, Supplier<Throwable> whitespaceStringThrowableSupplier, String nullThrowableSupplierName, String emptyThrowableSupplierName, String whitespaceThrowableSupplierName) {
        String params = nullThrowableSupplierName + ", " + emptyThrowableSupplierName + ", " + whitespaceThrowableSupplierName;

        System.out.print("requireNonNullNorWhitespaceElseThrow(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, (String) null, nullStringThrowableSupplier, emptyStringThrowableSupplier, whitespaceStringThrowableSupplier);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, "", nullStringThrowableSupplier, emptyStringThrowableSupplier, whitespaceStringThrowableSupplier);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, "   ", nullStringThrowableSupplier, emptyStringThrowableSupplier, whitespaceStringThrowableSupplier);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, " aaa ", nullStringThrowableSupplier, emptyStringThrowableSupplier, whitespaceStringThrowableSupplier);

        System.out.println();
    }

    //------------------------------------------------------------------------------------------------------------------

    //ELSE METHODS

    private void processRequireNonNullElse(String defaultValue) {
        System.out.print("requireNonNullElse(null, " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElse, (String) null, defaultValue);

        System.out.print("requireNonNullElse(\"\", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElse, "", defaultValue);

        System.out.print("requireNonNullElse(\"   \", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElse, "   ", defaultValue);

        System.out.print("requireNonNullElse(\" aaa \", " + this.getObjectValueToPrint(defaultValue) + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElse, " aaa ", defaultValue);

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

    //------------------------------------------------------------------------------------------------------------------

    //ELSE GET METHODS

    private void processRequireNonNullElseGet(Supplier<String> defaultValueSupplier, String defaultValueSupplierName) {
        System.out.print("requireNonNullElseGet(null, " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElseGet, (String) null, defaultValueSupplier);

        System.out.print("requireNonNullElseGet(\"\", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElseGet, "", defaultValueSupplier);

        System.out.print("requireNonNullElseGet(\"   \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElseGet, "   ", defaultValueSupplier);

        System.out.print("requireNonNullElseGet(\" aaa \", " + defaultValueSupplierName + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullElseGet, " aaa ", defaultValueSupplier);

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

    //------------------------------------------------------------------------------------------------------------------

    //EXCEPTION MESSAGE SUPPLIERS

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

    //------------------------------------------------------------------------------------------------------------------

    //THROWABLE SUPPLIERS

    private Throwable nullThrowableSupplier() {
        return null;
    }

    private Throwable nonNullThrowableSupplier() {
        return new NoSuchElementException("Throwable Supplier: Null not allowed");
    }

    private Throwable nonEmptyThrowableSupplier() {
        return new Exception("Throwable Supplier: Empty not allowed");
    }

    private Throwable nonWhitespaceThrowableSupplier() {
        return new Throwable("Throwable Supplier: Whitespace not allowed");
    }

    //------------------------------------------------------------------------------------------------------------------

    //DEFAULT VALUE SUPPLIERS

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

    //------------------------------------------------------------------------------------------------------------------

    //PRIVATE METHODS

    private <I1, O> void processAndPrintResultOrThrowable(OneParameterFunctionWithThrowable<I1, O> function, I1 param) {
        try {
            O result = function.apply(param);
            System.out.println(this.getObjectValueToPrint(result));
        } catch(Throwable t) {
            System.out.println(t.getClass().getCanonicalName() + " " + t.getMessage());
        }
    }

    private <I1, I2, O> void processAndPrintResultOrThrowable(TwoParameterFunctionWithThrowable<I1, I2, O> function, I1 param1, I2 param2) {
        try {
            O result = function.apply(param1, param2);
            System.out.println(this.getObjectValueToPrint(result));
        } catch(Throwable t) {
            System.out.println(t.getClass().getCanonicalName() + " " + t.getMessage());
        }
    }

    private <I1, I2, I3, O> void processAndPrintResultOrThrowable(ThreeParameterFunctionWithThrowable<I1, I2, I3, O> function, I1 param1, I2 param2, I3 param3) {
        try {
            O result = function.apply(param1, param2, param3);
            System.out.println(this.getObjectValueToPrint(result));
        } catch(Throwable t) {
            System.out.println(t.getClass().getCanonicalName() + " " + t.getMessage());
        }
    }

    private <I1, I2, I3, I4, O> void processAndPrintResultOrThrowable(FourParameterFunctionWithThrowable<I1, I2, I3, I4, O> function, I1 param1, I2 param2, I3 param3, I4 param4) {
        try {
            O result = function.apply(param1, param2, param3, param4);
            System.out.println(this.getObjectValueToPrint(result));
        } catch(Throwable t) {
            System.out.println(t.getClass().getCanonicalName() + " " + t.getMessage());
        }
    }

    private String getObjectValueToPrint(Object obj) {
        if(obj instanceof String) {
            return "\"" + obj + "\"";
        } else if(obj != null) {
            return obj.toString();
        } else {
            return "null";
        }
    }
}