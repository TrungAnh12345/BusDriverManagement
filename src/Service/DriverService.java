package Service;

import Entity.BusRoute;
import Entity.Driver;
import Function.Duty;
import Main.AllLists;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverService implements Duty {
    @Override
    public void input() {
        System.out.println("Nhập số lái xe muốn thêm");
        int number = 0;
        boolean check2 = false;
        while (!check2) {
            try {
                number = new Scanner(System.in).nextInt();
                if (number > 0) {
                    break;
                }
                System.out.println("Số nhập vào phải dương");
            } catch (InputMismatchException e) {
                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                new Scanner(System.in).next();
            }
        }
        for (int i =  0; i < number; i++){
            Driver driver = new Driver();
            driver.inputInfo();
            AllLists.drivers.add(driver);
        }

    }

    @Override
    public void output() {
        for (Driver dr :
                AllLists.drivers) {
            if (AllLists.drivers == null){
                continue;
            }
            System.out.println(dr);
        }
    }
    public static boolean isEmptyDriver(){
        for (int i = 0; i < AllLists.drivers.size();i++){
            if(AllLists.drivers.get(i)!= null){
                return false;
            }
        }
        return true;
    }
}
