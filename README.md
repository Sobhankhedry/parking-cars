# 🚗 Parking Cars

A small **Java algorithmic project** that solves a parking-related problem using an array-based representation of parking positions.

The project focuses on practicing **arrays, loops, greedy-style selection, range-based searching, and state modification** in Java.

---

## 📌 Overview

The parking area is represented using a character array.

Each position can represent either:

* `p` → a parked car
* `c` → an available parking position
* `R` → a car that has already been selected/assigned by the algorithm

For example:

```text
{'p', 'p', 'c', 'c', 'p', 'c'}
```

can be interpreted as:

```text
Position:  0   1   2   3   4   5
            │   │   │   │   │   │
            ▼   ▼   ▼   ▼   ▼   ▼
Parking:    P   P   C   C   P   C
```

The program attempts to determine how many available positions can be associated with nearby parked cars based on a given distance `k`.

---

# 🎯 Problem Idea

Given:

* A sequence of parking positions
* Parked cars
* Empty positions
* A distance/range `k`

the algorithm examines each available position and searches for a nearby parked car.

When a suitable parked car is found, it is marked as:

```text
p → R
```

and the counter of selected cars is increased.

The main objective is therefore to calculate the number of cars that can be selected according to the implemented distance constraint.

---

# 🧠 Representation

The input is represented using:

```java
char[] Parks = {'p', 'p', 'c', 'c', 'p', 'c'};
```

The second parameter determines the search range:

```java
int k = 2;
```

The main method then calls:

```java
int l = MaxPark(Parks, 2);
```

and prints the result.

---

# 🔄 Algorithm

The core logic is implemented in:

```java
private static int MaxPark(char[] parks, int k)
```

The algorithm maintains a counter:

```java
int ParkedCars = 0;
```

It then iterates over every position in the parking array.

### Step 1 — Iterate Through Parking Positions

```text
Start
  │
  ▼
Read current position
  │
  ▼
Is it already occupied/processed?
  │
 ┌┴──────────────┐
 │               │
Yes              No
 │               │
Skip              ▼
              Search Nearby
```

If the current position contains:

```text
p
```

or:

```text
R
```

the algorithm skips it.

This is implemented with:

```java
if (parks[i] == 'p' || parks[i] == 'R') {
    continue;
}
```

---

# 🔎 Searching for a Nearby Car

For an available position, the algorithm calculates a search range based on `k`.

The intended idea is:

```text
Current Position = i

Search approximately:

[i - k, i + k)
```

For example, if:

```text
i = 4
k = 2
```

the algorithm attempts to inspect nearby positions around index `4`.

Conceptually:

```text
        k           k
<---------------|--------------->
                i
```

This allows the algorithm to find a parked car close to the current available position.

---

# 🚗 Selecting a Car

During the search, the algorithm checks:

```java
if (parks[j] == 'p')
```

If a parked car is found:

```java
parks[j] = 'R';
ParkedCars++;
break;
```

The car is changed from:

```text
p
```

to:

```text
R
```

This prevents the same car from being selected again during later iterations.

The counter is then incremented.

---

# 🔄 Complete Flow

The algorithm can be represented as:

```text
                 Parking Array
                       │
                       ▼
              Examine each position
                       │
                       ▼
             Is position 'p' or 'R'?
                  /          \
                Yes           No
                 │             │
                 ▼             ▼
               Skip      Search nearby
                              │
                              ▼
                     Is there a 'p'?
                         /       \
                       No         Yes
                       │           │
                       ▼           ▼
                     Next       Mark as 'R'
                                │
                                ▼
                           Increment count
                                │
                                ▼
                              Next
```

At the end:

```java
return ParkedCars;
```

returns the number of selected cars.

---

# 🧩 Example

Initial state:

```text
Index:   0   1   2   3   4   5
         │   │   │   │   │   │
         ▼   ▼   ▼   ▼   ▼   ▼
         p   p   c   c   p   c
```

With:

```text
k = 2
```

the algorithm examines the empty positions:

```text
c
```

and searches their surrounding range for an available:

```text
p
```

When it finds one, it changes it to:

```text
R
```

For example:

```text
Before:

p   p   c   c   p   c

After selecting a car:

p   R   c   c   p   c
```

The important point is that `R` represents a car that has already been consumed/assigned by the algorithm.

---

# 💻 Implementation

The complete core algorithm is contained in `Main.java`.

The relevant structure is:

```java
public class Main {

    public static void main(String[] args) {

        char[] Parks = {'p', 'p', 'c', 'c', 'p', 'c'};

        int l = MaxPark(Parks, 2);

        System.out.println(l);
    }

    private static int MaxPark(char[] parks, int k) {

        int ParkedCars = 0;

        // Process parking positions...

        return ParkedCars;
    }
}
```

The repository intentionally keeps the implementation small and focused on the algorithm itself.

---

# 🛠️ Technology Stack

| Technology                 | Usage                                   |
| -------------------------- | --------------------------------------- |
| **Java**                   | Programming language                    |
| **Character Array**        | Parking-area representation             |
| **Loops**                  | Traversing positions                    |
| **Conditional Statements** | Detecting parking states                |
| **Math.min**               | Calculating part of the search boundary |
| **Methods**                | Encapsulating the parking algorithm     |

---

# 📚 Concepts Demonstrated

This project is primarily an exercise in fundamental algorithmic programming.

