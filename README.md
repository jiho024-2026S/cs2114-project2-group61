# Group 61 Song Suggestion Queue
## System Diagram
[Song Suggestion Queue System Diagram](SystemDiagram.png)

## Compile, Run, & Test Instructions
[Instructions](Instructions.rtf)

## 1. What Is Left to Finish the MVP?

### MVP Requirements and Current Implementation

The following table summarizes the MVP requirements. At this moment, our group completed the entire MVP requirement but in slightly modified way. The following evidence shows how we undergone through the requirements.

| MVP Requirement | Evidence in Code | Status |
|---|---|---|
| Store a collection of songs | `Main.java` creates a `LinkedChain<Song>` named `songs` and adds 10 songs. | Implemented |
| Store at least one listener profile | `Main.java` creates a `LinkedChain<ListenerProfile>` named `profiles` and adds a listener profile. | Implemented |
| Allow favorite genres and artists | Menu options **5** and **6** call `addFavoriteArtist()` and `addFavoriteGenre()`. | Implemented |
| Compare preferences with stored songs | `RecommendationEngine.generateSuggestions()` checks `likesArtist()` or `likesGenre()`. | Implemented |
| Display matching song suggestions | Option **7** generates suggestions, and option **8** displays the next matching song. | Implemented |
| Add and remove songs | Option **1** adds songs using `songs.add(song)`, while option **2** removes songs using `songs.remove(song)`. | Implemented |

### Planned Flow

The recommendation process follows these steps:

1. Add or select a favorite artist or genre.
2. Generate song suggestions.
3. Compare the listener's preferences with every stored song.
4. Place matching songs into `SuggestionQueue`.
5. Display matching songs one at a time.

### Our Prototype

The program displays song suggestions **one at a time** through menu option **8**, rather than printing the entire suggestion list at once. All matching songs are stored in `SuggestionQueue` and displayed sequentially. We still need discussion on this, however, the design supports the intended recommendation workflow by allowing the listener to retrieve suggestions individually.

### Remaining Work

The core MVP features are implemented. The remaining work we might be focusing is are

1. **Validate input handling:** Confirm that invalid menu inputs and invalid song or preference values are handled correctly.
2. **Review requirements:** Compare the final implementation and test results against the project rubric to identify any missing requirements.

## 2. Which stretch goals will you attempt? The ones from your scope you are committing to, and the ones you are dropping.

### (1) What we attempted?
| Our Stretch Goals | How is it attempted |
|---|---|
| A formatted song-library output to display stored songs with their title, artist, and genre. | When the user requests to view the library, our program shows songs stored in the library. |

### (2) What we'll be focusing on the final product?
| Our Stretch Goals | How we'll focus on the final procduct? |
|---|---|
| A simple graphical user interface (GUI) that allows users to interact with the song collection, listener profiles, and recommendation features. | We might create HTML file and docker to create real-time working website. |

## (3) What new tests will you need? The methods and bad-input cases the added work must cover.
The most important new bad-input tests are blank or null song fields, blank favorite artists or genres, negative or nonnumeric years, invalid menu choices, null chain entries, invalid chain indexes, and null arguments passed to the recommendation engine.

## Attribution
[View Attribution Table (Excel)](Attribution.xlsx)

## Generative AI Usage

ChatGPT assisted in formatting this table, conceptualizing Big-O time complexity analysis, and reviewing the project against the rubric.

## Time Complexity Analysis

The following table compares the specified Big-O time complexities with the actual complexities of the provided `LinkedChain<T>` implementation.

| Method | Specification Big-O | Actual Big-O | Comparison | Explanation |
|---|---|---|---|---|
| `add(T)` | O(1) | O(1) | Matches | Inserts at the head of the list. |
| `addToEnd(T)` | O(1) (tail assumed) | O(n) | Different | Traverses to the end of the list because no tail reference is maintained. |
| `remove(T)` | O(n) | O(n) | Matches | Searches for the matching element. |
| `remove()` | O(1) | O(1) | Matches | Removes the first element. |
| `contains(T)` | O(n) | O(n) | Matches | Performs a linear search. |
| `count(T)` | O(n) | O(n) | Matches | Traverses the list to count matching elements. |
| `size()` | O(1) | O(1) | Matches | Returns the stored size field. |
| `isEmpty()` | O(1) | O(1) | Matches | Checks the size or head reference. |
| `get(index)` | Not specified | O(n) | Added comparison | Traverses the list to reach the specified index. |
| `toArray(T[])` | Not specified | O(n) | Added comparison | Copies all list elements into an array. |
| `clear()` | Not specified | O(1) | Added comparison | Resets the list references and stored state. |

### Summary

- **Matching complexities:** `add(T)`, `remove(T)`, `remove()`, `contains(T)`, `count(T)`, `size()`, and `isEmpty()`.
- **Different complexity:** `addToEnd(T)` takes O(n) instead of the specified O(1), because the implementation traverses the list without maintaining a tail reference.
- **Additional comparisons:** `get(index)`, `toArray(T[])`, and `clear()` have been analyzed even though their specification Big-O complexities were not provided.

**Note:** The actual complexities assume a conventional singly linked list implementation. `clear()` is O(1) when it resets the head and tail references and the size field without traversing the nodes.
