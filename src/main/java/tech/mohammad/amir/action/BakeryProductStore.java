package tech.mohammad.amir.action;

import tech.mohammad.amir.common.exceptions.ReaderException;
import tech.mohammad.amir.common.parsers.Parser;
import tech.mohammad.amir.common.parsers.impl.ProductParser;
import tech.mohammad.amir.common.parsers.impl.ProductPriceParser;
import tech.mohammad.amir.common.utils.FileUtils;
import tech.mohammad.amir.models.Product;
import tech.mohammad.amir.models.ProductPrice;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static java.util.Objects.isNull;
import static tech.mohammad.amir.common.Constants.PRODUCT_CSV_FILE;
import static tech.mohammad.amir.common.Constants.PRODUCT_PRICE_CSV_FILE;
import static tech.mohammad.amir.io.impl.ConsoleWriter.*;

public class BakeryProductStore {
    private static BakeryProductStore bakeryProductStore;
    private static Map<String, Product> productMap;

    private BakeryProductStore() {
        loadProductMap();
        loadPriceInProductMap();
    }

    public static BakeryProductStore getInstance() {
        if(isNull(bakeryProductStore)) {
            bakeryProductStore = new BakeryProductStore();
        }

        return bakeryProductStore;
    }

    public Product findProduct(String productCode) {
        return productMap.get(productCode);
    }

    private void loadProductMap() {
        try {
            Parser<Product> productParser = new ProductParser();
            productMap = productParser.parseList(FileUtils.readFileText(PRODUCT_CSV_FILE));
        } catch (ReaderException rex) {
            write(rex.getMessage());
        }
    }

    private void loadPriceInProductMap() {
        Map<String, List<ProductPrice>> productPriceMap = getProductPriceMap();
        populatePriceInProductMap(productPriceMap);
    }

    private Map<String, List<ProductPrice>> getProductPriceMap() {
        try {
            Parser<List<ProductPrice>> productPriceParser = new ProductPriceParser();
            return productPriceParser.parseList(FileUtils.readFileText(PRODUCT_PRICE_CSV_FILE));
        } catch (ReaderException rex) {
            write(rex.getMessage());
            return emptyMap();
        }
    }

    private void populatePriceInProductMap(Map<String, List<ProductPrice>> productPriceMap) {
        productPriceMap.entrySet().forEach(this::populatePriceInProduct);
    }

    private void populatePriceInProduct(Map.Entry<String, List<ProductPrice>> productPriceEntry) {
        Product product = productMap.get(productPriceEntry.getKey());

        productPriceEntry.getValue().forEach(
                productPrice -> {
                    product.addPricePack(productPrice.getPackSize(), productPrice.getPrice());
                }
        );
    }
}
