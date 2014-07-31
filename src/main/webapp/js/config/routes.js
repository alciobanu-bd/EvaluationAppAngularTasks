app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/create', {
            templateUrl: 'views/create.html',
            controller: 'ClinicaController'
        }).
        when('/edit/:id', {
            templateUrl: 'views/edit.html',
            controller: 'ClinicaController'
        }).
        when('/list', {
            templateUrl: 'views/list.html',
            controller: 'ClinicaController'
        }).
        otherwise({
            redirectTo: '/list'
        });
}]);