public class Exceptions extends RuntimeException {
    private String errorMessage;

    public Exceptions (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void zeroDivisionException (int value) {
        if (value == 0)
            throw new Exceptions("Exception: Division by zero");

    }
    public void negativeNumberException (int value){
        if (value < 0)
            throw new Exceptions("Exception: Value " + value + " can't be less than 0");
    }
    public void indexOutOfRangeException (int index, int[] arr){
        if (index < 0 || index >= arr.length)
            throw new Exceptions("Exception: Index out of range");
    }

    public void isOfTypeException(Object obj, Class<?> targetType) {
        if (targetType.isInstance(obj))
            throw new Exceptions("Exception: Object '" + obj + "' is not a type of " + targetType);
    }

    public String getMessage() {
        return errorMessage;
    }

}

