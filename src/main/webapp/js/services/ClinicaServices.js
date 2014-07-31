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
        for (var i = 0; i < this.list.length; i++) {
            if (this.list[i].id == person.id) {
                this.list.splice(i, 1);
                break;
            }
        }
    }

    this.getPersonById = function (id) {
        /*
        TODO #18
        */
    }

    return this;

}])