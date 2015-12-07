var appLariMaia = angular.module('app',
    ['ngMaterial',
        'ngNewRouter',
        'ngAnimate',
        'ngAria',
        'app.home',
        'app.pedido',
        'app.cliente',
        'app.produto',
        'app.tipoevento',
        'app.usuario',
    ]);
appLariMaia.controller('AppController',['$scope','$http','$router',AppController]);

function AppController($scope,$http,$router){
    $router.config([
        {path: '/'    ,      redirectTo: '/home'},
        {path: '/home' ,      components: 'home'},
        {path: '/cliente',    components: 'cliente'},
        {path: '/pedido',     components: 'pedido'},
        {path: '/produto',    components: 'produto'},
        {path: '/tipoevento', components: 'tipoevento'},
        {path: '/usuario',    components: 'usuario'}
    ]);
}