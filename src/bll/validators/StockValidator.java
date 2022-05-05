package bll.validators;

import model.Product;

/**
 * This class validates de input for stock
 */

public class StockValidator implements Validators<Product> {
    private static final int MIN_STOCK = 0;

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
     * This method validates the input for stock in textfield for stock
     * @param t Product to be validated
     */
    public void validate(Product t) {

        if (t.getStock() < MIN_STOCK && isInt(t.getStock()) ) {
            throw new IllegalArgumentException("The minimum stock limit is not respected!");
        }
    }

}
