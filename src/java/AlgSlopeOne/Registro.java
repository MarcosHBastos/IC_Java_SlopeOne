/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgSlopeOne;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class Registro {

    private static DecimalFormat df = new DecimalFormat("##.##");
    private static ConexaoMySql conexao = new ConexaoMySql();

    public static int getTotalRegistros() {
        try {
            conexao.conectar();
            conexao.selecionar("SELECT COUNT(*) FROM avaliacoes");
            int totalRegistros = conexao.resultset.getInt("COUNT(*)");
            return totalRegistros;
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }
        return 0;
    }

    public static Usuario[] getUsuarios() {
        try {
            conexao.conectar();

            //select pra contar os registros
            conexao.selecionar("SELECT COUNT(*) FROM avaliacoes");
            conexao.resultset.next();
            int totalRegistros = conexao.resultset.getInt(1);

            double[] notas;
            Usuario[] users = new Usuario[totalRegistros];
            Usuario aux;

            //select pra buscar as notas
            conexao.selecionar("SELECT idUser, n1, n2, n3, n4, n5, n6 FROM avaliacoes");
            conexao.resultset.first();

            do {
                notas = new double[6];
                notas[0] = conexao.resultset.getDouble("n1");
                notas[1] = conexao.resultset.getDouble("n2");
                notas[2] = conexao.resultset.getDouble("n3");
                notas[3] = conexao.resultset.getDouble("n4");
                notas[4] = conexao.resultset.getDouble("n5");
                notas[5] = conexao.resultset.getDouble("n6");

                //"idUser"-1 porque é pra utilizar de índice no vetor de retorno 
                aux = new Usuario(notas);
                int id = (conexao.resultset.getInt("idUser") - 1);
                users[id] = aux;
                notas = null;
            } while (conexao.resultset.next());

            conexao.desconecta();
            return users;
        } catch (SQLException ex) {
            //System.out.println("Erro no SQL");
        }
        return null;
    }

    public static void setNewUsuario(double n1, double n2, double n3, double n4, double n5, double n6, double e) {
        conexao.conectar();
        conexao.selecionar("SELECT MAX(idUser) FROM avaliacoes");
        try {
            conexao.resultset.next();
        } catch (SQLException ex) {
           // Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        n1 = Double.parseDouble(df.format(n1).replaceAll(",", "."));
        n2 = Double.parseDouble(df.format(n2).replaceAll(",", "."));
        n3 = Double.parseDouble(df.format(n3).replaceAll(",", "."));
        n4 = Double.parseDouble(df.format(n4).replaceAll(",", "."));
        n5 = Double.parseDouble(df.format(n5).replaceAll(",", "."));
        n6 = Double.parseDouble(df.format(n6).replaceAll(",", "."));
        e = Double.parseDouble(df.format(e).replaceAll(",", "."));
        conexao.atualizar("INSERT INTO avaliacoes(n1,n2,n3,n4,n5,n6,prev) VALUES (" + n1 + "," + n2 + "," + n3 + "," + n4 + "," + n5 + "," + n6 +","+e+")");
        conexao.desconecta();
        }

    

    public static void setErroNewUsuario(double e) {
        conexao.conectar();
        conexao.selecionar("SELECT MAX(idUser) FROM avaliacoes");
        try {
            conexao.resultset.next();
            int ultimoAdicionado = conexao.resultset.getInt(1);
            conexao.atualizar("UPDATE avaliacoes SET n6=" + e + " WHERE idUser=" + ultimoAdicionado);

        } catch (SQLException ex) {
            //System.out.println("Erro no SQL");
        }
        conexao.desconecta();
    }
    /*public static String[] imprimeDados() {
        try {
            conexao.conectar();

            //select pra contar os registros
            conexao.selecionar("SELECT COUNT(*) FROM avaliacoes");
            int totalRegistros = conexao.resultset.getType();

            String[] linha = new String[totalRegistros];

            //select pra buscar as notas
            conexao.selecionar("SELECT * FROM avaliacoes");
            conexao.resultset.first();

            while (conexao.resultset.next()) {
                String[(conexao.resultset.getInt("idUser") - 1)] = "<tr>\n"
                        + "    <td><%=rs.getInt(\"ID\") %></td>\n"
                        + "    <td><%=rs.getString(\"NAME\") %></td>\n"
                        + "    <td><%=rs.getString(\"SKILL\") %></td>\n"
                        + "</tr>";
            }
            return reg;
        } */
}
