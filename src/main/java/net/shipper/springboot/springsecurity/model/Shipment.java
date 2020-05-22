package net.shipper.springboot.springsecurity.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Shipment {
    private static int idCounter = 1000;
    
    @Id
    private String trackingNumber;
    private String dimensions, description;
    private Date shipmentDate;
    private Origin origin;
    private Destination destination;
    
    @ManyToOne(targetEntity = ShipmentStatus.class)
    private ShipmentStatus shipmentStatus;


    public Shipment() {
    	this.trackingNumber = "SHIP" + idCounter;
    	idCounter ++; 
    }

    public Shipment(String trackingNumber, Origin origin, Destination destination, String dimensions, String description) {
        this.trackingNumber = "SHIP" + idCounter;
        this.shipmentDate = new Date();
        this.origin = origin;
        this.destination = destination;
        this.dimensions = dimensions;
        this.description = description;
        this.shipmentStatus = new ShipmentStatus(Status.Request_Made);
        idCounter ++;
    }

    /**
     * @return the trackingNumber
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * @return the shipmentDate
     */
    public Date getShipmentDate() {
        return shipmentDate;
    }

    /**
     * @return the origin
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    /**
     * @return the dimensions
     */
    public String getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the shipmentStatus
     */
    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }


}