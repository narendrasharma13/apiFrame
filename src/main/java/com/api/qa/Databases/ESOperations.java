package com.api.qa.Databases;

import org.apache.http.HttpHost;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

public class ESOperations {

    public void verifyDataPresenceInES(String collectionName, String id) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost("elasticsearch.zeniusnet.com") )
                        .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback()
                        { public HttpAsyncClientBuilder customizeHttpClient(
                                final HttpAsyncClientBuilder httpAsyncClientBuilder) {
                            return httpAsyncClientBuilder;
                        }}));
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);

        GetRequest getRequest = new GetRequest("zs_content." + collectionName);
        getRequest.id(id);

        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);

        if (getResponse.toString().contains("\"found\":false")) {
            System.out.println(id + " is not present in ES");
        } else System.out.println(id + " is present in ES");

        client.close();
    }

    public void verifyDataPresenceInES(String collectionName, String id, String Host) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost(Host,10000,"http") )
                        .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback()
                        { public HttpAsyncClientBuilder customizeHttpClient(
                                final HttpAsyncClientBuilder httpAsyncClientBuilder) {
                            return httpAsyncClientBuilder;
                        }}));
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);

        GetRequest getRequest = new GetRequest("zs_content." + collectionName);
        getRequest.id(id);

        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);

        if (getResponse.toString().contains("\"found\":false")) {
            System.out.println(id + " is not present in ES");
        } else System.out.println(id + " is present in ES");

        client.close();
    }


}
