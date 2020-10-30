/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import static MODELO.conection.getConection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class empleadoo {


    public int insertar(int id, String nombre, String apellido, String nit, String direccion, String activo,Date fecha, String salario)
    {
        Connection con = null;

        try {
            con = getConection();
            CallableStatement CST = con.prepareCall("{call insertar (?,?,?,?,?,?,?,?)}");
            CST.setInt(1, id);
            CST.setString(2, nombre);
            CST.setString(3, apellido);
            CST.setString(4, nit);
            CST.setString(5, direccion);
            CST.setString(6, activo);
            CST.setDate(7, fecha);
            CST.setString(8, salario);

            int res = CST.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "empleado guardado");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo almacenar empleado");

            }

            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    
}
