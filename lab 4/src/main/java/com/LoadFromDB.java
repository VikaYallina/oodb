package com;

import com.domain.Client;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadFromDB {
    public static List<Client> loadClientList(Connection connection) throws SQLException {
        String clientStr = "";

        PreparedStatement statement = connection.prepareStatement("SELECT jsonb FROM lab4");
        ResultSet resultSet = statement.executeQuery();
        Gson gson = new Gson();
        List<Client> list = new ArrayList<>();

        while (resultSet.next()){
            clientStr = resultSet.getString("jsonb");
            list.add(gson.fromJson(clientStr, Client.class));
        }

        statement.close();

//        System.out.println(clientStr);
//
//        Client[] clientArr = gson.fromJson(clientStr, Client[].class);

//        statement = connection.prepareStatement("SELECT jsonb->0 AS c FROM lab4");
//
//        resultSet = statement.executeQuery();
//
//        while (resultSet.next()){
//            clientStr = resultSet.getString("c");
//            //System.out.println(clientStr);
//        }

//        if (clientArr != null && clientArr.length != 0)
//            return Arrays.asList(clientArr);
//        else
//            return null;
        return list;
    }
}
