# APP TITLE

## Endpoints
### Backend URL
https://hackathon-final.herokuapp.com/

### Find users by id
https://hackathon-final.herokuapp.com/user/find/{id}

### Create users POST
https://hackathon-final.herokuapp.com/register

{
    "identificator": "48085007W",
    "password": "123",
    "name": "Prueba",
    "surname": "Prueba",
    "phone": "123",
    "mail": "qwdwq@veqev.com",
    "observations": "eqoihoqifhq"
}

### Login users POST
https://hackathon-final.herokuapp.com/authenticate

{
    "identificator": "48085007W",
    "password": "123"
}

### Create contact POST
https://hackathon-final.herokuapp.com/contact/create

{
    "phone": "+34 983 23 43 23",
    "fullname": "pepito vazques perez",
    "photo": "nombre_foto" //posiblemente no se implemente
}

### Actualitzation contact PUT
https://hackathon-final.herokuapp.com/contact/update

{
    "idContact": 1,
    "phone": "+34 983 23 43 23",
    "fullname": "pepito vazques perez",
    "photo": "nombre_foto" //posiblemente no se implemente
}

### Activate or desactivate contact PUT
https://hackathon-final.herokuapp.com/contact/status/{contactId}

{
    "idContact": 1,
    active: true
}

### Get all contacts from one user
https://hackathon-final.herokuapp.com/contact/find/user/{userId}
[
    {
        "idContact": 1,
        "phone": "+34 983 23 43 23",
        "fullname": "pepito vazques perez",
        "photo": "nombre_foto" //posiblemente no se implemente
    }
]

##crear configuracion POST
https://hackathon-final.herokuapp.com/configuration/create

{
    "type": 1, //1 - llegue aqui,2 - necesito ayuda o 3 - llamar
    "title": "estoy aqui", //puede ser el que desee, sino el de defecto
    "message": "mensaje que quiere que llegue al destinatario",
    "idUser": 1,
    "contacts" : [
        {
            "id": 1,
            "phone": "+34 482 23 43 54",
            "fullName": "roberto rodriguez chavez"
        }
    ]
}

##actualizar configuracion PUT
https://hackathon-final.herokuapp.com/configuration/update
{
    "idMessage": 1,
    "type": 1, //1 - llegue aqui,2 - necesito ayuda o 3 - llamar
    "title": "estoy aqui", //puede ser el que desee, sino el de defecto
    "message": "mensaje que quiere que llegue al destinatario",
    "idUser": 1,
    "contacts" : [
        {
            "id": 1,
            "phone": "+34 482 23 43 54",
            "fullName": "roberto rodriguez chavez"
        }
    ]
}

##consultar las configuraciones por usuarios
https://hackathon-final.herokuapp.com/configuration/find/user/{userId}
[
    {
    "idMessage": 1,
    "type": 1, //1 - llegue aqui,2 - necesito ayuda o 3 - llamar
    "title": "estoy aqui", //puede ser el que desee, sino el de defecto
    "message": "mensaje que quiere que llegue al destinatario",
    "idUser": 1,
    "contacts" : [
            {
                "id": 1,
                "phone": "+34 482 23 43 54",
                "fullName": "roberto rodriguez chavez"
            }
        ]
    }
]
