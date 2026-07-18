package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.ShoppingCartItem;
import com.util.Connectivity;

public class ShoppingCartDAO {

    Connection con = Connectivity.getConnection();

    // Add Item
    public void addItem(ShoppingCartItem item) {

        try {

            String sql = "INSERT INTO shoppingcart_item(id, name, price) VALUES(shoppingcart_seq.NEXTVAL, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Display Items
    public ArrayList<ShoppingCartItem> getAllItems() {

        ArrayList<ShoppingCartItem> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM shoppingcart_item ORDER BY ID";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ShoppingCartItem item = new ShoppingCartItem();

                item.setId(rs.getInt("ID"));
                item.setName(rs.getString("NAME"));
                item.setPrice(rs.getDouble("PRICE"));

                list.add(item);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    // Delete Item
    public void deleteItem(int id) {

        try {

            String sql = "DELETE FROM shoppingcart_item WHERE  ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}