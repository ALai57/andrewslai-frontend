# andrewslai-frontend

Clojurescript Frontend for `andrewslai`

Eventually, I hope to turn this project into a blogging platform where users can
easily create and publish blog content.

## What's included:

     Front end: Re-frame SPA written in Clojurescript

# Installation

## Clojurescript
The frontend is built using `figwheel-main`
To build the project without any Google Closure optimizations, use   
`lein fig:build`   
(this will also connect a figwheel REPL for interactive development)

To test the Clojurescript app, start a figwheel server with `lein fig:build`,
then navigate to `/tests.html` to see test output

# How to connect to Keycloak using the keycloak.js client


``` javascript

// Initialize Keycloak object
var kc = Keycloak({"url": "http://172.17.0.1:8080/auth",
                   "realm": "test", 
                   "clientId": "test-login"})

// Initialize connection to Keycloak.
kc.init({"onLoad": "login-required", // Optional - forces user to login at init time
         "checkLoginIframe": false,
         "pkceMethod": "S256"})
         .then(function (authenticated) {console.log(authenticated);})
         .catch(function (authenticated) {console.log("BAADD");})

// If we did not choose `onLoad`: `login-required`
kc.login({'prompt': 'Please authenticate', 'scope': 'roles'})

// Now that we've logged in, we can get the user's profile - I believe this also loads kc.token and kc.idToken, which are the JWTs used to access Keycloak
kc.loadUserProfile().then(function (profile) {console.log(profile)})

=> {username: "andrewtest@test.com", firstName: "Andrew", lastName: "Test", email: "andrewtest@test.com", emailVerified: false, …}attributes: {}email: "andrewtest@test.com"emailVerified: falsefirstName: "Andrew"lastName: "Test"username: "andrewtest@test.com"__proto__: Object

// We can also load user info
kc.loadUserInfo().then(function (profile) {console.log(profile)})

```

