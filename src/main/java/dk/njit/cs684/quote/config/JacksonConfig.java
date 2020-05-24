package dk.njit.cs684.quote.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new SimpleModule() {
                    @Override
                    public void setupModule(SetupContext context) {
                        super.setupModule(context);
                        context.addSerializers(new SimpleSerializers() {
                            {
                                addSerializer(new JsonSerializer<ObjectId>() {
                                    @Override
                                    public void serialize(ObjectId value,
                                                          JsonGenerator gen,
                                                          SerializerProvider serializers) throws IOException {
                                        gen.writeString(value.toHexString());
                                    }

                                    @Override
                                    public Class<ObjectId> handledType() {
                                        return ObjectId.class;
                                    }
                                });
                            }
                        });
                    }
                });
    }
}
