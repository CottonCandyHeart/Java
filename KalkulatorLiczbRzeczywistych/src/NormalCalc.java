public class NormalCalc implements INormalCalc {

    public String performOperation(double a, double b, String operand){

        String value;

        switch (operand) {
            case "+":
                value = "" + (a+b);
                break;
            case "-":
                value = "" + (a-b);
                break;
            case "*":
                value = "" + (a*b);
                break;
            case "/":
               if (b == 0){
                   value = "Cannot divide by 0";
               }else{
                   value = "" + (a/b);
               }
               break;
            default:
                value = "error";
        }

        return value;
    }

}
