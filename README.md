# APP TITLE

## Endpoints
### Backend URL
https://hackathon-final.herokuapp.com/

### Find users by id
https://hackathon-final.herokuapp.com/user/find/{id}

### Create users POST
https://hackathon-final.herokuapp.com/register

### Login users POST
https://hackathon-final.herokuapp.com/authenticate

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
https://hackathon-final.herokuapp.com/contact/status/%7BcontactId%7D

{
    "idContact": 1,
    active: true
}

### Get all contacts from one user
https://hackathon-final.herokuapp.com/contact/find/user/%7BuserId%7D
