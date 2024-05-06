package com.jspProject.dao;

import com.jspProject.dto.ProductDTO;
import com.jspProject.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<ProductDTO> getProductsByCategory(int categoryId) {
        List<ProductDTO> products = new ArrayList<>();
        String sql = "SELECT id, name, price, image_path FROM tb_item WHERE category_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, categoryId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ProductDTO product = new ProductDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image_path")
                    );
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
