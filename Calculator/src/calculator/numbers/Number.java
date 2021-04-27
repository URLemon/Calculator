package calculator.numbers;

public interface Number<T extends Number> {
    String getValue();
    int toInt();
    T sum(T number);
    T mul(T number);
    T sup(T number);
    T div(T number);
}
