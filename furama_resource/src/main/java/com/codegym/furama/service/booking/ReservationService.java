package com.codegym.furama.service.booking;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.entity.customerModel.IRoom;
import com.codegym.furama.entity.customerModel.Reservation;
import com.codegym.furama.entity.customerModel.Room;

import java.util.*;

public class ReservationService {
    public static final List<Room> roomList = new ArrayList<Room>();

    public void addRoom(IRoom room){

    }

    public List<Room> getAllRooms(){
        return null;
    }

    public IRoom getRoom(String roomId){
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        return null;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        return null;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer){
        return null;
    }

    public void printAllReservation(){
    }

}
