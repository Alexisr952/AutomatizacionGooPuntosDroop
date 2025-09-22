package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import utils.GuiaInfo;

public class GuiaDataReader {
    public static List<GuiaInfo> leerGuiasDesdePdf(Path pdfPath) throws IOException {
        String contenido = extraerTextoPdf(pdfPath);

        Pattern[] patrones = {
                Pattern.compile("GUIA:\\s*(\\d+\\.\\d+).*?UNIDAD\\s([\\d/]+)", Pattern.DOTALL),
                Pattern.compile("GUIA\\s*:\\s*(\\d+\\.\\d+).*?UNIDAD\\s*([\\d/]+)", Pattern.DOTALL),
                Pattern.compile("GUIA\\s*(\\d+\\.\\d+).*?UNIDAD\\s*([\\d/]+)", Pattern.DOTALL),
                Pattern.compile("(\\d+\\.\\d+).*?UNIDAD\\s*([\\d/]+)", Pattern.DOTALL),
                Pattern.compile("GUIA.*?(\\d+\\.\\d+).*?UNIDAD.*?([\\d/]+)", Pattern.DOTALL)
        };

        List<GuiaInfo> resultado = new ArrayList<>();

        for (Pattern patron : patrones) {
            Matcher matcher = patron.matcher(contenido);
            while (matcher.find()) {
                String guia = matcher.group(1); // ej: 123456789.1
                String unidad = matcher.group(2); // ej: 2/5

                String codigoRemision = guia.split("\\.")[0];
                String[] partesUnidad = unidad.split("/");
                String unidadNum = partesUnidad[0];
                String etiqueta1d = "7" + codigoRemision + String.format("%03d", Integer.parseInt(unidadNum));

                resultado.add(new GuiaInfo(codigoRemision, etiqueta1d));
            }
            if (!resultado.isEmpty())
                break;
        }

        return resultado;
    }

    private static String extraerTextoPdf(Path pdfPath) throws IOException {
        try (PDDocument doc = PDDocument.load(pdfPath.toFile())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(doc);
        }
    }
}
