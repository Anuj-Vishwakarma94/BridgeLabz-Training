# 💻 BridgeLabz-Training

## 🗓 Week 4 : Collections Framework in Java

## 📘 Section A : Training Learning Progress

### 🗓 Day 1 – Java Generics Fundamentals
**(Date: 16-Jan-2026)**
- Set up and revised the `java-collections-practice` branch structure.
```
BridgeLabz-Training/
│── java-collections-practice/
│ 	│── gcr-codebase/
|   |   └── CollectionsConcepts/
|   |       └── src/
|   |           └── com/
|   |               └── generics/
|   |               └── interfaces/
|   |
└── README.md
```
- Learned Java Generics for type-safe and reusable collection handling.
- Understood Type Parameters (`T`, `E`, `K`, `V`) and their role in APIs.
- Implemented Generic Classes and Generic Methods.
- Used Bounded Types (`extends`, `super`) to restrict and control types.
- Applied Wildcards (`?`, `? extends`, `? super`) for flexible collections.
- Followed Generics best practices (no raw types, safe bounds, readable design)
 
🔗 **Code Link:**      
👉 [Generics](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/java-collections-practice/java-collections-practice/gcr-codebase/JavaCollectionsConcepts/src/com/generics)

---

### 🗓 Day 2 – Interfaces
**Date: 17-Jan-2026**
- Studied Java Collections Framework architecture and hierarchy.
- Learned Collection vs Map interfaces.
- List
  - Implementations: ArrayList, LinkedList, Vector
  - Operations: add, remove, update, search
  - Iteration: for-each, Iterator, ListIterator
- Set
  - Implementations: HashSet, LinkedHashSet, TreeSet
  - Concepts: uniqueness, ordering, sorting
- Map
  - Implementations: HashMap, LinkedHashMap, TreeMap
  - Operations: insert, delete, retrieve
  - Iteration: entrySet(), keySet(), values()
- Queue
  - Implementations: PriorityQueue, ArrayDeque
  - Operations: enqueue, dequeue, peek, poll
- Concepts: FIFO & priority-based processing
- Understood internal working, use cases, and performance.
- Practiced real-time examples for List, Set, Queue, and Map.
- All work committed and pushed.

🔗 **Code Link:**       
👉 [Interfaces](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/java-collections-practice/java-collections-practice/gcr-codebase/JavaCollectionsConcepts/src/com/interfaces)

---

### 🗓 Day 3 – Streams
**Date: 19-Jan-2026**
- Practiced Java I/O Streams and file handling concepts.
- File Handling:
  - Read and write text files using FileInputStream and FileOutputStream.
  - Handled missing file scenarios with IOException.
- Buffered Streams:
  - Copied large files using BufferedInputStream and BufferedOutputStream.
  - Compared performance with unbuffered streams using System.nanoTime().
- Console Input:
  - Read user input using BufferedReader.
  - Stored input data into file using FileWriter.
- Serialization:
  - Serialized and deserialized Employee objects using Object streams.
- ByteArray Streams:
  - Converted image to byte array and recreated image file.
- Filter Streams:
  - Converted uppercase text to lowercase using BufferedReader and BufferedWriter.
- Data Streams: 
  - Stored and retrieved primitive data using DataInputStream and DataOutputStream.
- Piped Streams:
  - Implemented inter-thread communication using Piped streams.
- Large File Processing:
  - Read large files line by line and filtered error logs.
- Word Count:
  - Counted words and displayed top 5 frequent words using HashMap.
  - Understood use cases, performance, and real-world applications.
- All work committed and pushed.

🔗 **Code Link:**       
👉 [Streams](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/java-collections-practice/java-collections-practice/gcr-codebase/JavaCollectionsConcepts/src/com/streams)

---

## 🗓 Day 4 – Exception Handling  
**Date: 20-Jan-2026**

- **Checked Exception**
  - Handled `IOException` while reading a file.
- **Unchecked Exception**
  - Managed `ArithmeticException` and `InputMismatchException` during division.
- **Custom Exception**
  - Created and used `InvalidAgeException`.
- **Multiple Catch Blocks**
  - Handled `ArrayIndexOutOfBoundsException` and `NullPointerException`.
- **try-with-resources**
  - Used auto-closing resources with `BufferedReader`.
- **throw vs throws**
  - Validated input and propagated exceptions to caller.
- **finally Block**
  - Ensured execution of cleanup code.
- **Exception Propagation**
  - Observed exception flow across multiple methods.
- **Nested try-catch**
  - Managed array access and division errors.

🔗 **Code Link:**       
👉 [Exception Handling](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/java-collections-practice/java-collections-practice/gcr-codebase/JavaCollectionsConcepts/src/com/exceptionhandling)

---
