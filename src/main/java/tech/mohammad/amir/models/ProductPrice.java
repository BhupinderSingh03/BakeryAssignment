package tech.mohammad.amir.models;

public class ProductPrice {
    private String productCode;
    private Integer packSize;
    private Float price;

    public ProductPrice(String productCode, Integer packSize, Float price) {
        this.productCode = productCode;
        this.packSize = packSize;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public Integer getPackSize() {
        return packSize;
    }

    public Float getPrice() {
        return price;
    }
}
