package calculator.numbers;

public final class ArabicNumber implements Number<ArabicNumber> {
    private int value;

    public ArabicNumber(String number){
        value = Integer.parseInt(number);
    }

    public ArabicNumber(int number){
        value = number;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public ArabicNumber sum(ArabicNumber number) {
        return new ArabicNumber(value + number.toInt());
    }

    @Override
    public ArabicNumber mul(ArabicNumber number) {
        return new ArabicNumber(value * number.toInt());
    }

    @Override
    public ArabicNumber sup(ArabicNumber number) {
        return new ArabicNumber(value - number.toInt());
    }

    @Override
    public ArabicNumber div(ArabicNumber number) {
        return new ArabicNumber(value / number.toInt());
    }

    @Override
    public int toInt() {
        return value;
    }
}
