package Entity;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {
    private String fullName;
    private String address;
    private String phone;

    public String getFullName() {
        return fullName;
    }

    public Person(String fullName, String address, String phone) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person() {
    }
    public void inputInfo(){
        System.out.println("Nhập họ tên");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại");
        do {
            this.phone =new Scanner(System.in).nextLine();
            if(isValidPhoneNo(this.phone)){
                System.out.println("Số điện thoại hợp lệ");
            }
            else{
                System.out.println("Số điện thoại ko hợp lệ, vui lòng nhập đúng định dạng");
            }
        }while (!isValidPhoneNo(this.phone));

    }
    public static boolean isValidPhoneNo(String str){
        Pattern ptn = Pattern.compile("(0-9)?[0-9][0-9]{9}");
        Matcher matcher = ptn.matcher(str);
        return (matcher.find()&&matcher.group().equals(str));

    }
}
