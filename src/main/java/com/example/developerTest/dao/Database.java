package com.example.developerTest.dao;

import com.example.developerTest.model.ContactList;
import com.example.developerTest.model.Contacts;
import com.example.developerTest.model.Users;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;

public class  Database {
    public String getContactsJson() {
        return contactsJson;
    }

    public void setContactsJson(String contactsJson) {
        this.contactsJson = contactsJson;
    }

    private String contactsJson;
    private int errorReport;

    public int getErrorReport() {
        return errorReport;
    }




    public void setErrorReport(int errorReport) {
        this.errorReport = errorReport;
    }



    static Connection conn = null;

    public void connect() {

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://92.249.44.52/u107689122_DeveloperTest?tcpKeepAlive=true&autoReconnect=true","u107689122_merisite","developerTest%123");
//here sonoo is database name, root is username and password

            System.out.println("Log : Connected To Database");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


    }




    public void addUser(Users user) {
connect();
        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();
            addStmt.executeUpdate("INSERT INTO `Users` (`username`, `password`) VALUES ('"+user.getUsername()+"', '"+user.getPassword()+"');");
            addStmt.close();

            setErrorReport(0); // Error report zero if data got inserted

        } catch (SQLException ex) {
            // handle any errors

            setErrorReport(1); // Error report zero if data got inserted


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }



    }



    public ArrayList<ContactList> readUserContacts(String username, String password) {

connect();
        ArrayList<ContactList> list = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT username, contacts FROM Users where username = '"+username+"' and password= '"+password+"';");
           setErrorReport(0);


            while (rs.next()) {


                String json = rs.getString("contacts");
                setContactsJson(json);
                System.out.println(json);
                Gson gson = new Gson();

                 ContactList contactList = gson.fromJson(json, ContactList.class);


                  list.add(contactList);

               


            }
            stmt.close();

        } catch (SQLException ex) {

            setErrorReport(1); // Error report zero if data is not available

            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return list;

    }


    public void addContact(String contactJson, String userName){
        connect();

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();
            addStmt.executeUpdate("UPDATE `Users` SET `contacts` = '"+contactJson+"' WHERE `Users`.`username` = '"+userName+"'; ");
            addStmt.close();

            setErrorReport(0); // Error report zero if data got inserted

        } catch (SQLException ex) {
            // handle any errors

            setErrorReport(1); // Error report zero if data got inserted


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


    }







}
