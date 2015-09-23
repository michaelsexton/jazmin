package au.gov.ga.ozmin.service;

import au.gov.ga.ozmin.model.Commodity;
import org.springframework.data.domain.Page;


/**
 * Created by michael on 9/09/2015.
 */
public interface CommodityService {
     Page<Commodity> listCommodities(Integer pageNumber);
//    void addCommodity(Commodity ct);
//     void updateCommodity(Commodity ct);
//     List<Commodity> listCommodities(Integer pageNumber);
//     List<Commodity> listCommodities();
     Commodity getCommodityById(String id);
//     void removeCommodity(String id);
}
