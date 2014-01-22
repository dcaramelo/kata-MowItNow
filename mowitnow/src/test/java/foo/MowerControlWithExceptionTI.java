package foo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import foo.exception.FileFormatInvalidException;
import foo.exception.InitialPositionMowerInvalidException;

public class MowerControlWithExceptionTI {

	@Test(expected=FileFormatInvalidException.class)
	public void process_whenWrongCommandLineSpace_throwInvaliFileException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("5 5", "1 2 N", "GAGA  GAGAA", "3 3 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
	
	@Test(expected=FileFormatInvalidException.class)
	public void process_whenWrongCommandLineInvalidCaracter_throwInvaliFileException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("5 5", "1 2 N", "GAGAHAGAA", "3 3 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
	
	@Test(expected=FileFormatInvalidException.class)
	public void process_whenWrongCommandLineInvalidEmpty_throwInvaliFileException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("5 5", "1 2 N", "", "3 3 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
	
	@Test(expected=FileFormatInvalidException.class)
	public void process_whenWrongGardenSizeInvalid_throwInvaliFileException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("5", "1 2 N", "GAGAAGAA", "3 3 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}

	@Test(expected=FileFormatInvalidException.class)
	public void process_whenWrongGardenSizeInvalidNegative_throwInvaliFileException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("-5 5", "1 2 N", "GAGAAGAA", "3 3 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
	
	@Test(expected=FileFormatInvalidException.class)
	public void process_whenWrongGardenSizeInvalidCaracter_throwInvaliFileException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("5 T", "1 2 N", "GAGAAGAA", "3 3 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
	
	@Test(expected=FileFormatInvalidException.class)
	public void process_whenWrongGardenSizeInvalidEmpty_throwInvaliFileException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("", "1 2 N", "GAGAAGAA", "3 3 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
	
	@Test(expected=FileFormatInvalidException.class)
	public void process_whenWrongFileFormat_throwInvaliFileException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("5 5", "1 2 N");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
	
	@Test(expected=FileFormatInvalidException.class)
	public void process_whenEmptyFile_throwInvaliFileException() throws Exception {
		
		// Given
		MowerControl startEngine = new MowerControl(Collections.<String> emptyList());
		
		// When
		startEngine.process();
	}
	
	@Test(expected=InitialPositionMowerInvalidException.class)
	public void process_whenWrongInitialMowerPosition_throwInitialPositionMowerInvalidException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("5 5", "1 2 N", "GAGAAGAA", "3 7 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
	
	@Test(expected=InitialPositionMowerInvalidException.class)
	public void process_whenWrongInitialMowerPosition2_throwInitialPositionMowerInvalidException() throws Exception {
		
		// Given
		List<String> file = Arrays.asList("5 5", "1 5 N", "GAGAAGAA", "6 5 E",  "AADAADADDA");
		MowerControl startEngine = new MowerControl(file);
		
		// When
		startEngine.process();
	}
}
