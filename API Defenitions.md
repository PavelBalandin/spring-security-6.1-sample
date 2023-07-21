## Registration
**HTTP Method:** POST
**Endpoint URL:** /api/v1/users/register
**Request body:**
``` json
{
	"username":"username",
	"password":"password"
}
```

### Responses
### Successful 
#### **201 Created**
**Response body:**
``` json
{
	"username":"username",
}
```

### Errors 
#### **400 Bad Request**
**USERNAME_REQUIRED**
This error happens when **username** request attribute is not provided, or is provided explicitly as blank string (null, empty string, or spaces).

**PASSWORD_REQUIRED**
This error happens when **password** request attribute is not provided, or is provided explicitly as blank string (null, empty string, or spaces).

**INCORRECT_USERNAME**
This error happens when the provided **password** is incorrect:
1. Username length should be 2-35 inclusively both limits

**INCORRECT_PASSWORD**
This error happens when the provided **password** is incorrect:
1. Password should be not equal to username (ignore case)  
2. Password length should be 8-35 inclusively both limits  
3. Password allows any character except for line terminators  
4. Password should contain at least one of the following: uppercase English alphabet letter (A-Z) OR numeral (0-9)

**USERNAME_AND_PASSWORD_IDENTICAL**
This error happens when **username** and **password** request attributes are the same.

#### **409 Conflict**
USERNAME_ALREDY_EXISTS
This error happens when **username** field already exists in database.


## Authentication
**HTTP Method:** POST  
**Endpoint URL:** /api/v1/users/authenticate  
**Request body:**
**Body**
``` json
{
	"username":"username",
	"password":"password"
}
```
### Responses
### Successful 
**200 OK**
``` json
{
	"accessToken":"access_token",
	"refreshToken":"refresh_token"
}
```

### Errors
### 400 Bad request
**INVALID_LOGIN_OR_PASSWORD**
Login or password not specified or invalid


## Common
#### 401 Unauthorized
**TOKEN_SIGNATURE_MISMATCH**
Authentication failed due to JWT signature miss-match

**EXPIRED_TOKEN**
Token is expired

**INVALID_TOKEN**
Token is not provided or invalid

#### 403 FORBIDDEN
**PERMISSION_DENIED**
If user in request does not have right access

#### 500 Internal Server Error
**INTERNAL_SERVER_ERROR**
Something went wrong on the server side
