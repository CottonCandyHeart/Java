public interface IComplexCalculator {
    public String performOperation(ComplexNumber a, ComplexNumber b, String operand);
    public String sumComplex(ComplexNumber a, ComplexNumber b);
    public String subComplex(ComplexNumber a, ComplexNumber b);
    public String multComplex(ComplexNumber a, ComplexNumber b);
    public String divComplex(ComplexNumber a, ComplexNumber b);
}
