package com.solvd.taxi.model.person;
import java.time.LocalDate;

import com.solvd.taxi.model.location.Locatable;
import com.solvd.taxi.model.location.PointLocation;
import com.solvd.taxi.model.user.IUser;

public abstract class Person implements IUser, Locatable{

    private String name;
    private String lastName;
    private int id;
    private LocalDate birthDate;
    private PointLocation location;
    private String email;
    private String phoneNumber;

    public Person (String name, String lastName, int id, LocalDate birthDate, String phoneNumber, String email, PointLocation location){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
        this.location = location;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return String.format("""
                PERSON 
                { id: %s
                  full name: %s %s }
                """,
                id,
                name,
                lastName
        );
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }

    @Override
    public PointLocation getLocation(){
        return location;
    }

    @Override
    public void setLocation(PointLocation location){
        this.location = location;
    }

    @Override
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    @Override
    public String getEmail(){
        return this.email;
    }

    @Override
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getId(){
        return this.id;
    }

    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

}
