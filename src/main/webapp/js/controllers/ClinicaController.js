
app.controller('ClinicaController', [
'$scope',
function ($scope) {


    /*
    TODO #7
    a. Injectati $location si $routeParams.
    b. Creati un array de persoane. Acestea vor fi persoanele programate la clinica.
    */



    /*
     TODO #16

     Pentru ca editarea sa functioneze, trebuie sa initializati obiectul (js-ul) care va fi bindat de view.
     Completati getPersonById din PersonsService si apelati-l aici la incarcarea scope-ului.
     Ce parametru va primi getPersonById? Hint: $routeParams

     Next TODO: ClinicaController.js

     */



    $scope.createAppointment = function (person) {
        /*
         TODO #13

         Adaugati persoana care a facut programarea.
         La fel ca la funtia de delete, creati-va o functie de add in service-ul de persoane si apelati-o de aici.
         Asigurati-va ca dati un id unic persoanei.

         Next TODO: edit.html

         */

        /*
            Adaugati persoana aici (nu sub apelul $location.path).
         */
        $location.path('list'); // redirecteaza catre list dupa ce am adaugat persoana
    }

    $scope.editAppointment = function (person) {

        /*
         TODO #15

         Editati persoana care a facut programarea.
         La fel, creati-va o functie de edit/update in service-ul de persoane si apelati-o de aici.

         Next TODO: ClinicaController.js

         */

        $location.path('list');
    }

    $scope.deletePerson = function (person) {
        /*
         TODO #10

         Apelati metoda de delete din PersonsService.
         Ce lipseste? Ce trebuie injectat?

         Next TODO: ClinicaServices.js

         */
    }

    $scope.formatDoctor = function (doctor) {
        return doctor.name + " -- " + doctor.specialityName;
    }

    console.log('controller');

    $scope.dateOptions = {
        yearRange: '1900:-0'
    };

}
]);