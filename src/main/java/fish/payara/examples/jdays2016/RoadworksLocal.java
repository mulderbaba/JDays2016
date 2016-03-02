/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jdays2016;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author steve
 */
@Stateless
public class RoadworksLocal {

    @PersistenceContext(unitName = "fish.payara.examples_JDays2016_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public List<PlannedWorks> findAll() {
        return em.createNamedQuery("PlannedWorks.findAll").getResultList();
    }
    
    public PlannedWorks find(long ID) {
        return em.find(PlannedWorks.class, ID);
    }
    
    public List<PlannedWorks> findByRoad(String road) {
        Query query = em.createNamedQuery("PlannedWorks.findByRoad");
        query.setParameter("road", road);
        return query.getResultList();
    }

}
