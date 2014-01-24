package foo.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import foo.exception.InitialPositionMowerInvalidException;

@RunWith(Parameterized.class)
public class MowerTU {
	private final GardenLimit limit;
	private final Position position;
	private final List<Command> cmds;
	private final Position finalPosition;
	
	public MowerTU(GardenLimit limit, Position position, List<Command> cmds, final Position finalPosition) {
		this.limit = limit;
		this.position = position;
		this.cmds = cmds;
		this.finalPosition = finalPosition;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { new GardenLimit(5, 5), new Position(6, 5, Direction.North), 
	    				Collections.<Command> emptyList(), null },
	    		new Object[] { new GardenLimit(2, 5), new Position(-2, 5, Direction.East), 
	    				Collections.<Command> emptyList(), null },
	    		new Object[] { new GardenLimit(3, 8), new Position(1, 5, Direction.West), 
	    				Arrays.asList(Command.Avance, Command.Gauche, Command.Avance), new Position(0, 4, Direction.South)},
	    		new Object[] { new GardenLimit(3, 8), new Position(1, 5, Direction.West), 
	    				Arrays.asList(Command.Avance, Command.Avance, Command.Gauche, Command.Avance), new Position(0, 4, Direction.South)},
	    		new Object[] { new GardenLimit(2, 2), new Position(1, 1, Direction.East), 
	    				Arrays.asList(Command.Avance, Command.Avance, Command.Avance, Command.Droite), new Position(2, 1, Direction.South)},
	    		new Object[] { new GardenLimit(2, 2), new Position(1, 1, Direction.North), 
	       				Arrays.asList(Command.Avance, Command.Avance, Command.Avance, Command.Gauche), new Position(1, 2, Direction.West)},
	    		new Object[] { new GardenLimit(2, 2), new Position(1, 1, Direction.South), 
	       				Arrays.asList(Command.Avance, Command.Avance, Command.Avance, Command.Gauche), new Position(1, 0, Direction.East)}
	        );
	}

	@Test
	public void newMower_whenOutOfLimitPosition_WhenThrowInitialPositionMowerInvalidException() {
		// When
		try {
			Mower mow = new Mower(limit, position, cmds);
			Position resultPosition = mow.process();
			
		// Then
			assertNotNull(finalPosition);
			assertEquals(finalPosition.getX(), resultPosition.getX());
			assertEquals(finalPosition.getY(), resultPosition.getY());
			assertEquals(finalPosition.getDirection(), resultPosition.getDirection());
		} catch (InitialPositionMowerInvalidException e) {
			assertNull(finalPosition);
		}
	}
}
