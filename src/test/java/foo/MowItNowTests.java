package foo;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import foo.bean.Position;


public class MowItNowTests{ 
	
	//Fichier en entrée deux choix possible via test automatisé ou fichier ext, j'ai choisi un test auto
	List<String> file = Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E",  "AADAADADDA");
	
	//Position attendu des tondeuses en fin de séquence
	List<String> result = Arrays.asList("1 3 N", "5 1 E");
	

	@Test
	public void move() throws Exception {
		// Given
		MowerControl startEngine = new MowerControl(file);

		// When
		List<Position> positions = startEngine.process();
		
//		Le fait de caster le contenu de nos tableau en string ne fonctionne efficacement pour les tableaux de petite taille
		
		// Then
		assertEquals(result.toString(), positions.toString());

	}
}