package com.codegym.furama.entity.customerModel;

import com.codegym.furama.entity.Customer;

import java.util.Date;

public class Reservation {
    private Customer customer;

    private IRoom room;

    private Date checkinDate;

    private Date checkoutDate;

    public Reservation() {
    }

    public Reservation(Customer customer, IRoom room, Date checkinDate, Date checkoutDate) {
        this.customer = customer;
        this.room = room;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
