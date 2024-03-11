public class ComplexNumber implements IComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Metody do operacji na liczbach zespolonych
    // ...

    public String toString(){
        if (real != 0){
            return (real + " + " + imaginary + "i");
        }else{
            return (imaginary + "i");
        }
    }

    // Gettery i settery
    // ...

    public void setReal(double x){
        real = x;
    }
    public double getReal(){
        return real;
    }
    public void setImaginary(double x){
        imaginary = x;
    }
    public double getImaginary(){
        return imaginary;
    }
}
