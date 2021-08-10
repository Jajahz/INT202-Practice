package review;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        hashTest();
        System.out.println();
        treeTest();
    }

    private static void hashTest() {
        Set<student> hashSet = new HashSet<>();
        hashSet.add(new student(10001, "Somsri", 3.25));
        hashSet.add(new student(10002, "Somsak", 3.00));
        hashSet.add(new student(10009, "Somchai", 3.26));
        hashSet.add(new student(10007, "Somsiri", 3.25));
        hashSet.add(new student(10037, "Sirisopaphan", 3.25));

//        hashSet.stream().sorted(Comparator.comparing(student::getGpax))
//                .collect(Collectors.toList());
//
//        hashSet.stream().sorted(Comparator.comparing(student::getName))
//                .collect(Collectors.toList());
//        System.out.println(hashSet);

        List<student> desStudent = new ArrayList<student>(hashSet);
        Collections.sort(desStudent);

        ListIterator<student> itr = desStudent.listIterator(desStudent.size());
        while(itr.hasPrevious())
            System.out.println(itr.previous() + ", ");

    }


    private static void treeTest() {
        Set<student> treeSet = new TreeSet<>();
        treeSet.add(new student(10001, "Somsri", 3.25));
        treeSet.add(new student(10002, "Somsak", 3.00));
        treeSet.add(new student(10009, "Somchai", 3.26));
        treeSet.add(new student(10007, "Somsiri", 3.25));
        treeSet.add(new student(10037, "Sirisopaphan", 3.25));

//        TreeSet<student> desStudent2 = (TreeSet<student>) treeSet.des
    }
}

