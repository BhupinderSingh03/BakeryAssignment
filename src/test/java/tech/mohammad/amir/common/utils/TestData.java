package tech.mohammad.amir.common.utils;

import java.util.List;

import static java.util.Arrays.asList;

public class TestData {
    public static final String INVALID_CSV_FILE = "invalidFile.csv";

    public static final List<String> PRODUCT_LIST = asList(
            "VS5, Vegemite Scroll", "MB11, Blueberry Muffin", "CF, Croissant"
    );

    public static final List<String> PRODUCT_PRICE_LIST = asList(
                    "VS5, 3, 6.99", "MB11,2, 9.95", "MB11, 5, 16.95", "CF, 3, 5.95", "CF, 5, 9.95", "CF, 9, 16.99"
    );

    public static final List<String> USER_INPUT_LIST = asList("15 VS5", "13 MB11", "27 CF");
}
