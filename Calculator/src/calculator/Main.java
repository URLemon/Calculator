package calculator;

import calculator.numbers.ArabicNumber;
import calculator.numbers.Number;
import calculator.numbers.RomanNumber;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Number a,b;
        String[] q = scanner.nextLine().trim().split(" ");

        if(q.length != 3){
            throw new RuntimeException("Неверная конструкция входного выражения");
        }

        try{
            a = new ArabicNumber(q[0]);
            b = new ArabicNumber(q[2]);
            if(a.toInt() < 1 || 10 < a.toInt() || b.toInt() < 1 || 10 < b.toInt()){
                throw new NumberFormatException("Неверный формат данных");
            }
        }
        catch (Exception e){
            a = null;
            b = null;
        }


        if(a==null){
            a = new RomanNumber(q[0]);
            b = new RomanNumber(q[2]);
            if(a.toInt() < 1 || 10 < a.toInt() || b.toInt() < 1 || 10 < b.toInt()){
                throw new NumberFormatException("Неверный формат данных");
            }
        }

        if(q[1].equals("+")){
            System.out.println(a.sum(b).getValue());
        }
        else if(q[1].equals("-")){
            System.out.println(a.sup(b).getValue());
        }
        else if(q[1].equals("*")){
            System.out.println(a.mul(b).getValue());
        }
        else if(q[1].equals("/")){
            System.out.println(a.div(b).getValue());
        }
        else{
            throw new NumberFormatException("Неизвестная операция");
        }

    }
}
