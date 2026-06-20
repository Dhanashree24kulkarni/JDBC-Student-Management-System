package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.dao.StudentDAO;
import com.jdbc.model.Student;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();

        while(true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch(choice) {

            case 1:

                System.out.print("Enter ID : ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Email : ");
                String email = sc.nextLine();

                Student student =
                        new Student(id, name, email);

                dao.addStudent(student);

                break;

            case 2:

                dao.viewStudents();

                break;

            case 3:

                System.out.print("Enter Student ID : ");

                int searchId = sc.nextInt();

                dao.searchStudent(searchId);

                break;

            case 4:

                System.out.print("Enter Student ID : ");

                int updateId = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Name : ");

                String newName = sc.nextLine();

                System.out.print("Enter New Email : ");

                String newEmail = sc.nextLine();

                dao.updateStudent(
                        updateId,
                        newName,
                        newEmail);

                break;

            case 5:

                System.out.print("Enter Student ID : ");

                int deleteId = sc.nextInt();

                dao.deleteStudent(deleteId);

                break;

            case 6:

                System.out.println(
                        "Thank You!");

                sc.close();

                System.exit(0);

            default:

                System.out.println(
                        "Invalid Choice");

            }

        }

    }

}