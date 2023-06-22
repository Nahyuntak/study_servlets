package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class FactorysDao {
    public ArrayList selectAll() {
        ArrayList arrayList = new ArrayList();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query);
            HashMap hashmap = new HashMap();
            while (resultSet.next()) {
                hashmap = new HashMap();
                hashmap.put("COMPANY_ID", resultSet.getString("COMPANY_ID"));
                hashmap.put("COMPANY", resultSet.getString("COMPANY"));
                arrayList.add(hashmap);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }
}
