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

import foo.bean.Direction;
import foo.bean.Position;
import foo.exception.FileFormatInvalidException;

@RunWith(Parameterized.class)
public class ConvertorInitialPositionLineTU {
	
	private final String commandLine;
	private final Boolean hasException;
	
	public ConvertorInitialPositionLineTU(final String commandLine, Boolean result) {
		this.commandLine = commandLine;
		this.hasException = result;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { "5 2 N", true },
	    		new Object[] { "8 3 S", true },
	    		new Object[] { "5 7 E", true },
	    		new Object[] { "7 2 W", true },
	    		new Object[] { "55 W", false },
	    		new Object[] { "N 5 5", false },
	    		new Object[] { "N 55", false },
	    		new Object[] { "    5 5 N", false },
	    		new Object[] { "8 2 E  ", false },
	    		new Object[] { "R R 8", false },
	    		new Object[] { "-1 2 W", false }
	        );
	}
	
	@Test
	public void convert() {
		// Given
		ConvertorInitialPositionLine convertor = new ConvertorInitialPositionLine(commandLine);
		
		//When
		try {
			Position pos = convertor.convert();
			
		// Then
			assertTrue(hasException);
			assertNotNull(commandLine);
			String[] split = commandLine.split(" ");
			assertEquals(Integer.valueOf(split[0]).intValue(), pos.getX());
			assertEquals(Integer.valueOf(split[1]).intValue(), pos.getY());
			assertEquals(Direction.getDirectionFromCode(split[2]), pos.getDirection());
		} catch (FileFormatInvalidException e) {
			assertFalse(hasException);
		}
	}
}