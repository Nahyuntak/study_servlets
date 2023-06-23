package com.example.study_servlets.daos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CarInforDao")
public class CarInforDao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>bootstrap_tables</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "    <!-- <link rel=\"stylesheet\" href=\"../CSS/commons.css\"> -->\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>CAR_NAME</th>\r\n" + //
                    "                    <th>YEAR</th>\r\n" + //
                    "                    <th>CAR_INFOR_ID</th>\r\n" + //
                    "                    <th>COMPANY_ID</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n";

            // query Edit
            CarInforDao carInforDao = new CarInforDao();
            ArrayList<HashMap<String, String>> carInforList = carInforDao.selectAll();
            for (HashMap<String, String> hashMap : carInforList) {
                contents += "                <tr>\r\n" +
                            "                    <td>" + hashMap.get("CAR_NAME") + "</td>\r\n" +
                            "                    <td>" + hashMap.get("YEAR") + "</td>\r\n" +
                            "                    <td>" + hashMap.get("CAR_INFOR_ID") + "</td>\r\n" +
                            "                    <td>" + hashMap.get("COMPANY_ID") + "</td>\r\n" +
                            "                </tr>\r\n";
            }

            contents += "            </tbody>\r\n" +
                        "        </table>\r\n" +
                        "    </div>\r\n" +
                        "</body>\r\n" +
                        "</html>";

            // 클라이언트에 html 화면 제공
            response.setContentType("text/html;charset=UTF-8"); // 글자 안 깨짐
            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<HashMap<String, String>> selectAll() {
        // TODO: DB에서 데이터를 조회하여 반환하는 로직 구현
        // 예시 데이터를 반환하는 코드
        ArrayList<HashMap<String, String>> carInforList = new ArrayList<>();
        HashMap<String, String> carInfo1 = new HashMap<>();
        carInfo1.put("CAR_NAME", "Car 1");
        carInfo1.put("YEAR", "2022");
        carInfo1.put("CAR_INFOR_ID", "1");
        carInfo1.put("COMPANY_ID", "1");
        carInforList.add(carInfo1);

        HashMap<String, String> carInfo2 = new HashMap<>();
        carInfo2.put("CAR_NAME", "Car 2");
        carInfo2.put("YEAR", "2021");
        carInfo2.put("CAR_INFOR_ID", "2");
        carInfo2.put("COMPANY_ID", "2");
        carInforList.add(carInfo2);

        HashMap<String, String> carInfo1 = new HashMap<>();
        carInfo1.put("CAR_NAME", "Car 1");
        carInfo1.put("YEAR", "2022");
        carInfo1.put("CAR_INFOR_ID", "1");
        carInfo1.put("COMPANY_ID", "1");
        carInforList.add(carInfo1);

        HashMap<String, String> carInfo2 = new HashMap<>();
        carInfo2.put("CAR_NAME", "Car 2");
        carInfo2.put("YEAR", "2021");
        carInfo2.put("CAR_INFOR_ID", "2");
        carInfo2.put("COMPANY_ID", "2");
        carInforList.add(carInfo2);


        // DB에서 조회한 데이터를 carInforList에 추가하는 로직을 구현해야 합니다.

        return carInforList;
    }
}
