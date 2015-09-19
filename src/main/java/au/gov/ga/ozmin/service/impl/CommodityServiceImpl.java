package au.gov.ga.ozmin.service.impl;


import au.gov.ga.ozmin.model.Commodity;
import au.gov.ga.ozmin.repository.CommodityRepository;
import au.gov.ga.ozmin.service.CommodityService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;


/**
 * Created by michael on 9/09/2015.
 */
@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {
	private static final int PAGE_SIZE = 20;

	@Inject
    private CommodityRepository commodityRepository;


    @Override
    @Transactional
    public Page<Commodity> listCommodities(Integer pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
        return commodityRepository.findAll(pageRequest);

    }



//    @Override
//    @Transactional
//    public void addCommodity(Commodity ct){
//        this.commodityDAO.addCommodity(ct);
//    }
//
//    @Override
//    @Transactional
//    public void updateCommodity(Commodity ct) {
//        this.commodityDAO.updateCommodity(ct);
//    }
//
//    @Override
//    @Transactional
//    public List<Commodity> listCommodities() {
//        return this.commodityDAO.listCommodities();
//    }
//
//    @Override
//    @Transactional
//    public List<Commodity> listCommodities(Integer pageNumber) {
//        return this.commodityDAO.listCommodities();
//
//    }
//
    @Override
    @Transactional
    public Commodity getCommodityById(String id) {
        return this.commodityRepository.findOne(id);
    }
//
//    @Override
//    @Transactional
//    public void removeCommodity(String id) {
//        this.commodityDAO.removeCommodity(id);
//    }
}
