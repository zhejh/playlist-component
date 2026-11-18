# Portfolio Project Directions

Welcome to the portfolio project directions. Historically, this assignment
was completed in parts. But due to the excessive grading load that the
assignment created, the portfolio project was converted to a single submission.
The individual steps were maintained in this repo for your reference, but the
assignment must be completed as outlined in this document. In other words,
**ignore** any submission instructions you see in the individual docs.

## Assignment Description

In this assignment, you are tasked with creating a software component from
scratch using OSU's discipline as follows:

- Create the kernel and enhanced interfaces as described in the
   [component interfaces docs](03-component-interfaces/03-component-interfaces.md)
- Create the secondary abstract class as described in the
   [component abstract class docs](04-component-abstract-class/04-component-abstract-class.md)
- Create one kernel implementation as described in the
   [component kernel implementation docs](05-component-kernel-implementation/05-component-kernel-implementation.md)

In addition, you must complete the following tasks:

- Write a systematic test suite for all methods in each interface as well as the
  common methods as described in the
  [finishing touches doc](06-component-finishing-touches/06-component-finishing-touches.md)
- Write two qualitatively different use cases for your component as described in the
  [finishing touches doc](06-component-finishing-touches/06-component-finishing-touches.md)

Finally, you may take your component above and beyond expectations by
completing the following tasks:

- Create a CI pipeline that automates your testing on GitHub
- Generate documentation for you component using JavaDoc
- Version your component using your preferred versioning style

## Assignment Rubric

The assignment is graded broadly on the following categories. See Carmen for
the official rubric:

- **Discipline** (30%): how well does the component follow the discipline?
- **Testing** (25%): how systematic are the test cases?
- **Best Practices** (20%): how well-written is the code?
- **Use Cases** (15%): how well do the use cases show off the component?
- **Reflection** (10%): how thoughtful is the writing?

## Assignment Instructions

To complete the assignment, you must do the following **in order**:

1. Review this entire document from top-to-bottom
   - Make sure you have read the rubric and know how you're being assessed
2. Use this repo as a template, as described in the main [README](../README.md)
3. Clone this repo to your machine
4. Create a new branch from `main` and complete all of your work on it
   - `main` must only contain the template files at the time of submission
   - The new branch may be called whatever you like, but `portfolio-project` is
     fine
5. Create your component on your new branch
   - Commit early and often
   - Use descriptive commit messages (e.g., "Add enhanced interfaces")
6. Test your component and include two use cases showing it off
7. Complete the reflection in the next section
8. Create a pull request from your branch to `main`
9. Submit a link of the pull request to Carmen

## Assignment Reflection

Following the completion of the portfolio project, please take some time to
fill out the following reflection prompts. There is no word count, but at least
a few sentences per question would be ideal.

> A common gripe that students express is how much they feel the work they do
> in class fails to map to the real world. Now that you've had a chance to
> complete the portfolio project, how much better (or worse) do you think you
> understand software development and why?

I understand software development better now. At the start, I struggled with figuring out which test cases I needed and understanding abstract classes. Working through the portfolio project helped me understand both through trial and error. Getting feedback on my first submission showed me that I still had a lot to learn and helped me improve the data model, documentation, and tests.

> Also, did the portfolio project surface any gaps in your own knowledge of
> software development. If so, what are those gaps and how did you address them?

Before starting, I felt like I had gaps even in the basics, especially writing test cases, understanding abstract classes and interfaces, and writing contracts. I worked on these by going through the code step by step, and fixing mistakes as I tested. Regarding testing, I learned that the number of tests alone does not tell me how well my code is tested. Choosing meaningful cases helped me organize my tests and understand what each one was checking.

> Finally, as a part of completing the portfolio project, to what extent has
> your perspective of software development changed, if at all? In other words,
> is software development something you still enjoy? If not, why not?

I would say I’m still in a gray area. I don’t necessarily like software development, but I don’t hate it either. Honestly, the more I learn, the more questions I have. This project helped me understand some concepts, but it also showed me how much I still don’t know. It can feel overwhelming because there is always new information to take in.

> One of the challenges of completing the portfolio project is picking up a lot
> of skills on your own. Some of these skills are, of course, software skills.
> However, there are plenty of other skills you may have picked up through
> this process. Therefore, the first question is what skills did you pick up
> through this process?

