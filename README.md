# CIT300 - University Student Record and Campus Route Management System

## Assignment
Graded Practical Assignment 1 - Week 10

## Course
CIT300 - Data Structures and Algorithms

## Group Members

| Name | Student ID | Responsibility | Individual Contribution |
|---|---|---|---|
| MFF Hansa | 23DA2-0480 | Linked List and Student Records | Implemented Student class, linked list, add/update/delete/display and validation |
| MSF Shahama | 23DA2-0899 | Stack and Queue | Implemented action stack and student service request queue |
| MM Mifla Banu | 23DA2-1111 | BST and Hashing | Implemented BST organization/search and hash table searching |
| A Hijas Ahamad | 23DA2-0720 | Graph | Implemented campus graph, adjacency list, location/road operations and BFS |

## Technologies
- Java
- Visual Studio Code
- Console Application

## Data Structures Used
1. Linked List - stores and manages student records.
2. Stack - stores recent system actions using LIFO.
3. Queue - manages student service requests using FIFO.
4. Binary Search Tree (BST) - organizes student records by Student ID.
5. Hash Table - supports efficient Student ID searching.
6. Graph - represents campus locations and connections using an adjacency list.
7. BFS - traverses the campus graph.

## Main Features
- Add student
- Update student
- Delete student
- Display students using linked list
- Add/process service requests
- Display recent actions
- Display students using BST
- Search student using hashing
- Add/remove campus locations
- Add/remove campus roads
- Display campus adjacency list
- BFS campus traversal
- Input validation and error handling

## Validation
The system handles:
- Duplicate student IDs
- Missing student records
- Empty input
- Marks outside 0-100
- Invalid numeric input
- Duplicate campus locations
- Missing campus locations
- Invalid/duplicate campus connections
- Missing campus connections
- Empty service queue
- Invalid menu choices

## How to Run in VS Code

1. Install Java JDK 17 or later.
2. Install Visual Studio Code.
3. Install the Extension Pack for Java.
4. Open this project folder in VS Code.
5. Open the `src` folder.
6. Run `Main.java`.
7. Use the menu to demonstrate all components.

## Graph Representation

The campus graph is represented using an adjacency list.

Example:

Main Gate -> Library, Cafeteria, Administration
Library -> Main Gate, IT Faculty
IT Faculty -> Library, Hostel

BFS is used to traverse the campus from a selected starting location.

## Testing

The system was tested with:
- Valid student records
- Duplicate student IDs
- Invalid marks
- Missing records
- Queue processing
- Stack action history
- BST display
- Hashing search
- Campus location management
- Road management
- BFS traversal
- Invalid input cases

## Collaboration

Group members should use GitHub branches, commits, and pull requests where applicable. Each member is responsible for being able to explain and demonstrate their contribution.
