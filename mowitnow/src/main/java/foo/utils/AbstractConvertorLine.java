package foo.utils;

import foo.exception.FileFormatInvalidException;

public abstract class AbstractConvertorLine<T> {

	protected final String line;
	
	protected AbstractConvertorLine(final String line) {
		this.line = line;
	}
	
	protected abstract boolean isValidLine();
	protected abstract T process();
	
	public T convert() throws FileFormatInvalidException {
		if (!isValidLine()) {
			throw new FileFormatInvalidException();
		}
		return process();
	}
}