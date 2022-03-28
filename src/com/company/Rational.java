package com.company;

public class Rational {

    private int _numerator, _denominator;

    public Rational(int numerator, int denominator) throws IllegalArgumentException {
        this._numerator = numerator;
        this._denominator = 1;
        if (denominator <= 0)
            throw new IllegalArgumentException("Denominator must be Natural number");

        this._denominator = denominator;

    }

    public int getNumerator() {
        return this._numerator;
    }

    public int getDenominator() {
        return this._denominator;
    }


    public boolean greaterThan(Rational other) {
        return ((this._numerator * other.getDenominator()) > (this._denominator * other.getNumerator()));
    }


    public boolean equals(Rational other) {
        return ((this._numerator * other.getDenominator()) == (this._denominator * other.getNumerator()));
    }

    public Rational plus(Rational other) {
        Rational sum_rationals = null;
        int new_numerator = (this._numerator * other.getDenominator()) + (this._denominator * other.getNumerator());
        int new_denominator = this._denominator * other.getDenominator();
        try {
            sum_rationals = new Rational(new_numerator, new_denominator);
        } catch (IllegalArgumentException e) {
            System.out.println("At least one of your numbers has a denominator that equals zero.");
        }
        return sum_rationals;

    }

    public Rational minus(Rational other) {
        Rational sum_rationals = null;
        int new_numerator = (this._numerator * other.getDenominator()) - (this._denominator * other.getNumerator());
        int new_denominator = this._denominator * other.getDenominator();
        try {
            sum_rationals = new Rational(new_numerator, new_denominator);
        } catch (IllegalArgumentException e) {
            System.out.println("At least one of your numbers has a denominator that equals zero.");
        }
        return sum_rationals;
    }

    public Rational multiply(Rational other) {
        Rational sum_rationals = null;
        int new_numerator = (this._numerator * other.getNumerator());
        int new_denominator = this._denominator * other.getDenominator();
        try {
            sum_rationals = new Rational(new_numerator, new_denominator);
        } catch (IllegalArgumentException e) {
            System.out.println("At least one of your numbers has a denominator that equals zero.");
        }
        return sum_rationals;
    }

    public Rational divide(Rational other) throws ArithmeticException {//did not use multiply here because of unfitting error message
        Rational sum_rationals = null;
        if (other.getNumerator() == 0)
            throw new ArithmeticException("Denominator parameter is zero");
        int new_numerator = (this._numerator * other.getDenominator());
        int new_denominator = this._denominator * other.getNumerator();
        try {
            sum_rationals = new Rational(new_numerator, new_denominator);
        } catch (IllegalArgumentException e) {
            System.out.println("Returned number will have a denominator of zero");
        }
        return sum_rationals;
    }


    public Rational reduce() {
        Rational reduce_rational = null;
        int this_gcd = gcd(this._numerator, this._denominator);
        int new_numerator = (this._numerator / this_gcd);
        int new_denominator = (this._denominator / this_gcd);

        try {
            reduce_rational = new Rational(new_numerator, new_denominator);
        } catch (IllegalArgumentException e) {
            System.out.println("reduction results in a denominator of zero");
        }
        return reduce_rational;
    }

    private int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

    @Override
    public String toString() {
        String result = this._numerator + "/" + this._denominator;
        return result;
    }

}