I developed my problem solving skills by figuring out what was wrong with my code and what the Checkstyle warnings meant. Fixing one issue only to have ten more appear definitely tested my patience. It helped me practice working through problems one at a time instead of trying to fix everything at once. Although we had been using GitHub Desktop with our project partners, managing my own repository helped me get more comfortable with commits and branches. I now have a better understanding of how to organize changes for future projects.

> The follow-up question is: could you rephrase these skills you picked up
> as bullet points that you could put on a resume? Try it below.

- Built a Java playlist component using interfaces, an abstract class, and a queue.
- Tested component behavior with JUnit, including empty playlists and song ordering.
- Debugged Java errors and resolved Checkstyle warnings to improve code quality.
- Used GitHub Desktop to manage project files.

> Next, how has working on this project affected your career trajectory?
> In other words, do you now hate the topic you picked? Or, are you even more
> interested in it? Both outcomes are valuable to your personal development.

I chose a playlist because it seemed like the simplest project to complete with my current academic schedule. I don’t have much time to spare, so my choice was more about managing my workload than exploring a career interest.But I plan to try more projects on my own when I have free time.

> Finally, consider the skills you've picked up and your current career
> trajectory. What are some things you could do to continue on your
> career trajectory? Also, who are some mentors you could contact to help
> you stay on your path?

I could keep building small projects when I have free time to practice testing, debugging, and organizing code. Trying different projects could also help me figure out what areas interest me. I could ask my professors, TAs, or more experienced students for feedback and advice on what to learn next.

## Assignment Advice

Broadly, this assignment may take anywhere from a few hours to over a full work
week (i.e., 40 hours) to complete depending on the complexity of your design.
Historically, the first part of this assignment was meant to help you scope down
your design, so it is still recommended to complete it even though it is not
graded. You may want to share your ideas with your instructor before you start
coding. In any case, it is your job to budget your time effectively.

With that said, it may not be a good idea to start early. Much of the
discipline will not be exposed to you until the end of week 3. Perhaps a good
starting time would be after your first midterm when you'll know if you need
an exam replacement.

In addition, you will have to learn some of the concepts (e.g., the common
methods) on your own, even though the course will cover them near the end of
the course. So, once you understand how to layer a component (i.e., after week
3), you can begin your work. Do not wait until the end of the course to start.

Also, you may submit the entire component **early** for a chance to get
feedback. There will be an early submission window, about a week before the
second midterm, where you can submit your completed component for an initial
grade. Any submissions after this point will not have a chance to resubmit.

Finally, if you have no idea where to start, consider checking out the
[part 1 docs](01-component-brainstorming/01-component-brainstorming.md).
There, you'll find a link to an article that includes project ideas. It is
recommended to follow the instructions in parts 1 through 6 anyway (even the
proof of concept for your own sanity), but you can continue to ignore the
individual submission instructions since you'll just be submitting everything at
once.

## Artificial Intelligence (AI) Policy

The purpose of this assignment is to help you develop your own skill and style
as a future software developer. You cannot do that if you shortcut your growth
by leveraging the available generative AI tools that exist today (e.g., ChatGPT,
Claude, Gemini, Codex, Copilot, etc.). In fact, even if you plan to entirely
write code in the future by burning tokens, you still need to fundamentally
understand software to step in when things go wrong. Therefore, use of these
tools on this assignment are strictly prohibited.

With that said, it is impossible to prevent you from using "AI" to develop
your component. Copilot is currently embedded in VS Code, and even disabling AI
integration in VS Code using the `chat.disableAIFeatures` is not enough. First,
it's very easy for you to flip the boolean to false or to delete the line
altogether, despite this being an obvious sign of ignoring this disclaimer in
your pull request. Second, there are probably hundreds of chat bot extensions
that bypass this setting. Third, there is really nothing stopping you from
using a third-party tool and dumping the resulting code here. Ultimately,
there is just no way to prove that you used AI.

However, in the same way that educators have no control over the usage of AI,
beyond coding with pen and paper, you have no control over the assessment
process. Therefore, it is in your best interest to do your own work because
only you can trust the work that you produce. If you do not develop the
expertise to do good work, you won't be able to evaluate the output of a chat
bot or agent. You will be putting your grade in the hands of an LLM. Use it at
your own risk.

With that said, since the type of student who will use "AI" on their component
is unlikely to even read this section, a series of prompts are provided in the
AGENTS.md file at the root of the repo. While the most desperate will
certainly find workarounds, hopefully it gives everyone else a good laugh.
