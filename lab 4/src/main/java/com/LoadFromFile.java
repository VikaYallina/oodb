package com;

import com.domain.Client;
import com.domain.Product;
import com.domain.Shop;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class LoadFromFile {
    public static List<Client> loadClientList() throws IOException {
        String clientString = "";
        File file = new File("clients.json");

        if (file.exists()){
            clientString = new String(Files.readAllBytes(file.toPath()));
        }else {
            System.out.println("File clients.json not found.");
        }
        Gson gson = new Gson();
        Client[] clientList = gson.fromJson(clientString, Client[].class);
        return Arrays.asList(clientList);
    }

    public static Shop loadShop() throws IOException {
        String shopString = "";
        File file = new File("shop.json");

        if (file.exists()){
            shopString = new String(Files.readAllBytes(file.toPath()));
        }else {
            System.out.println("File shop.json not found.");
        }
        Gson gson = new Gson();
        return gson.fromJson(shopString, Shop.class);
    }

    public static List<Product> loadProductList() throws IOException {
        String productString = "";
        File file = new File("products.json");

        if (file.exists()){
            productString = new String(Files.readAllBytes(file.toPath()));
        }else {
            System.out.println("File products.json not found.");
        }
        Gson gson = new Gson();
        Product[] productList = gson.fromJson(productString, Product[].class);
        return Arrays.asList(productList);
    }
}
