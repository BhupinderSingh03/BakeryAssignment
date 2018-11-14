package tech.mohammad.amir.common;

import java.util.List;

import static java.util.Arrays.asList;

public class Constants {
    public static final List<String> EXIT_COMMANDS = asList("EXIT", "exit", "0");
    public static final String PRODUCT_CSV_FILE = "product.csv";
    public static final String PRODUCT_PRICE_CSV_FILE = "product_price.csv";
    public static final String CURRENCY = "$";
    public static final String SPACE = " ";
    public static final String TABSPACE = "\t";
    public static final String NEWLINE = "\n";
    public static final String MUL = " X ";
    public static final String LINE = "------------------------------------------------------------";
    public static final String ORDER_TEXT = "Please place your order.(Type " + EXIT_COMMANDS+" to exit).";
    public static final String BAKERY_CLOSED_TEXT = "BAKERY CLOSED";
    public static final String INVALID_USER_INPUT = "Invalid User Input";
    public static final String INVALID_PRODUCT_CODE = "Invalid Product Code";
    public static final String CSV_READING_ERROR = "Error while reading csv:";
    public static final String INVALID_INPUT_PRODUCT_COUNT = "Invalid Product count";
}
