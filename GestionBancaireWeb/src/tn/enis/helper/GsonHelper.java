package tn.enis.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {

	public static String getPrettyFormat(Object input) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(input);
		return json;
	}

}
