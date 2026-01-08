# Event Planner Mini

This project demonstrates practical use of data structures:
linked lists, stacks, queues, maps, trees, sorting, and searching.

## What You Must Do
- Implement all TODO methods
- Write JUnit 5 tests for core logic
- Pass instructor autograding tests
- Explain your design choices in this README

See Canvas assignment for full requirements.

README Requirements
Your README.md must explain:

Where and why you used each required data structure
Queue – upcoming tasks because you do it in a FIFO order
Stack – completed tasks (undo) because you do it in a LIFO order
Map<String, Queue<Guest>> for grouping guests
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