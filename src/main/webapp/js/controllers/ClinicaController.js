
app.controller('ClinicaController', [
    '$scope', '$location', 'PersonsService', '$routeParams',
    function ($scope, $location, PersonsService, $routeParams) {

    /*
     TODO #17

     Pentru ca editarea sa functioneze, trebuie sa initializati obiectul (js-ul) care va fi bindat de view.
     Completati getPersonById din PersonsService si apelati-l aici la incarcarea scope-ului.
     Un obiect de tip person va fi initializat cu obiectul returnat de getPersonById.
     In acest mod, field-urile din edit.html vor fi initializate (completate).
     Ce parametru va primi getPersonById? Hint: $routeParams

     Next TODO: PersonsService.js (legat de #17)

     */



    $scope.createAppointment = function (person) {
        /*
         TODO #14

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
         TODO #16

         Editati persoana care a facut programarea.
         La fel, creati-va o functie de edit/update in service-ul de persoane si apelati-o de aici.

         Next TODO: ClinicaController.js

         */

        $location.path('list');
    }

    $scope.deletePerson = function (person) {
        PersonsService.remove(person);
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