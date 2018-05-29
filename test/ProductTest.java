import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void twoProductsEqual(){
        Assert.assertEquals(new Product("100","Sugar", 1.99), new Product("100","Sugar", 1.99));
        Assert.assertEquals(new Product("100","Sugar", 1.99).hashCode(), new Product("100","Sugar", 1.99).hashCode());
    }

    @Test
    public void twoProductsWithDifferentBarCode(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99), new Product("101","Sugar", 1.99));
    }
    @Test
    public void twoProductsWithDifferentPrice(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99), new Product("100","Sugar", 0.99));
    }
    @Test
    public void twoProductsWithDifferentName(){
        Assert.assertNotEquals(new Product("100","Sugar", 1.99), new Product("100","Apple", 1.99));
    }

}
