package dbStepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StepDefinitions {
    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; user=techproed;password=P2s@rt65";
    String username="techproed";
    String password="P2s@rt65";
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @Given("kullanici HMC veri tabanina baglanir")
    public void kullanici_hmc_veri_tabanina_baglanir() throws SQLException {
        //databese'e baglantı kuruyoruz
       connection= DriverManager.getConnection(url,username,password);
       statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }
    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        // Query calistiriyoruz
        // Select Price FROM tHOTELROOM
        String readQuery = "SELECT "+field+" FROM " +table;
        resultSet = statement.executeQuery(readQuery);
    }
    @Given("kullanici {string} sutunundaki verileri okur")
    public void kullanici_sutunundaki_verileri_okur(String field) throws SQLException {
        // resultSet iterator ile calisiyor
        resultSet.first(); // bu komutla iterator'ın ilk elemente goturur, gitti ise true gidemezse false doner
        // iterator istenen konuma gidince artık elementi yazdırabiliriz.
        System.out.println(resultSet.getString(field));
        resultSet.next();
        System.out.println(resultSet.getString(field));


        while (resultSet.next()){
            System.out.println(resultSet.getString(field));
            resultSet.next();
        }

        resultSet.absolute(0);
        List<Double> priceList=new ArrayList<>();
        while (resultSet.next()){
            priceList.add(resultSet.getDouble(field));
            resultSet.next();
        }
        System.out.println("PriceListSize: "+priceList.size());
        System.out.println(priceList);

    }
}
