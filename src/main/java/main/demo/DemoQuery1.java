package main.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.demo.Utils.*;

public class DemoQuery1 {

    public static void main(String[] args) {

        Map<Masina, Proprietar> raportIntreg = new HashMap<>();

        Connection connection = null;
        try {
            connection = getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from masina join proprietar;");
            while (resultSet.next()) {
                raportIntreg.put(mapRowToMasina(resultSet), mapRowToProprietar(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            tryToCloseConnection(connection);
        }
        System.out.println(raportIntreg);

    }



    }

