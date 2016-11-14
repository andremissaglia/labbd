package labbd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import labbd.util.Column;
import labbd.util.Table;
import org.bson.Document;
public class Ex1 {
    
    public String oracle2Mongo(String tablename){
        try {
            // Metadados da tabela
            Table table = Table.getTableMetadata(tablename);
            // Resultset com as tuplas
            ResultSet rs = table.getLines();
            // Gera BSON
            StringBuilder saida = new StringBuilder();
            saida.append("use dblabbd\n");
            saida.append(String.format("db.createCollection(\"%s\")\n",tablename));
            while(rs.next()){
                Document doc = new Document();
                for(Column col : table.columns){
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
                            throw new RuntimeException("Tipo não tratado");
                    }                    
                }
                saida.append(String.format("db.%s.insert(%s)\n",tablename, doc.toJson()));
            }
            return saida.toString();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
