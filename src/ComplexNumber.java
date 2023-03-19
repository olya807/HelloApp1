public record ComplexNumber(double re, double im) {

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;

        if ((this.re() != other.re()) || (this.im() != other.im())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        long real = Double.doubleToLongBits(this.re()); // harmonize NaN bit patterns
        long imag = Double.doubleToLongBits(this.im());
        if (real == 1L << 63) real = 0; // convert -0.0 to +0.0
        if (imag == 1L << 63) imag = 0;
        long h = real ^ imag;
        return (int) h ^ (int) (h >>> 32);
    }

}