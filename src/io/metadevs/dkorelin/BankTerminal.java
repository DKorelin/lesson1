package io.metadevs.dkorelin;

import java.util.Scanner;

public class BankTerminal {
    static int[] monyes = {0,0,0,0,0,0};
    static int[] NOMINALS = {50,100,200,500,1000,5000};
    static int CAPACITY = 1000;
    static int bankSum = 0;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        label:
        while (true) {
            System.out.println("enter collection/withdrawal/depositing");
            String userInput = sc.nextLine();
            switch (userInput) {
                case "collection":
                    processCollection();
                    break;
                case "withdrawal":
                    processWithdrawal();
                    break;
                case "depositing":
                    processDepositing();
                    break;
                default:
                    System.out.println("GTFO");
                    break label;
            }
        }
    }

    public static void processCollection(){
        System.out.println("РЕЖИМ ИНКАССАЦИИ ВВЕДИТЕ ПОЗИЦИИ");
        bankSum = 0;
        for(int i=0; i< monyes.length; i++) {
            monyes[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < monyes.length;i++){
            bankSum = bankSum + monyes[i]*NOMINALS[i];
        }
    }

    public static void processWithdrawal(){
        System.out.println("введите сумму выдачи");
        int userSum = sc.nextInt();
        sc.nextLine();
        if (bankSum >= userSum) {
            withdrawalMenu();
        }
        else {
            System.out.println("извините столько денег нет");
        }
    }

    public static void withdrawalMenu(){
        //body
    }


    public static void processDepositing(){
        int[] userMonyes = {0,0,0,0,0,0};
        int allBanknotes = 0;
        System.out.println("РЕЖИМ ВНЕСЕНИЯ ВВЕДИТЕ ПОЗИЦИИ");
        for(int i=0; i< monyes.length; i++) {
            userMonyes[i] = sc.nextInt();
            allBanknotes = allBanknotes + userMonyes[i];
        }
        for (int i : monyes) {
            allBanknotes = allBanknotes + i;
        }
        if (CAPACITY >= allBanknotes) {
            for(int i=0; i< monyes.length; i++) {
                monyes[i] = monyes[i] + userMonyes[i];
                System.out.print(monyes[i]+" ");
            }
        }
        else {
            System.out.println("извините столько денег не принять");
        }
    }

}
