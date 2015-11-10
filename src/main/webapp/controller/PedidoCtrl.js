/**
 * Created by andré on 09/11/2015.
 */
appCrudAngular.controller('PedidoCtrl',function($scope,$http) {

    $scope.pedido = {};
    $scope.produtoSelec = {};
    $scope.clienteSelec = {};
    $scope.tipoeventoSelec = {};
    $scope.itempedido = {};
    $scope.clientes = [];
    $scope.tipoeventos = [];
    $scope.produtos = [];
    $scope.qtd = 0;

    $scope.adicionar = function () {
        $scope.itempedido.quantidade = $scope.qtd;
        $scope.itempedido.valorItem = $scope.produtoSelec.valor * $scope.qtd;
        $scope.itempedido.id = $scope.pedido;
        $scope.itempedido.idProduto = $scope.produtoSelec;
        $scope.pedido.itemPedidoCollection.push($scope.itempedido);
    };

    $scope.excluir = function () {
        var idx = $scope.pedido.itemPedidoCollection.indexOf($scope.itempedido);
        $scope.pedido.itemPedidoCollection.splice(idx, 1);
    };

    $scope.salvar = function () {
        $http.post('/ws/pedido/salvar',$scope.pedido).success(function (dados){
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
