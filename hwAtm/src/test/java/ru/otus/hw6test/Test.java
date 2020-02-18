package ru.otus.hw6test;

import ru.otus.hw6atm.Atm;
import ru.otus.hw6atm.Nominal;

public class Test {
    public static void main(String[] args) {
        Nominal[] newsum = {Nominal.TEN, Nominal.TEN, Nominal.HUNDRED, Nominal.HUNDRED, Nominal.FIFTY, Nominal.THOUSAND, Nominal.THOUSAND, Nominal.HUNDRED, Nominal.FIVE_HUNDRED};
        Atm atm = new Atm();
        atm.insertMoney(newsum);
        System.out.println("Всего средств: " + atm.totalMoney());
        System.out.println("<>Нужно 20<>");
        atm.printMoney(20);
        System.out.println("<>Нужно 90<>");
        atm.printMoney(90);
        System.out.println("<>Нужно 300<>");
        atm.printMoney(300);
        System.out.println("<>Нужно 1560<>");
        atm.printMoney(1560);
        System.out.println("<>Нужно 499<>");
        atm.printMoney(499);
        System.out.println("<>Текущее состояние счета<>");
        atm.printAllMoney();
        System.out.println("<>Нужно 1000<>");
        atm.printMoney(1000);
        System.out.println("<>Текущее состояние счета<>");
        atm.printAllMoney();
    }
}