package foo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributesException;

import org.apache.log4j.Logger;

import foo.bean.Position;
import foo.exception.FileFormatInvalidException;
import foo.exception.InitialPositionMowerInvalidException;

public class AppRunner {
	
	static final Logger logger = Logger.getLogger(AppRunner.class);
	
	public static void main(final String[] args) throws InvalidAttributesException, FileFormatInvalidException, InitialPositionMowerInvalidException {
	   
		if(args == null || args.length == 0) {
			logger.error("Filename is mandatory !");
			throw new InvalidAttributesException();
		}
	   
		List<String> fileLine = readFile(args);
        
		MowerControl mowerControl = new MowerControl(fileLine);
        
		List<Position> positions = mowerControl.process();
		
		logger.info("****************** Results **********************");
		for (int i=0 ; i < positions.size() ; i++) {
			logger.info("   " + i + " : Mower final position : " + positions.get(i));
		}
		logger.info("*************************************************");
	}

	private static List<String> readFile(final String[] args) {
		List<String> fileLine = new ArrayList<String>();
		   
        File file = new File(args[0]);
 
        try {
        	Scanner scanner = new Scanner(file);
 
        	while (scanner.hasNextLine()) {
        		String line = scanner.nextLine();
        		fileLine.add(line);
        	}
        	scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return fileLine;
	}
}
