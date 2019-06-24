package it.polito.tdp.seriea.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.seriea.model.PunteggiePeso;
import it.polito.tdp.seriea.model.Season;
import it.polito.tdp.seriea.model.Team;
import it.polito.tdp.seriea.model.Vicino;

public class SerieADAO {

	public List<Season> listSeasons() {
		String sql = "SELECT season, description FROM seasons";
		List<Season> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Season(res.getInt("season"), res.getString("description")));
			}

			conn.close();
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Team> listTeams() {
		String sql = "SELECT team FROM teams";
		List<Team> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Team(res.getString("team")));
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<PunteggiePeso> getArcoePeso() {
		
		final String sql="select fthg as goal1, ftag as goal2, count(*) as peso " + 
				"				from matches " + 
				"				group by goal1, goal2 ";
		
		
		List<PunteggiePeso> result= new ArrayList<>();
		
		
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {

				int goal1=res.getInt("goal1");
				int goal2=res.getInt("goal2");
				double peso=res.getDouble("peso");
				
				PunteggiePeso pp= new PunteggiePeso(goal1, goal2, peso);
				 
				result.add(pp);
				
				
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Vicino> getGoalVicini(Integer goalSelezionato) {


		final String sql="select fthg as goal1, ftag as goal2, count(*) cnt " + 
				"				from matches " + 
				"				where fthg=? " + 
				"				group by goal1, goal2 " ;
		
		
		
		List<Vicino> result= new ArrayList<>();
		
		
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, goalSelezionato);
			ResultSet res = st.executeQuery();

			while (res.next()) {

				int goal1=res.getInt("goal1");
				int goal2=res.getInt("goal2");
				double peso=res.getDouble("cnt");
				
				Vicino v= new Vicino(goal1, goal2, peso);
				 
				result.add(v);
				
				
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	

}
