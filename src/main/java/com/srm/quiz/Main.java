package com.srm.quiz;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        String regNo = "2024CS101";

        LeaderboardService service = new LeaderboardService();

        Thread.sleep(3000);

        for (int i = 0; i < 10; i++) {

            System.out.println("Polling " + i);

            ApiResponse response = ApiService.getData(regNo, i);

            service.process(response);

            Thread.sleep(5000);
        }

        List<LeaderboardEntry> leaderboard = service.getLeaderboard();

        System.out.println("\nLeaderboard:");
        for (LeaderboardEntry e : leaderboard) {
            System.out.println(e.participant + " -> " + e.totalScore);
        }

        System.out.println("\nTotal Score: " + service.getTotalScore());
    }
}