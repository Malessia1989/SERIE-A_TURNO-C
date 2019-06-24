package it.polito.tdp.seriea.model;

public class PunteggiePeso {
	
	
	private int goal1;
	private int goal2;
	private double peso;
	
	
	public PunteggiePeso(int goal1, int goal2, double peso) {
		super();
		this.goal1 = goal1;
		this.goal2 = goal2;
		this.peso = peso;
	}


	public int getGoal1() {
		return goal1;
	}


	public void setGoal1(int goal1) {
		this.goal1 = goal1;
	}


	public int getGoal2() {
		return goal2;
	}


	public void setGoal2(int goal2) {
		this.goal2 = goal2;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	
	
	
}
