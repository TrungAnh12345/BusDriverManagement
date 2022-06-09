package Entity;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver  extends Person{
    private static int AUTO_ID = 10000;
    private String level;
    private int id;

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  super.toString() +  "Driver{" +
                "level=" + level +
                ", id=" + id +
                '}';
    }
    public void inputInfo(){
        super.inputInfo();
        id = AUTO_ID++;
        System.out.println("Nhập trình độ");

        do {
            level = new Scanner(System.in).nextLine();
            if(isValidLevelNo(this.level)){
                System.out.println("hợp lệ");
            }
            else {
                System.out.println("không hợp lệ");
            }
        }while(!isValidLevelNo(this.level));

    }
    public static boolean isValidLevelNo(String str){
        Pattern ptn = Pattern.compile("[A-F]");
        Matcher matcher = ptn.matcher(str);
        return (matcher.find()&&matcher.group().equals(str));

    }
}
