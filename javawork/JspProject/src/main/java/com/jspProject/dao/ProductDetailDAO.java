package com.jspProject.dao;

import com.jspProject.dto.ProductDetailDTO;
import com.jspProject.util.DBUtil;

import java.sql.*;

public class ProductDetailDAO {

    public static ProductDetailDTO getProductById(int productId) {
        ProductDetailDTO product = null;
        String sql = "SELECT id, name, price, image_path, description, quantity FROM tb_item WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = new ProductDetailDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image_path"),
                        rs.getString("description"),
                        rs.getInt("quantity")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
