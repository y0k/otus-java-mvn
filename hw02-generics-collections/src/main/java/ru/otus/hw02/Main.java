package ru.otus.hw02;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {


        DIYarrayList<String> diYarrayList = new DIYarrayList<>();

        /*заполнение элементами >20*/
        for (char c = 'a'; c<='z'; c++) {
            diYarrayList.add(Character.toString(c));
        }

        DIYarrayList<String> diYarrayList_1 = new DIYarrayList<>();
        for (char c = 'z'; c>= 'a'; c--) {
            diYarrayList_1.add(Character.toString(c));
        }
        diYarrayList_1.add("A");
        diYarrayList_1.add("B");
        diYarrayList_1.add("c");
        diYarrayList_1.add("a");

        /*1*/
        Collections.addAll(diYarrayList, "az", "ab");
        System.out.println("Collections.addAll: "+diYarrayList);

        /*2*/
        Collections.copy(diYarrayList_1, diYarrayList);
        System.out.println("Collections.copy: "+diYarrayList_1);

        /*3*/
        Collections.sort(diYarrayList_1, Comparator.naturalOrder());
        System.out.println("Collections.sort: "+diYarrayList_1);
    }
}
