package com.company;

public class Rational {

    private int _numerator, _denominator;

    /**
     * constructor for Rational number
     *
     * @param numerator   - the numerator of the rational number
     * @param denominator - the denominator of the rational number
     * @throws IllegalArgumentException for a denominator that equals zero
     */
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
        this._numerator = numerator;
        this._denominator = 1;
        if (denominator <= 0)
            throw new IllegalArgumentException("Denominator must be Natural number");

        this._denominator = denominator;

    }

    /**
     * getter for Numerator
     *
     * @return the Rational's numerator
     */
    public int getNumerator() {
        return this._numerator;
    }

    /**
     * getter for denominator
     *
     * @return the Rational's denominator
     */
    public int getDenominator() {
        return this._denominator;
    }

    /**
     * this function returns whether or not this Rational number is bigger then the given param
     *
     * @param other param to compare to
     * @return boolean indicating whether or not this Rational number is bigger then the given param
     */
    public boolean greaterThan(Rational other) {
        return ((this._numerator * other.getDenominator()) > (this._denominator * other.getNumerator()));
    }

    /**
     * this function returns whether or not this Rational number and the param are equal
     *
     * @param other param to compare to
     * @return boolean indicating whether or not this Rational number and the param are equal
     */
    public boolean equals(Rational other) {
        return ((this._numerator * other.getDenominator()) == (this._denominator * other.getNumerator()));
    }

    /**
     * this function addition between this Rational and the param
     *
     * @param other param to add to
     * @return a new result Rational number
     */
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

    /**
     * this function subtraction between this Rational and the param
     *
     * @param other param to subtract with
     * @return a new result Rational number
     */
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

    /**
     * this function multiplication between this Rational and the param
     *
     * @param other param to multiply with
     * @return a new result Rational number
     */
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

    /**
     * this function divides between this Rational and the param
     *
     * @param other param to divide with
     * @return a new result Rational number
     * @throws ArithmeticException for a param that equals 0
     */
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

    /**
     * this function reduces this Rational
     *
     * @return a new result Rational
     */
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
        if (x < 0)
            x *= -1;
        if (y < 0)
            y *= -1;
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
