package se444.Battle.controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import se444.Battle.services.BattleService;
import se444.Battle.services.CreatePlayerService;
import se444.Battle.model.*;
import se444.Battle.model.Player;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {
	
	

	CreatePlayerService createplayerservice ;
	BattleService battleservice;
	private static ArrayList<Player> playerList;
	
	
	@Autowired
	public void setServiceList(BattleService playerServiceParam){
		this.battleservice = playerServiceParam;
	}
	
	@Autowired
	public void setServiceList(CreatePlayerService playerServiceParam){
		this.createplayerservice = playerServiceParam;
	}
	
	@RequestMapping("/players") 
	public ArrayList<Player> getAllPlayer(){
		return createplayerservice.getEntirePlayer(); 
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addNewPlayer")
	public Boolean AddnewPlayerName(@RequestBody Player p){
		
		return createplayerservice.AddnewPlayerName(p); 
	}
	@RequestMapping(method=RequestMethod.PUT, value="/setState")
	public String setStatePlayer(@RequestBody Player p){
		
		return createplayerservice.Addstate(p); 
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/Info")
	public String playerInfo(@RequestBody Player p){
		
		return createplayerservice.playerInfo(p); 
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/BattleAI")
	public Player BattleMonters1 (@RequestBody Player p){
	
		return battleservice.BattleAI(p);

	}
	
	@RequestMapping("/HighScore")
	public String gethighscore(){
		return battleservice.HighScore();
	}

}
