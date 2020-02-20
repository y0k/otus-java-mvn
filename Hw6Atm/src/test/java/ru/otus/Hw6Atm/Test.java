package ru.otus.Hw6Atm;

public class Test {
    public static void main(String[] args) {

        Atm atm = new Atm();

        PrintAllMoney pr = new PrintAllMoney();

        atm.InsertMoney(10, 4);
        atm.InsertMoney(50, 4);
        atm.InsertMoney(100, 3);
        atm.InsertMoney(500, 1);
        atm.InsertMoney(1000, 1);
        System.out.println("<>Нужно 20<>");
        atm.printMoney(20);
        System.out.println("<>Нужно 60<>");
        atm.printMoney(60);
        System.out.println("<>Нужно 300<>");
        atm.printMoney(300);
        System.out.println("<>Нужно 1560<>");
        atm.printMoney(1560);
        System.out.println("<>Нужно 499<>");
        atm.printMoney(499);
        System.out.println("<>Текущее состояние счета<>");
        pr.printAllMoney(atm);
        System.out.println("<>Нужно одной купюрой 100<>");
        atm.printMoney(100);
        System.out.println("<>Текущее состояние счета<>");
        pr.printAllMoney(atm);
    }
}