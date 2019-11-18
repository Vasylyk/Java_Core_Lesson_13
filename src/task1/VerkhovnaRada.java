package task1;

import java.util.*;

public class VerkhovnaRada {
    List<Faction> factions= new ArrayList();
    Scanner sc = new Scanner(System.in);

    public List<Faction> getFactions() {
        return factions;
    }

    public void setFactions(List<Faction> factions) {
        this.factions = factions;
    }

    @Override
    public String toString() {
        return "VerkhovnaRada{" +
                "factions=" + factions +
                '}';
    }

    void addFaction(){
        System.out.println("Напишіть ім'я фракції");
        String factionName = sc.nextLine();
        factions.add(new Faction(factionName));
    }

    void removeFaction(){
        System.out.println("Напишіть ім'я фракції, яку хочете видалити");
        String factionName = sc.nextLine();
        Iterator<Faction>iterator=factions.listIterator();
        boolean flag = true;
        while (iterator.hasNext()){
            Faction next = iterator.next();
            if (next.getName().equalsIgnoreCase(factionName)){
                iterator.remove();
                flag=false;
            }
            if (flag){
                System.out.println("Такої фракції немає");
            }
        }
    }

    void allFactions(){
        System.out.println("Всі фракції:");
        Iterator<Faction>iterator=factions.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    void addDeputyToFaction(){
        System.out.println("Напишіть ім'я фракції, в яку хочете добавити депутата");
        String factionName = sc.nextLine();
        Iterator<Faction>iterator=factions.listIterator();
        boolean flag = true;
        while (iterator.hasNext()) {
            Faction next = iterator.next();
            if (next.getName().equalsIgnoreCase(factionName)) {
                System.out.println("Введіть ім'я депутата");
                String name = sc.nextLine();
                System.out.println("Фамілію");
                String secondName = sc.nextLine();
                System.out.println("Вік");
                int age = sc.nextInt();
                System.out.println("Масу");
                int weight = sc.nextInt();
                System.out.println("Ріст");
                int height = sc.nextInt();
                System.out.println("Чи бере взятки (1-так, 2-ні)");
                int bribeTaker = sc.nextInt();
                boolean bribe = true;
                if (bribeTaker == 1) {
                    bribe = true;
                } else if (bribeTaker == 2) {
                    bribe = false;
                }
                next.deputies.add(new Deputy(weight, height, secondName, name, age, bribe));
                flag = false;
            }
            if (flag) {
                System.out.println("Такої фракції немає");
            }
        }
    }

    void removeDeputyFromFraction(){
        System.out.println("Напишіть ім'я фракції, з якої хочете видалити депутата");
        String factionName = sc.nextLine();
        Iterator<Faction>iterator=factions.listIterator();
        boolean flag = true;
        while (iterator.hasNext()) {
            Faction next = iterator.next();
            if (next.getName().equalsIgnoreCase(factionName)) {
                System.out.println("Введіть фамілію депутата");
                String name = sc.nextLine();
                Iterator<Deputy>iterator1=next.deputies.listIterator();
                boolean flag1 = true;
                while (iterator1.hasNext()){
                    Deputy n = iterator1.next();
                    if (n.getSecondName().equalsIgnoreCase(name)){
                        iterator1.remove();
                        flag1=false;
                    }
                    if (flag1){
                        System.out.println("Такого депутата немає");
                    }
                }
                flag = false;
            }
            if (flag) {
                System.out.println("Такої фракції немає");
            }
        }
    }

    void allBribeTakersFromFaction(){
        System.out.println("Введіть назву фракції");
        String factionName=sc.nextLine();
        Iterator<Faction>iterator=factions.listIterator();
        boolean flag = true;
        while (iterator.hasNext()){
            Faction next = iterator.next();
            if (next.getName().equalsIgnoreCase(factionName)){
                System.out.println("Депутати, які беруть хабарі з фракції "+factionName);
                ListIterator<Deputy> iterator2=next.deputies.listIterator();
                while (iterator.hasNext()){
                    Deputy n = iterator2.next();
                    if (n.isBribeTaker()){
                        System.out.println(next.toString());
                    }
                }
                flag=false;
            }
        }
        if (flag){
            System.out.println("Текої фракції немає");
        }
    }

    void deputyWithLargestBribeInFaction(){
        System.out.println("Введіть назву фракції");
        String factionName=sc.nextLine();
        Iterator<Faction>iterator=factions.listIterator();
        boolean flag = true;
        while (iterator.hasNext()){
            Faction next = iterator.next();
            if (next.getName().equalsIgnoreCase(factionName)){
                System.out.println("Депутат, який взяв найбільший хабар з фракції "+factionName);
                ListIterator<Deputy> iterator2=next.deputies.listIterator();
                int sizeOfBribe = 0;
                Deputy deputyWithLargestBribe=new Deputy(0,0,null,null,0,false);
                while (iterator2.hasNext()){
                    Deputy n = iterator2.next();
                    if (n.getBribe()>sizeOfBribe){
                        deputyWithLargestBribe=n;
                    }
                }
                System.out.println(deputyWithLargestBribe.toString());
                flag=false;
            }
        }
        if (flag){
            System.out.println("Текої фракції немає");
        }
    }

    void allDeputiesOfFaction(){
        System.out.println("Введіть назву фракції");
        String factionName=sc.nextLine();
        Iterator<Faction>iterator=factions.listIterator();
        boolean flag = true;
        while (iterator.hasNext()){
            Faction next = iterator.next();
            if (next.getName().equalsIgnoreCase(factionName)){
                System.out.println("Всі депутати фракції:");
                ListIterator<Deputy>iterator2=next.deputies.listIterator();
                while (iterator2.hasNext()){
                    System.out.println(iterator2.next().toString());
                }
            }
            flag=false;
        }
        if (flag){
            System.out.println("Текої фракції немає");
        }
    }

    void removeAllDeputiesOfFaction(){
        System.out.println("Введіть назву фракції");
        String factionName=sc.nextLine();
        Iterator<Faction>iterator=factions.listIterator();
        boolean flag = true;
        while (iterator.hasNext()){
            Faction next = iterator.next();
            if (next.getName().equalsIgnoreCase(factionName)){
                ListIterator<Deputy>iterator2=next.deputies.listIterator();
                while (iterator2.hasNext()){
                    iterator2.next();
                    iterator2.remove();
                }
                flag=false;
            }
        }
        if (flag){
            System.out.println("Текої фракції немає");
        }
    }


}
