package uk.co.freddiefaulkner.supercars;

public class YoutubePlayerConfig {

    // empty constructor used to create instance of this class
    public YoutubePlayerConfig(){

    }

    // declares the constant string which is the api key needed for my youtube video
    private static final String API_KEY = "AIzaSyCgD8ZQebCAT3rgGGAeXzxiGaUcUqWRz6A";

    // function used to return the api key
    public static String getApiKey(){
        return API_KEY;
    }

}
