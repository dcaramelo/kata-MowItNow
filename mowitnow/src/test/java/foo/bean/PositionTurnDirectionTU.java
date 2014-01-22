package foo.bean;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PositionTurnDirectionTU {
	
	private final Position position;
	private final Direction leftDirection;
	private final Direction rightDirection;
	
	public PositionTurnDirectionTU(Position position, Direction leftDirection, Direction rightDirection) {
		this.position = position;
		this.leftDirection = leftDirection;
		this.rightDirection = rightDirection;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { new Position(5, 8, Direction.North), Direction.West, Direction.East},
	    		new Object[] { new Position(5, 8, Direction.South), Direction.East, Direction.West },
	    		new Object[] { new Position(5, 8, Direction.East), Direction.North, Direction.South },
	    		new Object[] { new Position(5, 8, Direction.West), Direction.South, Direction.North }
	        );
	}

	@Test
	public void turnLeftDirection() {
		// When
		Position clonePosition = position.clone();
		clonePosition.turnLeftDirection();
		
		// Then
		assertEquals(clonePosition.getX(), 5);
		assertEquals(clonePosition.getY(), 8);
		assertEquals(clonePosition.getDirection(), leftDirection);
	}
	
	@Test
	public void turnRightDirection() {
		// When
		Position clonePosition = position.clone();
		clonePosition.turnRightDirection();
		
		// Then
		assertEquals(clonePosition.getX(), 5);
		assertEquals(clonePosition.getY(), 8);
		assertEquals(clonePosition.getDirection(), rightDirection);
	}
}
