public class Kalkulator implements IKalkulator {
    // VARIABLES
    private String[] arr_s;
    ComplexNumber a;
    ComplexNumber b;
    boolean complex;
    double x;
    double y;
    String result;
    char constant;

    // MATHEMATICAL CONSTANTS
    public Kalkulator(){
        printMathConst();
    }
    // CALCULATIONS
    public Kalkulator(String operation){
        arr_s = operation.split(" ");

        if (arr_s[1].contains("i") || arr_s[2].contains("i")){  // is complex
            complex = true;

                int indexOfSign = -1;

            // first number
                if (arr_s[1].contains("i")){
                    if (arr_s[1].contains("+")){
                        indexOfSign = arr_s[1].indexOf("+");
                        a = new ComplexNumber(Double.parseDouble(arr_s[1].substring(0,indexOfSign)),Double.parseDouble(arr_s[1].substring(indexOfSign+1,arr_s[1].length()-1)));
                    }else if(arr_s[1].contains("-")){
                        indexOfSign = arr_s[1].indexOf("-");
                        a = new ComplexNumber(Double.parseDouble(arr_s[1].substring(0,indexOfSign)),Double.parseDouble(arr_s[1].substring(indexOfSign+1,arr_s[1].length()-1)) * (-1));
                    }
                }else{
                    a = new ComplexNumber(Double.parseDouble(arr_s[1]),0);
                }

                // second number
                if (arr_s[2].contains("i")){
                    if (arr_s[2].contains("+")){
                        indexOfSign = arr_s[2].indexOf("+");
                        b = new ComplexNumber(Double.parseDouble(arr_s[2].substring(0,indexOfSign)),Double.parseDouble(arr_s[2].substring(indexOfSign+1,arr_s[2].length()-1)));
                    }else if(arr_s[2].contains("-")) {
                        indexOfSign = arr_s[2].indexOf("-");
                        b = new ComplexNumber(Double.parseDouble(arr_s[2].substring(0, indexOfSign)),Double.parseDouble(arr_s[2].substring(indexOfSign + 1, arr_s[2].length() - 1)) * (-1));
                    }
                }else {
                    b = new ComplexNumber(Double.parseDouble(arr_s[2]),0);
                }

        }else{  // normal calculations
            x = Double.parseDouble(arr_s[1]);
            y = Double.parseDouble(arr_s[2]);

        }

    }

    public void getResult(){
        if (complex){
            ComplexCalculator calc = new ComplexCalculator();
            result = calc.performOperation(a, b, arr_s[0]);
        }else{
            NormalCalc nrm = new NormalCalc();
            result = nrm.performOperation(x,y,arr_s[0]);
        }
    }
    public void printResult(){
        System.out.println(arr_s[1] + " " + arr_s[0] + " " + arr_s[2] + " = " + result);
    }

    public void printMathConst(){
        System.out.println("Zmienne: ");
        System.out.println("\t1. PI ");
        System.out.println("\t2. e ");
        System.out.println("\t3. fi ");
        System.out.println("\t4. Stala Eulera: ");
    }

    public double getMathConst(int num){
        MathConst mc = new MathConst();
        return switch (num) {
            case 1 -> mc.getPI();
            case 2 -> mc.getE();
            case 3 -> mc.getFI();
            case 4 -> mc.getEuler();
            default -> 0;
        };

    }
}
