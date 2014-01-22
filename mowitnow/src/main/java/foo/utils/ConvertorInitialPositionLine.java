package foo.utils;

import org.apache.commons.lang.StringUtils;

import foo.bean.Direction;
import foo.bean.Position;

public class ConvertorInitialPositionLine extends AbstractConvertorLine<Position>{

	public ConvertorInitialPositionLine(final String line) {
		super(line);
	}

	@Override
	protected boolean isValidLine() {
		return StringUtils.isNotBlank(line) && line.matches("^[0-9] [0-9] (N|S|W|E)$");
	}

	@Override
	protected Position process() {
		String[] split = line.split(" ");
		Direction direction = Direction.getDirectionFromCode(split[2]);
		return new Position(Integer.valueOf(split[0]), Integer.valueOf(split[1]), direction);
	}
}
