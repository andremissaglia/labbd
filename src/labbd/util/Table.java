package labbd.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import labbd.OracleConnection;

public class Table {
    public ArrayList<Column> columns;
    public String name;
    
    public Table(){
        this.columns = new ArrayList<>();
    }
    
    public static Table getTableMetadata(String tablename) throws SQLException{
        Table t = new Table();
        t.name = tablename;
        t.fetchColumns();
        return t;
    }
    public Column getColumn(String columnName){
        for(Column col : this.columns){
            if(col.name.equals(columnName)){
                return col;
            }
        }
        return null;
    }
    public void fetchColumns() throws SQLException{
        // Executa Select
        Statement stmt = OracleConnection.connection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "+this.name+" WHERE ROWNUM = 1");
        //Pega as colunas
        int count = rs.getMetaData().getColumnCount();
        for(int i = 0; i < count; i++){
            Column col = new Column();
            col.id = i+1;
            col.name = rs.getMetaData().getColumnName(col.id);
            col.type = rs.getMetaData().getColumnType(col.id);
            this.columns.add(col);
        }
        rs.close();
    }
    public ResultSet getLines() throws SQLException{
        // Executa Select
        Statement stmt = OracleConnection.connection().createStatement();
        return stmt.executeQuery("SELECT * FROM "+this.name);
    }
}
