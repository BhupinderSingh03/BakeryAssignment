package tech.mohammad.amir.action;

import org.junit.Assert;
import org.junit.Test;
import tech.mohammad.amir.models.Product;

public class BakeryProductStoreTest {
    private BakeryProductStore bakeryProductStore = BakeryProductStore.getInstance();

    @Test
    public void testProductSearch() {
        Product vs5Product = bakeryProductStore.findProduct("VS5");
        Product mb11Product = bakeryProductStore.findProduct("MB11");
        Product cfProduct = bakeryProductStore.findProduct("CF");

        Assert.assertNotNull(vs5Product);
        Assert.assertEquals("VS5-Vegemite Scroll", vs5Product.toString());
        Assert.assertEquals(2, vs5Product.getSortedSupportedPackList().size());
        Assert.assertTrue(vs5Product.getPrice(3).equals(6.99f));
        Assert.assertNull(vs5Product.getPrice(10));

        Assert.assertNotNull(mb11Product);
        Assert.assertEquals("MB11-Blueberry Muffin", mb11Product.toString());
        Assert.assertEquals(3, mb11Product.getSortedSupportedPackList().size());
        Assert.assertNull(mb11Product.getPrice(3));
        Assert.assertTrue(mb11Product.getPrice(5).equals(16.95f));

        Assert.assertNotNull(cfProduct);
        Assert.assertEquals("CF-Croissant", cfProduct.toString());
        Assert.assertEquals(3, cfProduct.getSortedSupportedPackList().size());
        Assert.assertTrue(cfProduct.getPrice(3).equals(5.95f));
        Assert.assertTrue(cfProduct.getPrice(5).equals(9.95f));
    }
}
