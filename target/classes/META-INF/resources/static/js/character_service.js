'use strict';

App.factory('RESTService', ['$http', '$q', function($http, $q){
  return {
    fetchAllCharacters: function() {
      return $http.get('http://localhost:8080/players')
                            .then( function(response){
                                        return response.data;
                                    },
                                    function(errResponse){
                                        console.error('Error while fetching characters');
                                        return $q.reject(errResponse);
                                    }
                              );
    },
                //More functions that perform CRUD operations ...

  addPlayer : function(name) {
		return $http({
			method : 'POST',
			url : 'http://localhost:8080/addNewPlayer',
			data : name,
			headers : {'Content-Type' : 'application/json'}
		}).then(function(response) {
			
			return response.data;
		},
			function(errResponse) {
			console.log(errResponse);
				return $q.reject(errResponse);
			}
		);
	},
	
	
	addState : function(state) {
		console.log(state);
		return $http({
			method : 'PUT',
			url : 'http://localhost:8080/setState',
			data : state,
			headers : {'Content-Type' : 'application/json'}
		}).then(function (response) {
			
			return response.data;
		},
			function(errResponse) {
			console.log("ERROR FROM SERVICE :"+errResponse);
				return $q.reject(errResponse);
			}
		);
	},
	
	BattleAI : function(battle) {
		console.log(battle);
		return $http({
			method : 'PUT',
			url : 'http://localhost:8080/BattleAI',
			data : battle,
			headers : {'Content-Type' : 'application/json'}
		}).then(function (response) {
			console.log("response:"+response);
			return response.data;
		},
			function(errResponse) {
			console.log("error:"+error);
			displayError(errResponse);
			}
		);
	},
	
  };
}]);

