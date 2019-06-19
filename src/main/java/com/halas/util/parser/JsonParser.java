package com.halas.util.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public final class JsonParser {
    private static final Logger LOG = LogManager.getLogger(JsonParser.class);
    private static JSONObject jsonObject;

    static {
        createInstanceJsonObject();
    }

    private JsonParser() {
    }

    private static void createInstanceJsonObject() {
        try {
            jsonObject = (JSONObject) (new JSONParser().parse(new FileReader("src/main/resources/data/gmail.json")));
        } catch (IOException | ParseException e) {
            LOG.error("Cannot find file json..");
            LOG.error("Class: " + e.getClass());
            LOG.error("Message: " + e.getMessage());
            LOG.error(e.getStackTrace());
        }
    }

    public static Object[][] getUsers(int amount) {
        int amountUsers = getAmountUsers();
        if (amount < amountUsers || amount >= 1) {
            amountUsers = amount;
        }
        Object[][] users = new Object[amountUsers][];
        for (int i = 0; i < amountUsers; i++) {
            users[i] = new Object[]{getUserLogin(i)};
            //, getUserPassword(i)};
        }
        return users;
    }


    private static int getAmountUsers() {
        return ((JSONArray) ((JSONObject) jsonObject.get("users")).get("login")).size();
    }

    private static String getUserLogin(int index) {
        return (String) ((JSONArray) ((JSONObject) jsonObject.get("users")).get("login")).get(index);
    }

    private static String getUserPassword(int index) {
        return (String) ((JSONArray) ((JSONObject) jsonObject.get("users")).get("password")).get(index);
    }

    public static String getBaseUrl() {
        return jsonObject.get("url-base").toString();
    }

    public static String getWhoReceiveMessage() {
        return ((JSONObject) jsonObject.get("message")).get("who-receive-message").toString();
    }

    public static String getWhoReceiveCopyMessage() {
        return ((JSONObject) jsonObject.get("message")).get("who-receive-copy-message").toString();
    }

    public static String getWhoReceiveHiddenCopyMessage() {
        return ((JSONObject) jsonObject.get("message")).get("who-receive-hidden-copy-message").toString();
    }

    public static String getThemeMessage() {
        return ((JSONObject) jsonObject.get("message")).get("theme-message").toString();
    }

    public static String getMessage() {
        return ((JSONObject) jsonObject.get("message")).get("message").toString();
    }
}