### Java

* Primitive arrays
* `char`
* `int`
* `for` loops
* `if` statements
* `continue`
* `break`
* Static methods
* Console output

### Algorithms

* Array traversal
* Local/range-based searching
* Greedy-style selection
* State modification
* Counting selected elements

### Problem Solving

The project demonstrates how a real-world-style problem can be reduced to:

```text
Data Representation
        ↓
Search Space
        ↓
Selection Rule
        ↓
State Update
        ↓
Result
```

---

# ⏱️ Complexity

Let:

```text
n = number of parking positions
k = search distance
```

The outer loop examines all `n` positions.

For each available position, the algorithm may inspect approximately `2k` nearby positions.

Therefore, the approximate time complexity of the implemented approach is:

```text
O(n × k)
```

When `k` is considered bounded by a small constant, this behaves approximately as:

```text
O(n)
```

The algorithm operates directly on the input array, so its auxiliary space usage is approximately:

```text
O(1)
```

apart from the input array itself.

---

# ⚠️ Implementation Notes

The current implementation is a small educational exercise and has boundary-handling issues that should be addressed before treating it as a robust general-purpose solution.

## Search Start Boundary

The current code contains:

```java
int s = Math.min(0, i - k);
```

If the intention is to prevent the lower index from becoming negative, the usual boundary calculation would be:

```java
int s = Math.max(0, i - k);
```

because the lower boundary should not be smaller than `0`.

---

## Search End Boundary

The loop currently uses:

```java
for (int j = s; j < i + k; j++)
```

without explicitly limiting the upper boundary to:

```text
parks.length
```

A safer implementation would ensure:

```java
j < parks.length
```

as part of the boundary condition.

This is important because an index larger than the array's last position would result in an `ArrayIndexOutOfBoundsException`.

---

# 🔧 Possible Improved Version

A safer version of the range handling could follow this pattern:

```java
int start = Math.max(0, i - k);
int end = Math.min(parks.length, i + k);

for (int j = start; j < end; j++) {

    if (parks[j] == 'p') {
        parks[j] = 'R';
        ParkedCars++;
        break;
    }
}
```

This preserves the basic idea of the original algorithm while preventing the search from going outside the array boundaries.

---

# 🏗️ Project Structure

The repository has a very small structure:

```text
parking-cars/
│
├── src/
│   └── Main.java
│
├── .idea/
│
├── ParkingCars.iml
│
└── README.md
```

The algorithm itself is implemented entirely inside:

```text
src/Main.java
```

The repository currently contains **5 commits**.

---

# 🚀 Getting Started

## Prerequisites

You need:

* Java JDK
* IntelliJ IDEA or another Java IDE

---

## Clone the Repository

```bash
git clone https://github.com/Sobhankhedry/parking-cars.git
```

Navigate into the project:

```bash
cd parking-cars
```

Open the project in IntelliJ IDEA.

Run:

```text
src/Main.java
```

The result is printed directly to the console.

---

# 🧪 Possible Test Cases

The algorithm can be extended and tested with different parking configurations.

### Case 1 — Multiple Cars

```text
p p c c p c
```

### Case 2 — No Available Positions

```text
p p p p
```

### Case 3 — No Parked Cars

```text
c c c c
```

### Case 4 — Different Search Distance

```text
k = 1
k = 2
k = 3
```

### Case 5 — Boundary Positions

Special attention should be given to empty positions near:

```text
index 0
```

and:

```text
index n - 1
```

because these positions have fewer neighbors.

---

# 🔮 Future Improvements

Possible improvements for this project include:

* [ ] Fix array-boundary handling
* [ ] Use `Math.max` for the lower search boundary
* [ ] Limit the upper search boundary to `parks.length`
* [ ] Add user input
* [ ] Allow dynamic parking-array sizes
* [ ] Introduce a `ParkingLot` class
* [ ] Separate the algorithm from the application entry point
* [ ] Add automated test cases
* [ ] Test edge cases
* [ ] Document the exact problem constraints
* [ ] Add a clearer visualization of parking positions

---

# 🎯 Learning Objectives

The main purpose of this project is to practice:

* Working with arrays
* Traversing arrays
* Searching within a local range
* Applying conditional selection rules
* Modifying array state
* Counting selected elements
* Handling algorithmic boundary conditions
* Translating a problem statement into executable logic

---

# 📌 Project Status

**Status:** Educational / Algorithmic Project

This repository contains a compact Java implementation for experimenting with a parking-related array problem and range-based selection.

The project is intentionally simple and focuses on **algorithmic thinking and fundamental Java programming concepts** rather than application architecture.

---

# 👨‍💻 Author

**Sobhan Khedry**

Computer Engineering Graduate Student
Backend Development Enthusiast

GitHub: [@Sobhankhedry](https://github.com/Sobhankhedry)

---

# ⭐ Summary

The project models a parking area using a character array:

```text
p → Parked Car
c → Empty Position
R → Already Selected Car
```

and applies a distance-based search around empty positions:

```text
Parking Array
      │
      ▼
Find Empty Position
      │
      ▼
Search Nearby
      │
      ▼
Find Parked Car
      │
      ▼
Mark Car as R
      │
      ▼
Increase Counter
      │
      ▼
Return Result
```

The main educational value of the project is practicing **array manipulation, local searching, greedy-style selection, state updates, and boundary handling in Java**.
