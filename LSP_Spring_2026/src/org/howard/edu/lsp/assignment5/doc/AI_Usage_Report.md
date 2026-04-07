## External Resources Used

### 1. ChatGPT (OpenAI)
URL: https://chat.openai.com/

**How it was used:**
ChatGpt Was used to check if code meet the assignment requirements

## ChatGPT Transcript
User: Does my IntegerSet.java Code(Copy/Pasted my IntegerSet.java) fit these requirements(Copy/pasted
the requirements for the code)

ChatGPT: Yes — your IntegerSet.java looks like it fits the requirements.
A few checks against the assignment:

Package structure
Your file starts with:

package org.howard.edu.lsp.assignment5;

That matches the required package.

Required methods
You have all of these:

clear()
length()
equals(IntegerSet b)
contains(int value)
largest()
smallest()
add(int item)
remove(int item)
union(IntegerSet intSetb)
intersect(IntegerSet intSetb)
diff(IntegerSet intSetb)
complement(IntegerSet intSetb)
isEmpty()
toString()

So method coverage is correct.

Set operation behavior
Your union, intersect, diff, and complement all create a new IntegerSet and do not modify the originals, which is exactly what the instructions want.

Examples from your code:

union gives elements from both sets
intersect gives common elements
diff gives elements in current set but not in b
complement gives elements in b but not in current set

Those match the required definitions.

equals
Your equals(IntegerSet b) works because it:

copies both sets
sorts both
compares them

That correctly makes [1,2,3] equal to [3,2,1].

toString()
Your toString():

uses @Override
sorts ascending
returns format like [1, 2, 3]
returns [] for empty set

That matches the strict formatting requirement.

add/remove

add() prevents duplicates, which is correct for a set
remove() correctly removes by value, not by index

So those are good too. 
The only small thing to notice is this:

public boolean equals(IntegerSet b)

This matches your assignment exactly, so it is fine.
Just know that this is not the same as overriding Java’s normal equals(Object o), but since your professor specifically asked for equals(IntegerSet b), you should keep it like that unless they say otherwise.

One tiny typo in your question: it should be IntegerSet.java, not IntegerSet.jave.

Overall: yes, your code matches the listed requirements.