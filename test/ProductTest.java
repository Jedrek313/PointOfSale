import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    @Before
    public void setUp(){
        Product sugar = new Product("100","Sugar", 1.99);
        Product sugarWithDifferentBarCode = new Product("101","Sugar", 1.99);
        Product sugarWithDifferentName = new Product("100","Apple", 1.99);
        Product sugarWithDifferentPrice = new Product("100","Sugar", 0.99);
    }
    @Test
    public void twoTheSameProductsEquals(){
        Assert.assertEquals(new Product("100","Sugar", 1.99), new Product("100","Sugar", 1.99));
    }

    @Test
    public void twoTheSameProductsWithTheSameHashCode(){
        Assert.assertEquals(new Product("100","Sugar", 1.99).hashCode(), new Product("100","Sugar", 1.99).hashCode());
    }

    @Test
    public void twoProductsWithDifferentBarCodeEquals(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99), new Product("101","Sugar", 1.99));
    }

    @Test
    public void twoProductsWithDifferentBarCodeWithTheSameHashCode(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99).hashCode(), new Product("101","Sugar", 1.99).hashCode());
    }

    @Test
    public void twoProductsWithDifferentPriceEquals(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99), new Product("100","Sugar", 0.99));
    }

    @Test
    public void twoProductsWithDifferentPriceWithTheSameHashCode(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99).hashCode(), new Product("100","Sugar", 0.99).hashCode());
    }

    @Test
    public void twoProductsWithDifferentNameEquals(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99), new Product("100","Apple", 1.99));
    }

    @Test
    public void twoProductsWithDifferentNameWithTheSameHashCode(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99).hashCode(), new Product("100","Apple", 1.99).hashCode());
    }

}
