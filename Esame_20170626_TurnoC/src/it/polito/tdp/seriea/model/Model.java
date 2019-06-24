package it.polito.tdp.seriea.model;




import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

import it.polito.tdp.seriea.db.SerieADAO;

public class Model {
	
	SerieADAO dao;
	Graph<Integer, DefaultWeightedEdge> grafo;
	
	
	public Model() {
		dao= new SerieADAO();
		grafo=new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
	}
	

	public void creaGrafo() {
		
		List<PunteggiePeso> result=dao.getArcoePeso();
		
		for(PunteggiePeso pp:result) {
			
			Graphs.addEdgeWithVertices(grafo, pp.getGoal1(), pp.getGoal2(), pp.getPeso());
			
			
		}
		System.out.println("vertici: " +grafo.vertexSet().size());
		System.out.println("archi: " +grafo.edgeSet().size());
		
		for(DefaultWeightedEdge e: grafo.edgeSet()) {
			System.out.println( e+ "peso : " +grafo.getEdgeWeight(e));
		}
	}


	public Graph<Integer, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}
	
	
	public String getConnessione(Integer goalSelezionato) {
		
		String res="";
		List<Vicino> connessi= dao.getGoalVicini(goalSelezionato);
		Collections.sort(connessi);
		
		for(Vicino v: connessi) {
			res+=v.getGoalCasa() +"-" +v.getGoalTrasf()+ " numero di partite: " +v.getNemPartite()+"\n";
		}

		return res;
		
	}

	

}
