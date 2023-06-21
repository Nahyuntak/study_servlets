// package com.example.study_servlets.controlls;

// import java.io.IOException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.example.study_servlets.commons.Commons;

// @WebServlet(urlPatterns = "/CarInforsServlet")
// public class CarInforsServlet extends HttpServlet {
//     private Commons commons;

//     @Override
//     public void init() throws ServletException {
//         commons = new Commons();
//     }

//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         try {
//             // MySQL workbench 실행 : JDBC
//             // User/password와 접속 IP:port 접속
//             String url = "jdbc:mysql://192.168.0.39:3306/db_cars";
//             String user = "yojulab";
//             String password = "!yojulab*";

//             Connection connection = DriverManager.getConnection(url, user, password);
//             System.out.println("DB연결 성공\n");

//             // Query Edit
//             Statement statement = connection.createStatement();
//             String query = "SELECT * FROM car_infors";
//             ResultSet resultSet = statement.executeQuery(query);
//             while (resultSet.next()) {
//                 System.out.println(resultSet.getString("CAR_NAME") + resultSet.getString("YEAR")
//                         + resultSet.getString("CAR_INFOR_ID") + resultSet.getString("COMPANY_ID"));
//             }

//               query = "insert into car_infors\n" + //
//                     "(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)\n" + //
//                     "values\n" + //
//                     "('벤츠-마이바흐 S680'+'2023' '" + commons.generateUUID() + "C007')";
//             int count = statement.executeUpdate(query);

//             System.out.println();
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//         System.out.println();
//     }
// }

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

import com.example.study_servlets.commons.Commons;

@WebServlet(urlPatterns = "/CarInforsServlet")
public class CarInforsServlet extends HttpServlet {
    private Commons commons;

    @Override
    public void init() throws ServletException {
        commons = new Commons();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // MySQL workbench 실행 : JDBC
            // User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.39:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // Query Edit
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("CAR_NAME") + resultSet.getString("YEAR")
                        + resultSet.getString("CAR_INFOR_ID") + resultSet.getString("COMPANY_ID"));
            }

            String carName = "벤츠-마이바흐S680";
            int year = 2023;
            String carInforID = commons.generateUUID();
            String companyID = "C001";

            query = "INSERT INTO car_infors (CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID) VALUES " +
                    "('" + carName + "', '" + year + "'', '" + carInforID + "', '" + companyID + "')";
            int count = statement.executeUpdate(query);

            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println();
    }
}


