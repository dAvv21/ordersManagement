package bll.validators;

import model.Order;

/**
 * This method validates the input for order size in textfield for order
 */
public class OrderSizeValidator implements Validators<Order> {
    private static final int MIN_ORDER = 0;

    /**
     * This method validates if the input is a interger
     * @param t integer to be validated
     * boolean
     */
    private boolean isInt(int t){
        try {
            Integer.parseInt(String.valueOf(t));
            return true;
        }catch (NumberFormatException e){
            System.out.println(t + " is not a valid integer");
        }
        return false;

    }

    /**
     * This method validates the input for order size in textfield for order
     * @param t Order to be validated
     */
    public void validate(Order t) {

        if (t.getOrderSize() < MIN_ORDER && isInt(t.getOrderSize()) ) {
            throw new IllegalArgumentException("The minimum order size limit is not respected!");
        }
    }
}
