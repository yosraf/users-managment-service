<br />
<p align="center">
  

  <h3 align="center"> users managment web service </h3>

  <p align="center">
This is a web service that allow to manage users using spring security and jwt.<br/>
  (Work in progress)
    <br />
  </p>
</p>

## Built with
This is project is build with :
<br/>
<ul>
  <li>Spring boot</li>
  <li>Spring security</li>
  <li>Jwt</li>
</ul>

## Documentation
1. User authentication
   ```sh
   curl --location --request POST http://localhost:8080/api/login?userName=yosra&password=password
   \--header 'Content-Type: application/x-www-form-urlencoded \
   ```
2. Get users list
```sh
  curl --location --request GET http://localhost:8080/protected/users \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5b3N
yYSIsInJvbGVzIjpbIkFETUlOIl0sImlzcyI6Imh0dHA6Ly9s
b2NhbGhvc3Q6ODA4MC9hcGkvbG9naW4iLCJleHAiOjE2MTA4MTE0NzV9.cOoRkh2OGPMVywb8SPUN9ml62HsYjrgHeR-Y-4ePWks
