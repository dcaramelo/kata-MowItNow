package foo.bean;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PositionAheatIfPossibleTU {
	
	private final Position position;
	private final GardenLimit limit;
	private final int resultX;
	private final int resultY;
	
	public PositionAheatIfPossibleTU(final Position position, final GardenLimit limit, final int resultX, final int resultY) {
		this.position = position;
		this.limit = limit;
		this.resultX = resultX;
		this.resultY = resultY;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { new Position(5, 5, Direction.North), new GardenLimit(5, 5), 5, 5 },
	    		new Object[] { new Position(5, 5, Direction.East), new GardenLimit(5, 5), 5, 5 },
	    		new Object[] { new Position(0, 5, Direction.West), new GardenLimit(5, 5), 0, 5 },
	    		new Object[] { new Position(5, 0, Direction.South), new GardenLimit(5, 5), 5, 0 },
	    		new Object[] { new Position(5, 1, Direction.South), new GardenLimit(5, 5), 5, 0 },
	    		new Object[] { new Position(2, 2, Direction.West), new GardenLimit(5, 5), 1, 2 },
	    		new Object[] { new Position(2, 2, Direction.East), new GardenLimit(5, 5), 3, 2 },
	    		new Object[] { new Position(2, 2, Direction.North), new GardenLimit(5, 5), 2, 3 }
	        );
	}

	@Test
	public void aheatIfPossible() {
		// When
		position.aheadIfPossible(limit);
		
		// Then
		assertEquals(position.getX(), resultX);
		assertEquals(position.getY(), resultY);
	}
}
