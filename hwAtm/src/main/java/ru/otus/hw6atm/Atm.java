package ru.otus.hw6atm;

import java.util.ArrayList;

public class Atm {


    private Cassete cas = new Cassete();

    public void insertMoney(Nominal[] banknotes) {
        for (Nominal banknote : banknotes) {
            moneySort(banknote);
        }
    }

    public void printMoney(int sum) {
        if (sum % 10 == 0) {
            sum = moneyGet(sum, 1000, cas.casThous);
            sum = moneyGet(sum, 500, cas.casFiveHundr);
            sum = moneyGet(sum, 100, cas.casHundr);
            sum = moneyGet(sum, 50, cas.casFift);
            sum = moneyGet(sum, 10, cas.casTen);
        } else {
            System.out.println("не кратно 10");
        }
    }

    public void printAllMoney() {
        if (totalMoney() != 0) {
            System.out.println("Доступно: " + totalMoney());
        } else {
            System.out.println("Средства закончились");
        }
    }

    public int totalMoney() {
        return (cas.casTen.size() * 10 + cas.casFift.size() * 50 + cas.casHundr.size() * 100 +cas.casFiveHundr.size() * 500 + cas.casThous.size() * 1000);
    }

    private void moneySort(Nominal banknote) {
        if (banknote.equals(Nominal.TEN)) {
            cas.casTen.add(banknote);
        } else if (banknote.equals(Nominal.FIFTY)) {
            cas.casFift.add(banknote);
        } else if (banknote.equals(Nominal.HUNDRED)) {
            cas.casHundr.add(banknote);
        } else if (banknote.equals(Nominal.FIVE_HUNDRED)) {
            cas.casFiveHundr.add(banknote);
        } else if (banknote.equals(Nominal.THOUSAND)) {
            cas.casThous.add(banknote);
        } else {
            throw new RuntimeException("Неизвестный номинал");
        }
    }

    private int moneyGet(int sum, int banknoteValue, ArrayList casType) {
        if (sum / banknoteValue >= 1) {
            if (casType.size() >= sum / banknoteValue) {
                int count = sum / banknoteValue;
                for (int i = 0; i < count; i++) {
                    casType.remove(casType.size() - 1);
                }
                sum = sum - banknoteValue * count;
                System.out.println("Возможно снять: " + banknoteValue * count);
            } else {
                System.out.println("Не хватает купюр номиналом: " + banknoteValue);
            }
        }
        return sum;
    }
}