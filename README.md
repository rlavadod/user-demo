# CRUD User API

This is a demo app for CRUD user using Spring Boot.

## Requirements

- Java 17 or higher
- Maven 3.8.4 or higher

## Installation

### Using Maven

1. Clone the repository:

    ```bash
    git clone https://github.com/rlavadod/user-demo.git
    ```
2. Navigate to the project directory:

    ```bash
    cd user-demo
    ```
3. Compile and package the application using Maven:

    ```bash
    mvn clean install
    ```
4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

## Postman
Once the application is running, download the postman collection file and import to postman app.

## Endpoints

### Create User

- **URL:** `/api/v1/user/`
- **Method:** `POST`
- **Description:** Creates a new user with the provided data.

- **Request Body:**

    ```json
    {
        "name": "Juan Perez 1",
        "email": "aaaaaaa@dominio.cl",
        "password": "cazadpr123",
        "phones": [
            {
                "number": "54514",
                "citycode": "1",
                "countrycode": "54"
            },
            {
                "number": "54514",
                "citycode": "1",
                "countrycode": "53"
            },
            {
                "number": "54514",
                "citycode": "1",
                "countrycode": "52"
            }
        ]
    }
    ```

- **Response:**

    ```json
    {
        "id": "3f8203d7-e045-433a-adf2-637a13dda746",
        "name": "Juan Perez 1",
        "email": "aaaaaaa@dominio.cl",
        "password": "cazadpr123",
        "phones": [
            {
                "id": "38856afd-0121-4d6d-850e-453385776cd1",
                "number": "54514",
                "citycode": "1",
                "countrycode": "54"
            },
            {
                "id": "cb609d53-d2ab-4b3c-9b34-c4cf8a6439a7",
                "number": "54514",
                "citycode": "1",
                "countrycode": "53"
            },
            {
                "id": "99edc2c0-3fa9-4cce-9b55-77387098e772",
                "number": "54514",
                "citycode": "1",
                "countrycode": "52"
            }
        ],
        "created": "2024-12-27T03:25:08.083+00:00",
        "modified": null,
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYWFhYWFhQGRvbWluaW8uY2wiLCJpYXQiOjE3MzUyNjk5MDgsImV4cCI6MTczNTI3MzUwOH0.nvt8XIXbbHk5qeClbrNJc6OjUiW-Mnw_0bgJ2R867xA",
        "isactive": false,
        "last_login": null
    }
    ```

### List users

- **URL:** `/api/v1/user/`
- **Method:** `GET`
- **Description:** Retrieves a list of all users.

- **Response:**

    ```json
    [
        {
            "id": "3f8203d7-e045-433a-adf2-637a13dda746",
            "name": "Juan Perez 1",
            "email": "aaaaaaa@dominio.cl",
            "password": "cazadpr123",
            "phones": [
                {
                    "id": "38856afd-0121-4d6d-850e-453385776cd1",
                    "number": "54514",
                    "citycode": "1",
                    "countrycode": "54"
                },
                {
                    "id": "cb609d53-d2ab-4b3c-9b34-c4cf8a6439a7",
                    "number": "54514",
                    "citycode": "1",
                    "countrycode": "53"
                },
                {
                    "id": "99edc2c0-3fa9-4cce-9b55-77387098e772",
                    "number": "54514",
                    "citycode": "1",
                    "countrycode": "52"
                }
            ],
            "created": "2024-12-27T03:25:08.083+00:00",
            "modified": null,
            "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYWFhYWFhQGRvbWluaW8uY2wiLCJpYXQiOjE3MzUyNjk5MDgsImV4cCI6MTczNTI3MzUwOH0.nvt8XIXbbHk5qeClbrNJc6OjUiW-Mnw_0bgJ2R867xA",
            "isactive": false,
            "last_login": null
        }
    ]
    ```

### Get User by ID

- **URL:** `/api/v1/user/{id}`
- **Method:** `GET`
- **Description:** Retrieves a user by identifier (UUID).

- **Response:**

    ```json
    
      {
        "id": "ff06e6eb-10ce-44d5-a4dc-30fae7904ad2",
        "name": "Juan Perez 1",
        "email": "aaaaaaa@dominio.cl",
        "password": "cazadpr123",
        "phones": [
            {
                "id": "88df6c68-4c2f-4ea6-8386-c5416d43310b",
                "number": "54514",
                "citycode": "1",
                "countrycode": "54"
            },
            {
                "id": "1590e37a-e2f5-401c-a4f4-5ae9cab31bdc",
                "number": "54514",
                "citycode": "1",
                "countrycode": "53"
            },
            {
                "id": "5e7ad153-ba85-4abe-9967-6d48fad2f7b7",
                "number": "54514",
                "citycode": "1",
                "countrycode": "52"
            }
        ],
        "created": "2024-12-27T01:33:04.828+00:00",
        "modified": null,
        "token": null,
        "isactive": false,
        "last_login": null
    }
    
    ```

### Delete User by ID

- **URL:** `/api/v1/user/{id}`
- **Method:** `DELETE`
- **Description:** Delete a user by identifier (UUID).

- **Response:** No content

### Update User by UUID

- **URL:** `/api/v1/user/`
- **Method:** `PATCH`
- **Description:** Partially update a user information.

- **Request Body:**

    ```json
    {
        "id": "ff06e6eb-10ce-44d5-a4dc-30fae7904ad2",
        "name": "Juan Perez 2",
        "email": "aaaaaaa@dominio.cl",
        "password": "cazadpr123",
        "phones": [
            {
                "id": "88df6c68-4c2f-4ea6-8386-c5416d43310b",
                "number": "54514",
                "citycode": "1",
                "countrycode": "54"
            },
            {
                "id": "1590e37a-e2f5-401c-a4f4-5ae9cab31bdc",
                "number": "54514",
                "citycode": "1",
                "countrycode": "53"
            },
            {
                "id": "5e7ad153-ba85-4abe-9967-6d48fad2f7b7",
                "number": "54514",
                "citycode": "1",
                "countrycode": "52"
            }
        ],
        "created": "2024-12-27T01:33:04.828+00:00",
        "modified": null,
        "token": null,
        "isactive": false,
        "last_login": null
    }
    ```

- **Response:**

    ```json
    {
        "id": "ff06e6eb-10ce-44d5-a4dc-30fae7904ad2",
        "name": "Juan Perez 2",
        "email": "aaaaaaa@dominio.cl",
        "password": "cazadpr123",
        "phones": [
            {
                "id": "88df6c68-4c2f-4ea6-8386-c5416d43310b",
                "number": "54514",
                "citycode": "1",
                "countrycode": "54"
            },
            {
                "id": "1590e37a-e2f5-401c-a4f4-5ae9cab31bdc",
                "number": "54514",
                "citycode": "1",
                "countrycode": "53"
            },
            {
                "id": "5e7ad153-ba85-4abe-9967-6d48fad2f7b7",
                "number": "54514",
                "citycode": "1",
                "countrycode": "52"
            }
        ],
        "created": "2024-12-27T01:33:04.828+00:00",
        "modified": "2024-12-27T01:34:04.985+00:00",
        "token": null,
        "isactive": false,
        "last_login": null
    }
    ```