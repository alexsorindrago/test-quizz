package main.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static main.demo.Utils.*;

public class DemoQuery2 {

    public static void main(String[] args) {
        List<SelectIdAdresaNrAuto> raportSpecific = new ArrayList<>();

        Connection connection = null;
        try {
            connection = getConnection();
            ResultSet resultSet = connection.createStatement().
                    executeQuery("select m.cnp_proprietar, adresa, id from masina m join proprietar p " +
                            "on m.cnp_proprietar=p.cnp_proprietar;");
            while (resultSet.next()) {
                raportSpecific.add(mapRowToSelectIdAdresaNrAuto(resultSet));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            tryToCloseConnection(connection);
        }
        System.out.println(raportSpecific);
    }



}
