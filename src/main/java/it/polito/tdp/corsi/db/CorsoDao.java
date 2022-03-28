package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDao {

	public List <Corso> getCorsiByPeriodo(int periodo) {
		String sql = "SELECT * "+ "FROM corso "+ "WHERE pd=?";
		List <Corso> result = new ArrayList <Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			//specifico il parametro (?) -----> NB LA NUMERAZIONE PARTE DA 1 NON  DA 0 !!!!!!
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				result.add(c);
			}
			st.close();
			rs.close();
			conn.close();
			return result;
			
		} catch(SQLException e) {
			System.err.println("Errore nel DAO");
			e.printStackTrace();
			return null;
		}
	}
	
	public Map <Corso, Integer> getIscritti (int periodo) {
		String sql = "SELECT c.codins, c.crediti, c.nome, c.pd, COUNT(*) AS n "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins = i.codins AND c.pd =? "
				+ "GROUP BY c.codins, c.crediti, c.nome, c.pd";
		
		Map <Corso, Integer> result = new HashMap <Corso, Integer>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			// NB posso eseguire la query solo dopo aver settato i parametri
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				// tra apici scrivo i nomi delle colonne
				result.put(new Corso (rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd")), rs.getInt("n"));
			}
			rs.close();
			st.clearBatch();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			System.err.println("Errore nel DAO");
			e.printStackTrace();
			return null;
		}		
	}
	
	
	
	
	
	
	
	
}
