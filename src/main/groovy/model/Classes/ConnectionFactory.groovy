package model.Classes

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectionFactory {
    static Connection getConnection() {
        try{
            return DriverManager.getConnection('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789')
        } catch(SQLException ex) {
            throw new RuntimeException(ex)
        }
    }
}
