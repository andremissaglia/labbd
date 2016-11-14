package labbd.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import labbd.connection.OracleConnection;

public class Table {
    public ArrayList<Column> columns;
    public ArrayList<Column> pk;
    public String name;
    
    public Table(){
        this.columns = new ArrayList<>();
        this.pk = new ArrayList<>();
    }
    
    public static Table getTableMetadata(String tablename) throws SQLException{
        Table t = new Table();
        t.name = tablename;
        t.fetchColumns();
        t.fetchPK();
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
        //Pega as colunas
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM "+this.name+" WHERE ROWNUM = 1")) {
            //Pega as colunas
            int count = rs.getMetaData().getColumnCount();
            for(int i = 0; i < count; i++){
                Column col = new Column();
                col.id = i+1;
                col.name = rs.getMetaData().getColumnName(col.id);
                col.type = rs.getMetaData().getColumnType(col.id);
                this.columns.add(col);
            }
        }
    }
    public void fetchPK() throws SQLException {
        String sql = 
            "SELECT " +
            "  COL.COLUMN_NAME " +
            "FROM " +
            "  USER_CONS_COLUMNS COL, " +
            "  USER_CONSTRAINTS CONS " +
            "WHERE COL.TABLE_NAME = ? " +
            "  AND COL.CONSTRAINT_NAME = CONS.CONSTRAINT_NAME " +
            "  AND CONS.CONSTRAINT_TYPE = 'P'";
        PreparedStatement stmt = OracleConnection.connection().prepareStatement(sql);
        stmt.setString(1, this.name);
        try (ResultSet rs = stmt.executeQuery()) {
            while(rs.next()){
                System.out.println("aaaa");
                Column c = this.getColumn(rs.getString(1));
                c.is_pk = true;
                this.pk.add(c);
            }
        }
    }
    public ResultSet getLines() throws SQLException{
        // Executa Select
        Statement stmt = OracleConnection.connection().createStatement();
        return stmt.executeQuery("SELECT * FROM "+this.name);
    }
}
