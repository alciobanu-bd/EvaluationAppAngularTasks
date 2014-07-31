app
.factory('DoctorsService',
[function() {
    /*
     TODO #11

    Intoarceti o lista de doctori. Competati return-ul de mai jos.
    Un doctor este un obiect de genul:
    {
        name: 'Gigel',
        specialityName: 'Chirurgie plastica'
    }

     Next TODO: create.html

     */

    return  [

    ];

}])

.factory('PersonsService',
[function() {

    this.personsList = [];

    this.remove = function (person) {
        /*
            TODO Remove person from array
            person va avea un camp id
            Stergeti persoana din array bazandu-va pe campul id care va fi unic pentru fiecare persoana.
         */
    }

    /*
     TODO #9

     Modificati array-ul de persoane din controller sa instantieze lista din PersonsService.
     Completati metoda remove de mai sus, care sterge o persoana din array.

    Next TODO: ClinicaController.js

     */

    this.getPersonById = function (id) {
        /*
        TODO #18
        */
    }

    return this;

}])