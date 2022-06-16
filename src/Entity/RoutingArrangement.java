package Entity;

import Main.AllLists;
import Testconnection.TestConnection2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class RoutingArrangement {
    List<RouteOfDriver> routeOfDrivers = new ArrayList<>();
    Driver driver;
    static int id = 0;
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

//    public void insertDriverRoute( RoutingArrangement routingArrangement, RouteOfDriver routeOfDriver){
//
//        String sql = "insert into routemanagement(id, driver_id, route_id, route_distance, route_numberofstops, numberofturns )" +"values(?,?,?,?,?,?)";
//        try (
//                Connection con = TestConnection2.connection();
//                PreparedStatement preparedStatement = con.prepareStatement(sql)){
//
//            for(int i = 0 ; i < routeOfDrivers.size();i++){
//                preparedStatement.setInt(1, id++);
//                preparedStatement.setInt(2, routingArrangement.getDriver().getId());
//                preparedStatement.setInt(3, routingArrangement.getRouteOfDrivers().get(i).getRoute());
//                preparedStatement.setFloat(4, routingArrangement.getRouteOfDrivers().get(i).getBusRoute().getDistance());
//                preparedStatement.setInt(5, routingArrangement.getRouteOfDrivers().get(i).getBusRoute().getNumberOfStops());
//                preparedStatement.setInt(6, routingArrangement.getRouteOfDrivers().get(i).getRoute());
//                preparedStatement.executeUpdate();
//
//            }
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public void insertDriverRoute( RoutingArrangement routingArrangement){

        String sql = "insert into routemanagement(id, driver_id, route_id, route_distance, route_numberofstops, numberofturns )" +"values(?,?,?,?,?,?)";
        try (
                Connection con = TestConnection2.connection();
                PreparedStatement preparedStatement = con.prepareStatement(sql)){
            for(int i = 0; i < routeOfDrivers.size(); i++){
                preparedStatement.setInt(1, id++);
                preparedStatement.setInt(2, routingArrangement.getDriver().getId());
                preparedStatement.setInt(3, routingArrangement.getRouteOfDrivers().get(i).getBusRoute().getId());
                preparedStatement.setFloat(4, routingArrangement.getRouteOfDrivers().get(i).getBusRoute().getDistance());
                preparedStatement.setInt(5, routingArrangement.getRouteOfDrivers().get(i).getBusRoute().getNumberOfStops());
                preparedStatement.setInt(6, routingArrangement.getRouteOfDrivers().get(i).getRoute());
                preparedStatement.executeUpdate();
            }
            con.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addRouting(Driver driver, List<RouteOfDriver> routeOfDrivers){
        RoutingArrangement routingArrangement = new RoutingArrangement();
        routingArrangement.setDriver(driver);
        routingArrangement.setRouteOfDrivers(routeOfDrivers);
        AllLists.routingArrangements.add(routingArrangement);
        insertDriverRoute(routingArrangement);

    }


}

