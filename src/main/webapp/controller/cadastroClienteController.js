/**
 * Created by Lucas, William e Diosefer on 05/10/2015.
 */

appCrudAngular.controller('ClienteCtrl', function($scope, $http){

    $scope.clientes = {};//Lista de clientes que estão vinculados a tela
    $scope.cliente = {};//Objeto de cliente vinculado a tela

   $scope.listar = function(){
       $http.get("ws/cliente/lista").success(function(dados){
           $scope.clientes = dados;
       });
   };

    //metodo salvar cliente
    $scope.salvar = function(){
       $http.post("ws/cliente/salvar", $scope.cliente).success(function(dados){
           window.alert("salvo com sucesso");
           $scope.cliente= {};
           $scope.listar();
       });

    };

    $scope.listar();

    $scope.excluir =  function (id){$http.delete("ws/cliente/excluir/"+ id).success(function (){ $scope.listar(); });};


    $scope.editar = function(cliente){

        $scope.cliente = cliente;

    }

});
