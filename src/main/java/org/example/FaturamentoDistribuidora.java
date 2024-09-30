package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FaturamentoDistribuidora {
    public static void main(String[] args) {
        try {
            // Lê o arquivo JSON com o faturamento diário
            String filePath = "src/main/resources/faturamento.json";  // Caminho do arquivo JSON
            String content = new String(Files.readAllBytes(Paths.get(filePath)));


            JSONArray faturamentoMensal = new JSONArray(content);

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;


            for (int i = 0; i < faturamentoMensal.length(); i++) {
                JSONObject dia = faturamentoMensal.getJSONObject(i);
                double faturamento = dia.getDouble("faturamento");


                if (faturamento > 0) {
                    if (faturamento < menorFaturamento) {
                        menorFaturamento = faturamento;
                    }
                    if (faturamento > maiorFaturamento) {
                        maiorFaturamento = faturamento;
                    }
                    somaFaturamento += faturamento;
                    diasComFaturamento++;
                }
            }


            double mediaFaturamento = somaFaturamento / diasComFaturamento;


            int diasAcimaDaMedia = 0;
            for (int i = 0; i < faturamentoMensal.length(); i++) {
                JSONObject dia = faturamentoMensal.getJSONObject(i);
                double faturamento = dia.getDouble("faturamento");

                if (faturamento > mediaFaturamento) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibe os resultados
            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento superior à média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
