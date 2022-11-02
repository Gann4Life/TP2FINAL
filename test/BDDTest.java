import org.junit.Assert;
import org.junit.Test;
import database.*;

public class BDDTest {
	
	BDD baseDeDatos = BDD.getInstance();
	
	@Test
	public void singleton() {
		Assert.assertEquals(baseDeDatos, BDD.getInstance());
	}
	
	
    

}
