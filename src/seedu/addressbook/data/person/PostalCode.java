package seedu.addressbook.data.person;


public class PostalCode{
    private String postalCode;

    public PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * Returns String of postalCode
     */
    public String getPostalCode(){
        return postalCode;
    }
}
