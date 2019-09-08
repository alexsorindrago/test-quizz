package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Persoana> persoane = new ArrayList<>();

        Connection connection = null;
        try {
            connection = getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select id, nume from person");
            while (resultSet.next()) {
                persoane.add(mapRowToPersoana(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            tryToCloseConnection(connection);
        }
        System.out.println(persoane);

    }

    private static Persoana mapRowToPersoana(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String nume = resultSet.getString(2);
        return new Persoana(id, nume);
    }

    private static void tryToCloseConnection(Connection connection) {
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
