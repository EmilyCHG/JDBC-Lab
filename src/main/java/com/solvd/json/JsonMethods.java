
package com.solvd.json;
import java.io.IOException;
import java.util.List;

import org.eclipse.persistence.exceptions.JSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMethods {

	private static ObjectMapper mapper = new ObjectMapper();

	public static <T> String serialize(T objetc)
			throws JsonProcessingException {
		String data = null;
		try {
			data = mapper.writeValueAsString(objetc);
		} catch (JSONException e) {
			System.out.println("Error in the process of serializatión" + e);
		}
		return data;

	}

	public static <T> T deserialize(String json, Class<T> type) {
		T data = null;
		try {
			data = mapper.readValue(json, type);
		} catch (IOException e) {
			System.out.println("Error in the process of deserializatión" + e);
		}
		return data;
	}

	public static <T> List<T> jsonToList(String jsonData, Class<T> type) {
		JavaType javaType = mapper.getTypeFactory()
				.constructParametricType(List.class, type);
		try {
			List<T> list = mapper.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
