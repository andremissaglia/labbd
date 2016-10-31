package labbd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import org.bson.Document;
public class Ex1 {
    private ArrayList<Column> columns;

    public Ex1() {
        columns = new ArrayList<>();
    }
    
    public void oracle2Mongo(String table){
        try {
            // Executa Select
            Statement stmt = OracleConnection.connection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+table);
            //Pega as colunas
            int count = rs.getMetaData().getColumnCount();
            for(int i = 0; i < count; i++){
                Column col = new Column();
                col.id = i+1;
                col.name = rs.getMetaData().getColumnName(col.id);
                col.type = rs.getMetaData().getColumnType(col.id);
                columns.add(col);
            }
            //Gera BSON
            while(rs.next()){
                Document doc = new Document();
                for(Column col : columns){
                    switch(col.type){
                        case Types.VARCHAR:
                        case Types.CHAR:
                            doc.append(col.name, rs.getString(col.id));
                            break;
                        case Types.INTEGER:
                            doc.append(col.name, rs.getInt(col.id));
                            break;
                        case Types.FLOAT:
                            doc.append(col.name, rs.getFloat(col.id));
                            break;
                        case Types.DOUBLE:
                            doc.append(col.name, rs.getDouble(col.id));
                            break;
                        case Types.NUMERIC:
                            if(rs.getMetaData().getScale(col.id) == 0){
                                doc.append(col.name, rs.getInt(col.id));
                            } else {
                                doc.append(col.name, rs.getDouble(col.id));
                            }
                            break;
                        default:
                            System.out.println(col.type);
                    }                    
                }
                System.out.println(doc.toJson());
            }
        } catch (SQLException ex) {
        }
    }
    private class Column{
        public int id;
        public String name;
        public int type;
    }
}
