package Entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusRoute {
    private int id;
    private static int AUTO_ID = 100;
    private float distance;
    private int numberOfStops;
    public static int getAutoId() {
        return AUTO_ID;
    }

    @Override
    public String toString() {
        return "BusRoute{" +
                "distance=" + distance +
                ", numberOfStops=" + numberOfStops +
                ", id=" + id +
                '}';
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public BusRoute() {
        this.id = AUTO_ID++;

    }

    public BusRoute(float distance, int numberOfStops, int id) {
        this.distance = distance;
        this.numberOfStops = numberOfStops;
        this.id = id;
    }


    public void inputInfo(){
        System.out.println("Nhập khoảng cách");
        this.distance = 0;
        boolean check2 = false;
        while (!check2) {

            try {
                distance = new Scanner(System.in).nextFloat();
                if (distance > 0) {
                    break;
                }
                System.out.println("Số nhập vào phải dương");
            } catch (InputMismatchException e) {
                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                new Scanner(System.in).next();
            }
        }
        System.out.println("Nhập số điểm dừng");

        while (!check2) {
            try {
                numberOfStops = new Scanner(System.in).nextInt();
                if (numberOfStops > 0) {
                    break;
                }
                System.out.println("Số nhập vào phải dương");
            } catch (InputMismatchException e) {
                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                new Scanner(System.in).next();
            }
        }
    }


}
