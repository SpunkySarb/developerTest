package com.example.developerTest.model;

import java.util.ArrayList;

public class ContactList {

    public ArrayList<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }

    ArrayList<Contacts> contacts = new ArrayList<>();
}
