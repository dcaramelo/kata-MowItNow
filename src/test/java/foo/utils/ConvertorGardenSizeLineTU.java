package foo.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import foo.bean.GardenLimit;
import foo.exception.FileFormatInvalidException;

@RunWith(Parameterized.class)
public class ConvertorGardenSizeLineTU {
	
	private final String commandLine;
	private final Boolean hasException;
	
	public ConvertorGardenSizeLineTU(final String commandLine, Boolean result) {
		this.commandLine = commandLine;
		this.hasException = result;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { "5 2", true },
	    		new Object[] { "5 -2", false },
	    		new Object[] { "55", false },
	    		new Object[] { "", false },
	    		new Object[] { "5 5 N", false },
	    		new Object[] { "    5 5", false },
	    		new Object[] { "8 2   ", false },
	    		new Object[] { "R R", false },
	    		new Object[] { "5 G", false },
	    		new Object[] { null, false }
	        );
	}
	
	@Test
	public void convert() {
		// Given
		ConvertorGardenSizeLine convertor = new ConvertorGardenSizeLine(commandLine);
		
		// When
		try {
			GardenLimit gl = convertor.convert();
			
		// Then
			assertTrue(hasException);
			assertNotNull(commandLine);
			String[] split = commandLine.split(" ");
			assertEquals(Integer.valueOf(split[0]).intValue(), gl.getX());
			assertEquals(Integer.valueOf(split[1]).intValue(), gl.getY());
		} catch (FileFormatInvalidException e) {
			assertFalse(hasException);
		}
	}
}