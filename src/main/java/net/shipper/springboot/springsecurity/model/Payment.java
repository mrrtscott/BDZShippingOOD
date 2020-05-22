
package net.shipper.springboot.springsecurity.model;

import java.util.Date;

public class Payment{
    private static int idCounter = 10000;
    private String paymentId;
    private double amount;
    private Date paymentDate;



    public Payment(){

    }

    public Payment(double amount){
        this.paymentId= "PAY" + idCounter;
        this.amount=amount;
        this.paymentDate= new Date();
        idCounter++;
    }


    /** 
     * @return the payment Id
     */

    public String getPaymentId(){
        return paymentId;

    }

 
    /** 
     * @return the amount to be paid
     */
    public Double getAmount(){
        return amount;

    }

    /**
     * @param [amount] Setting the payment amount
     */

    public void setAmount(Double amount){
        this.amount=amount;



    }

    /**
     * @return the payment date
     */
    public Date getPaymentDate(){
        return paymentDate;

    }

    /**
     * @param [paymentDate] Setting the payment date
     */

    public void setPaymentDate(Date paymentDate){
        this.paymentDate=paymentDate;



    }
    

}
