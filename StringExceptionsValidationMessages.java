package myjava.util;

import java.util.Objects;

public enum StringExceptionsValidationMessages {
    DEFAULT("stringExceptionsDefault"),
    DEFAULT_WITH_MESSAGE("stringExceptionsDefaultWithMessage"),
    DEFAULT_WITH_MESSAGE_SUPPLIER("stringExceptionsDefaultWithMessageSupplier"),
    CUSTOM("stringExceptionsCustom");

    public final String instanceName;
    public final String nullStringParam;
    public final String emptyStringParam;
    public final String whitespaceStringParam;
    public final String nullStringParamGet;
    public final String emptyStringParamGet;
    public final String whitespaceStringParamGet;

    private StringExceptionsValidationMessages(String instanceName) {
        this.instanceName = Objects.requireNonNull(instanceName, "instanceName");
        this.nullStringParam = this.instanceName + ".nullStringParam";
        this.emptyStringParam = this.instanceName + ".emptyStringParam";
        this.whitespaceStringParam = this.instanceName + ".whitespaceStringParam";
        this.nullStringParamGet = this.instanceName + ".nullStringParam.get()";
        this.emptyStringParamGet = this.instanceName + ".emptyStringParam.get()";
        this.whitespaceStringParamGet = this.instanceName + ".whitespaceStringParam.get()";
    }
}