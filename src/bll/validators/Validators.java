package bll.validators;

/**
 * Interface for validate Object
 * @param <T> generic param
 */
public interface Validators<T> {
    /**
     * Method for validating an Object
     * @param t object to be validated
     */
    public void validate(T t);
}
