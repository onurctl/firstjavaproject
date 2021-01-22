package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ogretmen {

    private JFrame pencere3 = new JFrame();
    private JPanel panel3 = new JPanel();
    private JLabel ogretEkran, okulAd, ogretAd, ogretTc, ogretDogum, ogretDers, ogretSinif, ogretAd2, ogretTc2,
                    ogretDogum2, ogretDers2, ogretSinif2, sifreEski, sifreYeni, ogrenciNo, ders_, sinif_, ogrNo,
    d1s1, d1s2, d2s1, d2s2, ogrAd;

    private JTable not;

    private JComboBox dersC, sinifC;

    private AdminGiris okulAdGetir = new AdminGiris();

    private JButton ogretBil, sifreDegis, degistir, ogrenciGetir, notGuncelle;

    private String sifre1, sifre2;

private JScrollPane scroll;
private JTableHeader header;

    private JTextField eskiSifre, yeniSifre, ogrenciNum, n11, n12,n21,n22, ogrIsim;

    void ogretmenEkran(String sifre, String ad, String tc, String dogum, String ders, String sinif) {

        String [] dersDizi = new String[1];
        dersDizi[0] = ders;
        String [] sinifDizi = new String[1];
        sinifDizi [0] = sinif;


        ImageIcon background = new ImageIcon("C:\\Users\\onurc\\IdeaProjects\\Proje\\42804a06e1bf2111.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(922, 632, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 922, 632);

        panel3.setLayout(null);
        panel3.add(back);

        ogretEkran = new JLabel("Öğretmen Ekranı");
        ogretEkran.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        ogretEkran.setBounds(320, 60, 250, 50);

        okulAd = new JLabel(okulAdGetir.getOkulAdi());
        okulAd.setBounds(150, 535, 140, 35);
        okulAd.setVisible(true);

        Border border = BorderFactory.createLineBorder(Color.black);
        ogretBil = new JButton("Bilgilerim");
        ogretBil.setBorder(border);
        ogretBil.setBounds(122, 155, 140, 35);
        ogretBil.setContentAreaFilled(false);
        ogretBil.setFocusPainted(false);

        ogretBil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogretBil();
            }
        });
        ogretAd = new JLabel("AD SOYAD:");
        ogretAd.setBounds(350, 155, 150, 30);
        ogretAd.setVisible(false);

        ogretTc = new JLabel("TC NO:");
        ogretTc.setBounds(350,185,150,30);
        ogretTc.setVisible(false);

        ogretDogum = new JLabel("DOĞUM TARİHİ:");
        ogretDogum.setVisible(false);
        ogretDogum.setBounds(350,215,150,30);

        ogretDers = new JLabel("DERS:");
        ogretDers.setVisible(false);
        ogretDers.setBounds(350,245,150,30);

        ogretSinif = new JLabel("SINIF:");
        ogretSinif.setVisible(false);
        ogretSinif.setBounds(350,275,150,30);

         Border border2 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);

        ogretAd2 = new JLabel(ad);
        ogretAd2.setBounds(450, 155, 150, 30);
        ogretAd2.setVisible(false);
        ogretTc2 = new JLabel(tc);
        ogretTc2.setBounds(450,185,150,30);
        ogretTc2.setVisible(false);
        ogretDogum2 = new JLabel(dogum);
        ogretDogum2.setVisible(false);
        ogretDogum2.setBounds(450,215,150,30);
        ogretDers2 = new JLabel(ders);
        ogretDers2.setVisible(false);
        ogretDers2.setBounds(450,245,150,30);
        ogretSinif2 = new JLabel(sinif);
        ogretSinif2.setVisible(false);
        ogretSinif2.setBounds(450,275,150,30);

        sifreDegis = new JButton("Şifre Değiştir");
        sifreDegis.setBounds(122,200,140,35);
        sifreDegis.setContentAreaFilled(false);
        sifreDegis.setBorder(border);
        sifreDegis.setOpaque(false);
        sifreDegis.setFocusPainted(false);

        sifreEski = new JLabel("Eksi Şifre:");
        sifreEski.setBounds(350, 155, 150, 30);
        sifreEski.setVisible(false);

        sifreYeni = new JLabel("Yeni Şifre:");
        sifreYeni.setBounds(350,205,150,30);
        sifreYeni.setVisible(false);

        eskiSifre = new JTextField();
        eskiSifre.setBounds(450, 157, 150, 24);
        eskiSifre.setVisible(false);
        eskiSifre.setBorder(border2);

        yeniSifre = new JTextField();
        yeniSifre.setBounds(450, 207, 150, 24);
        yeniSifre.setVisible(false);
        yeniSifre.setBorder(border2);

        degistir = new JButton("Değiştir");
        degistir.setBounds(450,250,75,30);
        degistir.setContentAreaFilled(false);
        degistir.setBorder(border2);
        degistir.setOpaque(false);
        degistir.setVisible(false);

        degistir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sifre1 = eskiSifre.getText();
                sifre2 = yeniSifre.getText();
                String sqlSorgu = "UPDATE ogretmen SET sifre='"+sifre2+"'WHERE sifre="+sifre1;
                Baglanti.ogretmen_Kayit(sqlSorgu);
            }
        });

        sifreDegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sifreDegisim();
            }
        });

        JButton notIslem = new JButton("Not İşlemleri");
        notIslem.setBorder(null);
        notIslem.setBounds(122,245,140,35);
        notIslem.setContentAreaFilled(false);
        notIslem.setBorder(border);

        notIslem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notIslemi();
            }
        });


        ogrenciNo = new JLabel("Öğrenci No:");
        ogrenciNo.setVisible(false);
        ogrenciNo.setBounds(320,150,75,30);

        ogrenciNum = new JTextField();
        ogrenciNum.setBounds(400, 150, 75, 24);
        ogrenciNum.setVisible(false);
        ogrenciNum.setBorder(border2);

         ogrenciGetir = new JButton("Getir");
        ogrenciGetir.setBounds(400,185,75,30);
        ogrenciGetir.setContentAreaFilled(false);
        ogrenciGetir.setBorder(border2);
        ogrenciGetir.setOpaque(false);
        ogrenciGetir.setVisible(false);

        sinif_ = new JLabel("Sınıf:");
        sinif_.setVisible(false);
        sinif_.setBounds(530,150,75,30);

        ders_ = new JLabel("Ders: ");
        ders_.setVisible(false);
        ders_.setBounds(530,180,75,30);

        dersC = new JComboBox(dersDizi);
        dersC.setVisible(false);
        dersC.setBounds(625,150,150,25);
        dersC.setBackground(Color.white);

        sinifC = new JComboBox(sinifDizi);
        sinifC.setVisible(false);
        sinifC.setBounds(625,180,150,25);
        sinifC.setBackground(Color.white);

        notGuncelle = new JButton("Güncelle");
        notGuncelle.setBounds(625,215,75,30);
        notGuncelle.setContentAreaFilled(false);
        notGuncelle.setBorder(border2);
        notGuncelle.setOpaque(false);
        notGuncelle.setVisible(false);


        ogrAd = new JLabel("Ad Soyad:");
        ogrAd.setVisible(false);
        ogrAd.setBounds(320,380,75,30);

        ogrIsim = new JTextField();
        ogrIsim.setBounds(385, 380, 90, 24);
        ogrIsim.setVisible(false);
        ogrIsim.setBorder(border2);

         d1s1 = new JLabel("D1S1:");
        d1s1.setVisible(false);
        d1s1.setBounds(320,260,75,30);

         d1s2 = new JLabel("D1S2:");
        d1s2.setVisible(false);
        d1s2.setBounds(320,290,75,30);

         d2s1 = new JLabel("D2S1:");
        d2s1.setVisible(false);
        d2s1.setBounds(320,320,75,30);

         d2s2 = new JLabel("D2S2:");
        d2s2.setVisible(false);
        d2s2.setBounds(320,350,75,30);

        n11 = new JTextField();
        n11.setBounds(385, 260, 75, 24);
        n11.setVisible(false);
        n11.setBorder(border2);

        n12 = new JTextField();
        n12.setBounds(385, 290, 75, 24);
        n12.setVisible(false);
        n12.setBorder(border2);

        n21 = new JTextField();
        n21.setBounds(385, 320, 75, 24);
        n21.setVisible(false);
        n21.setBorder(border2);

        n22 = new JTextField();
        n22.setBounds(385, 350, 75, 24);
        n22.setVisible(false);
        n22.setBorder(border2);

