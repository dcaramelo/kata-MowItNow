package foo.bean;

import java.util.List;

import org.apache.log4j.Logger;

import foo.exception.InitialPositionMowerInvalidException;

public class Mower {
	
	private static final Logger logger = Logger.getLogger(Mower.class);
	
	private final Position position;
	private final GardenLimit limite;
	private final List<Command> cmds;
	
	public Mower(final GardenLimit limit, final Position position, final List<Command> cmds) throws InitialPositionMowerInvalidException {
		
		if (!position.isValidPosition(limit)) {
			logger.error("Initial mower position is invalid !");
			throw new InitialPositionMowerInvalidException();
		}
		
		this.position = position;
		this.limite = limit;
		this.cmds = cmds;
	}

	public Position process() {
		for(Command cmd : cmds) {
			processCommand(cmd);
		}
		return position;
	}
	
	private void processCommand(final Command cmd) {
		switch(cmd) {
			case Avance :
				position.aheadIfPossible(limite);
				break;
			case Droite :
				position.turnRightDirection();
				break;
			case Gauche :
				position.turnLeftDirection();
				break;	
		}
	}
}