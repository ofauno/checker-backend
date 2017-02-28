## Running

### Adjust database connection values

* [database.properties](src/main/resources/database.properties)

### create databases:

You need to do this only once. Foe more information see [Database migrations](http://javalite.io/database_migrations). 

```
mvn db-migrator:create
```

### Start the app

Running is the same as any other Java app:

```
mvn jetty:run
```

and then navigating to [http://localhost:8080/people](http://localhost:8080/people).

### (SEED) Posting new JSON document

is easy by executing this command (from root of this project):

```
curl -X POST -H "Content-Type: octet/stream" --data-binary @src/test/resources/people.json http://localhost:8080/people
curl -X POST -H "Content-Type: octet/stream" --data-binary @src/test/resources/checklist.json http://localhost:8080/checklist

```
