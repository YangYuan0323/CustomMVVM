package com.custommvvm.network;

import android.util.Log;
import com.custommvvm.bean.DogBreed;
import com.custommvvm.bean.Dogs;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonDogBreedsDeserializer implements JsonDeserializer<Dogs> {
    @Override
    public Dogs deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Dogs breeds = new Dogs();
        if (json.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
                if (entry.getKey().equals("status")) {
                    Log.d("Test", "Primitive: " + entry.getKey() + " = " + entry.getValue().getAsString());
                    breeds.setStatus(entry.getValue().getAsString());
                } else if (entry.getKey().equals("message")) {
                    Log.d("Test", "Object: key: " + entry.getKey() + " = " + entry.getValue());
                    JsonObject jsonObject = entry.getValue().getAsJsonObject();
                    for (Map.Entry<String, JsonElement> subEntry : jsonObject.entrySet()) {
                        Log.d("Test", "subEntry: " + subEntry);
                        DogBreed db = new DogBreed();
                        db.setBreed(subEntry.getKey());
//                        db.setImageUrl("https://images.dog.ceo/breeds/spaniel-blenheim/n02086646_1002.jpg");
                        breeds.addBreed(db);
                    }
                }
            }
        }
        return breeds;
    }
}
