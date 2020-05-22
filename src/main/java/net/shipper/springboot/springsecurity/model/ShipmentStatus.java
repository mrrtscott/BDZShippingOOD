package net.shipper.springboot.springsecurity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShipmentStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated(EnumType.STRING)
    private Status status;
    private Date dateChanged;
    private String shippingId;

    public ShipmentStatus() {}

    public ShipmentStatus(Status status) {
        this.status = status;
        this.dateChanged = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
        this.dateChanged = new Date();
    }

    /**
     * @return the dateChanged
     */
    public Date getDateChanged() {
        return dateChanged;
    }
    
    /**
     * @return the shippingId
     */
    public String getShippingId() {
        return shippingId;
    }

    /**
     * @param shippingId the shippingId to set
     */
    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }
}