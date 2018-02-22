package com.tutorial.macbookpro.interviewer.manager;

/**
 * Created by macbookpro on 2017-10-19.
 */

public class ApiUtils {

   // public static final String BASE_URL = "";
   public static final String BASE_URL = "http://10.0.2.2:8080/messenger/webapp/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
