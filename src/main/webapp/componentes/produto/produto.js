/**
 * Created by Junio e Marcelo on 09/11/2015.
 */
'use strict';
angular.module('app.produto', ['ngMaterial'])
      .controller('ProdutoController', function ($scope, $http) {

    $scope.produtos = {}; //Lista de produtos vinculadas a tela
    $scope.produto = {}; // Objeto Produto Vinculado a tela (Form)

    $scope.listar = function () {

        $http.get("ws/produto/listar").success(function (dados) {
            $scope.produtos = dados;
        });
    };

    $scope.salvar = function (){
        $http.post("ws/produto/salvar", $scope.produto).success(function (){
            //$scope.produtos.push(dados);
            window.alert("Sucesso!");
            $scope.produto= {};
            $scope.listar();
        });

    };

    $scope.excluir =  function (idP){
        $http.delete("ws/produto/excluir/"+ idP,{}).success(function (){
            window.alert("Excluido com Sucesso!");
            $scope.produto={};
            $scope.listar();
        });

    };

    $scope.editar = function (produto){
        $scope.produto = produto;
    }

    $scope.listar(); //carregando inicialmente


});