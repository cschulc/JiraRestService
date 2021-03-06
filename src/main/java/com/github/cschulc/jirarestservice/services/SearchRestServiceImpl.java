/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.JqlSearchResultBean;
import com.github.cschulc.jirarestservice.domain.filter.FilterBean;
import com.github.cschulc.jirarestservice.jql.SearchBean;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang3.Validate;
import org.apache.http.client.utils.URIBuilder;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static com.github.cschulc.jirarestservice.misc.RestPaths.FAVORITE;
import static com.github.cschulc.jirarestservice.misc.RestPaths.FILTER;
import static com.github.cschulc.jirarestservice.misc.RestPaths.SEARCH;

public class SearchRestServiceImpl extends BaseRestService implements SearchRestService {

    public SearchRestServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    public Future<JqlSearchResultBean> searchIssues(final SearchBean jsb) {
        Validate.notNull(jsb);
        return executorService.submit(() -> {
            String body = gson.toJson(jsb);
            URIBuilder uriBuilder = buildPath(SEARCH);
            RestApiCall restApiCall = doPost(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                JqlSearchResultBean jqlSearchResult = gson.fromJson(jsonReader, JqlSearchResultBean.class);
                restApiCall.release();
                return jqlSearchResult;
            } else {
                throw restApiCall.buildException();
            }
        });

    }


    public Future<FilterBean> createSearchFilter(FilterBean create) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FILTER);
            RestApiCall restApiCall = doPost(uriBuilder.build(), create.toString());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                FilterBean filter = gson.fromJson(jsonReader, FilterBean.class);
                restApiCall.release();
                return filter;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<FilterBean>> getFavoriteFilter() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FILTER, FAVORITE);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<FilterBean>>() {
                }.getType();
                List<FilterBean> filters = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return filters;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<FilterBean> getFilterById(String id) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FILTER, id);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                FilterBean filter = gson.fromJson(jsonReader, FilterBean.class);
                restApiCall.release();
                return filter;
            } else {
                throw restApiCall.buildException();
            }
        });
    }
}
