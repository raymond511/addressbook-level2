package seedu.addressbook.data.person;

public class Block {
    private String block;

    public Block (String block) {
        this.block = block;
    }
    /**
     * Returns String of block of person's address
     */
    public String getBlock() {
        return block;
    }
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Block
                && this.block.equals(((Block) other).getBlock()));
    }
}