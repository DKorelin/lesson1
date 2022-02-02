package io.metadevs.dkorelin;

import java.util.Scanner;

public class M1_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        int n=sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        int[] arrC = new int[n];
        System.out.println("Enter the elements of the arrA: ");
        for(int i=0; i<n; i++) {
            arrA[i]=sc.nextInt();
        }
        System.out.println("Enter the elements of the arrB: ");
        for(int i=0; i<n; i++) {
            arrB[i]=sc.nextInt();
        }
        System.out.println("Enter the elements of the arrC: ");
        for(int i=0; i<n; i++) {
            arrC[i]=sc.nextInt();
        }


        for (int c : arrC) {
            for (int a: arrA) {
                for (int b: arrB){
                    if (c == a+b) System.out.println(String.format("%d = %d + %d",c,a,b));
                }
            }

        }

    }
}
