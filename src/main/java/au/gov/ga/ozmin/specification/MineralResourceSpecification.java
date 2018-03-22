package au.gov.ga.ozmin.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.criteria.*;

import au.gov.ga.ozmin.model.MineralisedZone;
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

	public static Specification<MineralResource> findMostRecentResource(LocalDate recordDate) {

		return new Specification<MineralResource>() {
			@Override
			public Predicate toPredicate(Root<MineralResource> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Subquery<Date> dateQuery = query.subquery(Date.class);
				final Root<MineralResource> maxMineralResource = dateQuery.from(MineralResource.class);
				dateQuery.select(cb.greatest(maxMineralResource.get(MineralResource_.recordDate)));
				dateQuery.where(cb.equal(maxMineralResource.get(MineralResource_.mineralisedZone),root.get(MineralResource_.mineralisedZone)));

				return cb.equal(root.get(MineralResource_.recordDate),dateQuery);

               // return cb.equal(root.get(MineralResource_.inclusive),false);
            }
		};
	}
}