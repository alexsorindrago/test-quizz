package main;


import org.junit.jupiter.api.Test;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    @Test
    public void testSelect() {

        List<Persoana> persoane = new ArrayList<>();

        Connection connection = null;

        try {
            connection = UtilsTest.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select id, nume from person");
            while (resultSet.next()) {
                persoane.add(UtilsTest.mapRowToPersoana(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsTest.tryToCloseConnection(connection);
        }
        System.out.println(persoane);

    }

    @Test

    public void testCRUD(){
        Connection connection = null;



        try {
            connection = UtilsTest.getConnection();
            Statement statement= connection.createStatement();
            statement.execute("create table xxx (id int, name varchar(20));");
            statement.execute("insert into xxx (id, name) values (1, 'mihai');");
            statement.execute("insert into xxx (id, name) values (2, 'anamaria');");

            PreparedStatement preparedStatement = connection.prepareStatement("select id, name from xxx where id = ?;");
            preparedStatement.setInt(1,2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int anInt = resultSet.getInt(1);
                String string = resultSet.getString(2);
                System.out.println(anInt + " " + string);
            }

            statement.execute("drop table xxx;");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsTest.tryToCloseConnection(connection);
        }

    }

}
