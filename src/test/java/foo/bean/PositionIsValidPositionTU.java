package foo.bean;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PositionIsValidPositionTU {
	
	private final Position position;
	private final GardenLimit limit;
	private final boolean isValidResult;
	
	public PositionIsValidPositionTU(final Position position, final GardenLimit limit, boolean isValidResult) {
		this.position = position;
		this.limit = limit;
		this.isValidResult = isValidResult;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { new Position(5, 5, Direction.North), new GardenLimit(5, 5), true },
	    		new Object[] { new Position(5, 6, Direction.East), new GardenLimit(5, 5), false },
	    		new Object[] { new Position(-1, 5, Direction.West), new GardenLimit(5, 5), false },
	    		new Object[] { new Position(7, 0, Direction.South), new GardenLimit(5, 5), false },
	    		new Object[] { new Position(5, -1, Direction.South), new GardenLimit(5, 5), false },
	    		new Object[] { new Position(2, 2, Direction.West), new GardenLimit(5, 5), true }
	        );
	}

	@Test
	public void aheatIfPossible() {
		// When
		boolean validPosition = position.isValidPosition(limit);
		
		// Then
		assertEquals(validPosition, isValidResult);
	}
}
