package se444.Battle.model;

import java.util.ArrayList;

public class Player {
	private String name;
	private int wins;
	private int lose;
	private int draw;
	private int state;
	private String result;
	
	public Player() {
		this.name = "";
		this.wins = 0;
		this.lose = 0;
		this.draw = 0;
		this.state = 0;
		this.result = "";
	}
	
	public Player(String a,int b, int c, int d, int e,String f) {
		this.name = a;
		this.wins = b;
		this.lose = c;
		this.draw = d;
		this.state = e;
		this.result = f;
		
	}

	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Player(String name,int state) {
		this.name = name;
		this.state = state;
	}
	
	public Player(String a){
		this.name = a;
		this.wins = 0;
		this.lose = 0;
		this.draw = 0;
		
	}
	public int getState() {
		return state;
	}
	public void setState(int stater) {
		this.state = stater;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int win) {
		this.wins = win;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
