package com.codegym.furama.controller;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.entity.customerModel.IRoom;
import com.codegym.furama.entity.customerModel.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Date;

@RequestMapping("/admin/hotel")
@Controller
public class HotelController {
    public Customer getCustomer(String email){
        return null;
    }

    public void createACustomer(String email, String firstName, String lastName){

    }

    public IRoom getRoom(String roomNumber){
        return null;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        return null;
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail){
        return null;
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return null;
    }
}
