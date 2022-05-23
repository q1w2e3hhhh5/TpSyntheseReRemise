package com.example.tp3.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String password;
    private String fullName;
    private int fee;

    @OneToMany(mappedBy = "document")
    private List<Borrow> borrows;


    public Client(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.borrows = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "\n" +
                "\t" + "ID : " + id + "\n" +
                "\t\t" + "Email : " + email + "\n" +
                "\t\t" + "Password : " + password + "\n" +
                "\t\t" + "Full Name : " + fullName + "\n" +
                "\t\t" + "Fee To Pay : " + fee + "\n" +
                "\t\t" + "List of borrows : " + borrows + "\n";
    }

    public void addBorrow(Borrow borrow){
        borrows.add(borrow);
        borrow.setClient(this);
    }

    public void removeBorrow(Borrow borrow){
        borrows.remove(borrow);
        borrow.setClient(null);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
