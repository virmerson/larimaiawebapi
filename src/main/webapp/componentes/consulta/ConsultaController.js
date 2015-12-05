/**
 * Created by Junio.
 */

appCrudAngular.controller('ConsultaCtrl', function($scope, $http){

    $scope.clientes = {};//Lista de clientes que estão vinculados a tela para
    $scope.pedidos = {};//Objeto de cliente vinculado a tela

    $scope.listarclientes = function(){
        $http.get('ws/cliente/lista').success(function(dados){
            $scope.clientes = dados;
        });
    };

    $scope.buscarporcliente = function(id){
        $http.get('ws/pedido/porcliente/'+id).success(function(dados){
            $scope.pedidos = dados;
        });
    };

    $scope.buscarpordataevento = function(dtinic, dtfim){
        $http.get('ws/pedido/pordataevento'+dtinic +'/'+ dtfim).success(function(dados){
            $scope.pedidos = dados;
        });
    };

    $scope.buscarpordatapedido = function(dtinic, dtfim){
        $http.get('ws/pedido/pordatapedido/'+dtinic +'/'+ dtfim).success(function(dados){
            $scope.pedidos = dados;
        });
    };

});
