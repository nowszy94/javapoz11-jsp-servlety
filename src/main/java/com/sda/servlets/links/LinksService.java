package com.sda.servlets.links;

import java.util.ArrayList;
import java.util.List;

public class LinksService {

    private static LinksService instance = new LinksService();

    public static LinksService instanceOf() {
        return instance;
    }

    private List<Link> links;
    private Integer nextId;

    private LinksService() {
        this.links = new ArrayList<>();
        this.nextId = 1;

        save(new Link("http://www.google.com", "Google"));
        save(new Link("http://pl.wikipedia.com", "Wikipedia"));
        save(new Link("http://onet.pl", "Onet"));
    }

    public List<Link> findAll() {
        return new ArrayList<>(links);
    }

    public void save(Link linkObject) {
        if (linkObject.getId() == null) {
            linkObject.setId(nextId++);
            links.add(linkObject);
        } else {
            links.stream()
                    .filter(e -> e.getId().equals(linkObject.getId()))
                    .findAny()
                    .ifPresent(e -> {
                        e.setUrl(linkObject.getUrl());
                        e.setText(linkObject.getText());
                    });
        }
    }

    public void delete(Integer id) {
        this.links.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .ifPresent(e -> {
                    int index = links.indexOf(e);
                    links.remove(index);
                });
    }
}
