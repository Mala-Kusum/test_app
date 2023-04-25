package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    TextView t;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.text);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","nhiadmin2023");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from test");
            while(rs.next()){
                s=rs.getString(1);
            }
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        t.setText(s);
    }
}