/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jdays2016;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author steve
 */
@Stateless
public class PlannedWorksFacade extends AbstractFacade<PlannedWorks> {

    @PersistenceContext(unitName = "fish.payara.examples_JDays2016_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlannedWorksFacade() {
        super(PlannedWorks.class);
    }
    
}
