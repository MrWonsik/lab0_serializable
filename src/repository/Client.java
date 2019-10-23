package repository;

import java.io.Serializable;
import java.util.HashMap;

public class Client implements Serializable {
    private String surname;
    private String name;
    private String mail;
    private String phone;
    private String nameOfShow;
    private HashMap<Character, Integer> position;

    public Client(String surname, String name, String mail, String phone) {
        this.surname = surname;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.nameOfShow = null;
        this.position = null;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<Character, Integer> getPosition() {
        return position;
    }

    public void setPosition(HashMap<Character, Integer> position) {
        this.position = position;
    }

    public String getNameOfShow() {
        return nameOfShow;
    }

    public void setNameOfShow(String nameOfShow) {
        this.nameOfShow = nameOfShow;
    }
}
