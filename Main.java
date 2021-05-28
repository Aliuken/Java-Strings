package myjava.tests;

import myjava.util.StringExceptionMessageSuppliers;
import myjava.util.StringExceptionMessages;
import myjava.util.StringExceptionSuppliers;
import myjava.util.Strings;

import java.util.NoSuchElementException;
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
        this.processRequireNonNullNorEmptyWithMessage(null);
        this.processRequireNonNullNorEmptyWithMessage(new StringExceptionMessages(null, null, null));
        this.processRequireNonNullNorEmptyWithMessage(new StringExceptionMessages(null, "Empty not allowed", null));
        this.processRequireNonNullNorEmptyWithMessage(new StringExceptionMessages("Null not allowed", null, null));
        this.processRequireNonNullNorEmptyWithMessage(new StringExceptionMessages("Null not allowed", "Empty not allowed", null));
        System.out.println();

        System.out.println("12. requireNonNullNorWhitespaceWithMessage");
        System.out.println();
        this.processRequireNonNullNorWhitespaceWithMessage(null);
        this.processRequireNonNullNorWhitespaceWithMessage(new StringExceptionMessages(null, null, null));
        this.processRequireNonNullNorWhitespaceWithMessage(new StringExceptionMessages(null, "Empty not allowed", "Whitespace not allowed"));
        this.processRequireNonNullNorWhitespaceWithMessage(new StringExceptionMessages("Null not allowed", null, "Whitespace not allowed"));
        this.processRequireNonNullNorWhitespaceWithMessage(new StringExceptionMessages("Null not allowed", "Empty not allowed", null));
        this.processRequireNonNullNorWhitespaceWithMessage(new StringExceptionMessages("Null not allowed", "Empty not allowed", "Whitespace not allowed"));
        System.out.println();

        System.out.println("13. requireNonNullNorEmptyWithMessageSupplier");
        System.out.println();
        this.processRequireNonNullNorEmptyWithMessageSupplier(null, null, null, null);
        this.processRequireNonNullNorEmptyWithMessageSupplier(new StringExceptionMessageSuppliers(null, null, null), "null", "null", "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(new StringExceptionMessageSuppliers(null, this::nonEmptyMessageSupplier, null), "null", "this::nonEmptyMessageSupplier", "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(new StringExceptionMessageSuppliers(this::nonNullMessageSupplier, null, null), "this::nonNullMessageSupplier", "null", "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(new StringExceptionMessageSuppliers(this::nullMessageSupplier, this::nullMessageSupplier, null), "this::nullMessageSupplier", "this::nullMessageSupplier", "null");
        this.processRequireNonNullNorEmptyWithMessageSupplier(new StringExceptionMessageSuppliers(this::nonNullMessageSupplier, this::nonEmptyMessageSupplier, null), "this::nonNullMessageSupplier", "this::nonEmptyMessageSupplier", "null");
        System.out.println();

        System.out.println("14. requireNonNullNorWhitespaceWithMessageSupplier");
        System.out.println();
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(null, null, null, null);
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(new StringExceptionMessageSuppliers(null, null, null), "null", "null", "null");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(new StringExceptionMessageSuppliers(null, this::nonEmptyMessageSupplier, this::nonWhitespaceMessageSupplier), "null", "this::nonEmptyMessageSupplier", "this::nonWhitespaceMessageSupplier");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(new StringExceptionMessageSuppliers(this::nonNullMessageSupplier, null, this::nonWhitespaceMessageSupplier), "this::nonNullMessageSupplier", "null", "this::nonWhitespaceMessageSupplier");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(new StringExceptionMessageSuppliers(this::nonNullMessageSupplier, this::nonEmptyMessageSupplier, null), "this::nonNullMessageSupplier", "this::nonEmptyMessageSupplier", "null");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(new StringExceptionMessageSuppliers(this::nullMessageSupplier, this::nullMessageSupplier, this::nullMessageSupplier), "this::nullMessageSupplier", "this::nullMessageSupplier", "this::nullMessageSupplier");
        this.processRequireNonNullNorWhitespaceWithMessageSupplier(new StringExceptionMessageSuppliers(this::nonNullMessageSupplier, this::nonEmptyMessageSupplier, this::nonWhitespaceMessageSupplier), "this::nonNullMessageSupplier", "this::nonEmptyMessageSupplier", "this::nonWhitespaceMessageSupplier");
        System.out.println();

        System.out.println("15. requireNonNullNorEmptyElseThrow");
        System.out.println();
        this.processRequireNonNullNorEmptyElseThrow(null, null, null, null);
        this.processRequireNonNullNorEmptyElseThrow(new StringExceptionSuppliers(null, null, null), "null", "null", "null");
        this.processRequireNonNullNorEmptyElseThrow(new StringExceptionSuppliers(null, this::nonEmptyThrowableSupplier, null), "null", "this::nonEmptyThrowableSupplier", "null");
        this.processRequireNonNullNorEmptyElseThrow(new StringExceptionSuppliers(this::nonNullThrowableSupplier, null, null), "this::nonNullThrowableSupplier", "null", "null");
        this.processRequireNonNullNorEmptyElseThrow(new StringExceptionSuppliers(this::nullThrowableSupplier, this::nullThrowableSupplier, null), "this::nullThrowableSupplier", "this::nullThrowableSupplier", "null");
        this.processRequireNonNullNorEmptyElseThrow(new StringExceptionSuppliers(this::nonNullThrowableSupplier, this::nonEmptyThrowableSupplier, null), "this::nonNullThrowableSupplier", "this::nonEmptyThrowableSupplier", "null");
        System.out.println();

        System.out.println("16. requireNonNullNorWhitespaceElseThrow");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElseThrow(null, null, null, null);
        this.processRequireNonNullNorWhitespaceElseThrow(new StringExceptionSuppliers(null, null, null), "null", "null", "null");
        this.processRequireNonNullNorWhitespaceElseThrow(new StringExceptionSuppliers(null, this::nonEmptyThrowableSupplier, this::nonWhitespaceThrowableSupplier), "null", "this::nonEmptyThrowableSupplier", "this::nonWhitespaceThrowableSupplier");
        this.processRequireNonNullNorWhitespaceElseThrow(new StringExceptionSuppliers(this::nonNullThrowableSupplier, null, this::nonWhitespaceThrowableSupplier), "this::nonNullThrowableSupplier", "null", "this::nonWhitespaceThrowableSupplier");
        this.processRequireNonNullNorWhitespaceElseThrow(new StringExceptionSuppliers(this::nonNullThrowableSupplier, this::nonEmptyThrowableSupplier, null), "this::nonNullThrowableSupplier", "this::nonEmptyThrowableSupplier", "null");
        this.processRequireNonNullNorWhitespaceElseThrow(new StringExceptionSuppliers(this::nullThrowableSupplier, this::nullThrowableSupplier, this::nullThrowableSupplier), "this::nullThrowableSupplier", "this::nullThrowableSupplier", "this::nullThrowableSupplier");
        this.processRequireNonNullNorWhitespaceElseThrow(new StringExceptionSuppliers(this::nonNullThrowableSupplier, this::nonEmptyThrowableSupplier, this::nonWhitespaceThrowableSupplier), "this::nonNullThrowableSupplier", "this::nonEmptyThrowableSupplier", "this::nonWhitespaceThrowableSupplier");
        System.out.println();

        System.out.println("17. requireNonNullNorEmptyElse");
        System.out.println();
        this.processRequireNonNullNorEmptyElse(null);
        this.processRequireNonNullNorEmptyElse("");
        this.processRequireNonNullNorEmptyElse("     ");
        this.processRequireNonNullNorEmptyElse(" defaultValue ");
        System.out.println();

        System.out.println("18. requireNonNullNorWhitespaceElse");
        System.out.println();
        this.processRequireNonNullNorWhitespaceElse(null);
        this.processRequireNonNullNorWhitespaceElse("");
        this.processRequireNonNullNorWhitespaceElse("     ");
        this.processRequireNonNullNorWhitespaceElse(" defaultValue ");
        System.out.println();

        System.out.println("19. requireNonNullNorEmptyElseGet");
        System.out.println();
        this.processRequireNonNullNorEmptyElseGet(null, "null");
        this.processRequireNonNullNorEmptyElseGet(this::nullDefaultValueSupplier, "this::nullDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::emptyDefaultValueSupplier, "this::emptyDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::whitespaceDefaultValueSupplier, "this::whitespaceDefaultValueSupplier");
        this.processRequireNonNullNorEmptyElseGet(this::defaultValueSupplier, "this::defaultValueSupplier");
        System.out.println();

        System.out.println("20. requireNonNullNorWhitespaceElseGet");
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

    //------------------------------------------------------------------------------------------------------------------

    //DEFAULT EXCEPTION METHODS

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

    private void processRequireNonNullNorEmptyWithMessage(StringExceptionMessages stringExceptionMessages) {
        String params;
        if(stringExceptionMessages != null) {
            params = getObjectValueToPrint(stringExceptionMessages.nullStringParam()) + ", " + getObjectValueToPrint(stringExceptionMessages.emptyStringParam()) + ", " + getObjectValueToPrint(stringExceptionMessages.whitespaceStringParam());
        } else {
            params = "NULL";
        }

        System.out.print("requireNonNullNorEmpty(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, (String) null, stringExceptionMessages);

        System.out.print("requireNonNullNorEmpty(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "", stringExceptionMessages);

        System.out.print("requireNonNullNorEmpty(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "   ", stringExceptionMessages);

        System.out.print("requireNonNullNorEmpty(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, " aaa ", stringExceptionMessages);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceWithMessage(StringExceptionMessages stringExceptionMessages) {
        String params;
        if(stringExceptionMessages != null) {
            params = getObjectValueToPrint(stringExceptionMessages.nullStringParam()) + ", " + getObjectValueToPrint(stringExceptionMessages.emptyStringParam()) + ", " + getObjectValueToPrint(stringExceptionMessages.whitespaceStringParam());
        } else {
            params = "NULL";
        }

        System.out.print("requireNonNullNorWhitespace(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, (String) null, stringExceptionMessages);

        System.out.print("requireNonNullNorWhitespace(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "", stringExceptionMessages);

        System.out.print("requireNonNullNorWhitespace(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "   ", stringExceptionMessages);

        System.out.print("requireNonNullNorWhitespace(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, " aaa ", stringExceptionMessages);

        System.out.println();
    }

    //------------------------------------------------------------------------------------------------------------------

    //DEFAULT EXCEPTION WITH MESSAGE SUPPLIER METHODS

    private void processRequireNonNullNorEmptyWithMessageSupplier(StringExceptionMessageSuppliers stringExceptionMessageSuppliers, String nullMessageSupplierName, String emptyMessageSupplierName, String whitespaceMessageSupplierName) {
        String params;
        if(stringExceptionMessageSuppliers != null) {
            params = nullMessageSupplierName + ", " + emptyMessageSupplierName + ", " + whitespaceMessageSupplierName;
        } else {
            params = "NULL";
        }

        System.out.print("requireNonNullNorEmpty(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, (String) null, stringExceptionMessageSuppliers);

        System.out.print("requireNonNullNorEmpty(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "", stringExceptionMessageSuppliers);

        System.out.print("requireNonNullNorEmpty(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, "   ", stringExceptionMessageSuppliers);

        System.out.print("requireNonNullNorEmpty(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmpty, " aaa ", stringExceptionMessageSuppliers);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceWithMessageSupplier(StringExceptionMessageSuppliers stringExceptionMessageSuppliers, String nullMessageSupplierName, String emptyMessageSupplierName, String whitespaceMessageSupplierName) {
        String params;
        if(stringExceptionMessageSuppliers != null) {
            params = nullMessageSupplierName + ", " + emptyMessageSupplierName + ", " + whitespaceMessageSupplierName;
        } else {
            params = "NULL";
        }

        System.out.print("requireNonNullNorWhitespace(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, (String) null, stringExceptionMessageSuppliers);

        System.out.print("requireNonNullNorWhitespace(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "", stringExceptionMessageSuppliers);

        System.out.print("requireNonNullNorWhitespace(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, "   ", stringExceptionMessageSuppliers);

        System.out.print("requireNonNullNorWhitespace(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespace, " aaa ", stringExceptionMessageSuppliers);

        System.out.println();
    }

    //------------------------------------------------------------------------------------------------------------------

    //ELSE THROW METHODS

    private void processRequireNonNullNorEmptyElseThrow(StringExceptionSuppliers stringExceptionSuppliers, String nullThrowableSupplierName, String emptyThrowableSupplierName, String whitespaceThrowableSupplierName) {
        String params;
        if(stringExceptionSuppliers != null) {
            params = nullThrowableSupplierName + ", " + emptyThrowableSupplierName + ", " + whitespaceThrowableSupplierName;
        } else {
            params = "NULL";
        }

        System.out.print("requireNonNullNorEmptyElseThrow(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, (String) null, stringExceptionSuppliers);

        System.out.print("requireNonNullNorEmptyElseThrow(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, "", stringExceptionSuppliers);

        System.out.print("requireNonNullNorEmptyElseThrow(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, "   ", stringExceptionSuppliers);

        System.out.print("requireNonNullNorEmptyElseThrow(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorEmptyElseThrow, " aaa ", stringExceptionSuppliers);

        System.out.println();
    }

    private void processRequireNonNullNorWhitespaceElseThrow(StringExceptionSuppliers stringExceptionSuppliers, String nullThrowableSupplierName, String emptyThrowableSupplierName, String whitespaceThrowableSupplierName) {
        String params;
        if(stringExceptionSuppliers != null) {
            params = nullThrowableSupplierName + ", " + emptyThrowableSupplierName + ", " + whitespaceThrowableSupplierName;
        } else {
            params = "NULL";
        }

        System.out.print("requireNonNullNorWhitespaceElseThrow(null, " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, (String) null, stringExceptionSuppliers);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\"\", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, "", stringExceptionSuppliers);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\"   \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, "   ", stringExceptionSuppliers);

        System.out.print("requireNonNullNorWhitespaceElseThrow(\" aaa \", " + params + ") <=> ");
        this.processAndPrintResultOrThrowable(Strings::requireNonNullNorWhitespaceElseThrow, " aaa ", stringExceptionSuppliers);

        System.out.println();
    }

    //------------------------------------------------------------------------------------------------------------------

    //ELSE METHODS

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

    private Object getObjectValueToPrint(Object obj) {
        if(obj instanceof String) {
            return "\"" + obj + "\"";
        } else {
            return obj;
        }
    }
}
