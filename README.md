## Logic

1. API Polling
   API is invoked 10 times with varying poll index values.
   A time delay is maintained between each request.
   Retry logic handles temporary failures.

2. Duplicate Elimination
   A unique key is formed using (roundId + participant).
   A HashSet is used to store unique entries.
   Duplicate records are ignored.

3. Score Accumulation
   A HashMap is used to maintain total scores for each participant.
   Scores are updated only for non-duplicate entries.

4. Leaderboard Creation
   Data is converted into a List.
   The list is sorted in descending order based on total score.

5. Total Score Computation
   The total score is calculated by summing all participant scores.

---

## Data Structures Used

* HashSet → used for duplicate elimination
* HashMap → used for storing total scores
* List → used for sorting leaderboard

---

## Result

* Leaderboard sorted based on total scores
* Total score computed across all participants
