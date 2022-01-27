/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.action;

import com.quotation.dao.DealerDao;
import com.quotation.pojos.Dealer;
import java.sql.SQLException;

public class DealerAction {

    private int dealerId;
    private String dealerUserName;
    private String password;
    private String dealerFirstName;
    private String dealerLastName;
    private String dealerAddress;
    private String dealerEmailId;
    private String dealerContactInfo;
    private String zipcode;
    private String msg;

    /**
     * @return the dealerId
     */
    public int getDealerId() {
        return dealerId;
    }

    /**
     * @param dealerId the dealerId to set
     */
    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    /**
     * @return the dealerUserName
     */
    public String getDealerUserName() {
        return dealerUserName;
    }

    /**
     * @param dealerUserName the dealerUserName to set
     */
    public void setDealerUserName(String dealerUserName) {
        this.dealerUserName = dealerUserName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the dealerFirstName
     */
    public String getDealerFirstName() {
        return dealerFirstName;
    }

    /**
     * @param dealerFirstName the dealerFirstName to set
     */
    public void setDealerFirstName(String dealerFirstName) {
        this.dealerFirstName = dealerFirstName;
    }

    /**
     * @return the dealerLastName
     */
    public String getDealerLastName() {
        return dealerLastName;
    }

    /**
     * @param dealerLastName the dealerLastName to set
     */
    public void setDealerLastName(String dealerLastName) {
        this.dealerLastName = dealerLastName;
    }

    /**
     * @return the dealerAddress
     */
    public String getDealerAddress() {
        return dealerAddress;
    }

    /**
     * @param dealerAddress the dealerAddress to set
     */
    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }

    /**
     * @return the dealerEmailId
     */
    public String getDealerEmailId() {
        return dealerEmailId;
    }

    /**
     * @param dealerEmailId the dealerEmailId to set
     */
    public void setDealerEmailId(String dealerEmailId) {
        this.dealerEmailId = dealerEmailId;
    }

    /**
     * @return the dealerContactInfo
     */
    public String getDealerContactInfo() {
        return dealerContactInfo;
    }

    /**
     * @param dealerContactInfo the dealerContactInfo to set
     */
    public void setDealerContactInfo(String dealerContactInfo) {
        this.dealerContactInfo = dealerContactInfo;
    }

    public String dealerLogin() throws SQLException {
        String status;
        Dealer dealer = DealerDao.login(dealerEmailId, password);
        System.out.println("Dealer object: " + dealer);
        if (dealer != null) {
            System.out.println("Successfully Logged In");
            setMsg("Successfully Logged In");
            status = "LoggedIn";
        } else {
            System.out.println("invalid userid ot password");
            setMsg("invalid userid ot password");
            status = "Failed";
        }
        return status;
    }

    public String dealerRegister() {
        String status;
        int i = DealerDao.register(dealerUserName, password, dealerFirstName, dealerLastName, dealerAddress, dealerEmailId, dealerContactInfo, zipcode);
        if (i > 0) {
            System.out.println("Successfully registered");
            status = "Registered";
        } else {
            setMsg("User Already Exist");
            System.out.println("Cant register");
            status = "Failed";
        }
        return status;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
