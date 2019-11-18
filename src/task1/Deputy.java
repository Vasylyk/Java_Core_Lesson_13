package task1;

import java.util.Scanner;

public class Deputy extends Human{
    private String secondName;
    private String firstName;
    private int age;
    private boolean bribeTaker;
    private int bribe;

    public Deputy(int weight, int height, String secondName, String firstName, int age, boolean bribeTaker) {
        super(weight, height);
        this.secondName = secondName;
        this.firstName = firstName;
        this.age = age;
        this.bribeTaker = bribeTaker;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBribeTaker() {
        return bribeTaker;
    }

    public void setBribeTaker(boolean bribeTaker) {
        this.bribeTaker = bribeTaker;
    }

    public int getBribe() {
        return bribe;
    }

    public void setBribe(int bribe) {
        this.bribe = bribe;
    }

    @Override
    public String toString() {
        return "Deputy{" +
                "secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }

    void bribe(){
        if (!bribeTaker){
            System.out.println("Цей депутат не бере хабарів");
        } else if (bribeTaker){
            System.out.println("Введіть суму хабаря");
            Scanner sc = new Scanner(System.in);
            int bribeSize = sc.nextInt();
            if (bribeSize>5000){
                System.out.println("Міліція ув'язнить депутата");
            } else {
                bribe=bribeSize;
                System.out.println("Сума хабаря дорівнює "+bribe);
            }
        }
    }
}
