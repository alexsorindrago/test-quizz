package main.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {

    public static Masina mapRowToMasina(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(1);
        String culoare = resultSet.getString(2);
        String marca = resultSet.getString(3);
        int cnp_proprietar = resultSet.getInt(4);
        return new Masina(id, culoare, marca, cnp_proprietar);
    }

    public static Proprietar mapRowToProprietar(ResultSet resultSet) throws SQLException{
        int cnp = resultSet.getInt(5);
        String adresa = resultSet.getString(6);
        return new Proprietar(cnp,adresa);
    }

    public static SelectIdAdresaNrAuto mapRowToSelectIdAdresaNrAuto (ResultSet resultSet) throws SQLException{
        int id= resultSet.getInt(1);
        String culoare = resultSet.getString(2);
        String marca = resultSet.getString(3);
        return new SelectIdAdresaNrAuto(id,culoare,marca);
    }

    public static void tryToCloseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection(){

        String url = "jdbc:mysql://localhost:3306/jdbc_db";
        String user = "root";
        String password = "root";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot get connection", e);
        }
    }
}
