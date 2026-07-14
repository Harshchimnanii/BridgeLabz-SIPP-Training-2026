# Linked Lists Practice Questions

## Practice Questions

6 Scenario-Based Problems + 10 LeetCode Problems

Companion to: Linked Lists: Singly & Doubly — Learning Content
Recommended: Attempt each scenario yourself before reading the approach.

## How to Use This Document
Each scenario below is written as a real-world engineering situation rather than an abstract exercise — this mirrors how linked-list reasoning actually shows up on the job (playlists, undo histories, redirect chains, log streams, task queues).

Suggested workflow for each scenario:
- Read the context and task. Do not look at the hints yet.
- On paper, draw the list as boxes and arrows, and mark exactly which reference(s) change at each step.
- Attempt a Java solution yourself, paying close attention to the order in which you reassign pointers.
- Compare against the provided approach and complexity analysis.
- Only after finishing all 6 scenarios, move to the LeetCode practice set to reinforce the patterns on standard problem formats.

---

# Part A: Scenario-Based Questions (6)

## Scenario 1: Insertion — Adding a Track to a Playlist Queue

### Context
A music streaming app models a user's play queue as a singly linked list of tracks. The user wants to insert a newly chosen track immediately after the track that's currently playing, without disturbing the rest of the queue.

### Task
Given a reference to the node representing the currently playing track, insert a new track node immediately after it.

### Think about it first
- Which reference must you set on the new node first, before touching the currently-playing node's reference — and why does the order matter?
- What would happen to the rest of the queue if you updated the current node's next reference before saving where it used to point?
- Would your answer change if this were a doubly linked queue instead? What extra reference(s) would need updating?

### Approach
```java
void insertAfter(Node current, int trackId) {
    Node newNode = new Node(trackId);
    newNode.next = current.next; // capture the rest of the queue first
    current.next = newNode; // now link the current track to the new one
}
```

### Complexity
- Time: O(1)
- Space: O(1)

---

## Scenario 2: Deletion — Removing a Completed Task from a Task Queue

### Context
A background job processor keeps pending tasks in a singly linked list, in the order they should run. Once a task completes, it needs to be removed from the queue so processing continues with the next pending task.

### Task
Given the head of the task queue and the ID of a completed task, remove the node with that ID from the queue and return the (possibly updated) head.

### Think about it first
- Since this is a singly linked list, what extra reference do you need to keep as you search for the task to remove?
- What's different about removing the very first task in the queue compared to removing one further along?
- What happens to the removed node once nothing in the list points to it anymore?

