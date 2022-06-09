package Entity;

import Main.AllLists;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RoutingArrangement {
    List<RouteOfDriver> routeOfDrivers = new ArrayList<>();
    Driver driver;

    public RoutingArrangement(List<RouteOfDriver> routeOfDrivers, Driver driver) {
        this.routeOfDrivers = routeOfDrivers;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "RoutingArrangement{" +
                "routeOfDrivers=" + routeOfDrivers +
                ", driver=" + driver +
                '}';
    }

    public RoutingArrangement() {
    }

    public List<RouteOfDriver> getRouteOfDrivers() {
        return routeOfDrivers;
    }

    public void setRouteOfDrivers(List<RouteOfDriver> routeOfDrivers) {
        this.routeOfDrivers = routeOfDrivers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public float sumDailyDistance(){
        float totalDistance = 0;
        float eachDistanceBusRoute = 0;


        for(int i = 0; i < routeOfDrivers.size(); i++){
            totalDistance += (float) routeOfDrivers.get(i).getBusRoute().getDistance() * routeOfDrivers.get(i).getRoute();

        }
        return totalDistance;
    }
    public int sumTurnRoute(){
        if(isEmptyRouteOfDriver()){
            System.out.println("Lộ trình hiện đang trống");
            return 0;
        }
        int totalRouteDaily = 0;
        for(int  i = 0; i < routeOfDrivers.size(); i++){
            totalRouteDaily += routeOfDrivers.get(i).getRoute();
        }
        return totalRouteDaily;
    }
    public boolean isEmptyRouteOfDriver(){
        for (int  i = 0 ; i < routeOfDrivers.size();i++){
            if(routeOfDrivers.get(i)!= null){
                return false;
            }
        }
        return true;
    }

    public  void sortNumberRoute(){
        Comparator<RouteOfDriver> com1 = new Comparator<RouteOfDriver>() {
            @Override
            public int compare(RouteOfDriver o1, RouteOfDriver o2) {
                if (o1.getRoute() < o2.getRoute()) {
                    return 1;

                }
                return -1;
            }
        };
     ;
        for (RouteOfDriver r1 : routeOfDrivers) {
            System.out.println(r1);

        }
    }
    public static void writeListToFile(String fileName) throws IOException{
        File file = null;
        BufferedWriter bufferedWriter = null;
        try{
            file = new File(fileName);
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for(RoutingArrangement routingArrangements : AllLists.routingArrangements ){
                bufferedWriter.write(routingArrangements.getRouteOfDrivers() + "" + routingArrangements.getDriver());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e){
            System.out.println("Error write file");
        }finally {
            bufferedWriter.close();
        }
    }

}

