package se444.Battle.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import se444.Battle.model.*;
import se444.Battle.model.Player;
import se444.Battle.services.CreatePlayerService;

@Service
public class BattleService {
	
	CreatePlayerService createplayer;
	
	public Player BattleAI(Player p) {
		
		String playername="";
		for(Player a:createplayer.playerList) {
			if(a.getName().equals(p.getName())){
			 playername = p.getName();
			 Random r = new Random();
			 int randomInt = r.nextInt(4-1) + 1;
			 String stateuser="";
			 String Whowin="";
			 if(a.getState() == 1) {
				 stateuser = "Scissors";
			 }
			 if(a.getState() == 2) {
				 stateuser = "Rock";
			 }
			 if(a.getState() == 3) {
				 stateuser = "Paper";
			 }
			 if(randomInt == 1) {
				 if(a.getState() == 1) {
					 p.setResult("Draw");
					 int draw = a.getDraw();
					 draw += 1;
					 a.setDraw(draw);
				 }
				 if(a.getState() == 2) {
					 p.setResult("Win");
					 int win = a.getWins();
					 win += 1;
					 a.setWins(win);
				 }
				 if(a.getState() == 3) {
					 p.setResult("lose");
					 int lose = a.getLose();
					 lose += 1;
					 a.setLose(lose);
				 }
				return p;
			 }
			 if(randomInt == 2) {
				 if(a.getState() == 1) {
					 int lose = a.getLose();
					 lose += 1;
					 a.setLose(lose);
					 p.setResult("lose");
				 }
				 if(a.getState() == 2) {
					 p.setResult("Draw");
					 int draw = a.getDraw();
					 draw += 1;
					 a.setDraw(draw);
				 }
				 if(a.getState() == 3) {
					 p.setResult("Win");
					 int win = a.getWins();
					 win += 1;
					 a.setWins(win);
				 }
				return p;
			 }
			 if(randomInt == 3) {
				 if(a.getState() == 1) {
					 p.setResult("Win");
					 int win = a.getWins();
					 win += 1;
					 a.setWins(win);
				 }
				 if(a.getState() == 2) {
					 p.setResult("lose");
					 int lose = a.getLose();
					 lose += 1;
					 a.setLose(lose);
				 }
				 if(a.getState() == 3) {
					 p.setResult("Draw");
					 int draw = a.getDraw();
					 draw += 1;
					 a.setDraw(draw);
				 }
				return p;
			 }
			}
		}
		return p;

	}
	public String HighScore() {
		if(createplayer.playerList.isEmpty()) {
			return "No score";
		}
		int winhigh=0;
		int exphigh=0;
		String nameS="";
		for(Player a:createplayer.playerList) {
			if(a.getWins() > winhigh) {
				winhigh = a.getWins();
					nameS=a.getName();
			}
		}
		return "Name: "+nameS+" | Highest wins: "+winhigh;
	}
}

