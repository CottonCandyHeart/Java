public class ComplexCalculator implements IComplexCalculator {

    public String performOperation(ComplexNumber a, ComplexNumber b, String operand){

        String value;

        switch (operand) {
            case "+":
                value = sumComplex(a,b);
                break;
            case "-":
                value = subComplex(a,b);
                break;
            case "*":
                value = multComplex(a,b);
                break;
            case "/":
                if (b.getReal() == 0 && b.getImaginary() == 0) {
                    value = "Cannot divide by 0";
                } else {
                    value = divComplex(a,b);
                }
                break;
            default:
                value = "error";
        }

        return value;
    }

    public String sumComplex(ComplexNumber a, ComplexNumber b){
        double real = 0, imaginary = 0;

        real = a.getReal() + b.getReal();
        imaginary = a.getImaginary() + b.getImaginary();
        return (real + (imaginary > 0 ? "+" : "") + (imaginary != 0 ? (imaginary + "i") : ""));
    }
    public String subComplex(ComplexNumber a, ComplexNumber b){
        double real = 0, imaginary = 0;

        real = a.getReal() - b.getReal();
        imaginary = a.getImaginary() - b.getImaginary();
        imaginary *= (-1);

        return (real + (imaginary > 0 ? "+" : "") + (imaginary != 0 ? (imaginary + "i") : ""));
    }
    public String multComplex(ComplexNumber a, ComplexNumber b){
        double real = 0, imaginary = 0;

        real = (a.getReal() * b.getReal()) + (a.getImaginary() * b.getImaginary() * (-1));
        imaginary = (a.getReal() * b.getImaginary()) + (a.getImaginary() * b.getReal());

        return (real + (imaginary > 0 ? "+" : "") + (imaginary != 0 ? (imaginary + "i") : ""));
    }
    public String divComplex(ComplexNumber a, ComplexNumber b){
        double real = 0, imaginary = 0;

        //licznik i mianownik
        double nominatorReal = 0, nominatorIm = 0, denominator = 0;

        denominator = b.getReal() + (b.getImaginary() * (-1));

        real = (a.getReal() * b.getReal()) + (a.getImaginary() * b.getImaginary());
        imaginary = (a.getReal() * b.getImaginary() * (-1)) + (a.getImaginary() * b.getReal());

        nominatorReal = real / denominator;
        nominatorIm = imaginary / denominator;

        return (nominatorReal + (nominatorIm > 0 ? "+" : "") + (nominatorIm != 0 ? (nominatorIm + "i") : ""));
    }

}