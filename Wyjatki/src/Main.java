public class Main {
    public static void main(String[] args) {
        Exceptions exception = new Exceptions("");
        int a = -5, b = 0;

        try {
            exception.zeroDivisionException(b);
            System.out.println(a/b);

            exception.negativeNumberException(a);
            System.out.println(Math.sqrt(a));

        } catch (Exceptions e) {
            System.out.println(e.getMessage());
        }

        int[] arr = {1,2,3,4,5};
        int index = 9;

        try {
            exception.indexOutOfRangeException(index,arr);
            System.out.println(arr[index]);
        } catch (Exceptions e) {
            System.out.println(e.getMessage());
        }

        String exampleString = "Hello, world!";

        try {
            exception.isOfTypeException(exampleString, String.class);
            exception.isOfTypeException(exampleString, Integer.class);
        } catch (Exceptions e) {
            System.out.println(e.getMessage());
        }

    }
}