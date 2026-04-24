package com.srm.quiz;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

class Event {
    public String roundId;
    public String participant;
    public int score;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ApiResponse {
    public List<Event> events;
}

class LeaderboardEntry {
    public String participant;
    public int totalScore;

    public LeaderboardEntry(String participant, int totalScore) {
        this.participant = participant;
        this.totalScore = totalScore;
    }
}