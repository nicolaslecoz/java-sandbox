package patternSpecification.regleMetier.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nlecoz <Nicolas Le Coz>
 * @since 25 mars 2009
 */
@SuppressWarnings("unchecked")
public abstract class AbstractCompositeSpecification<T> implements Specification<T> {
    protected List<Specification<T>> specifications;

    public Specification<T> or(Specification<T> specification) {
        return new OrSpecification<T>(this, specification);
    }

    public Specification<T> and(Specification<T> specification) {
        return new AndSpecification<T>(this, specification);
    }
    
    public Specification<T> not() {
        return new NotSpecification<T>(this);
    }

    protected AbstractCompositeSpecification(Specification<T>... specifications) {
        this.specifications = new ArrayList<Specification<T>>();
        
        for (Specification<T> specification : specifications) {
            this.specifications.add(specification);
        }
    }
}
