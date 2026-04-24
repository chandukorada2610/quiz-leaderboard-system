package com.srm.quiz;

import java.util.*;

public class LeaderboardService {

    private Set<String> seen = new HashSet<>();
    private Map<String, Integer> scores = new HashMap<>();

    public void process(ApiResponse response) {
        if (response == null || response.events == null) return;

        for (Event e : response.events) {
            String key = e.roundId + "_" + e.participant;

            if (!seen.contains(key)) {
                seen.add(key);
                scores.put(e.participant, scores.getOrDefault(e.participant, 0) + e.score);
            }
        }
    }

    public List<LeaderboardEntry> getLeaderboard() {
        List<LeaderboardEntry> list = new ArrayList<>();

        for (String p : scores.keySet()) {
            list.add(new LeaderboardEntry(p, scores.get(p)));
        }

        list.sort((a, b) -> b.totalScore - a.totalScore);

        return list;
    }

    public int getTotalScore() {
        return scores.values().stream().mapToInt(Integer::intValue).sum();
    }
}