package task1;

import java.util.*;

public class Faction {
    private String name;
    List deputies = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getDeputies() {
        return deputies;
    }

    public void setDeputies(List deputies) {
        this.deputies = deputies;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "name='" + name + '\'' +
                ", deputies=" + deputies +
                '}';
    }

    void addDeputy(){
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
        boolean bribe=true;
        if (bribeTaker==1){
            bribe=true;
        } else if (bribeTaker==2){
            bribe=false;
        } else {
            System.out.println("Error");
            addDeputy();
        }
        deputies.add(new Deputy(weight,height,secondName,name,age,bribe));
    }

    void removeDeputy(){
        System.out.println("Введіть фамілію депутата, якого хочете видалити");
        String secondName = sc.nextLine();
        Iterator<Deputy>iterator=deputies.iterator();
        boolean flag=true;
        while (iterator.hasNext()){
            if (iterator.next().getSecondName().equalsIgnoreCase(secondName)){
                iterator.remove();
                flag=false;
            }
            if (flag){
                System.out.println("Такого депутата немає");
            }
        }
    }
    void bribeTakers(){
        System.out.println("Депутати, які беруть хабарі:");
        ListIterator<Deputy>iterator=deputies.listIterator();
        while (iterator.hasNext()){
            Deputy next = iterator.next();
            if (next.isBribeTaker()){
                System.out.println(next.toString());
            }
        }
    }

    void deputyWithLargestBribe(){
        System.out.println("Депутат з найбільшою взяткою:");
        ListIterator<Deputy>iterator=deputies.listIterator();
        int sizeOfBribe = 0;
        Deputy deputyWithLargestBribe=new Deputy(0,0,null,null,0,false);
        while (iterator.hasNext()){
            Deputy next = iterator.next();
            if (next.getBribe()>sizeOfBribe){
                deputyWithLargestBribe=next;
            }
        }
        System.out.println(deputyWithLargestBribe.toString());
    }

    void allDeputiesOfFaction(){
        System.out.println("Всі депутати фракції:");
        ListIterator<Deputy>iterator=deputies.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    void removeAllDeputies(){
        ListIterator<Deputy>iterator=deputies.listIterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }

}
