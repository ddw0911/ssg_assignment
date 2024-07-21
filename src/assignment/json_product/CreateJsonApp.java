package assignment.json_product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

public class CreateJsonApp {

  public static void main(String[] args) {
    JSONObject jsonObject = UtilJson.createJsonData();
    Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping()
        .create();

    System.out.println(gson.toJson(jsonObject));
    System.out.println("=========================");

    UtilJson.parseJsonData(jsonObject);
    System.out.println("=========================");

    UtilJson.parseJsonDataUseIterator(jsonObject);
  }

}
