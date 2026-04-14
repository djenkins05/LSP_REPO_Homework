## External Resources Used

### 1. ChatGPT (OpenAI)
URL: https://chat.openai.com/

**How it was used:**
ChatGpt Was used to help run JUnit Test

## ChatGPT Transcript
User: How do I run JUnit test, I keep getting errors(With a screenshot)
Chat: Good screenshot — I can see the exact issue now 👍

🔴 The real problem

Your JUnit imports are still red:

import static org.junit.jupiter.api.Assertions...
import org.junit.jupiter.api.Test;

👉 That means JUnit is NOT properly linked, even though it shows on the left.

✅ FIX THIS (this is the one that will work)
Step 1: Delete module-info.java (IMPORTANT)

Right now I still see it at the bottom.

Do this:

Right click module-info.java
Click Delete
Click OK
Step 2: Re-add JUnit the RIGHT way

Right click your project:

LSP_Spring_2026

Click:

Build Path → Configure Build Path
Go to the Libraries tab
If you see JUnit there:
Click it → Remove

Click:

Add Library → JUnit → Next

Choose:

JUnit 5
Click Finish
Step 3: Clean the project

At the top:

Project → Clean

→ select your project → OK

Step 4: Fix imports

Go back to IntegerSetTest.java and press:

Ctrl + Shift + O
✅ NOW check
No red lines under org.junit...
No red X on assignment6
✅ THEN RUN

Right click:

IntegerSetTest.java

Click:

Run As → JUnit Test
🎯 What should happen

At the bottom:

🟢 Green bar = DONE
🔴 Red bar = test failed (I can fix that next)
💥 Why this was happening

Your project had:

module-info.java (Java modules)
JUnit added as a normal library

Those conflict in Eclipse, so JUnit never properly connects.

🚀 Fastest solution

Deleting module-info.java + re-adding JUnit fixes this 99% of the time.

If it STILL doesn’t work after this, send me:

screenshot of Build Path → Libraries
or the Problems tab

I’ll lock it in for you 👍