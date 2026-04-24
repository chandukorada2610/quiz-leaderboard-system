package com.srm.quiz;

import java.util.ArrayList;
import java.util.List;

public class SubmitOnce {

    public static void main(String[] args) {

        String regNo = "2024CS101";

        List<LeaderboardEntry> leaderboard = new ArrayList<>();
        leaderboard.add(new LeaderboardEntry("Bob", 295));
        leaderboard.add(new LeaderboardEntry("Alice", 280));
        leaderboard.add(new LeaderboardEntry("Charlie", 260));

        ApiService.submit(regNo, leaderboard);
    }
}