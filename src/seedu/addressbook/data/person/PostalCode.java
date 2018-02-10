package seedu.addressbook.data.person;


public class PostalCode{
    private String postalCode;

    public PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * Returns String of postalCode of person's address
     */
    public String getPostalCode(){
        return postalCode;
    }
    public boolean equals(Object other) {
        return other == this
                || (other instanceof PostalCode
                && this.postalCode.equals(((PostalCode) other).getPostalCode()));
    }
}
