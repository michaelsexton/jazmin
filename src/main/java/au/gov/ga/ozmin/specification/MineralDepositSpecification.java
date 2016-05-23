package au.gov.ga.ozmin.specification;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import au.gov.ga.ozmin.model.Commodity;
import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.model.MineralDeposit_;
import au.gov.ga.ozmin.model.Province;

public class MineralDepositSpecification {

	public static Specification<MineralDeposit> searchByParameters(final String name, final String operatingStatus,
			final String state, final String provinceName, final String commodity) {
		return new Specification<MineralDeposit>() {

			@Override
			public Predicate toPredicate(Root<MineralDeposit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
				if (!StringUtils.isEmpty(name)) {
					final Predicate namePredicate = MineralDepositSpecification.findByNameOrSynonym(name)
							.toPredicate(root, query, cb);
					predicates.add(namePredicate);
				}
				if (!StringUtils.isEmpty(operatingStatus)) {
					System.out.println(operatingStatus);
					final Predicate operatingStatusPredicate = cb.equal(root.get(MineralDeposit_.operatingStatus),
							operatingStatus);
					predicates.add(operatingStatusPredicate);
				}
				if (!StringUtils.isEmpty(state)) {
					final Predicate statePredicate = cb.equal(root.get(MineralDeposit_.state), state);
					predicates.add(statePredicate);
				}
				if (!StringUtils.isEmpty(provinceName)) {
					final Predicate provinceNamePredicate = MineralDepositSpecification.findByProvince(provinceName)
							.toPredicate(root, query, cb);
					predicates.add(provinceNamePredicate);
				}
				if (!StringUtils.isEmpty(commodity)) {
					System.out.println(commodity);
					final Predicate commodityPredicate = MineralDepositSpecification.findByCommodity(commodity)
							.toPredicate(root, query, cb);
					predicates.add(commodityPredicate);
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
				provinceQuery.where(cb.like(province.<String> get("name"), "%" + provinceName + "%"));

				return cb.in(root.get("id")).value(provinceQuery);

			}
		};

	}
	
	public static Specification<MineralDeposit> findByCommodity(final String commodity) {
		return new Specification<MineralDeposit>() {
			
	
			@Override
			public Predicate toPredicate(Root<MineralDeposit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Subquery<String> commodityQuery = query.subquery(String.class);
				final Root<Commodity> commodity = commodityQuery.from(Commodity.class);
				final Join<Commodity, MineralDeposit> deposits = commodity.join("mineralDeposits");
				Path<String> test = deposits.<String> get("id");
				commodityQuery.select(deposits.<String> get("id"));
				commodityQuery.where(cb.equal(commodity.<String> get("id"), commodity));
				System.out.println(commodity);
				return cb.in(root.get("id")).value(commodityQuery);
				
			}
		};
	}
}
