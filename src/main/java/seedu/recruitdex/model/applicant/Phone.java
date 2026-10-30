package seedu.recruitdex.model.applicant;

import static java.util.Objects.requireNonNull;
import static seedu.recruitdex.commons.util.AppUtil.checkArgument;

/**
 * Represents an Applicant's phone number in RecruitDex.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Phone {

    public static final String DEFAULT_VALUE = "";
    public static final String MESSAGE_CONSTRAINTS =
            "Phone details must be empty or contain at least 3 digits on one line";
    public final String value;
    private static final String VALIDATION_REGEX = "[\\p{L}\\d+ ()-]+";

    /**
     * Constructs a {@code Phone}.
     *
     * @param phone A valid phone number, or empty if not provided.
     */
    public Phone(String phone) {
        requireNonNull(phone);
        checkArgument(isValidPhone(phone), MESSAGE_CONSTRAINTS);
        value = phone;
    }

    /**
     * Returns true if a given string is empty or a valid phone number.
     */
    public static boolean isValidPhone(String test) {
        return test.isEmpty()
                || (test.codePoints().filter(Character::isDigit).count() >= 3
                && test.matches(VALIDATION_REGEX));
    }

    public boolean containsDigitsOnly() {
        return value.codePoints().allMatch(Character::isDigit);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Phone otherPhone)) {
            return false;
        }

        return value.equals(otherPhone.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
