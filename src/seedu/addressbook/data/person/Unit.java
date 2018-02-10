package seedu.addressbook.data.person;

public class Unit {
    private String unit;

    public Unit(String unit) {
        this.unit = unit;
    }
    /**
     * Returns String of unit of person's address
     */
    public String getUnit(){
        return unit;
    }
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Unit
                && this.unit.equals(((Unit) other).getUnit()));
    }
}