### Approach
```java
Node removeTask(Node head, int taskId) {
    if (head == null) return null;
    if (head.val == taskId) return head.next; // removing the first task

    Node prev = head, curr = head.next;
    while (curr != null && curr.val != taskId) {
        prev = curr;
        curr = curr.next;
    }

    if (curr != null) {
        prev.next = curr.next;
    }
    return head;
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## Scenario 3: Reverse — Reversing a Browser Back-Button History Stack

### Context
A browser's page history is modeled as a singly linked list, most-recent page first. A new "replay history forward" feature needs the entire history reversed, so the oldest visited page becomes first and the most recently visited becomes last.

### Task
Given the head of the history list, reverse it in place and return the new head.

### Think about it first
- What three references do you need to track simultaneously to reverse the list without losing access to any part of it?
- In what order must you update those three references at each step?
- How would you know your loop is finished?

### Approach
```java
Node reverseHistory(Node head) {
    Node prev = null, curr = head;
    while (curr != null) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## Scenario 4: Find the Middle — Picking a Midpoint Server in a Relay Chain

### Context
A set of servers is chained together for a message relay system, modeled as a singly linked list (each server knows only the next server in the chain). For a maintenance operation, the ops team needs to identify the server sitting at the midpoint of the chain, without first counting the total number of servers.

### Task
Given the head of the server chain, return the middle server node in a single pass.

### Think about it first
- What are the two pointers you'll use, and how much faster does one move relative to the other?
- Why does this guarantee the slower pointer is at the midpoint once the faster one reaches the end?
- What should your loop's stopping condition check?

### Approach
```java
Node findMiddleServer(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## Scenario 5: Cycle Detection — Catching an Infinite Redirect Loop

### Context
A URL shortening service represents a chain of redirects as a singly linked list, where each node's next points to the URL it redirects to. A misconfiguration can accidentally create a redirect loop (URL A redirects to B, which eventually redirects back to A), which would cause a browser to hang. The team wants a way to detect this before it reaches a user.

### Task
Given the head of a redirect chain, determine whether it contains a cycle.

### Think about it first
- What pointer setup lets you detect a cycle without using any extra memory (like a HashSet of visited URLs)?
- How do you know, in code, that the two pointers have "met" inside a cycle?
- Why must this comparison use reference equality rather than comparing the URLs' string values?

### Approach
```java
boolean hasRedirectLoop(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## Scenario 6: Merge — Combining Two Sorted Log Streams

### Context
Two microservices each produce a stream of timestamped log entries, modeled as singly linked lists, and each stream is already sorted by timestamp internally. A monitoring dashboard needs a single, fully time-ordered feed combining both streams for display.

### Task
Given the heads of two sorted linked lists of log entries (sorted by timestamp), merge them into one sorted linked list, reusing the existing nodes.

### Think about it first
- What placeholder technique avoids needing special-case code for attaching the very first node of the merged result?
- At each step, how do you decide which of the two current nodes to attach next?
- What must you do once one of the two streams runs out of entries but the other still has some left?

### Approach
```java
Node mergeLogStreams(Node a, Node b) {
    Node dummy = new Node(0);
    Node tail = dummy;

    while (a != null && b != null) {
        if (a.val <= b.val) {
            tail.next = a;
            a = a.next;
        } else {
            tail.next = b;
            b = b.next;
        }
        tail = tail.next;
    }

    tail.next = (a != null) ? a : b;
    return dummy.next;
}
```

### Complexity
- Time: O(n + m)
- Space: O(1) extra space

---

# Part B: LeetCode Practice Set (10 Questions)

These are standard-format versions of the same patterns you just practiced above, in increasing order of difficulty. Solve them in the suggested order — each one reinforces a slightly different variation of the underlying pattern.

1. Reverse Linked List — Easy — Reverse — LeetCode 206
2. Middle of the Linked List — Easy — Find Middle — LeetCode 876
3. Linked List Cycle — Easy — Cycle Detection — LeetCode 141
4. Merge Two Sorted Lists — Easy — Merge — LeetCode 21
5. Remove Duplicates from Sorted List — Easy — Delete — LeetCode 83
6. Palindrome Linked List — Medium — Find Middle + Reverse — LeetCode 234
7. Linked List Cycle II — Medium — Cycle Detection (find start) — LeetCode 142
8. Remove Nth Node From End of List — Medium — Delete — LeetCode 19
9. Reverse Linked List II — Medium — Reverse (partial) — LeetCode 92
10. Design Linked List — Medium — Insert/Delete (Singly & Doubly) — LeetCode 707

## Solving Order & Why
- Start with #1–#5 — the cleanest, single-technique version of each core operation: reverse, find middle, cycle detection, merge, and predecessor-tracked deletion.
- Do #6 next — Palindrome Linked List combines two techniques you already have (find the middle, then reverse the second half) into one problem, which is a great checkpoint for whether you can compose patterns.
- Move to #7 — Linked List Cycle II asks not just whether a cycle exists, but where it starts, extending the Floyd's algorithm you already know with one more mathematical insight.
- Do #8 and #9 to see two more variations on deletion and reversal — removing from a specific position relative to the end, and reversing only a sub-portion of the list.
- Finish with #10 — Design Linked List asks you to implement get/insert/delete operations yourself, including a doubly linked list variant, which is the best single exercise for cementing the pointer-rewiring discipline from this whole module.

## Self-Evaluation Checklist
Before considering this topic complete, you should be able to check off all of the following without referring back to notes:
- I can explain, out loud, why the order of pointer reassignment matters during insertion and reversal.
- I can write the three-reference (prev/curr/next) reversal template from memory.
- I can write the fast/slow pointer template for both finding the middle and detecting a cycle, and explain the subtle loop-condition difference between them if any.
- I can explain why deletion is O(1) given a node reference in a doubly linked list, but O(n) by value in a singly linked list.
- I can write the dummy-node merge template from memory.
- I solved all 10 LeetCode questions above without looking at the editorial on the first attempt (or I revisited and fully understood any I couldn't solve).
- I can identify, within 30 seconds of reading a new problem statement, which of the six core patterns (insert, delete, reverse, find middle, cycle detection, merge) it belongs to — or whether it composes two of them.
