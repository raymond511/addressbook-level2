package seedu.addressbook.data.person;

public class Street {
    private String street;

    public Street(String street) {
        this.street = street;
    }
    /**
     * Returns String of street of person's address
     */
    public String getStreet(){
        return street;
    }
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Street
                && this.street.equals(((Street) other).getStreet()));
    }
}
