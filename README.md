# MyFirstApplication

Using Mongo DB, Rest API, OAuth2.

1) Will not be able to access using the below query

curl http://localhost:8080/resource/test

2) curl -XPOST -k foo:foosecret@localhost:9000/authserver/oauth/token \
   -d grant_type=password -d client_id=foo -d client_secret=abc123 \
   -d username=bar -d password=barsecret
   
   
Run the Oauth2 Server - my other application and run the step 2 command. Get the token

3) TOKEN = "bcjsdkn-bjhdna -bja" Copy the token to TOKEN variable

4) curl -H "Authorization: Bearer $TOKEN" http://localhost:8080/resource/test

See the "Hello" Message
