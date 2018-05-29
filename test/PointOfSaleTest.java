import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PointOfSaleTest{

    public static PointOfSale pointOfSale;

    @BeforeClass
    public static void setUp(){
        pointOfSale = new PointOfSale();
    }

    @Test
    public void addingProduct(){
        Product milk = new Product("100","Milk",1.99);
        pointOfSale.addProduct(milk);
        Assert.assertTrue(pointOfSale.getProducts().contains(milk));
        Assert.assertNotEquals(pointOfSale.getTotalPrice(), 0.0, 0.005);
    }

    @Test
    public void endTransaction(){
        Product milk = new Product("100","Milk",1.99);
        pointOfSale.addProduct(milk);
        pointOfSale.exit();
        Assert.assertTrue(pointOfSale.getProducts().isEmpty());
        Assert.assertEquals(pointOfSale.getTotalPrice(), 0.0, 0.005);
    }

    @Test
    public void f(){

    }

}