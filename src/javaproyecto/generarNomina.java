/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luban
 */
public class generarNomina extends Empleado {

    private static void mostrarTablas(DatabaseMetaData dbmd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Empleado emp = new Empleado();

    /*public void generaNomina1() throws SQLException, IOException {

        try {
            String query = "select empId,nombre from empleado";
            PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnName = rsmd.getColumnName(i);
                System.out.print(columnName);
            }

            FileWriter fstream = new FileWriter("file.txt");
            BufferedWriter out = new BufferedWriter(fstream);

            while (rs.next()) {

                out.write(Integer.toString(rs.getInt("empId")) + ", ");
                out.write(Integer.toString(rs.getInt("depID")) + ", ");
                out.write(rs.getString("nombre") + ", ");
                out.write(rs.getString("apellido1") + ", ");
                out.write(rs.getString("apellido2") + ", ");
                out.write(rs.getString("correo") + ", ");
                out.write(Integer.toString(rs.getInt("movil")) + ", ");
                out.newLine();

                System.out.println("hecho escribir dato en archivo");
                out.close();
                try {
                    int empId = rs.getInt("empId");
                    String nombre = rs.getString("nombre");

                    out.write(empId);
                    out.write(nombre);
                    out.newLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
            out.close();
            ps.close();
        } catch (IOException | SQLException e1) {
            e1.getMessage();
        }
    }

    /*public void generaNomina() throws IOException, SQLException {
        CSVWriter writer = new CSVWriter(new FileWriter("yourfile.csv"), '\t');
        Boolean includeHeaders = true;

        String query = "select empId,nombre from empleado";
            PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);

        java.sql.ResultSet myResultSet = pst.executeQuery();//your resultset logic here

writer.writeAll(myResultSet, includeHeaders);

        writer.close();

    }*/

 /*private List<String> resultSetArray = new ArrayList<>();
    public void generaNomina() throws Exception{
        Connection connection = null;
        fetchDataFromDatabase("SQL queries", connection);
        printToCsv(resultArray);
    }
    public void fetchDataFromDatabase(String selectQuery,Connection connection) throws  Exception{
            try {

                String q ="select * from empleado";
                PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(q);
                ResultSet rs = ps.executeQuery();
                int numCols = rs.getMetaData().getColumnCount();

                while(rs.next()) {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 1; i <= numCols; i++) {
                        sb.append(String.format(String.valueOf(rs.getString(i))) + " ");

                    }
                    resultSetArray.add(sb.toString());

                }

            } catch (SQLException e) {
                LOGGER.error("Sql exception " + e.getMessage());
            }

        }
    public static void printToCsv(List<String> resultArray) throws Exception{

        File csvOutputFile = new File("file_name");
        FileWriter fileWriter = new FileWriter(csvOutputFile, false);


        for(String mapping : resultArray) {
            fileWriter.write(mapping + "\n");
         }

        fileWriter.close();

    }*/
    public void generaNomina() throws SQLException {

        try {
            String q = "select empId,nombre,apellido1,apellido2,correo,movil,depId from empleado";
            PreparedStatement psmnt = conecion_bbdd.establecerConexion().prepareStatement(q);
            ResultSet rs = psmnt.executeQuery();

            while (rs.next()) {
                System.out.println("empID : " + rs.getInt(1));
                System.out.println("nombre : " + rs.getString(2));
                System.out.println("apellido1 : " + rs.getString(3));
                System.out.println("apellido2 : " + rs.getString(4));
                System.out.println("correo : " + rs.getString(5));
                System.out.println("movil : " + rs.getInt(6));
                System.out.println("depId : " + rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    }
    
     

