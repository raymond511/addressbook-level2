package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "546, Dover Street 51, #01-01, 654825";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in this format: BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String splitAddress[] = trimmedAddress.split(",");
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        else {
            block = new Block(splitAddress[0]);
            street = new Street(splitAddress[1]);
            unit = new Unit(splitAddress[2]);
            postalCode = new PostalCode(splitAddress[3]);
        }
        this.value = trimmedAddress;
    }
    public class Block {
        private String block;

        public Block (String block) {
            this.block = block;
        }
        /**
         * Returns String of block
         */
        public String getBlock() {
            return block;
        }
    }
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
    class Street {
        private String street;

        public Street(String street) {
            this.street = street;
        }
        /**
         * Returns String of street
         */
        public String getStreet(){
            return street;
        }
    }
    public class Unit {
        private String unit;

        public Unit(String unit) {
            this.unit = unit;
        }
        /**
         * Returns String of unit.
         */
        public String getUnit(){
            return unit;
        }
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
