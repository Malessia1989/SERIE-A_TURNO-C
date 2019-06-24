package it.polito.tdp.seriea.model;

public class Vicino implements Comparable<Vicino> {
	
	private int goalCasa;
	private int goalTrasf;
	private double nemPartite;
	public Vicino(int goalCasa, int goalTrasf, double nemPartite) {
		super();
		this.goalCasa = goalCasa;
		this.goalTrasf = goalTrasf;
		this.nemPartite = nemPartite;
	}
	public int getGoalCasa() {
		return goalCasa;
	}
	public void setGoalCasa(int goalCasa) {
		this.goalCasa = goalCasa;
	}
	public int getGoalTrasf() {
		return goalTrasf;
	}
	public void setGoalTrasf(int goalTrasf) {
		this.goalTrasf = goalTrasf;
	}
	public double getNemPartite() {
		return nemPartite;
	}
	public void setNemPartite(double nemPartite) {
		this.nemPartite = nemPartite;
	}
	@Override
	public int compareTo(Vicino o) {
		// TODO Auto-generated method stub
		return (int) (o.nemPartite-this.nemPartite);
	}
	
	

}
