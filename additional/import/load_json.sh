#!/bin/bash

echo "Usage load_json.sh "

JSON_API="https://goo.gl/pOaWLm"
QUERY=`cat "./import_json.cypher"`

JSON_DATA=`curl --compress -s H accept:application/json -s "$JSON_API"`
POST_DATA="{\"statements\":[{\"statement\": \"$QUERY\", \"parameters\": {\"data\":\"$JSON_DATA\"}}]}"
DB_URL=${NEO4J_URL-http://localhost:7473}

curl -i -H accept:application/json -H content-type:application/json -d "$POST_DATA" -XPOST
"$DB_URL/db/data/transaction/commit"