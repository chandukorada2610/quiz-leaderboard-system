package com.srm.quiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    private static final String BASE_URL =
            "https://devapigw.vidalhealthtpa.com/srm-quiz-task/quiz/messages";

    public static ApiResponse getData(String regNo, int poll) {

        for (int attempt = 0; attempt < 5; attempt++) {
            try {
                String urlString = BASE_URL + "?regNo=" + regNo + "&poll=" + poll;

                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(5000);

                int status = conn.getResponseCode();

                if (status == 200) {

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream())
                    );

                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    reader.close();

                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(response.toString(), ApiResponse.class);
                }

                Thread.sleep(3000);

            } catch (Exception e) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {}
            }
        }

        return null;
    }

    public static void submit(String regNo, java.util.List<LeaderboardEntry> leaderboard) {
        try {
            URL url = new URL(
                    "https://devapigw.vidalhealthtpa.com/srm-quiz-task/quiz/submit"
            );

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(
                    java.util.Map.of("regNo", regNo, "leaderboard", leaderboard)
            );

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}