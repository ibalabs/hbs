package com.ahcareer.hbs.util;

import java.lang.reflect.Type;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * JSONUtils.java
 * 
 * Author : MANPAR TECHNOLOGIES
 */
public class JSONUtils {

  private static Gson gson = new Gson();

  /**
   * Convert the Java Object to String
   * 
   * @param custObject
   * @return
   */
  public static String toJson(Object custObject) {
    if (custObject == null) {
      return null;
    }
    return gson.toJson(custObject);
  }

  /**
   * Format Json
   * 
   * @param value
   * @return
   */
  public static String formatJson(Object value) {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    return gson.toJson(value);
  }

  /**
   * Convert the Java Object to JsonElement
   * 
   * @param custObject
   * @return
   */
  public static JsonElement toJsonTree(Object custObject) {
    if (custObject == null) {
      return null;
    }
    return gson.toJsonTree(custObject);
  }

  /**
   * Convert GSON String To Object
   * 
   * @param type
   * @param jsonObj
   * @return
   */
  public static Object fromJson(Type type, Object jsonObj) {
    if (jsonObj == null) {
      return null;
    }
    if (jsonObj instanceof String) {
      return gson.fromJson((String) jsonObj, type);
    }
    return gson.fromJson(gson.toJson(jsonObj), type);
  }

  /**
   * Convert To JSON Object
   * 
   * @param jsonString
   * @return
   * @throws Exception
   */
  public static JSONObject toJSONObject(String jsonString) throws Exception {
    if (jsonString == null || jsonString.isEmpty()) {
      return new JSONObject();
    }
    return (JSONObject) new JSONParser().parse(jsonString);
  }

  /**
   * To Json Object
   * 
   * @param jsonString
   * @return
   * @throws Exception
   */
  public static JsonObject toJsonObject(String jsonString) throws Exception {

    JsonParser jsonParser = new JsonParser();
    JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonString);
    return jsonObject;
  }

  /**
   * To Json Array
   * 
   * @param jsonString
   * @return
   * @throws Exception
   */
  public static JsonArray toJsonArray(String jsonString) throws Exception {
    JsonParser jsonParser = new JsonParser();
    JsonArray jsonArray = (JsonArray) jsonParser.parse(jsonString);
    return jsonArray;
  }
}