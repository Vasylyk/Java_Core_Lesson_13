package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        VerkhovnaRada vr = new VerkhovnaRada();
        while (true) {
            System.out.println("Введіть 1 щоб додати фракцію");
            System.out.println("Введіть 2 щоб видалити конкретну фракцію");
            System.out.println("Введіть 3 щоб вивести усі  фракції");
            System.out.println("Введіть 4 щоб очистити конкретну фракцію");
            System.out.println("Введіть 5 щоб вивести конкретну фракцію");
            System.out.println("Введіть 6 щоб додати депутата в фракцію");
            System.out.println("Введіть 7 щоб видалити депутата з фракції");
            System.out.println("Введіть 8 щоб вивести список хабарників");
            System.out.println("Введіть 9 щоб вивести найбільшого хабарника");

            switch (s.nextInt()) {
                case 1: {
                    vr.addFaction();
                    break;
                }
                case 2: {
                    vr.removeFaction();
                    break;
                }
                case 3: {
                    vr.allFactions();
                    break;
                }
                case 4: {
                    vr.removeAllDeputiesOfFaction();
                    break;
                }
                case 5: {
                    vr.allDeputiesOfFaction();
                    break;
                }
                case 6: {
                    vr.addDeputyToFaction();
                    break;
                }
                case 7: {
                    vr.removeDeputyFromFraction();
                    break;
                }
                case 8: {
                    vr.allBribeTakersFromFaction();
                    break;
                }
                case 9: {
                    vr.deputyWithLargestBribeInFaction();
                    break;
                }
            }
        }
    }
}
