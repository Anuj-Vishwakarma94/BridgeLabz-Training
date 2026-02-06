package com.lamdaexpresions.schoolstudentsystem;

import java.util.*;

public class StudentSort {

    public static void sortByName(List<Student> list) {
        list.sort((s1, s2) -> s1.name.compareTo(s2.name));
    }

    public static void sortByRank(List<Student> list) {
        list.sort((s1, s2) -> s1.rank - s2.rank);
    }
}
