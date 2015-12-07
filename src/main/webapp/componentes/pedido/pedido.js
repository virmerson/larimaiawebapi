/**
 * Created by andré on 09/11/2015.
 */
'use strict';
angular.module('app.pedido',['ngMaterial'])
  .controller('PedidoController',function($scope,$http) {

    $scope.pedido = {};
    $scope.itens = [];
    $scope.produtoSelec = {};
    $scope.clienteSelec = {};
    $scope.tipoeventoSelec = {};
    $scope.itempedido = {};
    $scope.clientes = [];
    $scope.tipoeventos = [];
    $scope.produtos = [];
    $scope.qtd = 0;
    $scope.total = 0;

    $scope.adicionar = function () {
        $scope.itempedido.quantidade = $scope.qtd;
        $scope.itempedido.valorItem = $scope.produtoSelec.valor * $scope.qtd;
        $scope.itempedido.idProduto = $scope.produtoSelec;
        $scope.itens.push($scope.itempedido);
        $scope.total = $scope.total + $scope.itempedido.valorItem;
        $scope.itempedido = {};
    };

    $scope.excluir = function (item) {
        var idx = $scope.itens.indexOf(item);
        $scope.itens.splice(idx, 1);
        $scope.total = $scope.total - item.valorItem;
    };

    $scope.salvar = function () {
        $scope.pedido.itemPedidoCollection = $scope.itens;
        $scope.pedido.idCliente = $scope.clienteSelec;
        $scope.pedido.idTipoEvento = $scope.tipoeventoSelec;
        $http.post('./ws/pedido/salvar',$scope.pedido).success(function (dados){
            window.alert("Sucesso!");
            $scope.pedido = {};
        });
    };

    $scope.listarCliente = function(){
      $http.get('./ws/cliente/lista').success(function (dados){
            $scope.clientes = dados;
        });
    };

    $scope.listarTipoEvento = function(){
        $http.get('./ws/tipoevento/listar').success(function (dados){
            $scope.tipoeventos = dados;
        });
    };

    $scope.listarProduto = function(){
        $http.get('./ws/produto/listar').success(function (dados){
            $scope.produtos = dados;
        });
    };

    $scope.listarCliente();
    $scope.listarProduto();
    $scope.listarTipoEvento();

});


/**/