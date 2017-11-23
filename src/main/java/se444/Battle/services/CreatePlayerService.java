package se444.Battle.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import se444.Battle.model.*;
import se444.Battle.model.Player;

@Service
public class CreatePlayerService {
	
	Player player;
	public static ArrayList<Player> playerList = new ArrayList<Player>();
	
	
	
	public String getId() {

		return this.player.getName();

	}
	public String Addstate(Player p) {
		String stateR="";
		if(p.getState() == 1) {
			 stateR = "Scissors";
		 }
		if(p.getState() == 2) {
			 stateR ="Rock";
		 }
		if(p.getState() == 3) {
			 stateR = "Paper";
		 }
		for(Player a:this.playerList) {
			if(a.getName().equals(p.getName())){
				a.setState(p.getState());
				return "Update Success ! | "+a.getName()+" got "+stateR;
			}
				}
		return "Can not find a players";
	}
	
	
	public ArrayList<Player> getEntirePlayer() {
		return this.playerList;
	}
	
	// Add new player with new name
		public Boolean AddnewPlayerName(Player p) {
			try {
				Player newplayer = new Player(p.getName());
				this.playerList.add(newplayer);
				
				return true;
			} catch (Exception e) {
				System.out.println("This is log of error " + e);
				return false;
			}

		}
		
		public String playerInfo(Player p) {
			for(Player a:this.playerList) {
				if(a.getName().equals(p.getName())){
					String stateuser="";
					if(a.getState() == 1) {
						 stateuser = "Scissors";
					 }
					 if(a.getState() == 2) {
						 stateuser = "Rock";
					 }
					 if(a.getState() == 3) {
						 stateuser = "Paper";
					 }
					return a.getName()+" INFO | Wins:"+a.getWins()+" | Lose:"+a.getLose()+" | Draw:"+a.getDraw()+" | State:"+stateuser;
				}
			}
			return "No player";
		}

}
