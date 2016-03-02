/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jdays2016;

import fish.payara.examples.jdays2016.jaxb.HaPlannedRoadworks;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author steve
 */
@Stateless
public class DataLoaderLocal {

    @PersistenceContext(unitName = "fish.payara.examples_JDays2016_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public int parseFile(File file) {
        JAXBContext jc;
        int count = 0;
        try {
            jc = JAXBContext.newInstance("fish.payara.examples.jdays2016.jaxb");
            Unmarshaller um = jc.createUnmarshaller();
            HaPlannedRoadworks rw = (HaPlannedRoadworks) um.unmarshal(file);
            for (HaPlannedRoadworks.HaPlannedWorks works : rw.getHaPlannedWorks()) {
                PlannedWorks pw = new PlannedWorks(works);
                em.persist(pw);
                count++;
            }
        } catch (JAXBException ex) {
            Logger.getLogger(DataLoaderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

}
