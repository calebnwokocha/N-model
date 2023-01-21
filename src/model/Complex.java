package model;

public class Complex {
    private Double real;
    private Double imaginary;

    public Complex (Double real, Double imaginary) { this.real = real; this.imaginary = imaginary; };

    public Double getImaginary() { return imaginary; }

    public Double getReal() { return real; }

    public void setImaginary(Double imaginary) { this.imaginary = imaginary; }

    public void setReal(Double real) { this.real = real; }

    public void add (Complex number) {
        this.real += number.real;
        this.imaginary += number.imaginary;
    }

    public void subtract (Complex number) {
        this.real -= number.real;
        this.imaginary -= number.imaginary;
    }

    public void multiply (Complex number) {
        Double realTemp = this.real;
        this.real *= number.real;
        this.real -= (this.imaginary * number.imaginary);
        this.imaginary = (realTemp * number.imaginary) + (this.imaginary * number.real);
    }

    public void divide (Complex number) {
        Double realTemp = this.real;
        this.real = ((this.real * number.real) + (this.imaginary * number.imaginary)) /
                (Math.pow(number.real, 2) + Math.pow(number.imaginary, 2));
        this.imaginary = ((this.imaginary * number.real) - (realTemp * number.imaginary)) /
                (Math.pow(number.real, 2) + Math.pow(number.imaginary, 2));
    }
}
