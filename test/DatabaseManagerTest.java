import model.DatabaseManager;
import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseManagerTest {

    public static DatabaseManager databaseManager;

    @Before
    public void setUp(){
        databaseManager = new DatabaseManager();
    }

    @Test
    public void checkDataIntegrity(){
        Product water = new Product("100", "water 1l", 0.99);
        Assert.assertEquals(databaseManager.find("100"), water);
    }
}
