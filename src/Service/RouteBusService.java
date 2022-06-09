package Service;

import Entity.BusRoute;
import Function.Duty;
import Main.AllLists;

import java.util.Scanner;

public class RouteBusService implements Duty {
    @Override
    public void input() {
        System.out.println("Nhập vào số tuyến xe muốn thêm");
        int number = new Scanner(System.in).nextInt();

        for (int i = 0; i < number; i++){
            BusRoute busRoute = new BusRoute();
            busRoute.inputInfo();
            AllLists.busRoutes.add(busRoute);
        }

    }
    @Override
    public void output() {
        for (int i = 0; i < AllLists.busRoutes.size(); i++){
            System.out.println(AllLists.busRoutes.get(i).toString());
        }
    }
    public static boolean isEmptyRouteBus(){
        for (int  i = 0; i < AllLists.busRoutes.size();  i++){
            if(AllLists.busRoutes.get(i) != null){
                return false;
            }

        }
        return true;
    }
}
