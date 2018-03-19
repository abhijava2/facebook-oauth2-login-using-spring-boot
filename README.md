# Facebook Oauth2 login using Spring Boot

## Spring Boot, OAuth2 Authentication, Facebook API


## Requirements

1.  Java - 1.8.x

2.  Maven - 3.x.x

3.  Spring 5, Spring Boot

4.  Facebook developer App


## Steps to Setup

** 1. Clone the application repo **

** 2. Change application.yml file  **
 Change file with your clientId and clientSecret.

** 3. Build and run the backend app using maven**

```bash
mvn spring-boot:run
```

### Snapshots

```
Landing page
```
<img src="src/main/resources/static/images/login.png" width="60%" >

```
Facebook API RESTful call
```
<img src="src/main/resources/static/images/facebook_API_Call.png" width="80%" >

```
API authentication on Facebook
```
<img src="src/main/resources/static/images/facebook_app_authentication.png" width="80%" >

```
Callback to base URL after successful authentication
```
<img src="src/main/resources/static/images/callback_successful_login.png" width="60%" >



The application will start at <http://localhost:8080>.
