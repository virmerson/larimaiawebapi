/**
 * Created by Junio.
 */

appCrudAngular.controller('ConsultaCtrl', function($scope, $http){

    $scope.clientes = {};//Lista de clientes que estão vinculados no select
    $scope.pedidos = {};//Objeto de pedidos

    //Metodo chama todos os clientes para colocar no select
    $scope.listarclientes = function(){
        $http.get('ws/cliente/lista').success(function(dados){
            $scope.clientes = dados;
        });
    };

    //Metodo buscar todos os pedidos vinculados a um cliente
    $scope.buscarporcliente = function(id){
        $http.get('ws/pedido/porcliente/'+id).success(function(dados){
            $scope.pedidos = dados;
        });
    };

    //Metodo busca todos os pedidos relacionados as datas do evento
    $scope.buscarpordataevento = function(dtinic, dtfim){
        $http.get('ws/pedido/pordataevento'+dtinic +'/'+ dtfim).success(function(dados){
            $scope.pedidos = dados;
        });
    };

    //Metodo busca todos os pedidos relacionados as datas do pedido
    $scope.buscarpordatapedido = function(dtinic, dtfim){
        $http.get('ws/pedido/pordatapedido/'+dtinic +'/'+ dtfim).success(function(dados){
            $scope.pedidos = dados;
        });
    };

    $scope.listarCliente();

});
