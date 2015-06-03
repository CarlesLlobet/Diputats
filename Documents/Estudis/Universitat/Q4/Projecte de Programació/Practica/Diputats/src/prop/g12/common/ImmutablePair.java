package prop.g12.common;

/**
 * Immutable pair, or 2-tuple. It only adds a public constructor to Pair.
 *
 * @author Andrés Correa Casablanca
 */
public class ImmutablePair<T1, T2> extends Pair<T1,T2> {

    public ImmutablePair(T1 v1, T2 v2) {
        super(v1, v2);
    }

}
