package test.javamentor;

//чисто свич-стейтмент, беру 2 значения + оператор, делаю что надо, возвращаю результат. Все.

public class Calc {

    String pervoeZnnachenie;
    String operator;
    String vtoroeZnachenie;
    private int flag;

    RomanToArabic perevod = new RomanToArabic();

    public Calc(String pervoeZnnachenie, String operator, String vtoroeZnachenie, int flag) {
        this.pervoeZnnachenie = pervoeZnnachenie;
        this.operator = operator;
        this.vtoroeZnachenie = vtoroeZnachenie;
        this.flag = flag;
    }

    public String resolving(int first, int second) {                   // Собственно производим необходимые вычисления в зависимости от оператора
        String result = "";
        switch (this.operator) {
            case "*":
                result =  String.valueOf(first * second);
                break;
            case "+" :
                result =  String.valueOf(first + second);
                break;
            case "-":
                result =  String.valueOf(first - second);
                break;
            case "/":
                result =  String.valueOf(first / second);
                break;
        }

        return result;
    }

    public void arabicResolve() {
        int first = Integer.parseInt(pervoeZnnachenie);
        int second = Integer.parseInt(vtoroeZnachenie);

        System.out.println("Результат: " + resolving(first, second));
    }

    public void romanResolve() {
        int first = perevod.romanToArabic(pervoeZnnachenie);
        int second = perevod.romanToArabic(vtoroeZnachenie);

        System.out.println("Результат: " + perevod.arabicToRoman(Integer.parseInt(resolving(first, second))));
    }



}
