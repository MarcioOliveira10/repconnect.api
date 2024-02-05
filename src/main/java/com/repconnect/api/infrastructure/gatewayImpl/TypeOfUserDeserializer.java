package com.repconnect.api.infrastructure.gatewayImpl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.repconnect.api.core.domain.TypeOfUser;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class TypeOfUserDeserializer extends JsonDeserializer<TypeOfUser> {


    @Override
    public TypeOfUser deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        if (node.isTextual()){
            String value = node.textValue();
            for (TypeOfUser type : TypeOfUser.values()){
                if (type.getValue().equalsIgnoreCase(value)){
                    return type;
                }
            }
        }
        System.out.println("Deserialization failed. Value: " + node.textValue());
        return null;
    }
}
