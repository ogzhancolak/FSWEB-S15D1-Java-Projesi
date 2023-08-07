package com.workintech.arraylist.mobilephone;

public class Main {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone("1234567890");
        Contact contact1 = Contact.createContact("Bob", "31415926");
        Contact contact2 = Contact.createContact("Alice", "16180339");
        Contact contact3 = Contact.createContact("Tom", "11235813");
        Contact contact4 = Contact.createContact("Jane", "23571113");

        mobilePhone.addNewContact(contact1);
        mobilePhone.addNewContact(contact2);
        mobilePhone.addNewContact(contact3);
        mobilePhone.addNewContact(contact4);

        mobilePhone.printContacts();

        Contact foundContact = mobilePhone.queryContact("Alice");
        if (foundContact != null) {
            System.out.println("Found contact: " + foundContact.getName() + " -> " + foundContact.getPhoneNumber());
        } else {
            System.out.println("Contact not found.");
        }
    }
}