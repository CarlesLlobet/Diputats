package prop.g12.diputats.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TVot {
	favor, contra, abstencio;
	
	private static final List<TVot> valors = Collections.unmodifiableList(Arrays.asList(values()));
	
	public static List<TVot> getVots() { return valors;}
}
