package net.shipper.springboot.springsecurity.model;

public class Branch {
    private static int idCounter = 10000;
    private String branchID, branchName, branchLocation;

    public Branch() {}

    public Branch(String branchID, String branchName, String branchLocation) {
        this.branchID = "BRAN" + idCounter;
        this.branchName = branchName;
        this.branchLocation = branchLocation;
    }

    /**
     * @return the branchID
     */
    public String getBranchID() {
        return branchID;
    }

    /**
     * @return the branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName the branchName to set
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * @return the branchLocation
     */
    public String getBranchLocation() {
        return branchLocation;
    }

    /**
     * @param branchLocation the branchLocation to set
     */
    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

}