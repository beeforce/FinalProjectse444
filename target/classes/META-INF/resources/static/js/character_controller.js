'use strict';

App.controller('CharacterController', [
		'$scope',
		'RESTService',
		function($scope, RESTService) {
			var self = this;

			self.character = { name : null, wins: '', lose: '', draw: '', state: ''};
			self.characters = [];
			self.deleteName = {name:''};
			self.nameBattle = {name:''};
			self.output = { name:'', wins:'', lose:'', draw:'', state:'',result:''};
			self.state = {state:'',name:''};
			self.fetchAllCharacters = function() {
				RESTService.fetchAllCharacters().then(function(d) {
					self.characters = d;
				}, function(errResponse) {
					console.error("Error while fetching Characters");
				});
			};
			
			self.addPlayer = function() {

				RESTService.addPlayer(self.character).then(function(d) {
					console.log("Add player success");
					self.character = d;
					self.fetchAllCharacters();
				}, function(errResponse) {
					console.log("errResponse from controller:" + errResponse);
					console.error("Error while fetching Characters");
				});
				self.fetchAllCharacters();
			};
			
			self.addState = function(number,name) {
				console.log(number+"|| "+name);
				self.state.state = number;
				self.state.name = name;
				console.log(self.state);
				RESTService.addState(self.state).then(function(d) {
					console.log("Add state success");
					self.fetchAllCharacters();
					
				}, function(errResponse) {
					console.log("errResponse from controller:" + errResponse);
					console.error('Error while fetching Characters');
				});
				self.fetchAllCharacters();
			};
			
			self.BattleAI = function(nameBattle) {
				self.nameBattle.name = nameBattle;
				RESTService.BattleAI(self.nameBattle).then(function(response) {
					self.output = response;
					self.fetchAllCharacters();
					
				}, function(errResponse) {
					console.log("errResponse from controller:" + errResponse);
					console.error('Error while fetching Characters');
				});
				self.fetchAllCharacters();
			};
			
			self.Deleteplayer = function(nameDelete) {
				self.deleteName.name = nameDelete;
				RESTService.Deleteplayer(self.deleteName.name).then(function(response) {
					
				}, function(errResponse) {
					console.log("errResponse from controller:" + errResponse);
					console.error('Error while fetching Characters');
				});
				self.fetchAllCharacters();
			};


	
			self.fetchAllCharacters();
		} ]);