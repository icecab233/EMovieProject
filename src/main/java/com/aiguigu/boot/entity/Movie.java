package com.aiguigu.boot.entity;

import com.alibaba.fastjson.JSONObject;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.Setter;
//import springfox.documentation.spring.web.json.Json;

import java.net.URL;
import java.util.Date;

@Data
public class Movie {
    private String adult;
    private String belongsToCollection;

//    @Setter
//    JSONObject jbelongsToCollection;
//    public void setJbelongsToCollection(String belongsToCollection) {
//        this.jbelongsToCollection = JSONObject.parseObject(belongsToCollection);
////        this.jbelongsToCollection = JSONObject.Object();
//    }
    private int budget;
    private String genres;
    private String homepage;
    private int id;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private String productionCompanies;
    private String productionCountries;
    private String releaseDate;
    private int revenue;
    private int runtime;
    private String spokenLanguages;
//    @Setter
//    com.alibaba.fastjson.JSONObject jspokenLanguages;
//    public void setJspokenLanguages(String spokenLanguages) {
//        this.jspokenLanguages = JSONObject.parseObject(spokenLanguages);
//    }

    private String status;
    private String tagline;
    private String title;
    private String video;
    private float voteAverage;
    private int voteCount;
}
