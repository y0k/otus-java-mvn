package ru.otus.Hw6Atm;

import java.util.EnumMap;
import static ru.otus.Hw6Atm.Cassete.Nominal.*;

public class Atm {
    Cassete cas = new Cassete(0);

    private int sum;
    private int nominalcount;
    private int nominalvalue;

    public void InsertMoney(int nominalvalue, int nominalcount) {
        this.nominalcount = nominalcount;
        this.nominalvalue = nominalvalue;
        Cassete.Nominal nominal = getEnumByInt(nominalvalue);
        if (nominal != null) {
            cas.casmap.put(nominal, cas.nominalscount + nominalcount);
                System.out.println("Внесли: "+nominalcount+" купюры номиналом "+nominalvalue);
        }
    }

    public void printMoney(int sum) {
        this.sum = sum;
        if (sum % 10 == 0) {
            sum = moneyGet(sum, 1000, cas.casmap);
            sum = moneyGet(sum, 500, cas.casmap);
            sum = moneyGet(sum, 100, cas.casmap);
            sum = moneyGet(sum, 50, cas.casmap);
            sum = moneyGet(sum, 10, cas.casmap);
        } else {
            System.out.println("не кратно 10");
        }
    }

    private int moneyGet(int sum, int banknoteValue, EnumMap<Cassete.Nominal, Integer> casType) {
        if (sum / banknoteValue >= 1) {
            int count = sum / banknoteValue;
            Cassete.Nominal nominal = Cassete.Nominal.getEnumByInt(banknoteValue);
            if (casType.get(nominal) >= count) {
                sum = sum - banknoteValue * count;
                assert nominal != null;
                casType.put(nominal, casType.get(nominal) - count);
                System.out.println(Cassete.Nominal.getEnumByInt(banknoteValue) + " Берем " + count);
            } else {
                System.out.println("Не хватает: " + banknoteValue);
            }
        }
        return sum;
    }
}
