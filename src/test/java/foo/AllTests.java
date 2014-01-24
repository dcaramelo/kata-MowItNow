package foo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import foo.bean.CommandTU;
import foo.bean.DirectionTU;
import foo.bean.MowerTU;
import foo.bean.PositionAheatIfPossibleTU;
import foo.bean.PositionIsValidPositionTU;
import foo.bean.PositionTurnDirectionTU;
import foo.utils.ConvertorCommandLineTU;
import foo.utils.ConvertorGardenSizeLineTU;
import foo.utils.ConvertorInitialPositionLineTU;

@RunWith(Suite.class)
@SuiteClasses(value={
	CommandTU.class,
	DirectionTU.class,
	ConvertorCommandLineTU.class,
	ConvertorGardenSizeLineTU.class,
	ConvertorInitialPositionLineTU.class,
	PositionTurnDirectionTU.class,
	PositionAheatIfPossibleTU.class,
	PositionIsValidPositionTU.class,
	MowerTU.class,
	MowerControlTI.class,
	MowerControlWithExceptionTI.class,
})
public class AllTests{ 
}
