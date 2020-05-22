package net.shipper.springboot.springsecurity.web.dto;

import net.shipper.springboot.springsecurity.model.BillingMethod;

public class ShippingDto {

	private String trackingNumber;
	
	private String description;

	private String origin;

	private String destination;

	private String dimensions;
	
	private int customerId;
	
	private String shipmentDate;
	
	private String shipmentStatus;
	
	private Double price;
	
	private BillingMethod billingMethod;
	
	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}
	
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDimensions() { 
		return dimensions; 
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions; 
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getShipmentDate() { 
		return shipmentDate; 
	}
	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate; 
	}
	
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	
	public void setShipmentStatusId(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public BillingMethod getBillingMethod() {
		return billingMethod;
	}

	public void setBillingMethod(BillingMethod billingMethod) {
		this.billingMethod = billingMethod;
	}

	
}
