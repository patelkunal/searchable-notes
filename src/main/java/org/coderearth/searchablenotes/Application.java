package org.coderearth.searchablenotes;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting SearchableNotes Application !!");

        final RestHighLevelClient restClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                )
        );

        TransportClient client = TransportClient
                .builder()
                .settings(Settings.builder().build())
                .build();

        final SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        final SearchRequest searchRequest = new SearchRequest("notes").types("note").source(sourceBuilder);
        final SearchResponse searchResponse = restClient.search(searchRequest);
        System.out.println(searchResponse.status().getStatus());
        System.out.println("Stopping SearchableNotes Application !!");
    }

}
