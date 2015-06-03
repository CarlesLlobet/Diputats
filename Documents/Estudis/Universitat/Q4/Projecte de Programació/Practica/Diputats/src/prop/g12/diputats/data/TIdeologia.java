package prop.g12.diputats.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TIdeologia {
	esquerra, dreta, centre;
	
	private static final List<TIdeologia> valors = Collections.unmodifiableList(Arrays.asList(values()));
	
	public static List<TIdeologia> getIdeologies() { return valors;}
}
