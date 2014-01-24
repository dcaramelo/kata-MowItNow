package foo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import foo.bean.Position;

@RunWith(Parameterized.class)
public class MowerControlTI {

	private final List<String> file;
	private final List<String> result;
	
	public MowerControlTI(List<String> file, List<String> result) {
		this.file = file;
		this.result = result;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] {
	    				Arrays.asList("8 2", "4 1 E", "GAAADA"),
	    				Arrays.asList("5 2 E") },
	    		new Object[] {
	    				Arrays.asList("8 4", "4 1 E", "GAAGDADA"),
	    				Arrays.asList("5 4 E") },
	            new Object[] { 
	            		Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E",  "AADAADADDA"),
	            		Arrays.asList("1 3 N", "5 1 E") },
	            new Object[] {
	            		Arrays.asList("5 5", "1 2 N", "GAAAAAAAGAGAGAA", "3 3 E",  "AAAAAAADAADADDA"),
	            		Arrays.asList("1 3 N", "5 1 E") }
	        );
	}
	
	@Test
	public void process() throws Exception {
		// Given
		MowerControl startEngine = new MowerControl(file);
		
		// When
		List<Position> positions = startEngine.process();
		
		// Then
		assertNotNull(positions);
		assertEquals(result.size(), positions.size());
		
		for (int i = 0 ; i < positions.size() ; i++) {
			assertNotNull(positions.get(i));
			assertEquals(result.get(i), positions.get(i).toString());
		}
	}
}
