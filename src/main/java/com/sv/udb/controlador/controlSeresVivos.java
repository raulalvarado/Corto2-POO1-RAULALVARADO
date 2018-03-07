/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.SeresVivos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class controlSeresVivos {

    private final Connection conect;
    
    public controlSeresVivos() {
        this.conect = new Conexion().getConn();
    }
    
    public boolean guardar(String nombSere, String descSere, int codRef)
    {
         boolean resp= false;
        try
        {
            PreparedStatement cmd = this.conect.prepareStatement("INSERT INTO seresvivos VALUES(NULL,?,?,?)");
            cmd.setString(1, nombSere);
            cmd.setString(2, descSere);
            cmd.setInt(3, codRef);
            cmd.executeUpdate();
            resp=true;
        
        }
        catch(SQLException ex)
         {
             System.err.println("Ocurrio un error al guardar: "+ ex.getMessage());
         }
        finally
        {
             try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public List<SeresVivos> consultar()
    {
         List<SeresVivos> resp = new ArrayList<>();
        try
        {
            PreparedStatement cmd = conect.prepareStatement("SELECT * from seresvivos");
            //Vea la siguiente ayuda
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new SeresVivos(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
                         // <----- Hay que llenar con los objetos
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error al consultar: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
        
    }
    
    public boolean modificar(int codSere, String nombSere, String descSere, int codRef)
    {
        boolean resp= false;
        try
        {
            PreparedStatement cmd = this.conect.prepareStatement("UPDATE seresvivos SET nomb_sere = ?, "
                    + "desc_sere = ?, codi_refe_sere = ? WHERE codi_sere = ?");
            cmd.setString(1, nombSere);
            cmd.setString(2, descSere);
            cmd.setInt(3, codRef);
            cmd.setInt(4, codSere);
            cmd.executeUpdate();
            resp=true;
        
        }
        catch(SQLException ex)
         {
             System.err.println("Ocurrio un error al actualizar: "+ ex.getMessage());
         }
        finally
        {
             try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    
    public boolean eliminar (int codSere) {
        boolean resp = false;
        try {
            PreparedStatement cmd = conect.prepareStatement("DELETE FROM seresvivos WHERE codi_sere = ?");
            cmd.setInt(1, codSere);
            cmd.executeUpdate();
            resp = true;
        }
        catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
        finally {
            try {
                if (conect != null)
                    if (!conect.isClosed())
                        conect.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;       
    }
    
    
}
