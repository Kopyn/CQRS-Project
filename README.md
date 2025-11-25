# CQRS-Project
Project aimed at applying the CQRS pattern with usage of Kafka EventBus, Elasticsearch for Query handling with further possible upgrades. 

## Breakdown of project components:
* Client application - this application will be used to interact with the system. At first it will generate a call to the backend every X seconds. Later there will be introduced functionality to make manual calls to the backend.
* Command and Query channels - used to facilitate the CQRS pattern - Command channel will be realised with Kafka event bus making the system event-driven. Query channel will be implemented with the usage of basic HTTP requests.
* Query channel:
  * Query service - a service dedicated for handling queries, the service will have a connection to some data store - possible solutions are MongoDB, Elasticsearch, Solr, separate Database or deticated views in main DB.
  * Query datastore - used for storing the data which will be queried.
* Command channel:
