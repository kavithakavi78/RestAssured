package org.testfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadJsonFile {

	@DataProvider(name = "sample")
	public String[] test() throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\Json\\inputs.json");
		Object obj = jsonparser.parse(reader);

		JSONObject jsonobj = (JSONObject) obj;

		JSONArray array = (JSONArray) jsonobj.get("tags");
		String arr[] = new String[array.size()];

		for (int i = 0; i < array.size(); i++) {
			JSONObject users = (JSONObject) array.get(i);
			String id = (String) users.get("id");
			String Uname = (String) users.get("name");
			arr[i] = id + "," + Uname + ",";

		}
		return arr;

	}
}
