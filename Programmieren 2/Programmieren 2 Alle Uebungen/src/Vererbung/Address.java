package Vererbung;

public class Address {
    private String street;
    private String zip;
    private String city;
    private String country;

    public Address(String street, String city, String country, String zip) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
