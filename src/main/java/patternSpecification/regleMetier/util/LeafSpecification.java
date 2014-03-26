package patternSpecification.regleMetier.util;

/**
 * @author nlecoz <Nicolas Le Coz>
 * @since 25 mars 2009
 */
@SuppressWarnings("unchecked")
public abstract class LeafSpecification<T> extends AbstractCompositeSpecification<T> {
    public abstract boolean isSatisfiedBy(T candidate);
}
