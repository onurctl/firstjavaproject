package com.company;

import javax.swing.*;
import java.sql.*;

class Baglanti {

static Connection connection;
static Statement durum;

    public ResultSet baglanti(){
        ResultSet sonuc;

        final  String url = "jdbc:mysql://localhost/eokul?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final  String username = "root";
        final  String password = "202123";

        try  {
            connection = DriverManager.getConnection(url, username, password);
            durum = (Statement) connection.createStatement();
            sonuc = durum.executeQuery("select * from yonetim");
            System.out.println("Veritabanı bağlantısı başarıyla gerçekleşti!");

            return sonuc;
        } catch (SQLException e) {
            throw new IllegalStateException("Veritabanı bağlantısı gerçekleşmedi!", e);
        }

    }


    static void ogretmen_Kayit(String sqlString){

        try {
            durum.executeUpdate(sqlString);
            JOptionPane.showMessageDialog(null, "İşlem başarıyla gerçekleşti!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Bir hata gerçekleşti!");


        }
    }


    static void ogrenci_Kayit(String sqlString){

        try {
            durum.executeUpdate(sqlString);
            JOptionPane.showMessageDialog(null, "İşlem başarıyla gerçekleşti!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Bir hata gerçekleşti!");


        }
    }

    static void ogrenciIslem(String sqlString, String sqlString2, String sqlString3, String sqlString4, String sqlString5, String sqlString6){

        try {
            durum.executeUpdate(sqlString);
            durum.executeUpdate(sqlString2);
            durum.executeUpdate(sqlString3);
            durum.executeUpdate(sqlString4);
            durum.executeUpdate(sqlString5);
            durum.executeUpdate(sqlString6);
            JOptionPane.showMessageDialog(null, "İşlem başarıyla gerçekleşti!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Bir hata gerçekleşti!");

        }
    }

static ResultSet ogrenciIslemBaglanti () {

    ResultSet sonuc;

    final String url = "jdbc:mysql://localhost/eokul?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String username = "root";
    final String password = "202123";

    try  {
        connection = DriverManager.getConnection(url, username, password);
        durum = (Statement) connection.createStatement();
        sonuc = durum.executeQuery("select * from ogrenci");
        System.out.println("Veritabanı bağlantısı başarıyla gerçekleşti!");
        return sonuc;
    } catch (SQLException e) {
        throw new IllegalStateException("Veritabanı bağlantısı gerçekleşmedi!", e);
    }

}

static ResultSet ogretmenBaglanti (){
    ResultSet sonuc;

    final String url = "jdbc:mysql://localhost/eokul?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String username = "root";
    final String password = "202123";

    try  {
        connection = DriverManager.getConnection(url, username, password);
        durum = (Statement) connection.createStatement();
        sonuc = durum.executeQuery("select * from ogretmen");
        System.out.println("Veritabanı bağlantısı başarıyla gerçekleşti!");
        return sonuc;
    } catch (SQLException e) {
        throw new IllegalStateException("Veritabanı bağlantısı gerçekleşmedi!", e);
    }


}

    static ResultSet matematik (){
        ResultSet sonuc;

        final String url = "jdbc:mysql://localhost/eokul?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "202123";

        try  {
            connection = DriverManager.getConnection(url, username, password);
            durum = (Statement) connection.createStatement();
            sonuc = durum.executeQuery("select * from matematik");
            System.out.println("Veritabanı bağlantısı başarıyla gerçekleşti!");

            return sonuc;
        } catch (SQLException e) {
            throw new IllegalStateException("Veritabanı bağlantısı gerçekleşmedi!", e);
        }


    }

    static ResultSet turkce (){
        ResultSet sonuc;

        final String url = "jdbc:mysql://localhost/eokul?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "202123";

        try  {
            connection = DriverManager.getConnection(url, username, password);
            durum = (Statement) connection.createStatement();
            sonuc = durum.executeQuery("select * from turkce");
            System.out.println("Veritabanı bağlantısı başarıyla gerçekleşti!");

            return sonuc;
        } catch (SQLException e) {
            throw new IllegalStateException("Veritabanı bağlantısı gerçekleşmedi!", e);
        }


    }


    static ResultSet tarih (){
        ResultSet sonuc;

        final String url = "jdbc:mysql://localhost/eokul?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "202123";

        try  {
            connection = DriverManager.getConnection(url, username, password);
            durum = (Statement) connection.createStatement();
            sonuc = durum.executeQuery("select * from tarih");
            System.out.println("Veritabanı bağlantısı başarıyla gerçekleşti!");

            return sonuc;
        } catch (SQLException e) {
            throw new IllegalStateException("Veritabanı bağlantısı gerçekleşmedi!", e);
        }


    }

    static ResultSet fizik (){
        ResultSet sonuc;

        final String url = "jdbc:mysql://localhost/eokul?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "202123";

        try  {
            connection = DriverManager.getConnection(url, username, password);
            durum = (Statement) connection.createStatement();
            sonuc = durum.executeQuery("select * from fizik");
            System.out.println("Veritabanı bağlantısı başarıyla gerçekleşti!");

            return sonuc;
        } catch (SQLException e) {
            throw new IllegalStateException("Veritabanı bağlantısı gerçekleşmedi!", e);
        }


    }

    static ResultSet ingilizce (){
        ResultSet sonuc;

        final String url = "jdbc:mysql://localhost/eokul?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String username = "root";
        final String password = "202123";

        try  {
            connection = DriverManager.getConnection(url, username, password);
            durum = (Statement) connection.createStatement();
            sonuc = durum.executeQuery("select * from ingilizce");
            System.out.println("Veritabanı bağlantısı başarıyla gerçekleşti!");

            return sonuc;
        } catch (SQLException e) {
            throw new IllegalStateException("Veritabanı bağlantısı gerçekleşmedi!", e);
        }


    }
}
