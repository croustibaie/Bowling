import junit.framework.TestCase;
import org.junit.*;

public class TestBasic  {
	
	@Test
	public void testPartie() {
		Partie partie = new Partie();
		assertFalse(partie != NULL);
	}
}