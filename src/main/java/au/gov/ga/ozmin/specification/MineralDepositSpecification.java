package au.gov.ga.ozmin.specification;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.model.MineralDeposit_;
import au.gov.ga.ozmin.model.Province;

public class MineralDepositSpecification {

	public static Specification<MineralDeposit> searchByParameters(final String qName, final String operatingStatus,
			final String state, final String provinceName) {
		return new Specification<MineralDeposit>() {

			@Override
			public Predicate toPredicate(Root<MineralDeposit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
				if (!StringUtils.isEmpty(qName)) {
					final Predicate namePredicate = MineralDepositSpecification.findByNameOrSynonym(qName)
							.toPredicate(root, query, cb);
					predicates.add(namePredicate);
				}
				if (!StringUtils.isEmpty(operatingStatus)) {
					final Predicate operatingStatusPredicate = cb.equal(root.get(MineralDeposit_.operatingStatus),
							operatingStatus);
					predicates.add(operatingStatusPredicate);
				}
				if (!StringUtils.isEmpty(state)) {
					final Predicate statePredicate = cb.equal(root.get(MineralDeposit_.state), state);
					predicates.add(statePredicate);
				}
				if (!StringUtils.isEmpty(provinceName)) {
					final Predicate provinceNamePredicate = MineralDepositSpecification.findByProvince(provinceName).toPredicate(root, query, cb);
					predicates.add(provinceNamePredicate);
				}

				return cb.and(predicates.toArray(new Predicate[predicates.size()]));

			}

		};
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Specification<MineralDeposit> findByNameOrSynonym(final String name) {
		return new Specification<MineralDeposit>() {

			@Override
			public Predicate toPredicate(Root<MineralDeposit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.or(cb.like(root.get(MineralDeposit_.name), name),
						cb.like(root.get(MineralDeposit_.synonyms), name));

			}
		};
	}

	public static Specification<MineralDeposit> findByProvince(final String provinceName) {
		return new Specification<MineralDeposit>() {

			@Override
			public Predicate toPredicate(Root<MineralDeposit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Subquery<Long> provinceQuery = query.subquery(Long.class);
				final Root<Province> province = provinceQuery.from(Province.class);
				final Join<Province, MineralDeposit> deposits = province.join("mineralDeposits");
				provinceQuery.select(deposits.<Long> get("id"));
				provinceQuery.where(cb.like(province.<String> get("name"), "%"+provinceName+"%"));
				
				 return cb.in(root.get("id")).value(provinceQuery);
				
			}
		};
		
	}
}
