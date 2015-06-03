package prop.g12.diputats.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TAmbit {
	industria, comercial, serveis;
	
	private static final List<TAmbit> valors = Collections.unmodifiableList(Arrays.asList(values()));
	
	public static List<TAmbit> getAmbits() { return valors;}
}
