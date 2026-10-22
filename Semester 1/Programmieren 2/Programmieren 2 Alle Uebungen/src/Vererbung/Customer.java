package Vererbung;

import java.util.ArrayList;

public class Customer extends Person{
    private int customerNumber;
    private ArrayList<Address> addresses =  new ArrayList<>();

    public Customer(String firstName, String lastName, int customerNumber) {
        super(firstName, lastName); // inherited from Person

        this.customerNumber = customerNumber;
    }


    public void addAddress(Address a){
        this.addresses.add(a);

    }

    @Override
    public String toString() {
        return "Customer " + customerNumber + ": " + super.toString();
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
}


