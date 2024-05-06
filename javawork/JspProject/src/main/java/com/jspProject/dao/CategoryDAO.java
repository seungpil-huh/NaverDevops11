package com.jspProject.dao;

import com.jspProject.dto.CategoryDTO;
import com.jspProject.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public static List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categories = new ArrayList<>();
        String sql = "SELECT id, name, description FROM tb_category";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
