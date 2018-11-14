package tech.mohammad.amir.models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Product {
    private String code;
    private String name;
    private Map<Integer, Float> priceByPackMap;

    public Product(String code, String name) {
        this.code = code;
        this.name = name;
        this.priceByPackMap = new HashMap<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Float getPrice(Integer packSize) {
        return priceByPackMap.get(packSize);
    }

    public void addPricePack(Integer packSize, Float price) {
        this.priceByPackMap.put(packSize, price);
    }

    public List<Integer> getSortedSupportedPackList() {
        return priceByPackMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(toList());
    }

    @Override
    public String toString() {
        return code + "-" + name;
    }
}
