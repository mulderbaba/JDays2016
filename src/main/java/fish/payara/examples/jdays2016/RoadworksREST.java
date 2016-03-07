/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jdays2016;

import java.util.List;
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
    public List<PlannedWorks> getAllWorks()  {
        return ejb.findAll();
    }
    
    /**
     * Retrieves representation of an instance of fish.payara.examples.jdays2016.RoadworksREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}/")
    public PlannedWorks getWorks(@PathParam("id") long id) {
        return ejb.find(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/road/{name}/")
    public List<PlannedWorks> getWorksByRoad(@PathParam("name") String name) {
        return ejb.findByRoad(name);
    }
}
