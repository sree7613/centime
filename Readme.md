
# MicroServices - Sample Project with SpringBoot

This project helps to 
1. understand how to host different rest apis with the help of SpringBoot
2. Iterating over nested objects




## API Reference

## Hello Controller
This api is to print hello as response
```http
GET http://ec2-52-55-61-177.compute-1.amazonaws.com:8080/centime/api/hello
```

## User Controller
This api is to concatinate given name and surname parameters
```http
POST  http://ec2-52-55-61-177.compute-1.amazonaws.com:8080/centime/api/user
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Name` | `string` | **Required**. |
| `Surname` | `string` | **Required**. |

 ## Hello User Controller
This api is to concatinate given name and surname parameters suffixed by Hello
```http
GET  http://ec2-52-55-61-177.compute-1.amazonaws.com:8080/centime/api/hello_user
POST  http://ec2-52-55-61-177.compute-1.amazonaws.com:8080/centime/api/hello_user
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Name` | `string` | **Required**. |
| `Surname` | `string` | **Required**. |

## Application User Controller
This api is to get user by given Id.
```http
GET  http://ec2-52-55-61-177.compute-1.amazonaws.com:8080/centime/api/users/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | Integer | **Required**. |

```http
GET  http://ec2-52-55-61-177.compute-1.amazonaws.com:8080/centime/api/users
```
This api is to get all the users saved in database - iterating over nested objects, 
to display parent and child reference nodes if any


