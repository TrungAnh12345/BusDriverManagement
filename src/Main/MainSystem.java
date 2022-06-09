package Main;

import Entity.BusRoute;
import Entity.Driver;
import Entity.RouteOfDriver;
import Entity.RoutingArrangement;
import File.InitializeData;
import Service.DriverService;
import Service.RouteBusService;
import Service.RoutingService;
import com.sun.org.apache.bcel.internal.generic.DREM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainSystem {
    public static InitializeData initializeData  = new InitializeData();

    public static void main(String[] args) {


        DriverService driverService = new DriverService();
        RouteBusService routeBusService = new RouteBusService();
        RoutingService routingService = new RoutingService();
        RoutingArrangement routingArrangement = new RoutingArrangement();
        boolean isContinue = true;

        do {
            System.out.println("Nhập vào các chức năng bạn muốn thực hiện:");
            System.out.println("1: Nhập vào thông tin lái xe");
            System.out.println("2: HIển thị ra màn hình thông tin lái xe");
            System.out.println("3: Nhập vào thông tin tuyến xe");
            System.out.println("4: Hiển thị ra thông tin tuyến xe");
            System.out.println("5: Phân công chạy xe");
            System.out.println("6: Sắp xếp tên lái xe");
            System.out.println("7: Sắp xếp theo tuyến trong ngày");
            System.out.println("8: Tính tổng khoảng cách chạy xe trong ngày");
            System.out.println("10: Thoát");
            int choice = 0;
            boolean check2 = false;
            while (!check2) {
                try {
                    choice = new Scanner(System.in).nextInt();
                    if (choice > 0) {
                        break;
                    }
                    System.out.println("Số nhập vào phải dương");
                } catch (InputMismatchException e) {
                    System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                    new Scanner(System.in).next();
                }
            }
            switch (choice){
                //0985445471

                case 1:
                    driverService.input();

                    System.out.println("Nhập thành công");
                    break;
                case 2:
                    driverService.output();
                    break;
                case 3:   routeBusService.input();
                    break;
                case 4:   routeBusService.output();
                    break;
                case 5:
                    routingService.createRoute();

                    break;
                case 6:
                    routingService.sortByDriver();
                    break;
                //0222222222
                case 7:

                    break;
                case 8:
                    routingService.showTotalDistance();
                    break;
                case 9:
                    routingArrangement.sortNumberRoute();
                    break;
                case 10:

                    break;
            }
        }while (isContinue);
    }

//     do {
//        for (int k = 0; k < routeOfDrivers.size(); k++){
//            totalTurnDaily += routeOfDrivers.get(i).getRoute();
//        }
//        if(totalTurnDaily <= 15){
//            routeOfDrivers.add(routeOfDriver);
//            break;
//        }
//        System.out.println("Số lượt đã vượt quá quy định, vui lòng thu nhỏ số lượt lái xe của tài xế");
//    }while (true);
}
