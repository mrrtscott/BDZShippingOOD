package net.shipper.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manifest {
	
    
    @Id
    private String manifestNumber;
    
    private String shipments;
    private String vessel;
    private String container;

    public Manifest(){
    }

    public Manifest(String shipments, String vessel, String manifestNumber, String container){
        
        this.shipments = shipments;
        this.vessel=vessel;
        this.manifestNumber = manifestNumber;
        this.container = container;
    }
    
//    /**
//     * @return the number of Shipments
//     */
//    public int getNumberOfShipments(){
//
//        return this.shipments.size();
//
//    }

    /**
     * @return the vessel
     */
    public String getVessel() {
        return vessel;
    }

    /**
     * @param vessel the vessel to set
     */
    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    /**
     * @return the manifestNumber
     */
    public String getManifestNumber() {
        return manifestNumber;
    }
    

    /**
     * @param manifestNumber the manifestNumber to set
     */
    public void setManifestNumber(String manifestNumber) {
        this.manifestNumber = manifestNumber;
    }

    /**
     * @return the shipments
     */
    public String getShipments() {
        return shipments;
    }

    /**
     * @param shipments the shipments to set
     */
    public void setShipments(String shipments) {
        this.shipments = shipments;
    }

//    /**
//     * @param shipment the shipment to add
//     */
//    public void addShipment(Shipping shipment) {
//        this.shipments.add(shipment);
//    }

    /**
     * @return the container
     */
    public String getContainer() {
        return container;
    }

    /**
     * @param container the container to set
     */
    public void setContainer(String container) {
        this.container = container;
    }

}
    
