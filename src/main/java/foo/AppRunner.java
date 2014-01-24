package foo;

import java.io.FileNotFoundException;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.apache.log4j.Logger;

import foo.bean.Position;
import foo.exception.FileFormatInvalidException;
import foo.exception.InitialPositionMowerInvalidException;
import foo.utils.FileReader;

public class AppRunner {
	
	static final Logger logger = Logger.getLogger(AppRunner.class);
	
	public static void main(final String[] args) throws InvalidAttributesException, FileFormatInvalidException, InitialPositionMowerInvalidException, FileNotFoundException {
	   
		if(args == null || args.length == 0) {
			logger.error("Filename is mandatory !");
			throw new InvalidAttributesException();
		}
	    
		List<String> fileLine = FileReader.getInstance().read(args[0]);
 
		List<Position> positions = new MowerControl(fileLine).process();
		
		logger.info("****************** Results **********************");
		for (int i=0 ; i < positions.size() ; i++) {
			logger.info("   " + i + " : Mower final position : " + positions.get(i));
		}
		logger.info("*************************************************");
	}
}
