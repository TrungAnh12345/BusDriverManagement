package Service;

import Entity.BusRoute;
import Entity.Driver;
import Function.Duty;
import Main.AllLists;
import Testconnection.TestConnection2;

import java.io.Serializable;
import java.sql.*;
import java.util.Scanner;

public class RouteBusService implements Duty, Serializable {
    @Override
    public void input() throws SQLException {
        System.out.println("Nhập vào số tuyến xe muốn thêm");
        int number = new Scanner(System.in).nextInt();

        for (int i = 0; i < number; i++){
            BusRoute busRoute = new BusRoute();
            busRoute.inputInfo();
//            AllLists.busRoutes.add(busRoute);
//            AllLists.busRoutes.add(busRoute);
            insertDatabase(busRoute);

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
    public void insertDatabase(BusRoute busRoute){
        int count = 100;

        String sql = "Insert into busroute(id, distance, numberofstops)" + "values(?,?,?)";
        String sql1 = "Select * from busroute";

        try{
            Connection connection = TestConnection2.connection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql1);
            while(rs.next()){
                count = rs.getInt(1);
            }
            connection.close();
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        try (
                Connection con = TestConnection2.connection();
                PreparedStatement preparedStatement = con.prepareStatement(sql)){

                preparedStatement.setInt(1,count + 1);
                preparedStatement.setFloat(2, busRoute.getDistance());
                preparedStatement.setInt(3, busRoute.getNumberOfStops());
                preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (BusRoute bus:
             AllLists.busRoutes) {
            System.out.println(bus);
        }
    }
}
