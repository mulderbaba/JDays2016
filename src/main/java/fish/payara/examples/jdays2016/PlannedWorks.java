/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.examples.jdays2016;

import fish.payara.examples.jdays2016.jaxb.HaPlannedRoadworks;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author steve
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "PlannedWorks.findAll", query = "SELECT p from PlannedWorks p"),
    @NamedQuery(name = "PlannedWorks.findByRoad", query = "SELECT p from PlannedWorks p where p.road = :road"),
    @NamedQuery(name = "PlannedWorkd.findByRoadAndDate", query = "SELECT p from PlannedWorks p where p.road = :road AND  :searchDate >= p.startDate AND :searchDate <= p.endDate")
})
@XmlRootElement
public class PlannedWorks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String road;
    private String area;
    private String location;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date   startDate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date endDate;
    private String delay;
    
    @Column(length = 1337)
    private String description;
    private String trafficManagement;
    private String type;
    private Long easting;
    private Long northing;
    private String status;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date publishedDate;

    public PlannedWorks() {
    }
    

    PlannedWorks(HaPlannedRoadworks.HaPlannedWorks works) {
        this.area = works.getLocalAuthority();
        this.delay = works.getExpectedDelay();
        this.description = works.getDescription();
        this.easting = (long)works.getCentreEasting();
        this.endDate = works.getEndDate().toGregorianCalendar().getTime();
        this.id = (long)works.getReferenceNumber();
        this.location = works.getLocation();
        this.northing = (long)works.getCentreNorthing();
        this.publishedDate = works.getPublishedDate().toGregorianCalendar().getTime();
        this.road = works.getRoad();
        this.startDate = works.getStartDate().toGregorianCalendar().getTime();
        this.status = works.getStatus();
        this.trafficManagement = works.getTrafficManagement();
        this.type = works.getClosureType();
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return startDate;
    }

    public void setStart(Date start) {
        this.startDate = start;
    }

    public Date getEnd() {
        return endDate;
    }

    public void setEnd(Date end) {
        this.endDate = end;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrafficManagement() {
        return trafficManagement;
    }

    public void setTrafficManagement(String trafficManagement) {
        this.trafficManagement = trafficManagement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getEasting() {
        return easting;
    }

    public void setEasting(Long easting) {
        this.easting = easting;
    }

    public Long getNorthing() {
        return northing;
    }

    public void setNorthing(Long northing) {
        this.northing = northing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
    
    
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlannedWorks)) {
            return false;
        }
        PlannedWorks other = (PlannedWorks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlannedWorks{" + "id=" + id + ", road=" + road + ", area=" + area + ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate + ", delay=" + delay + ", description=" + description + ", trafficManagement=" + trafficManagement + ", type=" + type + ", easting=" + easting + ", northing=" + northing + ", status=" + status + ", publishedDate=" + publishedDate + '}';
    }



    
}
