package com.company;

public class Main {

    public static void main(String[] args) {
// Quelques déclarations préalables
        String s1 = "loic";
        String s2 = "loic";
        String s3 = new String("loic");
        String s4 = new String("loic");
        String s5 = s3;
        String s6 = null;

// Test de l'opérateur égal ==
        System.out.print("s1==s2? ");
        System.out.println(s1==s2);
        System.out.print("s1==s3? ");
        System.out.println(s1==s3);
        System.out.print("s3==s4? ");
        System.out.println(s3==s4);
        System.out.print("s5==s3? " );
        System.out.println(s5==s3);

// Test de la méthode equals()
        System.out.print("s1.equals(s3)? ");
        System.out.println(s1.equals(s3));
        System.out.print("s1.equals(s6)? ");
        System.out.println(s1.equals(s6));
        System.out.print("s6.equals(s1)? ");
        System.out.println(s2.equals(s1));
    }
}
