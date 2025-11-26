# CQRS-Project
Project aimed at applying the CQRS pattern with usage of Kafka EventBus, Elasticsearch for Query handling with further possible upgrades. 

## Breakdown of project components:
* Client application - this application will be used to interact with the system. At first it will generate a call to the backend every X seconds. Later there will be introduced functionality to make manual calls to the backend.
* Command and Query channels - used to facilitate the CQRS pattern - Command channel will be realised with Kafka event bus making the system event-driven. Query channel will be implemented with the usage of basic HTTP requests.
* Query channel:
  * Query service - a service dedicated for handling queries, the service will have a connection to some data store - possible solutions are MongoDB, Elasticsearch, Solr, separate Database or deticated views in main DB.
  * Read-only datastore - used for storing the data which will be queried.
* Command channel:
 * Kafka command topic - used for transfering commands from the client to command handling service
 * Command handling service - will be implemented as Spring boot application at first. It will handle CUD operations on entities and store them in the Datastore.
 * Database
 * Indexer - used for synchronizing read-only datastore with the main database

## Tech stack
* Java with SpringWebflux for asynchronous and non-blocking command processing
* Kafka Event Store for reliable message transfer
* Zookeeper for distributed coordination
* MySQL database for reliable data storage
* Elasticsearch search engine for fast querying
