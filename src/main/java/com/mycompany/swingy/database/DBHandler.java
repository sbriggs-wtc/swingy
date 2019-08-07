package com.mycompany.swingy.database;

import java.sql.*;
//JDBC API has 2 packages -> java.sql, javax.sql

/* 
JDBC 7 steps
1 Import the package
2   a) Load driver 
    b) register driver Class.forName() jkl;ahshjkhjk api method
3 Establish the connection - Connection interface
4 Create the statement - statement/prepared statement/callable statement
5 Execute the query - returns something
6 Process result
7 Close

2b Class.forName()
3 Connection con = DriverManager
.getConnection(URL, UN, PW) static method returns an implementation of Connection
4 Statement st = con.createStatement();//statement is an interface
5 ResultSet rs = st.executeQuery("query here");
6 rs.next(), rs.getInt(), rs.getString()
7 st.close(), conn.close()

*/

public class DBHandler{
    
    private Connection connection;
    private String SQLITE_DRIVER = "org.sqlite.JDBC";
    private String SQLITE_URL = "jdbc:sqlite::"
    
    public void connect(){
        try{
        Class.forName(SQLITE_DRIVER);
        connection = DriverManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery();
        }catch(Exception e){
        }
    }
}