package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class RestBookDao implements BookDao {

    public RestBookDao() { }

    @Override
    public List<Book> list(String key) {

        Object doc = getBooksDoc(key);
        List<Book> books = new ArrayList<>();

        List<String> isbns = JsonPath.read(doc, "$.*.bib_key");
        List<String> titles = JsonPath.read(doc, "$.*.details.title");
        List<String> infoUrls = JsonPath.read(doc, "$.*.info_url");

        int size = Math.min(titles.size(), Math.min(isbns.size(), infoUrls.size()));

        for (int i = 0; i < size; i++) {
            String isbn = isbns.get(i);
            String title = titles.get(i);
            String infoUrl = infoUrls.get(i);

            if (title != null && title.contains(" -- ")) {
                title = title.substring(0, title.indexOf(" -- ")).trim();
            }

            if (isbn == null) isbn = "N/A";
            if (title == null || title.isBlank()) title = "Untitled";
            if (infoUrl == null) infoUrl = "";

            books.add(new Book(isbn, title, infoUrl));
        }

        return books;
    }

    @Override
    public Book find(String key) {
        Object doc = getBooksDoc(key);

        List<String> isbns = JsonPath.read(doc, "$.*.bib_key");
        List<String> titles = JsonPath.read(doc, "$.*.details.title");
        List<String> subtitle = JsonPath.read(doc, "$.*.details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$.*.info_url");
        List<Integer> pages = JsonPath.read(doc, "$.*.details.number_of_pages");

        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String desc = subtitle.size() > 0 ? subtitle.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        return new Book(isbn, title, desc, infoUrl, numOfPages);
    }

    private Object getBooksDoc(String isbnString) {
        String openLibraryUrl = "https://openlibrary.org/api/books";

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        String jsonBooklist = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }
}