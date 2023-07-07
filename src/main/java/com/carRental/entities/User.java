package com.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "User")
public class User extends BaseEntity{

    @GeneratedValue(strategy =GenerationType.IDENTITY )
   // private Long userId;
    private String fname;
    private String lname;
    private LocalDate dob;
    private  String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Booking> BookingList=new ArrayList<>();

    public List<Booking> getBookingList() {
        return BookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        BookingList = bookingList;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password=hashpw;
    }


}
