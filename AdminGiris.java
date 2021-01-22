package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminGiris  {

private String kullaniciAdi;
private String sifre;
private final String okulAdi ="Ankara Lisesi";

static JFrame pencere;

    public String getOkulAdi() {
        return okulAdi;
    }

    public static void main(String[] args) {

        int guvenKodu = (int) (Math.random()*10000);
        String gKodu = Integer.toString(guvenKodu);

        JLabel captcha = new JLabel(gKodu);
        captcha.setBounds(570,382,50,30);
        captcha.setForeground(Color.gray);
        captcha.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

        pencere = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton ogretmen = new JButton("Öğretmen");
        ogretmen.setBorder(null);
        ogretmen.setBounds(550,420,80,30);
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        ogretmen.setBorder(border);
        ogretmen.setContentAreaFilled(false);
        panel.add(ogretmen);

        JButton ogrenciB = new JButton("Öğrenci");
        ogrenciB.setBorder(null);
        ogrenciB.setBounds(457,420,80,30);
        ogrenciB.setBorder(border);
        ogrenciB.setContentAreaFilled(false);
        panel.add(ogrenciB);

        JButton girisButon = new JButton("Yönetim");
        girisButon.setBorder(null);
        girisButon.setBounds(457,380,80,30);
        girisButon.setBorder(border);
        girisButon.setContentAreaFilled(false);

        panel.add(girisButon);

        JLabel kullaniciGiris = new JLabel("Kullanıcı Giriş");
        kullaniciGiris.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        kullaniciGiris.setBounds(320,60,250,50);

        JTextField adText, sifreText, guvenliKod;
        adText = new JTextField();
        adText.setBounds(460,200,135,28);
        adText.setVisible(true);
        panel.add(adText);

        JLabel kulAdi = new JLabel("Kullanıcı Adı:");
        kulAdi.setBounds(360,199,80,30);

        adText.setBorder(border);

        sifreText = new JTextField();
        sifreText.setBounds(460,260,135,28);
        sifreText.setVisible(true);

        sifreText.setBorder(border);
        panel.add(sifreText);

        JLabel sif = new JLabel("Şifre:");
        sif.setBounds(360,259,80,30);

        guvenliKod = new JTextField();
        guvenliKod.setBounds(460,320,135,28);
        guvenliKod.setVisible(true);

        guvenliKod.setBorder(border);
        panel.add(guvenliKod);

        JLabel guven = new JLabel("Güvenlik Kodu:");
        guven.setBounds(360,319,85,30);

        ImageIcon background = new ImageIcon("C:\\Users\\onurc\\IdeaProjects\\Proje\\42804a06e1bf2.png");
        Image img = background.getImage();
        Image temp=img.getScaledInstance(922,632,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,922,632);

        panel.add(back);
        pencere.add(kulAdi);
        pencere.add(sif);
        pencere.add(guven);
        pencere.add(kullaniciGiris);
        pencere.add(captcha);
        pencere.add(panel);

        Baglanti veritabani = new Baglanti();

        girisButon.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ad = adText.getText();
                String sifre_ = sifreText.getText();
                String kod = guvenliKod.getText();

               ResultSet sonuc2 = veritabani.baglanti();

                try {

                    while (sonuc2.next()) {

                        String baglantiad = sonuc2.getString("idyonetim");
                        String baglantisifre = sonuc2.getString("sifreyonetim");

                        if (baglantisifre.equals(sifre_) && baglantiad.equals(ad) && gKodu.equals(kod)) {

                            pencere.setVisible(false);
                            Yonetim pencere2 = new Yonetim();
                            pencere2.anaEkran();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Hatalı veri girişi!");

                    }  }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Veritabanı bağlantı sorunu!");


                }

            }
        });



        ogretmen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ad = adText.getText();
                String sifre_ = sifreText.getText();
                String kod = guvenliKod.getText();

                Baglanti veritabani2 = new Baglanti();
                ResultSet sonuc3 = Baglanti.ogretmenBaglanti();


                    try {
                        while (sonuc3.next()) {

                            String baglantiad = sonuc3.getString("adsoyad");
                            String baglantisifre = sonuc3.getString("sifre");

                            if (baglantisifre.equals(sifre_) && baglantiad.equals(ad) && gKodu.equals(kod)) {

                                String tc = sonuc3.getString("tc");
                                String dogum = sonuc3.getString("dogum");
                                String ders = sonuc3.getString("ders");
                                String sinif = sonuc3.getString("ogretsinif");
                                Ogretmen pencere_3 = new Ogretmen();
                                pencere.setVisible(false);
                                pencere_3.ogretmenEkran(baglantisifre, baglantiad, tc, dogum, ders, sinif);
                            }
                            else { JOptionPane.showMessageDialog(null, "Hatalı veri girişi!"); }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }



            }
        });

        ogrenciB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ad = adText.getText();
                String sifre_ = sifreText.getText();
                String kod = guvenliKod.getText();

                Baglanti veritabani2 = new Baglanti();
                ResultSet sonuc3 = Baglanti.ogrenciIslemBaglanti();


                try {
                    while (sonuc3.next()) {

                        String baglantiad = sonuc3.getString("ograd");
                        String baglantisifre = sonuc3.getString("ogr_no");

                        if (baglantisifre.equals(sifre_) && baglantiad.equals(ad) && gKodu.equals(kod)) {

                            String no = sonuc3.getString("ogr_no");
                            String ad_ = sonuc3.getString("ograd");
                            String sinif = sonuc3.getString("ogrsinif");
                            String tc = sonuc3.getString("ogrtc");
                            String dogum = sonuc3.getString("ogrdogum");

                            Ogrenci pencere_4 = new Ogrenci();
                            pencere.setVisible(false);
                            pencere_4.ogrenciEkran(no, ad_, sinif, tc, dogum);
                        }
                       // else { JOptionPane.showMessageDialog(null, "Hatalı veri girişi!"); }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        pencere.setSize(922,671);
        pencere.setVisible(true);
        pencere.setLayout(null);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setLocationRelativeTo(null);
        pencere.setTitle("eOkul - Bilgi Sistemi");

        }

}


