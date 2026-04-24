# Quiz Leaderboard System

## Overview

This project is developed as part of the Round 1 assignment for the placement process.
The objective is to consume data from a given API, handle duplicate responses, compute participant scores accurately, and generate a leaderboard.

The system simulates real-world scenarios where APIs may return repeated data across multiple calls, requiring proper deduplication and aggregation logic.

---

## Objective

* Poll the API 10 times
* Handle duplicate responses using (roundId + participant)
* Aggregate scores for each participant
* Generate a leaderboard sorted by total score
* Compute total score across all participants
* Ensure correct and reliable data processing

---

## Approach

### 1. API Polling

* The API is called 10 times using different poll indices
* A delay is maintained between requests as specified
* Retry logic is implemented to handle temporary server failures (HTTP 503)

### 2. Deduplication

* Each event is uniquely identified using (roundId + participant)
* A HashSet is used to ensure duplicate entries are ignored

### 3. Score Aggregation

* A HashMap is used to store cumulative scores for each participant

### 4. Leaderboard Generation

* Data is converted into a list and sorted in descending order of total score

---

## Tech Stack

* Java (JDK 21)
* Maven
* Jackson (for JSON parsing)
* HttpURLConnection (for API communication)

---

## Project Structure

```id="projstruct"
com.srm.quiz
├── Main.java
├── ApiService.java
├── LeaderboardService.java
├── Model.java
├── SubmitOnce.java
```

---

## Execution Steps

1. Clone the repository
2. Open the project in IntelliJ IDEA or any Java IDE
3. Update the register number in Main.java
4. Run Main.java to generate leaderboard
5. Run SubmitOnce.java once to submit the result

---

## Sample Output

```id="sampleout"
Leaderboard:
Bob -> 295
Alice -> 280
Charlie -> 260

Total Score: 835
```

---

## Key Concepts Used

* Object-Oriented Programming
* Data Structures (HashSet, HashMap, List)
* API Integration
* Error Handling and Retry Logic

---

## Conclusion

The system correctly processes API responses, eliminates duplicates, and generates an accurate leaderboard.
The implementation ensures reliability even when the API returns repeated or delayed responses.

---
