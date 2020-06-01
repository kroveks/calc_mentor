package test.javamentor;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArithmeticExpression vvod = new ArithmeticExpression();
        vvod.lineReader();

        Calc calc = new Calc(vvod.getFirstValue(), vvod.getOperator(), vvod.getSecondValue(), vvod.getFlag());

        if (vvod.getFlag() == 0) {
            calc.arabicResolve();
        }else {
            calc.romanResolve();
        }


    }
}
