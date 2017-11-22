# searchable-notes

search recipe using elasticsearch and spring (if required)

### requirements -
1. as explained here
   https://www.elastic.co/blog/state-of-the-official-elasticsearch-java-clients
   - please use elasticsearch-rest-client which doesn't bring any bagages of
   	 unnecessary dependencies which is not required by clients in general
2. donot use spring-data-elasticsearch package (atleast for now - I don't know
   how that magic happens using Repository<?, ?>
