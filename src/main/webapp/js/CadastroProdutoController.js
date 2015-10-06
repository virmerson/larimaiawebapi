/**
 * Created by Junio on 05/10/2015.
 */
'use strict';

var appControllers = angular.module('appControllers', []);

//Um controller dela
appControllers.controller('ProdutoCtrl', function ($scope, $http) {


    $scope.produtos = {};
    $scope.produto = {};

    $scope.listar = function () {

        $http.get("ws/produto/lista").success(function (dados) {
            $scope.produtos = dados;
        });
    };

    $scope.salvar = function (){
        $http.post("ws/produto/salvar", $scope.produto).success(function (dados){

            window.alert("Sucesso!");
            $scope.produto= {};
            $scope.listar();
        });

    };

    $scope.excluir =  function (idP){
        $http.delete("ws/produto/excluir/"+ idP,{}).success(function (){

        });

    };

    $scope.editar = function (cliente){
        $scope.produto = cliente;
    }

    $scope.listar(); //carregando inicialmente


});
