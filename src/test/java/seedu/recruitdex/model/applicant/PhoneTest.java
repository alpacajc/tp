package seedu.recruitdex.model.applicant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.recruitdex.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PhoneTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Phone(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidPhone = "91";
        assertThrows(IllegalArgumentException.class, () -> new Phone(invalidPhone));
    }

    @Test
    public void isValidPhone() {
        // null phone number
        assertThrows(NullPointerException.class, () -> Phone.isValidPhone(null));

        // invalid phone numbers
        assertFalse(Phone.isValidPhone(" ")); // spaces only
        assertFalse(Phone.isValidPhone("91")); // fewer than 3 digits
        assertFalse(Phone.isValidPhone("phone")); // no digits
        assertFalse(Phone.isValidPhone("12@345")); // unsupported character
        assertFalse(Phone.isValidPhone("12.345")); // unsupported punctuation

        // valid phone numbers
        assertTrue(Phone.isValidPhone("")); // not provided
        assertTrue(Phone.isValidPhone("911")); // exactly 3 numbers
        assertTrue(Phone.isValidPhone("93121534"));
        assertTrue(Phone.isValidPhone("124293842033123")); // long phone numbers
        assertTrue(Phone.isValidPhone("")); // phone is optional
        assertTrue(Phone.isValidPhone("91234567")); // digits
        assertTrue(Phone.isValidPhone("+65 9123-4567")); // permitted formatting
        assertTrue(Phone.isValidPhone("(212) 555-0123")); // parentheses
        assertTrue(Phone.isValidPhone("ABC 123")); // letters with at least 3 digits
        assertTrue(Phone.isValidPhone("9011p041")); // letters within digits
        assertTrue(Phone.isValidPhone("9312 1534")); // spaces within digits
    }

    @Test
    public void containsDigitsOnly() {
        assertTrue(new Phone("123").containsDigitsOnly());
        assertFalse(new Phone("+65 9123-4567").containsDigitsOnly());
        assertTrue(new Phone("").containsDigitsOnly()); // empty string has no non-digit characters
    }

    @Test
    public void equals() {
        Phone phone = new Phone("999");

        // same values -> returns true
        assertTrue(phone.equals(new Phone("999")));

        // same object -> returns true
        assertTrue(phone.equals(phone));

        // null -> returns false
        assertFalse(phone.equals(null));

        // different types -> returns false
        assertFalse(phone.equals(5.0f));

        // different values -> returns false
        assertFalse(phone.equals(new Phone("995")));
    }
}
