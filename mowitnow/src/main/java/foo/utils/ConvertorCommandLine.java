package foo.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import foo.bean.Command;

public class ConvertorCommandLine extends AbstractConvertorLine<List<Command>>{

	public ConvertorCommandLine(final String line) {
		super(line);
	}

	@Override
	protected boolean isValidLine() {
		return StringUtils.isNotBlank(line) 
				&& StringUtils.containsOnly(line, 
						Command.Avance.getCode()
						+ Command.Droite.getCode()
						+ Command.Gauche.getCode());
	}

	@Override
	protected List<Command> process() {
		List<Command> cmds = new ArrayList<Command>();
		char [] listeCmds = line.toCharArray();
		
		for (char c : listeCmds) {
			cmds.add(Command.getCommandeFromCode(String.valueOf(c)));
		}
		
		return cmds;
	}
}