# Lab 4

### Scenario 1: Pseudo-Code for Authentication System

<u>Pseudo-Code Example</u>

    FUNCTION authenticateUser(username, password):
    QUERY database WITH username AND password
    IF found RETURN True
    ELSE RETURN False

<u>Analysis and vulnerabilities </u>

* Seems the `password` param is passed in a clear way (not encrypted), and also is compared in database in a encrypted way 
* If this implementation belong to a web app, this could be a broken Authentication incident or also this same error could be caused by a missed/wrong Cookie security configuration

<u> Security Plan </u>

* In user signup process, first validate inputs, and  implement an algorithm to encrypt password and store it in database
* In Login process, backend should encrypt password param, and then compare with password found from database , If the all passwords of accounts are encrypted and saved them in database, although database will be accessed, the password data will not compromised or violated

<u>Pseudocode scenarios </u>

Signup using password encrypt algorithm

    FUNCTION login(username, password):
    IF validationRules(password ) FALSE
      RETURN ERROR
    IF ELSE
      DECRYPT/HASH password
      INSERT (username, password) VALUES (username, #$%#%#$&$%)
      ASSIGN ROLE IN SPRING SECURITY
      RETURN TRUE

Login process

    FUNCTION authenticateUser(username, password):
    ENCRYPT password
    QUERY database WITH username AND password
    IF found 
      IF HAS ROLE IN SPRING SECURITY
        GENERATE TOKEN
        RETURN TOKEN
      END IF
      IF NOT 
        RETURN FALSE
      END IF
    END IF

-----------------------------------
      
### Scenario 2: JWT Authentication Schema

  Design Outline:

    DEFINE FUNCTION generateJWT(userCredentials):
    IF validateCredentials(userCredentials):
      SET tokenExpiration = currentTime + 3600 // Token expires in one hour
      RETURN encrypt(userCredentials + tokenExpiration, secretKey)
    ELSE:
      RETURN error

<u>Analysis and vulnerabilities </u>
* Secret key is in blank and is a weak and predictable word
* Expiration time is hardcode

<u> Security Plan </u>
* Implement maybe AWS cognito provider to store and validate login using the credentials
* Implement mechanism/algorithm to generate a better secret Key for JWT
* Store secure key in AWS PARAMETER STORE or secrets of Kubernetes or Environment Var of Cloud provider from your choice
* Implement mechanism algorithm if AWS Cognito granted access returns JWT 

<u>Pseudocode scenarios </u>

    EXPIRATION_VAR = {{$EXPIRATION_TIME}}
    EXPIRATION_VAR = {{$SECRET_KEY}}

    DEFINE FUNCTION generateJWT(userCredentials):
      IF validateCredentialsInCognito(userCredentials):
        SET tokenExpiration = currentTime + EXPIRATION_VAR 
        RETURN encrypt(userCredentials + tokenExpiration, EXPIRATION_VAR)
      ELSE:
        RETURN error

-----------------------------------

### Scenario 3: Secure Data Communication Plan

<u>Outline for Data Protection:</u>

    PLAN secureDataCommunication:
      IMPLEMENT SSL/TLS for all data in transit
      USE encrypted storage solutions for data at rest
      ENSURE all data exchanges comply with HTTPS protocols

<u>Analysis and vulnerabilities </u>

* Not consider attacks for CSRF and XSS
* not consider password encrypted in database
* Not consider auditory or analysis using DAST SAST

<u>Security Plan </u>

* Use Cookie security configuration to enable HTTPS, avoid CSRF and avoid XSS
* Password encrypted or hashed 
* Implement DAST auditory to detect Onine vulnerabilities
* Implement SAST auditory to detect vulnerabilities on libraries
* IMPLEMENT Multifactor Auth or Double auth using OTP, TOTP to access to DAtabase or app

<u>Pseudocode scenarios </u>

    PLAN secureDataCommunication:
    IMPLEMENT SSL/TLS for all data in transit
    USE encrypted storage solutions for data at rest
    ENSURE all data exchanges comply with HTTPS protocols
    IF APP IS WEB IMPLEMENT Cookie Security Config (Set-Cookie: SID=12345; Secure; HttpOnly; SameSite=Strict;)
    IMPLEMENT Multifactor Auth or Double auth using OTP, TOTP to access to web platform
    IMPLEMENT DAST Auditories each month
    IMPLEMENT SAST auditory to detect vulnerabilities on libraries

    
