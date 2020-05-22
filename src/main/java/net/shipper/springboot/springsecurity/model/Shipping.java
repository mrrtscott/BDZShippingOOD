package net.shipper.springboot.springsecurity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Shipping {

    
    private static int idCounter = 1000;
    
    @Id
    private String trackingNumber;
    private String dimensions, description;
    private Date shipmentDate;
    private int customerId;
    @Enumerated(EnumType.STRING)
    private Origin origin;
    @Enumerated(EnumType.STRING)
    private Destination destination;
    
    
	/*
	 * @ManyToOne(targetEntity = ShipmentStatus.class) private ShipmentStatus
	 * shipmentStatus;
	 */
    private String shipmentStatus;
    private Double price;
    private BillingMethod billingMethod;
    

    public Shipping() {
    	this.trackingNumber = "SHIP" + idCounter;
        this.shipmentDate = new Date();
        idCounter ++;
    }
    
    public Shipping(String trackingNumber, Origin origin, Destination destination, String dimensions, String description, int customerId, String shipmentStatus,Double price) {
        this.trackingNumber = "SHIP" + idCounter;
        this.shipmentDate = new Date();
        this.origin = origin;
        this.destination = destination;
        this.dimensions = dimensions;
        this.description = description;
        this.shipmentStatus = shipmentStatus;
        this.customerId = customerId;
        this.price=price;
        idCounter ++;
    }
    
    /**
     * @param trackingNumber the trackingNumber to set
     */
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
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
    public void setOrigin(String origin) {
        this.origin = Origin.valueOf(origin);
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
    public void setDestination(String destination) {
        this.destination = Destination.valueOf(destination);
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
    public String getShipmentStatus() {
        return shipmentStatus;
    }
    
    /**
     * @param shipmentStatus the shipmentStatus to set
     */
    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }
    
    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }


    /**
     * @return the price
     */
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	  /**
     * @return the billingMethod
     */
    public BillingMethod getBillingMethod() {
        return billingMethod;
    }

    /**
     * @param billingMethod the billingMethod to set
     */
    public void setBillingMethod(BillingMethod billingMethod) {
        this.billingMethod = billingMethod;
    }

}
    
