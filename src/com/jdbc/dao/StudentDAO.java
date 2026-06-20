package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.model.Student;
import com.jdbc.util.DBConnection;

public class StudentDAO {

    public void addStudent(Student student) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO STUDENT(ID,NAME,EMAIL) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Student Added Successfully");

            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
    public void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM STUDENT";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("----------------------------");
            System.out.println("ID\tNAME\tEMAIL");
            System.out.println("----------------------------");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("ID") + "\t" +
                        rs.getString("NAME") + "\t" +
                        rs.getString("EMAIL"));

            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
    public void searchStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM STUDENT WHERE ID=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                System.out.println("Student Found");

                System.out.println("ID : "
                        + rs.getInt("ID"));

                System.out.println("NAME : "
                        + rs.getString("NAME"));

                System.out.println("EMAIL : "
                        + rs.getString("EMAIL"));

            }
            else {

                System.out.println(
                        "Student Not Found");

            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
    public void updateStudent(int id, String newName, String newEmail) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "UPDATE STUDENT SET NAME=?, EMAIL=? WHERE ID=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, newName);
            ps.setString(2, newEmail);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Student Updated Successfully");

            } else {

                System.out.println("Student Not Found");

            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
    public void deleteStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "DELETE FROM STUDENT WHERE ID=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Student Deleted Successfully");

            } else {

                System.out.println("Student Not Found");

            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
}