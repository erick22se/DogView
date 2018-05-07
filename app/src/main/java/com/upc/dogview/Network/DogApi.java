package com.upc.dogview.Network;

public class DogApi {
    private static String URL_BASE = "https://api.thedogapi.co.uk";

    public static String getDog(){
        return URL_BASE.concat("/v2/dog.php");
    }

    public static String get20Dog(){return URL_BASE.concat("/v2/dog.php?limit=20");}
}
