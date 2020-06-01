package test.javamentor;

import java.util.Scanner;

public class ArithmeticExpression {

    private int  flag = 0;
    private String firstValue = "";
    private String secondValue = "";
    private String operator = "";


    Scanner scanner = new Scanner(System.in);
    RomanToArabic perevod = new RomanToArabic();

    public String getFirstValue() {
        return firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public String getOperator() {
        return operator;
    }

    public int getFlag() {
        return flag;
    }



    public void lineReader() {
        System.out.println("Input your expression: ");

        try {
            this.firstValue = scanner.next();                                        // вводим первое значение и проводим проверки
            if(isRoman(firstValue)) {
                if(!inRange(perevod.romanToArabic(firstValue))) {
                    throw new IndexOutOfBoundsException();
//                    System.out.println("Бросить исключение что 1 значение не в диапазоне и завершить работу");
                }else {
                    this.flag = 1;
                }
            }else {
                if(!inRange(Integer.parseInt(firstValue))) {
                    throw new IndexOutOfBoundsException ();
//                    System.out.println("Бросить исключение что 1 значение не в диапазоне и завершить работу");
                }
            }
        } catch (IndexOutOfBoundsException  ex) {
            System.out.println("First value out of range");
            System.exit(1);
        }


        try {
            this.operator = scanner.next();                                       // вводим оператор и проверяем подходит ли он
            if(!rightOperator(operator)) {
                throw new IllegalArgumentException();
//                System.out.println("Бросить исключение, что оператор не тот и завевршить работу");
            }
        } catch (Exception e) {
            System.out.println("Wrong operator");
            System.exit(1);
        }


        try {
            this.secondValue = scanner.next();                                  //вводим второй символ и проводим проверки в том числе совпадает ли тип знака с первым значение
            if(isRoman(secondValue)) {
                if (this.flag == 0) {
                    throw  new NumberFormatException();
//                    System.out.println("Бросить иключение, что цифры разных типов и завершить работу");
                }
                if(!inRange(perevod.romanToArabic(secondValue))) {
                    throw new IndexOutOfBoundsException ();
//                    System.out.println("Бросить исключение что 2 значение не в диапазоне и завершить работу");
                }
            }else {
                if (this.flag  == 1) {
                    throw  new NumberFormatException();
 //                   System.out.println("Бросить исключение, что цифры разных типов и завершить работу");
                }
                if(!inRange(Integer.parseInt(secondValue))) {
                    throw new IndexOutOfBoundsException ();
//                    System.out.println("Бросить исключение что 2 значение не в диапазоне и завершить работу");
                }
            }
        } catch (IndexOutOfBoundsException  e) {
            System.out.println("Second value out of range");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Different type of values");
            System.exit(1);
        }

    }

    public boolean isRoman(String value) {                               // смотрим, если строка числовая - значит это арабские, иначе - римские
        if (value.matches("-?\\d+")) {
            return false;
        }

        return true;
    }

    public boolean inRange(int value) {
        if(value < 0 || value > 10) {
            return false;
        }

        return true;
    }

    public boolean rightOperator(String operator) {
        String str = "* + - /";
        boolean got = str.contains(operator);
        return got;
    }
}


