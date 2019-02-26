package com.company;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MysqlCon{
    public static void main(String args[]) {



        List<Student> listaStudentow = new ArrayList<>();

        try(Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            rs.beforeFirst();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                Integer fee = rs.getInt("fee");
                Student student = new Student(id, firstName, lastName, dob, email, fee);

                listaStudentow.add(student);
            }

            System.out.println();
            System.out.println("Lista studentoe bez ocen");

            listaStudentow.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(Connection con2 = DBConnection.getConnection();
            Statement stmt2 = con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM oceny")) {

            List<Oceny> listaWszystkichOcen = new ArrayList<>();
            rs2.beforeFirst();
            while (rs2.next()) {
                Integer id = rs2.getInt("ID");
                Integer wartosc = rs2.getInt("WARTOSC");
                Integer idStudent = rs2.getInt("ID_STUDENT");
                Integer idNauczyciel = rs2.getInt("ID_NAUCZYCIEL");

                listaWszystkichOcen.add(new Oceny(id.longValue(),wartosc,idStudent,idNauczyciel));
            }

            System.out.println();
            System.out.println("Lista studentow z ocenami");
            for (Student s:listaStudentow) {
                List<Oceny> listaOcenStudenta = new ArrayList<>();
                for(Oceny o:listaWszystkichOcen){
                    if(s.getId().equals(o.getIdStudent()))
                        listaOcenStudenta.add(o);
                }
                s.setListaOcenStudent(listaOcenStudenta);
            }

            listaStudentow.forEach(System.out::println);

            System.out.println();
            System.out.println("Wartosci ocen z id <= 2 posortowanych po imieniu:");
            List<Student> listaStudentowMniej = new ArrayList<>();
            for (Student s:listaStudentow){
                if(s.getId()<=2)
                    listaStudentowMniej.add(s);
            }
            listaStudentowMniej.sort(Comparator.comparing(Student::getFirstName));


            List<Student> listaStudentowWiecej = new ArrayList<>();
            for (Student s:listaStudentow){
                if(s.getId()>2)
                    listaStudentowWiecej.add(s);
            }
            listaStudentowWiecej.sort(Comparator.comparing(Student::getLastName));



            for (Student s:listaStudentowMniej){
                for (Oceny o:s.getListaOcenStudent())
                    System.out.println(o.getWartosc());
            }

            System.out.println();
            System.out.println("Wartosci ocen z id > 2 posortowanych po nazwisku:");
            for (Student s:listaStudentowWiecej){
                for (Oceny o:s.getListaOcenStudent())
                    System.out.println(o.getWartosc());
            }

            listaStudentow.stream()
                    .filter(s -> s.getId() <= 2)
                    .sorted(Comparator.comparing(Student::getFirstName))
                    .flatMap(s -> s.getListaOcenStudent().stream())
                    .map(Oceny::getWartosc)
                    .forEach(System.out::println);

            System.out.println();
            System.out.println("Od litery m nazwisko, imiona alfabetycznie same oceny");
            listaStudentow.stream()
                    .filter(s -> s.getLastName().startsWith("m"))
                    .sorted(Comparator.comparing(Student::getFirstName))
                    .flatMap(s -> s.getListaOcenStudent().stream())
                    .map((Oceny::getWartosc))
                    .forEach(System.out::println);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

}
}