ogrenciGetir.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        ResultSet sonucM, sonucTr, sonucF, sonucTa, sonucI;
        String sinifO, dersO, ogrenciN;
        sonucM = Baglanti.matematik();
        sonucTr = Baglanti.turkce();
        sonucF = Baglanti.fizik();
        sonucTa = Baglanti.tarih();
        sonucI = Baglanti.ingilizce();

        ogrenciN = ogrenciNum.getText();
        sinifO = (String) sinifC.getSelectedItem();
        dersO = (String) dersC.getSelectedItem();

        if (dersO.equals("Matematik")){
            try {
                while (sonucM.next()) {

                    if (sonucM.getString("ogrsinif").equals(sinifO) && sonucM.getString("ogr_no").equals(ogrenciN) ) {
                       ogrIsim.setText(sonucM.getString("ograd"));
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
        if (dersO.equals("Türkçe")){
            try {
                while (sonucTr.next()) {

                    if (sonucTr.getString("ogrsinif").equals(sinifO) && sonucTr.getString("ogr_no").equals(ogrenciN) ) {
                        ogrIsim.setText(sonucTr.getString("ograd"));

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

        if (dersO.equals("Fizik")){
            try {
                while (sonucF.next()) {

                    if (sonucF.getString("ogrsinif").equals(sinifO) && sonucF.getString("ogr_no").equals(ogrenciN) ) {
                        ogrIsim.setText(sonucF.getString("ograd"));

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
        if (dersO.equals("Tarih")){
            try {
                while (sonucTa.next()) {

                    if (sonucTa.getString("ogrsinif").equals(sinifO) && sonucTa.getString("ogr_no").equals(ogrenciN) ) {
                        ogrIsim.setText(sonucTa.getString("ograd"));

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

        if (dersO.equals("İngilizce")){
            try {
                while (sonucI.next()) {

                    if (sonucI.getString("ogrsinif").equals(sinifO) && sonucI.getString("ogr_no").equals(ogrenciN) ) {
                        ogrIsim.setText(sonucI.getString("ograd"));

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


        notGuncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet sonucM, sonucTr, sonucF, sonucTa, sonucI;
                String sinifO, dersO, ogrenciN, sqlSorgu;
                sonucM = Baglanti.matematik();
                String not1, not2, not3, not4;
                not1 = n11.getText();
                not2 = n12.getText();
                not3 = n21.getText();
                not4 = n22.getText();
                ogrenciN = ogrenciNum.getText();
                sinifO = (String) sinifC.getSelectedItem();
                dersO = (String) dersC.getSelectedItem();

                sonucTr = Baglanti.turkce();
                sonucF = Baglanti.fizik();
                sonucTa = Baglanti.tarih();
                sonucI = Baglanti.ingilizce();

                if(ders.equals("Matematik")) {
                    try {

                        while (sonucM.next())
                            if (sonucM.getString("ogrsinif").equals(sinifO) && sonucM.getString("ogr_no").equals(ogrenciN)) {
                                sqlSorgu = "UPDATE matematik SET dbir_sbir='" + not1 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE matematik SET 1.2='" + not2 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE matematik SET 2.1='" + not3 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE matematik SET 2.2='" + not4 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                            }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }
                if(ders.equals("Türkçe")) {
                    try {

                        while (sonucTr.next())
                            if (sonucTr.getString("ogrsinif").equals(sinifO) && sonucTr.getString("ogr_no").equals(ogrenciN)) {
                                sqlSorgu = "UPDATE turkce SET 1.1='" + not1 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE turkce SET 1.2='" + not2 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE turkce SET 2.1='" + not3 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE turkce SET 2.2='" + not4 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                            }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

                if(ders.equals("Fizik")) {
                    try {

                        while (sonucF.next())
                            if (sonucF.getString("ogrsinif").equals(sinifO) && sonucF.getString("ogr_no").equals(ogrenciN)) {
                                sqlSorgu = "UPDATE fizik SET 1.1='" + not1 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE fizik SET 1.2='" + not2 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE fizik SET 2.1='" + not3 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE fizik SET 2.2='" + not4 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                            }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

                if(ders.equals("Tarih")) {
                    try {

                        while (sonucTa.next())
                            if (sonucTa.getString("ogrsinif").equals(sinifO) && sonucTa.getString("ogr_no").equals(ogrenciN)) {
                                sqlSorgu = "UPDATE tarih SET 1.1='" + not1 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE tarih SET 1.2='" + not2 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE tarih SET 2.1='" + not3 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE tarih SET 2.2='" + not4 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                            }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

                if(ders.equals("İngilizce")) {
                    try {

                        while (sonucI.next())
                            if (sonucI.getString("ogrsinif").equals(sinifO) && sonucI.getString("ogr_no").equals(ogrenciN)) {
                                sqlSorgu = "UPDATE ingilizce SET 1.1='" + not1 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE ingilizce SET 1.2='" + not2 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE ingilizce SET 2.1='" + not3 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                                sqlSorgu = "UPDATE ingilizce SET 2.2='" + not4 + "'WHERE ogr_no=" + ogrenciN;
                                Baglanti.ogrenci_Kayit(sqlSorgu);
                            }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

    }

        });

 pencere3.add(d1s1);pencere3.add(d1s2);pencere3.add(d2s1);pencere3.add(d2s2);
pencere3.add(n11); pencere3.add(n12);pencere3.add(n21);pencere3.add(n22);
pencere3.add(dersC);
        pencere3.add(sinifC);
        pencere3.add(ders_);
pencere3.add(sinif_);

      pencere3.add(notIslem);
      pencere3.add(ogrenciGetir);
      pencere3.add(ogrenciNo);
      pencere3.add(ogrenciNum);
      pencere3.add(notGuncelle);
      pencere3.add(ogrAd); pencere3.add(ogrIsim);

        pencere3.add(eskiSifre);
        pencere3.add(yeniSifre);
pencere3.add(sifreEski);
pencere3.add(sifreYeni);
pencere3.add(degistir);
        pencere3.add(sifreDegis);
        pencere3.add(ogretAd);
        pencere3.add(ogretAd2);
        pencere3.add(ogretTc2);
        pencere3.add(ogretDers2);
        pencere3.add(ogretDogum2);
        pencere3.add(ogretSinif2);
        pencere3.add(ogretTc);
        pencere3.add(ogretDers);
        pencere3.add(ogretDogum);
        pencere3.add(ogretSinif);
        pencere3.add(ogretBil);
        pencere3.add(ogretEkran);
        pencere3.add(okulAd);
        pencere3.add(panel3);

        pencere3.setSize(922, 671);
        pencere3.setVisible(true);
       // pencere3.setLayout(null);
        pencere3.setLocationRelativeTo(null);
        pencere3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere3.setResizable(false);



    }
void notIslemi () {
    ogretEkran.setText("Not İşlemleri");

    ogretAd.setVisible(false);         ogretTc.setVisible(false);
    ogretDogum.setVisible(false);
    ogretDers.setVisible(false);
    ogretSinif.setVisible(false);

    ogretAd2.setVisible(false);         ogretTc2.setVisible(false);
    ogretDogum2.setVisible(false);         ogretSinif2.setVisible(false);
    ogretDers2.setVisible(false);

    eskiSifre.setVisible(false);         yeniSifre.setVisible(false);
    sifreYeni.setVisible(false);         sifreEski.setVisible(false);
    degistir.setVisible(false);

    ogrenciGetir.setVisible(true);
    ogrenciNum.setVisible(true);
    ogrenciNo.setVisible(true);
ders_.setVisible(true);
    sinif_.setVisible(true);
    dersC.setVisible(true);
    sinifC.setVisible(true);
    notGuncelle.setVisible(true);
    ogrenciNo.setVisible(true);
    d1s1.setVisible(true);d1s2.setVisible(true);d2s1.setVisible(true);
    d2s2.setVisible(true);
n11.setVisible(true); n12.setVisible(true);n21.setVisible(true);n22.setVisible(true);

    ogrAd.setVisible(true);
    ogrIsim.setVisible(true);

}



    void sifreDegisim() {
        ogretEkran.setText("Şifre İşlemleri");

        d1s1.setVisible(false);d1s2.setVisible(false);d2s1.setVisible(false);
        d2s2.setVisible(false);
        n11.setVisible(false); n12.setVisible(false);n21.setVisible(false);n22.setVisible(false);

        ogrAd.setVisible(false);
        ogrIsim.setVisible(false);

        ogretAd.setVisible(false);         ogretTc.setVisible(false);
        ogretDogum.setVisible(false);
        ogretDers.setVisible(false);
        ogretSinif.setVisible(false);

        ogretAd2.setVisible(false);         ogretTc2.setVisible(false);
        ogretDogum2.setVisible(false);         ogretSinif2.setVisible(false);
        ogretDers2.setVisible(false);


        ogrenciGetir.setVisible(false);
        ogrenciNum.setVisible(false);
        ogrenciNo.setVisible(false);
        ders_.setVisible(false);
        sinif_.setVisible(false);
        dersC.setVisible(false);
        sinifC.setVisible(false);
        notGuncelle.setVisible(false);

        eskiSifre.setVisible(true);         yeniSifre.setVisible(true);
        sifreYeni.setVisible(true);         sifreEski.setVisible(true);
                        degistir.setVisible(true);


    }

    void ogretBil() {
        ogretEkran.setText("Bilgilerim");

        d1s1.setVisible(false);d1s2.setVisible(false);d2s1.setVisible(false);
        d2s2.setVisible(false);
        n11.setVisible(false); n12.setVisible(false);n21.setVisible(false);n22.setVisible(false);
        ogrAd.setVisible(false);
        ogrIsim.setVisible(false);

        ogrenciGetir.setVisible(false);
        ogrenciNum.setVisible(false);
        ogrenciNo.setVisible(false);
        ders_.setVisible(false);
        sinif_.setVisible(false);
        dersC.setVisible(false);
        sinifC.setVisible(false);
        notGuncelle.setVisible(false);

        degistir.setVisible(false);

        eskiSifre.setVisible(false);         yeniSifre.setVisible(false);
        sifreYeni.setVisible(false);         sifreEski.setVisible(false);

        ogretAd.setVisible(true);         ogretTc.setVisible(true);
        ogretDogum.setVisible(true);
        ogretDers.setVisible(true);
        ogretSinif.setVisible(true);

        ogretAd2.setVisible(true);         ogretTc2.setVisible(true);
        ogretDogum2.setVisible(true);         ogretSinif2.setVisible(true);
        ogretDers2.setVisible(true);

    }
}

    interface Cikis {
        public void cikisMesaj();
    }

        class CikisYap implements Cikis{

            public void cik(){
            System.exit(0);
            }

            @Override
            public void cikisMesaj() {
                System.out.println("Çıkış yapıldı");

            }
        }
            // çıkış metodunun yer aldığı Cikis sınıfını, Cikis Yap sınıfına implement ettik
            // ardından sistemden çıkış yapılması ve çıkış mesajına dair metodu kullandık
