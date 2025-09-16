package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GuiaDataReader {

    public static List<String> leerGuiasDesdeJson(String path) {
        List<String> guias = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File(path));
            for (JsonNode guia : root.get("guias")) {
                guias.add(guia.asText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return guias;
    }
}
