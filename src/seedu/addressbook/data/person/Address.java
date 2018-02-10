package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #01-01, Singapore 100100";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the format: BLOCK, STREET, UNIT, POSTAL_CODE";
    private static final String TO_STRING_FORMAT = "%s, %s, %s, %s";
    private static final String ADDRESS_VALIDATION_REGEX = "[\\w ]+, [\\w ]+, [\\w \\-#]+, [\\w ]+";

    private static final int ADDRESS_BLOCK_INDEX = 0;
    private static final int ADDRESS_STREET_INDEX = 1;
    private static final int ADDRESS_UNIT_INDEX = 2;
    private static final int ADDRESS_POSTAL_CODE_INDEX = 3;

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        block = new Block(trimmedAddress.split(", ")[ADDRESS_BLOCK_INDEX]);
        street = new Street(trimmedAddress.split(", ")[ADDRESS_STREET_INDEX]);
        unit = new Unit(trimmedAddress.split(", ")[ADDRESS_UNIT_INDEX]);
        postalCode = new PostalCode(trimmedAddress.split(", ")[ADDRESS_POSTAL_CODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT,block.getBlock(), street.getStreet(),
                unit.getUnit(), postalCode.getPostalCode());
    }
    private Block getBlock(){ return block; }
    private Street getStreet(){ return street; }
    private Unit getUnit(){ return unit; }
    private PostalCode getPostalCode(){ return postalCode; }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }

        if (!(other instanceof Address)){
            return false;
        }

        Address otherAddress = (Address) other;
        return block.equals(otherAddress.getBlock())
                && street.equals(otherAddress.getStreet())
                && unit.equals(otherAddress.getUnit())
                && postalCode.equals(otherAddress.getPostalCode());
    }

    @Override
    public int hashCode() {
        String hashCode;
        hashCode = String.format(block.getBlock(), street.getStreet(),
                unit.getUnit(), postalCode.getPostalCode());
        return hashCode.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
