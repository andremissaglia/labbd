package labbd.ex1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import labbd.connection.MongoConnection;
import labbd.util.Column;
import labbd.util.Table;
import org.bson.Document;

public class Ex1 {
    private ArrayList<Document> inserts;
    private String collection;
    public String oracle2Mongo(String tablename) {
        inserts = new ArrayList<>();
        collection = tablename;
        tablename = tablename.toUpperCase();
        try {
            // Metadados da tabela
            Table table = Table.getTableMetadata(tablename);
            // Resultset com as tuplas
            ResultSet rs = table.getLines();
            // Gera BSON
            StringBuilder saida = new StringBuilder();
            saida.append("use dblabbd\n");
            saida.append(String.format("db.createCollection(\"%s\")\n", tablename));
            while (rs.next()) {
                Document doc = new Document();
                // coloca as chaves primarias
                Document docpk = new Document();
                for(Column col : table.pk){
                    append(docpk, col, rs);
                }
                doc.append("_id", docpk);
                // coloca as demais colunas não chaves
                for (Column col : table.columns) {
                    if (!col.is_pk) {
                        append(doc, col, rs);
                    }
                }
                saida.append(String.format("db.%s.insert(%s)\n", tablename, doc.toJson()));
                inserts.add(doc);
            }
            return saida.toString();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void append(Document doc, Column col, ResultSet rs) throws SQLException {
        // TODO tratar nulos
        switch (col.type) {
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
                if (rs.getMetaData().getScale(col.id) == 0) {
                    doc.append(col.name, rs.getInt(col.id));
                } else {
                    doc.append(col.name, rs.getDouble(col.id));
                }
                break;
            case Types.DATE:
                Date d = new Date(rs.getDate(col.id).getTime());
                doc.append(col.name, d);
                break;
            default:
                System.out.println(col.type);
                throw new RuntimeException("Tipo não tratado");
        }
    }
    public void execute(){
        inserts.forEach((Document doc) -> {
            MongoConnection.getCollection(collection).insertOne(doc);
        });
    }
    public boolean hasScript(){
        return inserts != null;
    }
}
