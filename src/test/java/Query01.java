import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1- Driver yukle
        Class.forName("com.mysql.jdbc.Driver");

        // 2- Baglantı olustur
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC",
                "root", "1234");

        // 3- Statement:SQL Kkodlarimizi yazmak için bir nesne olustur
        Statement st = con.createStatement();

        // 4- ResultSet:
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        // 5- sonucları yazdır
        while (veri.next()){
            //System.out.println(veri.getInt(1)+" "+veri.getString(2)+" "+veri.getString(3)+" "+veri.getString(4));
            System.out.println(veri.getInt("okul_no")+" "+veri.getString("ogrenci_ismi")+" "
                    +veri.getString("sinif")+" "+veri.getString("cinsiyet"));
        }
        // 6- kapatma

        con.close();
        st.close();
        veri.close();

    }
}
