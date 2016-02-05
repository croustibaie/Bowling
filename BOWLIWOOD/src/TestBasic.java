

import static org.junit.Assert.*;

import org.junit.*;

public class TestBasic  {
	
	@Test
	public void testPartie() {
		Partie partie = new Partie();
		assertNotNull(partie);
	}
}