package de.qabel.core.drop;


import com.google.gson.*;

import java.lang.reflect.Type;

public class DropSerializer<T extends ModelObject> implements JsonSerializer<DropMessage<T>> {
    public JsonElement serialize (DropMessage<T> src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject obj = new JsonObject();
        Gson gson = new Gson();
        String model = src.getData().getClass().getName() + "";

        obj.addProperty("version",       src.getVersion());
        obj.addProperty("time",          src.getTime());
        obj.addProperty("sender",        src.getSender());
        obj.addProperty("acknowledgeID", src.getAcknowledgeID());
        obj.addProperty("model",         model);
        obj.addProperty("data",          gson.toJson(src.getData()));

        return obj;
    }
}