angular.module('app.cliente',['ngNewRouter'])
    .controller('UsuarioController', function($scope, $http){


    $scope.usuarios = {};
    $scope.usuario = {};

   $scope.listar = function(){
       $http.get("ws/usuario/listar").success(function(dados){
           $scope.usuarios = dados;
       });
   };

    //metodo salvar usuario
    $scope.salvar = function(){
       $http.post("ws/usuario/salvar", $scope.usuario).success(function(dados){
           window.alert("salvo com sucesso");
           $scope.usuario= {};
           $scope.listar();
       });

    };

    $scope.listar();

    $scope.excluir =  function (id){$http.delete("ws/usuario/excluir/"+ id).success(function (){ $scope.listar(); });};


    $scope.editar = function(usuario){

        $scope.usuario = usuario;

    }

});
