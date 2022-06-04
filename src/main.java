import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.List;

public  class main {

    public static void main(String[] args) throws Exception {
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя арабскими или римскими числами от 1 до 10: a + b, a - b, a * b, a / b.");
        String[] rom = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Scanner scanner = new Scanner(System.in);
        String sar = scanner.nextLine();
        String[] arr = sar.split(" ");
        String a1 = arr[0];
        String a2 = arr[1];
        String a3 = arr[2];

        if (Arrays.asList(arab).contains(a1) && Arrays.asList(rom).contains(a3) || Arrays.asList(rom).contains(a1) && Arrays.asList(arab).contains(a3)) {
            throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        if (Arrays.asList(arab).contains(a1) && Arrays.asList(arab).contains(a3)) {
            System.out.println(calc(sar));
        }

        if (Arrays.asList(rom).contains(a1) && Arrays.asList(rom).contains(a3)) {
            String as = romanToNumber(a1);
            String ass = romanToNumber(a3);
            int aa = Integer.parseInt(as);
            int an1 = Integer.parseInt(ass);
            int result2 = 0;
            if (a2.equals("+")) {
                result2 = aa + an1;
            } else if (a2.equals("-")) {
                result2 = aa - an1;
                if (result2 < 1) throw new Exception("В римской системе нет отрицательных чисел");
            } else if (a2.equals("*")) {
                result2 = aa * an1;
            } else if (a2.equals("/")) {
                result2 = aa / an1;
                if (result2 < 1) throw new Exception("В римской системе нет отрицательных чисел");
            }
            String sa = convertNumToRoman(result2);
            String bbb = String.valueOf(sa);
            System.out.println(bbb);
        }

        int sl = Integer.valueOf(a1);
        int sb = Integer.valueOf(a3);
        if (sl < 1 || sl > 10 || sb < 1 || sb > 10) throw new Exception("Введенные числа не соответствуют условиям калькулятора");

    }


    public static String calc(String input) throws Exception {

        String[] parts = input.split(" ");
        String part1 = parts[0]; // первое число
        String part2 = parts[1]; // символ
        String part3 = parts[2]; // второе число
        int a1 = Integer.parseInt(part1);
        int a2 = Integer.parseInt(part3);

        if (parts.length != 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int result = 0;
        String result2;
        if (part2.equals("+")) {
            result = a1 + a2;
        } else if (part2.equals("-")) {
            result = a1 - a2;
        } else if (part2.equals("*")) {
            result = a1 * a2;
        } else if (part2.equals("/")) {
            result = a1 / a2;
        }
        result2 = String.valueOf(result);
        return result2;
    }

    public static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String s = roman[numArabian];
        return s;

    }

    public static String romanToNumber(String roman) {
        if (roman.equals("I")) {
            return "1";
        } else if (roman.equals("II")) {
            return "2";
        } else if (roman.equals("III")) {
            return "3";
        } else if (roman.equals("IV")) {
            return "4";
        } else if (roman.equals("V")) {
            return "5";
        } else if (roman.equals("VI")) {
            return "6";
        } else if (roman.equals("VII")) {
            return "7";
        } else if (roman.equals("VIII")) {
            return "8";
        } else if (roman.equals("IX")) {
            return "9";
        } else if (roman.equals("X")) {
            return "10";
        }
        return roman;
    }
}
