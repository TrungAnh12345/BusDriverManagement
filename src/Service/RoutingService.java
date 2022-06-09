package Service;

import Entity.BusRoute;
import Entity.Driver;
import Entity.RouteOfDriver;
import Entity.RoutingArrangement;
import Main.AllLists;

import java.util.*;

// trước khi phân công chạy xe phải nhập vào thông tin lái xe và tuyến xe,
// kiểm tra xem lx và tuyến xe nhập vaofn có tồn tại trong hệ thống hay ko
// kiểm tra lx
public class RoutingService {

    // route <= 15;
    public void createRoute(){
        if(DriverService.isEmptyDriver() || RouteBusService.isEmptyRouteBus()){
            System.out.println("Lái xe và số tuyến hiện đang trống");
            return;
        }
        System.out.println("Nhập số lái xe cần phân công");
        boolean check2 = false;
        int numberDriver = 0;
        while (!check2) {
            try {
                numberDriver = new Scanner(System.in).nextInt();
                if (numberDriver > 0) {
                    break;
                }
                System.out.println("Số nhập vào phải dương");
            } catch (InputMismatchException e) {
                System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                new Scanner(System.in).next();
            }
        }

        for(int i = 0; i < numberDriver;i++){
            int totalTurnDaily = 0;
            System.out.println("Nhập vào lái xe thứ " + (i + 1)) ;
            Driver driver = new Driver();
            driver = inputDriver();
            List<RouteOfDriver> routeOfDrivers = new ArrayList<RouteOfDriver>();
            addRoute(routeOfDrivers);
            RoutingArrangement routingArrangement = new RoutingArrangement(routeOfDrivers, driver);
            AllLists.routingArrangements.add(routingArrangement);

        }
    }

    public  void addRoute(List<RouteOfDriver> routeOfDrivers){
        int totalTurn = 0;
        float totalDistance = 0;
        System.out.println("Mời nhập số tuyến");
        int numberRoute = new Scanner(System.in).nextInt();
        for(int i =  0; i < numberRoute; i++){
            System.out.println("Nhập mã tuyến");

            BusRoute busRoute = findBusRouteById();
            System.out.println("Nhập số lượt lái của tuyến");
            int numberTurn = new Scanner(System.in).nextInt();
            if(totalTurn > 15){
                System.out.println("Lượt lái lớn hơn 15");
                break;
            }
            totalTurn += numberTurn;
            totalDistance += busRoute.getDistance() * numberTurn;
            RouteOfDriver routeOfDriver = new RouteOfDriver(busRoute, numberTurn);
            routeOfDrivers.add(routeOfDriver);
            System.out.println("tính tổng khoảng cách");
        }
        totalDistance += totalDistance * numberRoute;

    }


    public int inputTurnRoute(RouteOfDriver routeOfDriver, Driver driver){
        int turnRoute = 0;
        boolean check2 = false;

        do {
            while (!check2) {
                try {
                    turnRoute = new Scanner(System.in).nextInt();
                    if (turnRoute > 0) {
                        break;
                    }
                    System.out.println("Số nhập vào phải dương");
                } catch (InputMismatchException e) {
                    System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                    new Scanner(System.in).next();
                }
            }
            if(turnRoute <= 15){
                int totalTurnRoute = getTotalRoute(driver);
                totalTurnRoute +=  routeOfDriver.getRoute();
                if(totalTurnRoute > 15){
                    System.out.println("nếu số lượt đăng kí là " + turnRoute + " với tuyến xe này thì tổng số lượt sẽ vượt quá 15 ");
                    continue;
                }
                break;
            }
        }while (true);
        return turnRoute;

    }
    public Driver inputDriver(){
        Driver driver =null;
        System.out.println("Nhập mã tài xế cần phân công");
        int idDriver = 0;
        boolean check2 = false;
        do {
            while (!check2) {
                try {
                    idDriver = new Scanner(System.in).nextInt();
                    if (idDriver > 0) {
                        break;
                    }
                    System.out.println("Số nhập vào phải dương");
                } catch (InputMismatchException e) {
                    System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                    new Scanner(System.in).next();
                }
            }
            for (int i = 0; i < AllLists.drivers.size(); i++){
                if(AllLists.drivers.get(i) != null && idDriver == AllLists.drivers.get(i).getId()){
                    driver = AllLists.drivers.get(i);
                    break;
                }
            }
            if(driver != null){
                break;
            }
            System.out.println("không tìm thấy tên tài xế với id vừa nhập, nhập lại cho đúng");
        }while (true);
       return driver;
    }
    public BusRoute findBusRouteById( ){
        System.out.println("Nhập vào mã tuyến");
        int idBusroute = 0;
        boolean check2 = false;

        BusRoute busRoute = null;
        do {
            while (!check2) {
                try {
                    idBusroute = new Scanner(System.in).nextInt();
                    if (idBusroute > 0) {
                        break;
                    }
                    System.out.println("Số nhập vào phải dương");
                } catch (InputMismatchException e) {
                    System.out.println("Bạn phải nhập số, ko được nhập chữ, nhấp phím bất kì và nhập lại");
                    new Scanner(System.in).next();
                }
            }
            for (int i = 0; i < AllLists.busRoutes.size(); i++){
                if(AllLists.busRoutes.get(i) != null && idBusroute == AllLists.busRoutes.get(i).getId()){
                    busRoute = AllLists.busRoutes.get(i);
                    break;
                }
            }
            if (busRoute != null){
                break;
            }
            System.out.println("không tìm thấy mã tuyến vừa nhập, vui lòng nhập mã tuyến khác");
        }while(true);
        return busRoute;
    }



    public void showDistanceDaily(){
        for(int i = 0; i < AllLists.routingArrangements.size(); i++){
            if(AllLists.routingArrangements.get(i) == null){
                continue;
            }
            System.out.println("khoảng cách trong ngày của tài xế " + AllLists.routingArrangements.get(i).getDriver().getFullName() + " " );
        }
     }

     public void showRoutingDaily(){
        for (int i = 0; i < AllLists.routingArrangements.size(); i++){
            if(AllLists.routingArrangements.get(i) == null){
                continue;
            }
            System.out.println(AllLists.routingArrangements.get(i).toString());
        }
     }
     public void showTotalDistance(){
      for (int  i = 0; i < AllLists.routingArrangements.size(); i++){
          System.out.println("Tổng số khoảng cách của tài xế" + AllLists.routingArrangements.get(i).getDriver() + "là: " + AllLists.routingArrangements.get(i).sumDailyDistance());
      }
     }

    public int getTotalRoute(Driver driver){
        RoutingArrangement routingArrangement = findRoutingArrangement(driver.getId());
        return routingArrangement.sumTurnRoute();
    }
    public RoutingArrangement findRoutingArrangement(int idDriver){
        for(int i = 0 ;i < AllLists.routingArrangements.size(); i++){
            if(AllLists.routingArrangements.get(i).getDriver().getId() == idDriver){
                return AllLists.routingArrangements.get(i);
            }
        }
        return null;
    }
    public void sortByDriver(){
        Comparator<RoutingArrangement> com2 = new Comparator<RoutingArrangement>() {
            @Override
            public int compare(RoutingArrangement o1, RoutingArrangement o2) {
                if(o1.getDriver().getFullName().compareTo(o2.getDriver().getFullName()) > 0){
                    return 1;
                }
                return 0;
            }
        };
        showRoutingDaily();
    }







}
