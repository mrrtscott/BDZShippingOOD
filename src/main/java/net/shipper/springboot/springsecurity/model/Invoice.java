package net.shipper.springboot.springsecurity.model;

import java.util.ArrayList;

public class Invoice{

    private static int idCounter = 10000;
    private String invoiceNumber;
    private double cost;
    private int numberOfItems;
    private ArrayList<Payment> payments;

    public Invoice(double cost, int numberOfItems){

        this.invoiceNumber= "INV" + idCounter;
        this.cost=cost;
        this.numberOfItems=numberOfItems;
        this.payments = new ArrayList<Payment>();
        idCounter++;


    }


    /**
     * @return invoice's number
     */
        public String getInvoiceNumber(){

        return invoiceNumber;

        }

     /**
      * @return cost
      */

      public double getCost(){
        return cost;


      }
      /**
       * @param [cost] the cost of the shipment
       */
      public void setCost(double cost){

        this.cost=cost;

      }

      /**
       * @return numberOfItems
       */

    public int getNumberOfItems(){

        return numberOfItems;
    
    }
    /**
     * @param [numberOfItems] the number of items in the shipment
    */

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;


    }

    /**
     * @return the payments
     */
    public ArrayList<Payment> getPayments() {
        return payments;
    }

    /**
     * @param payments the payments to set
     */
    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    /**
     * @param payment the payment to add
     */
    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

}
