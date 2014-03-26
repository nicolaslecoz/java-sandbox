package patternSpecification.regleMetier.util;

/**
 * @author nlecoz <Nicolas Le Coz>
 * @since 25 mars 2009
 */
@SuppressWarnings("unchecked")
public class NotSpecification<T> extends AbstractCompositeSpecification<T> {
    
    @Override
    public boolean isSatisfiedBy(final T candidate) {
        return !specifications.get(0).isSatisfiedBy(candidate);
    }
    
    public NotSpecification(Specification<T> specification) {
        super(specification);
    }
}
