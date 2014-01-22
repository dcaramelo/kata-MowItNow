package foo.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import foo.bean.Command;
import foo.exception.FileFormatInvalidException;

@RunWith(Parameterized.class)
public class ConvertorCommandLineTU {
	
	private final String commandLine;
	private final Boolean hasException;
	
	public ConvertorCommandLineTU(final String commandLine, Boolean result) {
		this.commandLine = commandLine;
		this.hasException = result;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { "GDAAGAADAA", true },
	    		new Object[] { "GAA ADA", false },
	    		new Object[] { "", false },
	    		new Object[] { "QSDFQSDF", false },
	    		new Object[] { "    GADAAGA", false },
	    		new Object[] { "GADAAGA   ", false },
	    		new Object[] { "11111", false },
	    		new Object[] { "  11111", false },
	    		new Object[] { "11111  ", false },
	    		new Object[] { null, false }
	        );
	}
	
	@Test
	public void convert() {
		// Given
		ConvertorCommandLine convertor = new ConvertorCommandLine(commandLine);
		
		//When
		try {
			List<Command> lCmds = convertor.convert();
			
		// Then
			assertTrue(hasException);
			assertNotNull(lCmds);
			assertEquals(commandLine.length(), lCmds.size());
			
			char[] charArrayCmds = commandLine.toCharArray();
			
			for (int i = 0; i < charArrayCmds.length; i++) {
				assertEquals(String.valueOf(charArrayCmds[i]), lCmds.get(i).getCode());
			}
		} catch (FileFormatInvalidException e) {
			assertFalse(hasException);
		}
	}
}
