package assignment.json_product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class UtilJson {

  public static JSONObject createJsonData() {
    /**
     * 모든 데이터를 담을 JSONObject 생성
     */

    JSONObject productInfo = new JSONObject();

    /**
     * value로 단순 값(string, int)를 가지는 프로퍼티 처리.
     * product_no
     * product_name
     */

    productInfo.put("1", "사과");
    productInfo.put("2", "복숭아");
    productInfo.put("3", "포도");
    productInfo.put("4", "수박");
    productInfo.put("5", "바나나");

    /**
     * value로 Json을 가지는 프로퍼티 처리.
     * extra_product_info JSONObject 생성
     */
    JSONObject extra_product_info = new JSONObject();
    extra_product_info.put("2-1","천도복숭아");
    extra_product_info.put("4-1","무등산수박");
    productInfo.put("extra product info", extra_product_info);

    /**
     * value로 Array를 가지는 프로퍼티 처리.
     * item_list JSONArray 생성
     */
    JSONArray item_list = new JSONArray();
    item_list.put("망고");
    item_list.put("용과");
    item_list.put("샤인머스켓");
    productInfo.put("item list", item_list);

    /**
     * value로 Json을 가지는 프로퍼티 처리.
     * item_list.* JSONObject 생성하세요
     */
    JSONObject item_list2 = new JSONObject();
    productInfo.put("item list.*", item_list2);

    return productInfo;
  }


  public static void parseJsonData(JSONObject jsonObject) {

    /**
     * String 형태로 만들어져있는 JSON 데이터를 파싱해줄 객체 생성.
     */
    JSONObject jsonObject1 = jsonObject;

    /**
     * JSON 데이터가 String 형태로 들어왔음을 가정하기 위해
     * Json 데이터를 생성하고 String 형태로 바꿔주었다.
     */
    try {
      String s = jsonToString(jsonObject1);
      BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Temp/fruit.json"));
      bw.write(s);
      bw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    /**
     * value로 단순 값(string, int)를 가지는 프로퍼티 조회.
     * product_no, product_name
     */
    for (int i = 1; i < jsonObject1.length(); i++) {
      try {
        System.out.println(i + " " + jsonObject1.get(String.valueOf(i)));
      } catch (RuntimeException e) {
      }
    }

    /**
     * value로 Json을 가지는 프로퍼티 조회.
     * extra_product_info를 꺼낼 때, JSONObject로 캐스팅.
     */
    System.out.println(jsonObject1.getJSONObject("extra product info"));

    /**
     * value로 Array를 가지는 프로퍼티 조회.
     * item_list를 꺼낼 때, JSONArray로 캐스팅.
     */
    System.out.println(jsonObject1.getJSONArray("item list"));

  }

  public static void parseJsonDataUseIterator(JSONObject jsonObject) {
    /**
     * String 형태로 만들어져있는 JSON 데이터를 파싱해줄 객체 생성.
     */
    JSONObject jsonObject1 = jsonObject;

    /**
     * JSON 데이터가 String 형태로 들어왔음을 가정하기 위해
     * Json 데이터를 생성하고 String 형태로 바꿔주었다.
     */
    try {
      String s = jsonToString(jsonObject1);
      BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Temp/fruit.json"));
      bw.write(s);
      bw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    /**
     * value로 단순 값(string, int)를 가지는 프로퍼티 조회.
     * product_no, product_name
     */
    for (int i = 1; i < jsonObject1.length(); i++) {
      try {
        System.out.println(i + " " + jsonObject1.get(String.valueOf(i)));
      } catch (RuntimeException e) {
      }
    }


    /**
     * value로 Json을 가지는 프로퍼티 조회.
     * extra_product_info를 꺼낼 때, JSONObject로 캐스팅.
     */
    System.out.println(jsonObject1.getJSONObject("extra product info"));

    /**
     * value로 Array를 가지는 프로퍼티 조회.
     * item_list를 꺼낼 때, JSONArray로 캐스팅.
     */
    for (int i = 0; i < jsonObject1.getJSONArray("item list").length(); i++) {
      System.out.println(jsonObject1.getJSONArray("item list").get(i));
    }

    /**
     * item_list의 각 원소를 JSONObject로 캐스팅 후, 변수의 키셋을 가져온다.
     * [참고] 각 원소의 키가 다를 경우 유용하다.
     */
    System.out.println(jsonObject1.keySet());
  }


  public static String jsonToString(JSONObject jsonObject) {
    return jsonObject.toString();
  }


}
