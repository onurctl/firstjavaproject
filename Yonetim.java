package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.Baglanti.*;

class Yonetim extends JFrame {

    /* INHERITANCE KULLANIMI (extends komutu ile): Yonetim sınıfı, JFrame sınıfını miras aldığı için
    JFrame artık onun subclass'ı oldu, JFrame metodlarına direkt ulaşabileceğiz, yani JFrame'de herhangi
    bir nesne tanımlamadan direkt çalıştırabileceğiz, örneğin: setVisible(false); pencere görünürlüğünü kapatacaktır,
    eğer miras almasaydık JFrame'de nesne oluşturarak metoda erişebilirdik, örneğin: frame1.setVisible(false) */

    private String ogrno, ograd, ogrsinif, ogrtc, ogrdogum, ogrenciNo, ogretisim, ogretc, ogretders, ogretdogum,
                    ogretsinif, ogretsifre, sqlString, sqlString2, sqlString3, sqlString4, sqlString5, sqlString6,
                    sqlSorgu;

    private JLabel ana_Ekran, okulAdi, ogrenciKayit, ogrenciKayit2, ogrenciKayit3, ogrenciKayit4, ogrenciKayit5,
                    ogretKayitL, ogretKayitL2, ogretKayitL3, ogretKayitL4, ogretKayitL5, ogretKayitL6;

    private JTextField ogr1, ogr2, ogr3, ogr4, ogr5, ogret1, ogret2, ogret3, ogret4;

    private JButton ogrenciKayitB, ogrenciSilB, ogrenciSinifGuncelle, ogrenciGetir, ogretKayitB, ogretSilB,
                     ogretGetir;

    private JComboBox sinif, sinif2, ders;
    private String [] sinifDizi = {"9A", "9B", "10A", "10B", "11A", "11B", "12A", "12B"};
    private String [] dersDizi = {"Matematik", "Türkçe", "İngilizce", "Fizik", "Tarih"};

    private AdminGiris okulAdiGetir = new AdminGiris();

    void anaEkran (){

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);

        ana_Ekran = new JLabel("Yönetim Ekranı"); // MENULER YAZSIN BURADA İSİMLERİ SOL ALTA EKLERİZ..
        ana_Ekran.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        ana_Ekran.setBounds(320,60,250,50);

                Border border = BorderFactory.createLineBorder(Color.black);
        JButton ogrKayit = new JButton("Öğrenci");
        ogrKayit.setBorder(border);
        ogrKayit.setBounds(122,155,140,35);
        ogrKayit.setContentAreaFilled(false);
                ogrKayit.setFocusPainted(false);


        ogrKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogrkayit();
            }
        });


        JButton ogretKayit = new JButton("Öğretmen");

        ogretKayit.setBounds(122,200,140,35);
        ogretKayit.setContentAreaFilled(false);
        ogretKayit.setBorder(border);
        ogretKayit.setOpaque(false);
        ogretKayit.setFocusPainted(false);

        ogretKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogret_Kayit();
            }
        });

            okulAdi = new JLabel(okulAdiGetir.getOkulAdi());
        okulAdi.setBounds(150,535,140,35);
        okulAdi.setVisible(true);


        JButton cikisB = new JButton("Çıkış");
        cikisB.setBorder(null);
        cikisB.setBounds(122,245,140,35);
        cikisB.setContentAreaFilled(false);
        cikisB.setBorder(border);

        cikisB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int secim = JOptionPane.showConfirmDialog(null, "Çıkmak istiyor musunuz?", "Çıkış", JOptionPane.YES_NO_OPTION);
                if(secim == JOptionPane.YES_OPTION)
                {
                    setVisible(false);
                    AdminGiris.pencere.setVisible(true);

                }
                 }
        });


                JButton ogrSil = new JButton("Öğrenci Sil");
                ogrSil.setBounds(122,335,140,35);
                ogrSil.setContentAreaFilled(false);
                ogrSil.setBorder(border);

                JButton ogretSil = new JButton("Öğretmen Sil");
                ogretSil.setBounds(122,380,140,35);
                ogretSil.setContentAreaFilled(false);
                ogretSil.setBorder(border);

        ImageIcon background = new ImageIcon("C:\\Users\\onurc\\IdeaProjects\\Proje\\42804a06e1bf2111.png");
        Image img = background.getImage();
        Image temp=img.getScaledInstance(922,632,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,922,632);

        Border border2 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
                ogrenciKayit = new JLabel("Öğrenci No:");
                ogrenciKayit.setBounds(350,155,150,30);
                ogrenciKayit.setVisible(false);

                ogrenciKayit2 = new JLabel("Ad Soyad:");
                ogrenciKayit2.setBounds(350,205,150,30);
                ogrenciKayit2.setVisible(false);

                ogrenciKayit3 = new JLabel("Sınıf:");
                ogrenciKayit3.setVisible(false);
                ogrenciKayit3.setBounds(350,255,150,30);

                ogrenciKayit4 = new JLabel("TC No:");
                ogrenciKayit4.setVisible(false);
                ogrenciKayit4.setBounds(350,305,150,30);

                ogrenciKayit5 = new JLabel("Doğum Tarihi (GG.AA.YY):");
                ogrenciKayit5.setVisible(false);
                ogrenciKayit5.setBounds(350,355,150,30);

                ogr1 = new JTextField();
        ogr1.setVisible(false);
        ogr1.setBounds(505,156,150,25);
        ogr1.setBorder(border2);

        ogr2 = new JTextField();
        ogr2.setVisible(false);
        ogr2.setBounds(505,206,150,25);
        ogr2.setBorder(border2);

        sinif = new JComboBox(sinifDizi);
        sinif.setVisible(false);
        sinif.setBounds(505,256,150,25);
        sinif.setBackground(Color.white);

        ogr4 = new JTextField();
        ogr4.setVisible(false);
        ogr4.setBounds(505,306,150,25);
        ogr4.setBorder(border2);

        ogr5 = new JTextField();
        ogr5.setVisible(false);
        ogr5.setBounds(505,356,150,25);
        ogr5.setBorder(border2);

        ogrenciKayitB = new JButton("Kayıt");
        ogrenciKayitB.setBounds(505,406,75,30);
        ogrenciKayitB.setContentAreaFilled(false);
        ogrenciKayitB.setBorder(border2);
        ogrenciKayitB.setOpaque(false);
        ogrenciKayitB.setVisible(false);

        ogrenciKayitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            ogrno = ogr1.getText();
                ograd = ogr2.getText();
                ogrsinif = (String) sinif.getSelectedItem();
                ogrtc = ogr4.getText();
                ogrdogum = ogr5.getText();

                sqlString = "INSERT INTO ogrenci (ogr_no,ograd,ogrsinif,ogrtc,ogrdogum) VALUES (" + ogrno + ",'" + ograd + "'," + "'" + ogrsinif + "'," + "'" + ogrtc + "'," + "'" + ogrdogum + "')";

                sqlString2 = "INSERT INTO fizik (ogr_no,ograd,ogrsinif) VALUES (" + ogrno + ",'" + ograd + "'," + "'" + ogrsinif + "')";
                //ogrenciIslem(sqlString);
                sqlString3 = "INSERT INTO matematik (ogr_no,ograd,ogrsinif) VALUES (" + ogrno + ",'" + ograd + "'," + "'" + ogrsinif + "')";
                //ogrenciIslem(sqlString);
                sqlString4 = "INSERT INTO tarih (ogr_no,ograd,ogrsinif) VALUES (" + ogrno + ",'" + ograd + "'," + "'" + ogrsinif + "')";
                //ogrenciIslem(sqlString);
                sqlString5 = "INSERT INTO ingilizce (ogr_no,ograd,ogrsinif) VALUES (" + ogrno + ",'" + ograd + "'," + "'" + ogrsinif + "')";
                //ogrenciIslem(sqlString);
                sqlString6 = "INSERT INTO turkce (ogr_no,ograd,ogrsinif) VALUES (" + ogrno + ",'" + ograd + "'," + "'" + ogrsinif + "')";
               // ogrenciIslem(sqlString);

                ogrenciIslem(sqlString,sqlString2,sqlString3,sqlString4,sqlString5,sqlString6 );

            }
        });

        ogrenciSilB = new JButton("Sil");
        ogrenciSilB.setBounds(585,406,75,30);
        ogrenciSilB.setContentAreaFilled(false);
        ogrenciSilB.setBorder(border2);
        ogrenciSilB.setOpaque(false);
        ogrenciSilB.setVisible(false);

        ogrenciSilB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // String ogrno, sqlString;
                ogrno = ogr1.getText();
                sqlString = "DELETE FROM ogrenci WHERE ogr_no="+ogrno;
                //ogrenciIslem(sqlString);
                sqlString2 = "DELETE FROM matematik WHERE ogr_no="+ogrno;
                //ogrenciIslem(sqlString);
                sqlString3 = "DELETE FROM fizik WHERE ogr_no="+ogrno;
                //ogrenciIslem(sqlString);
                sqlString4 = "DELETE FROM ingilizce WHERE ogr_no="+ogrno;
                //ogrenciIslem(sqlString);
                sqlString5 = "DELETE FROM turkce WHERE ogr_no="+ogrno;
                //ogrenciIslem(sqlString);
                sqlString6 = "DELETE FROM tarih WHERE ogr_no="+ogrno;
               // ogrenciIslem(sqlString);
                ogrenciIslem(sqlString,sqlString2,sqlString3,sqlString4,sqlString5,sqlString6 );

            }
        });

        ogrenciGetir = new JButton("Getir");
        ogrenciGetir.setBounds(585,445,75,30);
        ogrenciGetir.setContentAreaFilled(false);
        ogrenciGetir.setBorder(border2);
        ogrenciGetir.setOpaque(false);
        ogrenciSilB.setFocusPainted(false);
        ogrenciGetir.setVisible(false);

        ogrenciGetir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogrenciNo = ogr1.getText();
                ResultSet ogrencisonuc = Baglanti.ogrenciIslemBaglanti();

                    try {
while (ogrencisonuc.next()) {
                        if (ogrencisonuc.getString("ogr_no").equals(ogrenciNo)) {
                            ogr2.setText(ogrencisonuc.getString("ograd"));
    sinif.setSelectedItem(ogrencisonuc.getString("ogrsinif"));
                        ogr4.setText(ogrencisonuc.getString("ogrtc"));
                        ogr5.setText(ogrencisonuc.getString("ogrdogum"));}
                        }

                    } catch (SQLException throwables) {
                        JOptionPane.showMessageDialog(null, "Veritabanı bağlantı sorunu!");
                        throwables.printStackTrace();
                    }

            }
        });


        ogrenciSinifGuncelle = new JButton("Güncelle");
        ogrenciSinifGuncelle.setBounds(505,445,75,30);
        ogrenciSinifGuncelle.setContentAreaFilled(false);
        ogrenciSinifGuncelle.setBorder(border2);
        ogrenciSinifGuncelle.setOpaque(false);
        ogrenciSinifGuncelle.setVisible(false);

        ogrenciSinifGuncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ogrenci_no = ogr1.getText();
                String ogrAd = ogr2.getText();
                String ogrSinif = (String) sinif.getSelectedItem();

                sqlSorgu     = "UPDATE ogrenci SET ogrsinif='"+ogrSinif+"'WHERE ogr_no="+ogrenci_no;
                //ogrenci_Kayit(sqlSorgu);

               sqlString = "INSERT INTO fizik (ogr_no,ograd,ogrsinif) VALUES (" + ogrenci_no + ",'" + ogrAd + "'," + "'" + ogrSinif + "')";
                //ogrenci_Kayit(sqlString);
                sqlString2 = "INSERT INTO matematik (ogr_no,ograd,ogrsinif) VALUES (" + ogrenci_no + ",'" + ogrAd + "'," + "'" + ogrSinif + "')";
                //ogrenci_Kayit(sqlString);
                sqlString3 = "INSERT INTO tarih (ogr_no,ograd,ogrsinif) VALUES (" + ogrenci_no + ",'" + ogrAd + "'," + "'" + ogrSinif + "')";
                //ogrenci_Kayit(sqlString);
                sqlString4 = "INSERT INTO ingilizce (ogr_no,ograd,ogrsinif) VALUES (" + ogrenci_no + ",'" + ogrAd + "'," + "'" + ogrSinif + "')";
                //ogrenci_Kayit(sqlString);
                sqlString5 = "INSERT INTO turkce (ogr_no,ograd,ogrsinif) VALUES (" + ogrenci_no + ",'" + ogrAd + "'," + "'" + ogrSinif + "')";
                //Baglanti.ogrenci_Kayit(sqlString);

                Baglanti.ogrenciIslem(sqlSorgu,sqlString, sqlString2, sqlString3, sqlString4,sqlString5);

            }
        });

        ogretKayitL = new JLabel("Şifre:");
        ogretKayitL.setBounds(350,155,150,30);
        ogretKayitL.setVisible(false);

        ogretKayitL2 = new JLabel("Ad Soyad");
        ogretKayitL2.setBounds(350,205,150,30);
        ogretKayitL2.setVisible(false);

        ogretKayitL3 = new JLabel("TC No:");
        ogretKayitL3.setVisible(false);
        ogretKayitL3.setBounds(350,255,150,30);

        ogretKayitL4 = new JLabel("Doğum Tarihi (GG.AA.YY):");
        ogretKayitL4.setVisible(false);
        ogretKayitL4.setBounds(350,305,150,30);

        ogretKayitL5 = new JLabel("Ders:");
        ogretKayitL5.setVisible(false);
        ogretKayitL5.setBounds(350,355,150,30);

        ogretKayitL6 = new JLabel("Sınıf:");
        ogretKayitL6.setVisible(false);
        ogretKayitL6.setBounds(350,405,150,30);

        ogret1 = new JTextField();
        ogret1.setVisible(false);
        ogret1.setBounds(505,156,150,25);
        ogret1.setBorder(border2);

        ogret2 = new JTextField();
        ogret2.setVisible(false);
        ogret2.setBounds(505,206,150,25);
        ogret2.setBorder(border2);

        ogret3 = new JTextField();
        ogret3.setVisible(false);
        ogret3.setBounds(505,256,150,25);
        ogret3.setBorder(border2);

        ogret4 = new JTextField();
        ogret4.setVisible(false);
        ogret4.setBounds(505,306,150,25);
        ogret4.setBorder(border2);

        ders = new JComboBox(dersDizi);
        ders.setVisible(false);
        ders.setBounds(505,356,150,25);
        ders.setBackground(Color.white);

        sinif2 = new JComboBox(sinifDizi);
        sinif2.setVisible(false);
        sinif2.setBounds(505,406,150,25);
        sinif2.setBackground(Color.white);

        ogretKayitB = new JButton("Kayıt");
        ogretKayitB.setBounds(505,445,75,30);
        ogretKayitB.setContentAreaFilled(false);
        ogretKayitB.setBorder(border2);
        ogretKayitB.setOpaque(false);
        ogretKayitB.setVisible(false);

        ogretKayitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ogretsifre = ogret1.getText();
                ogretisim = ogret2.getText();
                ogretc = ogret3.getText();
                ogretdogum = ogret4.getText();
                ogretders = (String) ders.getSelectedItem();
                ogretsinif = (String) sinif2.getSelectedItem();

                sqlString = "INSERT INTO ogretmen (sifre,adsoyad,tc,dogum,ders,ogretsinif) VALUES (" + ogretsifre + ",'" + ogretisim + "'," + "'" + ogretc + "'," + "'" + ogretdogum + "'," + "'" + ogretders + "'," + "'" + ogretsinif + "')";
                ogretmen_Kayit(sqlString);
            }
        });

        ogretSilB = new JButton("Sil");
        ogretSilB.setBounds(585,445,75,30);
        ogretSilB.setContentAreaFilled(false);
        ogretSilB.setBorder(border2);
        ogretSilB.setOpaque(false);
        ogretSilB.setVisible(false);

        ogretSilB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogretsifre = ogret1.getText();
                sqlString = "DELETE FROM ogretmen WHERE sifre='"+ogretsifre+"'";
                ogretmen_Kayit(sqlString);

            }
        });

        ogretGetir = new JButton("Getir");
        ogretGetir.setBounds(665,445,75,30);
        ogretGetir.setContentAreaFilled(false);
        ogretGetir.setBorder(border2);
        ogretGetir.setOpaque(false);
        ogretGetir.setFocusPainted(false);
        ogretGetir.setVisible(false);

        ogretGetir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogretisim = ogret2.getText();
                ResultSet ogretmensonuc = Baglanti.ogretmenBaglanti();
                try {
                    while (ogretmensonuc.next()) {
                        if (ogretmensonuc.getString("adsoyad").equals(ogretisim)) {

                            ogret1.setText(ogretmensonuc.getString("sifre"));
                            ogret3.setText(ogretmensonuc.getString("tc"));
                            ogret4.setText(ogretmensonuc.getString("dogum"));
                            ders.setSelectedItem(ogretmensonuc.getString("ders"));
                            sinif2.setSelectedItem(ogretmensonuc.getString("ogretsinif"));}

                    }

                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(null, "Veritabanı bağlantı sorunu!");
                    throwables.printStackTrace();
                }
            }
        });


        panel2.add(back);
        add(ana_Ekran);
                add(ogrenciKayit);
                add(ogrenciKayit2);
                add(ogrenciKayit3);
                add(ogrenciKayit4);
                add(ogrenciKayit5);
        add(ogr1);
        add(okulAdi);
        add(ogr2);
        add(ogr4);
        add(ogr5);
                add(ogrKayit);
                setTitle("eOkul - Bilgi Sistemi");
                add(cikisB);

                add(ogretKayit);
                add(ogrenciSinifGuncelle);
                add(ogrenciGetir);
                add(ogrenciKayitB);
                add(ogrenciSilB);
                add(ogretKayitL);
                add(sinif); add(sinif2); add(ders);
        add(ogretKayitL2);
        add(ogretKayitL3);
        add(ogretKayitL4);
        add(ogretKayitL5);
        add(ogretKayitL6);
        add(ogret1); add(ogret2);add(ogret3);add(ogret4);
        add(ogretKayitB); add(ogretSilB);
        add(ogretGetir);

        add(panel2);
                setSize(922,671);
                setVisible(true);
                setLayout(null);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(false);

    }

    private void ogrkayit(){

         ogretKayitL.setVisible(false);
         ogretKayitL2.setVisible(false);
         ogretKayitL3.setVisible(false);
         ogretKayitL4.setVisible(false);
         ogretKayitL5.setVisible(false);
         ogretKayitL6.setVisible(false);
         ogret1.setVisible(false);        ogret2.setVisible(false);
         ogret3.setVisible(false);
         ogret4.setVisible(false);
         ogretKayitB.setVisible(false);
         ogretSilB.setVisible(false);
        ogretGetir.setVisible(false); sinif2.setVisible(false); ders.setVisible(false);

        ogrenciKayit.setVisible(true);
            ogrenciKayit2.setVisible(true);
            ogrenciKayit3.setVisible(true);
            ogrenciKayit4.setVisible(true);
            ogrenciKayit5.setVisible(true);
            ogr1.setVisible(true);
            ogr2.setVisible(true);
            //ogr3.setVisible(true);
            ogr4.setVisible(true);
            ogr5.setVisible(true);
            ogrenciKayitB.setVisible(true);         ogrenciSilB.setVisible(true);
            ogrenciSinifGuncelle.setVisible(true);         ogrenciSinifGuncelle.setVisible(true);
            ogrenciGetir.setVisible(true);
            sinif.setVisible(true);

            ana_Ekran.setText("Öğrenci İşlemleri");

    }
    private void ogret_Kayit (){

       ogrenciKayit.setVisible(false);
        ogrenciKayit2.setVisible(false);
        ogrenciKayit3.setVisible(false);
        ogrenciKayit4.setVisible(false);
        ogrenciKayit5.setVisible(false);
        ogr1.setVisible(false);
        ogr2.setVisible(false);
        //ogr3.setVisible(false);
        ogr4.setVisible(false);
        ogr5.setVisible(false);
        ogrenciKayitB.setVisible(false);         ogrenciSilB.setVisible(false);
        ogrenciSinifGuncelle.setVisible(false);         ogrenciSinifGuncelle.setVisible(false);
        ogrenciGetir.setVisible(false); sinif.setVisible(false);

        ogretKayitL.setVisible(true);
        ogretKayitL2.setVisible(true);
        ogretKayitL3.setVisible(true);
        ogretKayitL4.setVisible(true);
        ogretKayitL5.setVisible(true);
        ogretKayitL6.setVisible(true);
        ogret1.setVisible(true);        ogret2.setVisible(true);
        ogret3.setVisible(true);
        ogret4.setVisible(true);
        sinif2.setVisible(true);
        ders.setVisible(true);
        ogretKayitB.setVisible(true);
        ogretSilB.setVisible(true);
        ogretGetir.setVisible(true);

        ana_Ekran.setText("Öğretmen İşlemleri");

    }
}

    abstract class Ders {
        private String ad;
        public int sinifNo = 9;

        public abstract String getAd();

            public int  getsinifNo()
            {
                return this.sinifNo;
            }
    }

    class Matematik extends Ders {

        public String getAd()
        {
            String dersAdi="Matematik";
            return dersAdi;
        }

            public int getsinifNo()
            {
                return super.getsinifNo();
            }
    }
