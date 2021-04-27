package calculator.numbers;


public final class RomanNumber implements Number<RomanNumber> {
    private String value;
    private int valueInt;

    private int converter(String number){
        int value = 0;
        number += "|";
        //100
        if(number.startsWith("C")){
            value = 100;
            number = number.substring(1);
        }
        if(number.startsWith("XC")){
            value = 90;
            number = number.substring(2);
        }

        //50
        if(number.startsWith("L")){
            value += 50;
            number = number.substring(1);
        }
        if(number.startsWith("XL")){
            value += 40;
            number = number.substring(2);
        }

        //30
        if(number.startsWith("XXX")){
            value += 30;
            number = number.substring(3);
        }
        if(number.startsWith("XX")){
            value += 20;
            number = number.substring(2);
        }
        if(number.startsWith("X")){
            value += 10;
            number = number.substring(1);
        }

        //10
        if(number.startsWith("IX")){
            value += 9;
            number = number.substring(2);
        }
        if(number.startsWith("V")){
            value += 5;
            number = number.substring(1);
        }
        if(number.startsWith("IV")){
            value += 4;
            number = number.substring(2);
        }
        if(number.startsWith("III")){
            value += 3;
            number = number.substring(3);
        }
        if(number.startsWith("II")){
            value += 2;
            number = number.substring(2);
        }
        if(number.startsWith("I")){
            value += 1;
            number = number.substring(1);
        }

        if(!number.equals("|")){
            throw new NumberFormatException(String.format("Невозможно преобразовать %s в RomanNumber", number.substring(0,number.length()-1)));
        }

        return value;
    }
    @Override
    public String getValue() {
        return value;
    }

    public RomanNumber(String number){
        valueInt = converter(number);
        value = number;
    }

    public RomanNumber(int number){
        if(number <= 0){
            throw new NumberFormatException(String.format("Невозможно преобразовать %d в RomanNumber", number));
        }

        valueInt = number;
        StringBuilder value = new StringBuilder();
        if(number>=100){
            value.append("C");
            number -= 100;
        }
        if(number>=90){
            value.append("XC");
            number -= 90;
        }
        if(number>=50){
            value.append("L");
            number -= 50;
        }
        if(number>=40){
            value.append("XL");
            number -= 40;
        }
        if(number>=30){
            value.append("XXX");
            number -= 30;
        }
        if(number>=20){
            value.append("XX");
            number -= 20;
        }
        if(number>=10){
            value.append("X");
            number -= 10;
        }

        if(number >= 9){
            value.append("IX");
            number -= 9;
        }
        if(number >= 5){
            value.append("V");
            number -= 5;
        }
        if(number >= 4){
            value.append("IV");
            number -= 4;
        }
        if(number >= 3){
            value.append("III");
            number -= 3;
        }
        if(number >= 2){
            value.append("II");
            number -= 2;
        }
        if(number >= 2){
            value.append("II");
            number -= 2;
        }
        if(number >= 1){
            value.append("I");
            number -= 1;
        }

        if(number != 0){
            throw new RuntimeException();
        }

        this.value = value.toString();
    }

    @Override
    public RomanNumber sum(RomanNumber number) {
        return new RomanNumber(toInt() + number.toInt());
    }

    @Override
    public RomanNumber mul(RomanNumber number) {
        return new RomanNumber(toInt() * number.toInt());
    }

    @Override
    public RomanNumber sup(RomanNumber number) {
        try {
            return new RomanNumber(toInt() - number.toInt());
        }catch (NumberFormatException e){
            throw new RuntimeException("Невозможно совершить вычитание.");
        }
    }

    @Override
    public RomanNumber div(RomanNumber number) {
        return new RomanNumber(toInt() / number.toInt());
    }

    @Override
    public int toInt() {
        return valueInt;
    }
}
