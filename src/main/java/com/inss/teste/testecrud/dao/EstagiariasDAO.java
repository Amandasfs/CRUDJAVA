package com.inss.teste.testecrud.dao;

import com.inss.teste.testecrud.model.Estagiarias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstagiariasDAO {
    private Connection conn;

    // Método para obter a conexão com o banco de dados
    public Connection getConn(){
        return conn;
    }

    // Método para configurar a conexão com o banco de dados
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir uma nova estagiária no banco de dados
    public boolean insert(Estagiarias estagiarias){
        String sql = "INSERT INTO estagiarias(matricula, nome) VALUES (?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estagiarias.getId());
            stmt.setString(2, estagiarias.getNome());
            stmt.execute();
            return true;
        }catch (SQLException ex){
            Logger.getLogger(EstagiariasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para alterar os dados de uma estagiária no banco de dados
    public boolean alter(Estagiarias estagiarias){
        String sql = "UPDATE estagiarias SET nome=?, id=? WHERE matricula=?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estagiarias.getId());
            stmt.setString(2, estagiarias.getNome());
            stmt.execute();
            return true;
        }catch (SQLException ex){
            Logger.getLogger(EstagiariasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para listar todas as estagiárias do banco de dados
    public List<Estagiarias> list(){
        String sql = "SELECT * FROM estagiarias";
        List<Estagiarias> ret = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                Estagiarias estagiarias = new Estagiarias();
                estagiarias.setId(result.getInt("matricula"));
                estagiarias.setNome(result.getString("nome"));
                ret.add(estagiarias);
            }
        }catch (SQLException ex){
            Logger.getLogger(EstagiariasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // Método para buscar uma estagiária específica no banco de dados pelo número de matrícula
    public Estagiarias sheard(Estagiarias estagiarias){
        String sql = "SELECT * FROM estagiarias WHERE matricula=?";
        Estagiarias retorno = new Estagiarias();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estagiarias.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                estagiarias.setNome(resultado.getString("nome"));
                estagiarias.setId(resultado.getInt("matricula"));
                retorno = estagiarias;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstagiariasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    // Método para remover uma estagiária do banco de dados pelo número de matrícula
    public boolean remove(Estagiarias estagiarias){
        String sql = "DELETE FROM estagiarias WHERE matricula=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estagiarias.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstagiariasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
