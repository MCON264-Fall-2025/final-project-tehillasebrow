
Where and why you used each required data structure
Dequeue – upcoming tasks because you do it in a FIFO order and you want to add to the front when you undo a task
Stack – completed tasks (undo) because you do it in a LIFO order
Map<String, Queue<Guest>> for grouping guests so you have a queue for each group organized within a map
Queue for seating guests fairly- because its a fifo order so whoever came first gets better seating
Binary Search Tree for ordered seating or table storage-it's a tree so you can find the next available table quickly
Linked List – master guest list because you can add and remove guests at any time
Map – fast lookup by name or ID because you can find a guest by name

Which sorting and searching algorithms you used
I used a merge sort for sorting the guest list and a binary search for searching the guest list.

Big-O complexity for:
Finding a guest o(1) because it's a map 
Selecting a venue o(log n)
Generating seating o(n)
I asked ai to format it nicely for me so the  bottom is it formatted...and the top is not formatted

# 🎉 Event Guest Management System

A Java-based system designed to efficiently manage guests, seating, and tasks using appropriate data structures and algorithms. Every design choice mirrors real-world event management needs such as fairness, speed, and flexibility.

---

## 🧠 Data Structures Used (and Why)

Each data structure was selected intentionally to match how the system behaves in practice.

### 🔁 Deque — Upcoming Tasks
Upcoming tasks are stored in a **Deque** because tasks are typically processed in **First-In, First-Out (FIFO)** order. However, when a task is undone, it can be added back to the **front** of the deque efficiently without disrupting the workflow.

### 📚 Stack — Completed Tasks (Undo Feature)
Completed tasks are stored in a **Stack** to support undo functionality. Since undo operations follow a **Last-In, First-Out (LIFO)** pattern, a stack is the most efficient and logical structure.

### 🗂️ Map<String, Queue<Guest>> — Guest Grouping
Guests are grouped using a **Map** where each key represents a group name and each value is a **Queue of Guests**. This allows guests to be organized by category while still preserving their arrival order within each group.

### 🚶 Queue — Fair Guest Seating
A **Queue** is used to seat guests fairly. Because queues operate on a **FIFO** basis, guests who arrive first are seated first, ensuring fairness and consistency.

### 🌳 Binary Search Tree — Seating & Table Management
Seating and table data are stored in a **Binary Search Tree**, which keeps tables ordered and allows the system to quickly locate the **next available table**.

### 🔗 Linked List — Master Guest List
The master guest list is implemented as a **Linked List** because guests can be added or removed at any time without costly shifts or resizing.

### ⚡ Map — Fast Guest Lookup
A **Map** is used for fast guest lookup by name or ID, providing **constant-time access** to guest information.

---

## 🔍 Algorithms Used

### 🧩 Merge Sort
The guest list is sorted using **Merge Sort** for reliable and efficient performance, even as the list grows.

### 🔎 Binary Search
Once the guest list is sorted, **Binary Search** is used to quickly locate a guest, significantly reducing search time.

---

## ⏱️ Big-O Time Complexity

| Operation           | Time Complexity | Explanation |
|---------------------|-----------------|-------------|
| Finding a Guest     | **O(1)**        | Map-based lookup |
| Selecting a Venue   | **O(log n)**    | Binary Search Tree traversal |
| Generating Seating  | **O(n)**        | Single pass through guests |

---

## 🚀 Why This Design Works

This system reflects real-world event management needs by prioritizing:
- Fair guest handling
- Fast and reliable lookups
- Easy undo functionality
- Efficient seating and venue selection

Each data structure and algorithm was chosen to maximize **clarity, efficiency, and scalability**.
