package com.geekbrains.lesson4;

public class Functions {
    // метод, определяющий является ли число простым
    // (без остатка делится на себя или 1)
    public static boolean isPrime(Integer number) {
        // 1, 2, 3, ... - простые
        // 4, 6, 8, ... - не является простыми
        if (number <= 0) return false;
        if (number <= 3) return true;
        for (int i = 2; i < number; i++) {
            //условие: число делится без остатка
            if (number % i == 0) return false;
        }
        return true;
    }
    public static boolean isPalindrome(String word) {
        //1, 11, 121, 123321 - палиндром
        //12 - не палиндром
        if (word.length() < 2) return true;
        if (word.charAt(0) != word.charAt(word.length() - 1)) return false;
        // делаем рекурсию (вызываем метод внутри себя)
        // укорачиваем слово и передаем в метод
        return isPalindrome(word.substring(1, word.length() - 1));
        // 123321 - 1 цикл
        // 2332   - 2 цикл
        // 33     - 3 цикл
        // пустя строка - true
    }
}
