package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ConnectDBServlet")
public class ConnectDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // MySQL workbench 실행: JDBC
            // User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.39:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // 클라이언트 html 화면 제공
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>bootstrap template</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n"
                    + //
                    "    <!-- <link rel=\"stylesheet\" href=\"../css/commons.css\"> -->\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container mt-3\">\r\n" + //
                    "        <!--table-striped:\uC9DD\uC218\uC5F4\uBD80\uD130 \uC0C9\uC774 \uCE60\uD574\uC9D0.-->\r\n" + //
                    "        <!--table-borderd:\uD14C\uC774\uBE14 \uD14C\uB450\uB9AC <-> table-borderless-->\r\n" + //
                    "        <!--table-hover: \uC5F4\uC774 \uC120\uD0DD\uB418\uB294 \uAC83 \uAC19\uC774-->\r\n" + //
                    "        <table class=\"table table-striped table-bordered table-hover\">\r\n" + //
                    "            <!--thead: \uB370\uCF54\uB97C \uC548\uD574\uB3C4 \uAE30\uBCF8 \uC591\uC2DD\uC774 \uB4E4\uC5B4\uAC00 \uC788\uB2E4.-->\r\n"
                    + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <!--th: table head-->\r\n" + //
                    "                    <th>COMPANY_ID</th>\r\n" + //
                    "                    <th>COMPANY</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n";

            // - Query Edit
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                contents = contents + "                <tr>\r\n" + //
                        "                    <td>" + resultSet.getString("COMPANY_ID") + "</td>\r\n" + //
                        "                    <td>" + resultSet.getString("COMPANY") + "</td>\r\n" + //
                        "                </tr>";
            }

            contents = contents + "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js\"></script>\r\n"
                    + //
                    "\r\n" + //
                    "</html>";

            // 클라이언트에 HTML 화면 제공
            resp.setContentType("text/html;charset=UTF-8"); // UTF-8: 통상적으로 character를 쓸 때 사용, 글자 깨짐 방지
            PrintWriter printwriter = resp.getWriter();
            printwriter.println(contents);
            printwriter.close();

            // SELECT COUNT(*) AS CNT FROM factorys;
            query = "SELECT COUNT(*) AS CNT FROM factorys";
            resultSet = statement.executeQuery(query);
            int totalCount = 0;
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
            }

            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
