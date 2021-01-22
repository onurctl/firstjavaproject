package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ogrenci {

    private JFrame pencere4 = new JFrame();
    private JPanel panel4 = new JPanel();
    private JLabel ogrenciEkran, okulIsim, no1, ad1, sinif1, tc1, dogum1, no2, ad2, sinif2, tc2, dogum2, d1s1, d1s2, d2s1, d2s2, dersSec;
    private AdminGiris okulIsimGetir = new AdminGiris();

    private  JTextField ders, n11, n12, n21, n22;

    private JButton ogrenBil, notlar, notGetir;

    void ogrenciEkran (String no, String ad_, String sinif, String tc, String dogum) {

        ImageIcon background = new ImageIcon("C:\\Users\\onurc\\IdeaProjects\\Proje\\42804a06e1bf2111.png");
        Image img = background.getImage();
        Image temp=img.getScaledInstance(922,632,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,922,632);

        Border border = BorderFactory.createLineBorder(Color.black);
         ogrenBil = new JButton("Bilgilerim");
        ogrenBil.setBorder(border);
        ogrenBil.setBounds(122, 155, 140, 35);
        ogrenBil.setContentAreaFilled(false);
        ogrenBil.setFocusPainted(false);

        no1 = new JLabel("ÖĞRENCİ NO:");
        no1.setBounds(350, 155, 150, 30);
        no1.setVisible(false);

        ad1 = new JLabel("AD SOYAD:");
        ad1.setBounds(350,185,150,30);
        ad1.setVisible(false);

        sinif1 = new JLabel("SINIF:");
        sinif1.setVisible(false);
        sinif1.setBounds(350,215,150,30);

        tc1 = new JLabel("TC NO:");
        tc1.setVisible(false);
        tc1.setBounds(350,245,150,30);

        dogum1 = new JLabel("DOĞUM TARİHİ:");
        dogum1.setVisible(false);
        dogum1.setBounds(350,275,150,30);


        no2 = new JLabel(no);
        no2.setBounds(450, 155, 150, 30);
        no2.setVisible(false);

        ad2 = new JLabel(ad_);
        ad2.setBounds(450,185,150,30);
        ad2.setVisible(false);

        sinif2 = new JLabel(sinif);
        sinif2.setVisible(false);
        sinif2.setBounds(450,215,150,30);

        tc2 = new JLabel(tc);
        tc2.setVisible(false);
        tc2.setBounds(450,245,150,30);

        dogum2 = new JLabel(dogum);
        dogum2.setVisible(false);
        dogum2.setBounds(450,275,150,30);


        ogrenBil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            bilgiler();
            }
        });

         notlar = new JButton("Notlarım");
        notlar.setBounds(122,200,140,35);
        notlar.setContentAreaFilled(false);
        notlar.setBorder(border);
        notlar.setOpaque(false);
        notlar.setFocusPainted(false);

        ogrenciEkran = new JLabel("Öğrenci Ekranı");
        ogrenciEkran.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        ogrenciEkran.setBounds(320,60,250,50);

        okulIsim = new JLabel(okulIsimGetir.getOkulAdi());
        okulIsim.setBounds(150,535,140,35);
        okulIsim.setVisible(true);


        d1s1 = new JLabel("D1S1:");
        d1s1.setVisible(false);
        d1s1.setBounds(340,160,75,30);

        d1s2 = new JLabel("D1S2:");
        d1s2.setVisible(false);
        d1s2.setBounds(340,190,75,30);

        d2s1 = new JLabel("D2S1:");
        d2s1.setVisible(false);
        d2s1.setBounds(340,220,75,30);

        d2s2 = new JLabel("D2S2:");
        d2s2.setVisible(false);
        d2s2.setBounds(340,250,75,30);

        dersSec = new JLabel("Ders:");
        dersSec.setVisible(false);
        dersSec.setBounds(340,280,75,30);

        ders = new JTextField();
        ders.setVisible(false);
        ders.setBounds(385,280,75,24);

        notGetir = new JButton("Getir");
        notGetir.setBounds(340,310,80,35);
        notGetir.setContentAreaFilled(false);
        notGetir.setBorder(border);
        notGetir.setOpaque(false);
        notGetir.setVisible(false);
        notGetir.setFocusPainted(false);

        notGetir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet sonucM, sonucTr, sonucF, sonucTa, sonucI;
                sonucM = Baglanti.matematik();
                sonucTr = Baglanti.turkce();
                sonucF = Baglanti.fizik();
                sonucTa = Baglanti.tarih();
                sonucI = Baglanti.ingilizce();

                if (ders.equals("Matematik")){
                    try {
                        while (sonucM.next()) {

                            if (sonucM.getString("ogr_no").equals(no)) {
                                n11.setText(sonucM.getString("dbir_sbir"));
                                n12.setText(sonucM.getString("1.2"));
                                n21.setText(sonucM.getString("2.1"));
                                n22.setText(sonucM.getString("2.2"));
                            }

                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

                if (ders.equals("Fizik")){
                    try {
                        while (sonucF.next()) {

                            if (sonucF.getString("ogr_no").equals(no)) {
                                n11.setText(sonucF.getString("1.1"));
                                n12.setText(sonucF.getString("1.2"));
                                n21.setText(sonucF.getString("2.1"));
                                n22.setText(sonucF.getString("2.2"));
                            }

                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

                if (ders.equals("Türkçe")){
                    try {
                        while (sonucTr.next()) {

                            if (sonucTr.getString("ogr_no").equals(no)) {
                                n11.setText(sonucTr.getString("1.1"));
                                n12.setText(sonucTr.getString("1.2"));
                                n21.setText(sonucTr.getString("2.1"));
                                n22.setText(sonucTr.getString("2.2"));
                            }

                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

                if (ders.equals("Tarih")){
                    try {
                        while (sonucTa.next()) {

                            if (sonucTa.getString("ogr_no").equals(no)) {
                                n11.setText(sonucTa.getString("1.1"));
                                n12.setText(sonucTa.getString("1.2"));
                                n21.setText(sonucTa.getString("2.1"));
                                n22.setText(sonucTa.getString("2.2"));
                            }

                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

                if (ders.equals("İngilizce")){
                    try {
                        while (sonucI.next()) {

                            if (sonucI.getString("ogr_no").equals(no)) {
                                n11.setText(sonucI.getString("1.1"));
                                n12.setText(sonucI.getString("1.2"));
                                n21.setText(sonucI.getString("2.1"));
                                n22.setText(sonucI.getString("2.2"));
                            }

                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }

            }
        });

        n11 = new JTextField();
        n11.setBounds(385, 160, 75, 24);
        n11.setVisible(false);

        n12 = new JTextField();
        n12.setBounds(385, 190, 75, 24);
        n12.setVisible(false);

        n21 = new JTextField();
        n21.setBounds(385, 220, 75, 24);
        n21.setVisible(false);

        n22 = new JTextField();
        n22.setBounds(385, 250, 75, 24);
        n22.setVisible(false);


        notlar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notlar();
            }
        });


        panel4.setLayout(null);
        panel4.add(back);

        pencere4.add(n11);pencere4.add(n12);pencere4.add(n21);pencere4.add(n22);
        pencere4.add(d1s1);pencere4.add(d1s2);pencere4.add(d2s1);pencere4.add(d2s2);
        pencere4.add(ders); pencere4.add(notGetir); pencere4.add(dersSec);

        pencere4.add(no1);
        pencere4.add(ad1);
        pencere4.add(sinif1);
        pencere4.add(tc1);
        pencere4.add(dogum1);
        pencere4.add(no2);
        pencere4.add(ad2);
        pencere4.add(sinif2);
        pencere4.add(tc2);
        pencere4.add(dogum2);
        pencere4.add(ogrenBil);
        pencere4.add(notlar);

        pencere4.add(ogrenciEkran);
        pencere4.add(okulIsim);
        pencere4.add(panel4);
        pencere4.setSize(922,671);
        pencere4.setVisible(true);
        pencere4.setLayout(null);
        pencere4.setLocationRelativeTo(null);
        pencere4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere4.setResizable(false);


    }

    void notlar(){
        no1.setVisible(false);
        ad1.setVisible(false);
        sinif1.setVisible(false);
        tc1.setVisible(false);
        dogum1.setVisible(false);

        no2.setVisible(false);
        ad2.setVisible(false);
        sinif2.setVisible(false);
        tc2.setVisible(false);
        dogum2.setVisible(false);

        n11.setVisible(true);
        n12.setVisible(true);
        n21.setVisible(true);
        n22.setVisible(true);

        d1s1.setVisible(true); d1s2.setVisible(true); d2s1.setVisible(true); d2s2.setVisible(true);

        ders.setVisible(true); notGetir.setVisible(true); dersSec.setVisible(true);

    }

    void bilgiler () {


        no1.setVisible(true);
        ad1.setVisible(true);
        sinif1.setVisible(true);
        tc1.setVisible(true);
        dogum1.setVisible(true);

        no2.setVisible(true);
        ad2.setVisible(true);
        sinif2.setVisible(true);
        tc2.setVisible(true);
        dogum2.setVisible(true);

        n11.setVisible(false);
        n12.setVisible(false);
        n21.setVisible(false);
        n22.setVisible(false);

        d1s1.setVisible(false); d1s2.setVisible(false); d2s1.setVisible(false); d2s2.setVisible(false);

        ders.setVisible(false); notGetir.setVisible(false);  dersSec.setVisible(false);

    }
}
