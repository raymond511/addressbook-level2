package seedu.addressbook.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility methods
 */
public class Utils {

    /**
     * Returns true if any of the given items are null.
     */
    public static boolean isAnyNull(Object... items) {
        for (Object item : items) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if every element the given collection are unique by {@link Object#equals(Object)}.
     */
    public static boolean elementsAreUnique(Collection<?> items) {
        final Set<Object> testSet = new HashSet<>();
        for (Object item : items) {
            final boolean itemAlreadyExists = !testSet.add(item); // see Set documentation
            if (itemAlreadyExists) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param set of String
     * @return the same set with all the strings in lowercase
     */
    public static Set<String> getStringInLowerCase(Set<String> set) {
        Set<String> stringsInLowerCase = new HashSet<>();
        for (String s : set) {
            stringsInLowerCase.add(s.toLowerCase());
        }
        return stringsInLowerCase;
    }
}
