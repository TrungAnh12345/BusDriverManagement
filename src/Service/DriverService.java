package Service;

import Entity.BusRoute;
import Entity.Driver;
import Function.Duty;
import Main.AllLists;
import Testconnection.TestConnection2;

import java.io.Serializable;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverService implements Duty, Serializable {
    static final String  DB_URL  = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String User = "system";
    static final String Pass = "root";
    @Override
    public void input() throws SQLException {

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
        for (int i = 0; i < number; i++) {
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

    public void insertDatabase(){
        String sql = "INSERT into driver(ID, fullname, ADDRESS, phonenumber, level_driver)" + "VALUES(?,?,?,?,?)";
        try (
            Connection con = TestConnection2.connection();
            PreparedStatement preparedStatement = con.prepareStatement(sql)){
            int count = 0;
            for (Driver dr :
                    AllLists.drivers) {
                preparedStatement.setInt(1, dr.getId());
                preparedStatement.setString(2, dr.getFullName());
                preparedStatement.setString(3, dr.getAddress());
                preparedStatement.setString(4, dr.getPhone());
                preparedStatement.setString(5, dr.getLevel());
                //preparedStatement.addBatch();
                preparedStatement.executeUpdate();

            }
            con.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
