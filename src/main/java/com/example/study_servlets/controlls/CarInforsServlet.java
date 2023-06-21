package com.example.study_servlets.controlls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CarInforsServlet")
public class CarInforsServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.54:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            Statement statement = connection.createStatement();
            Commons commons = new Commons();
            String query = "insert into car_infors\n" + //
                    "(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)\n" + //
                    "values\n" + //
                    "('zkzkzk', '2023', '" +commons.generateUUID()+ "', 'C002')";
             int count = statement.executeUpdate(query);

            // - query Edit
            statement = connection.createStatement();
            String query2 = "SELECT * FROM db_cars.car_infors;";
            ResultSet resultSet = statement.executeQuery(query2);
            while(resultSet.next()){
                System.out.println(resultSet.getString("CAR_NAME") + resultSet.getString("YEAR") + resultSet.getString("CAR_INFOR_ID") + resultSet.getString("COMPANY_ID"));
            }

            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
