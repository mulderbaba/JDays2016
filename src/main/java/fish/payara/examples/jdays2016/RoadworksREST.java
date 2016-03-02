/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jdays2016;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.cache.annotation.CacheResult;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author steve
 */
@Path("roadworks")
@RequestScoped
public class RoadworksREST {

    @Context
    private UriInfo context;
    
    @EJB
    RoadworksLocal ejb;

    /**
     * Creates a new instance of RoadworksREST
     */
    public RoadworksREST() {
    }

    /**
     * Retrieves representation of an instance of fish.payara.examples.jdays2016.RoadworksREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @CacheResult
    public List<PlannedWorks> getAllWorks()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RoadworksREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.findAll();
    }
    
    /**
     * Retrieves representation of an instance of fish.payara.examples.jdays2016.RoadworksREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}/")
    @CacheResult
    public PlannedWorks getWorks(@PathParam("id") long id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RoadworksREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.find(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/road/{name}/")
    @CacheResult
    public List<PlannedWorks> getWorksByRoad(@PathParam("name") String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RoadworksREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejb.findByRoad(name);
    }
}
