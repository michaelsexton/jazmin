package au.gov.ga.ozmin.specification;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import au.gov.ga.ozmin.model.MineralResource;
import au.gov.ga.ozmin.model.MineralResource_;

public class MineralResourceSpecification {
	
	public static Specification<MineralResource> searchByParameters(final String qaStatus, final String enteredBy) {
		return new Specification<MineralResource>() {
			
			@Override
			public Predicate toPredicate(Root<MineralResource> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
				if (!StringUtils.isEmpty(qaStatus)) {
					final Predicate qaStatusPredicate = MineralResourceSpecification.findByQaStatusCode(qaStatus)
							.toPredicate(root, query, cb);
					predicates.add(qaStatusPredicate);
				}
				if (!StringUtils.isEmpty(enteredBy)) {
					final Predicate enteredByPredicate = MineralResourceSpecification.findByEnteredBy(enteredBy).toPredicate(root, query, cb);
					predicates.add(enteredByPredicate);
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

	public static Specification<MineralResource> findByQaStatusCode(final String qaStatus) {
		return new Specification<MineralResource>() {
			
			@Override
			public Predicate toPredicate(Root<MineralResource> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(MineralResource_.qaStatus), qaStatus);
			}
		};
	}
	
	public static Specification<MineralResource> findByEnteredBy(final String enteredBy) {
		return new Specification<MineralResource>() {
			
			@Override
			public Predicate toPredicate(Root<MineralResource> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(MineralResource_.enteredBy), enteredBy); 
			}
		
		};
	}
}