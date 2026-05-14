[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23508306)
# AP Computer Science A – Final Project
## Software & Systems Development Capstone

# Transit Bot Capstone Project

**AP Computer Science A — Final Project**
**Author:** Julia Lockwood

---

## Project Description

Transit Bot is a Java-based command-line application designed to make San Diego's public transportation system more accessible and easier to navigate. The program guides users through identifying their current location and destination, determines which trolley line or lines they need to take, and handles the transfer logic when a route requires switching lines. Users can also purchase tickets directly through the program, with automatic discount pricing applied for students, seniors, and veterans. What makes this project unique is its focus on accessibility — it is designed with the goal of helping people who find existing transit technology confusing, including elderly riders and younger users who are unfamiliar with the system.

---

## Features

- **User profile setup** — Collects the user's name and discount eligibility (student, senior, veteran, or standard) at the start of each session.
- **Route lookup** — Searches a 2D array of San Diego trolley lines (Blue, Copper, Green, and Orange) to identify which line a stop belongs to.
- **Same-line detection** — Automatically recognizes when a starting stop and destination are on the same line and tells the user which line to take.
- **Transfer routing** — When stops are on different lines, identifies a shared transfer station and provides step-by-step directions.
- **Ticket purchasing** — Allows users to purchase one or more tickets per session with pricing calculated based on the number of tickets and user discount status.
- **Session summary** — Displays the total number of tickets purchased and the final price at the end of each session.

---

## Code Structure and Design

The program is organized into four classes, each with a distinct responsibility:

- **`TransitBot`** — The main entry point of the program. It manages the overall program flow, including the welcome sequence, the ticket purchasing loop, and the final price summary. It creates and coordinates instances of the other classes.
- **`Transit`** — Stores all trolley line and stop data in a 2D `String` array, where each row represents a line and each column represents a stop. It contains methods to search for stops, determine whether two stops share a line, and find transfer routes between lines.
- **`Ticket`** — Accepts the number of tickets purchased and a `User` object to calculate the total price. It applies a 50% discount if the user is eligible, using the `isDiscountEligible()` method from the `User` class.
- **`User`** — Stores the user's name and identity type as an integer (0 = standard, 1 = student, 2 = senior, 3 = veteran). Includes getter methods and a boolean method to determine discount eligibility.

Objects interact through constructor parameters and method calls — for example, `TransitBot` passes the `User` object into the `Ticket` constructor so pricing can be personalized. Data is stored primarily in a 2D `String` array inside `Transit`. This project does not use inheritance or interfaces, as the scope did not require it, but the class structure demonstrates clear separation of concerns and encapsulation.

![UML Class Diagram](<svg viewBox="0 0 900 620" xmlns="http://www.w3.org/2000/svg" font-family="monospace" font-size="13">

  <!-- Background -->
  <rect width="900" height="620" fill="#f8f9fa" rx="10"/>

  <!-- Title -->
  <text x="450" y="34" text-anchor="middle" font-size="16" font-weight="bold" fill="#1a1a2e">Transit Bot — UML Class Diagram</text>

  <!-- ===================== TransitBot (top center) ===================== -->
  <g id="transitbot">
    <!-- Header -->
    <rect x="310" y="55" width="280" height="36" fill="#1a1a2e" rx="4 4 0 0"/>
    <text x="450" y="78" text-anchor="middle" font-weight="bold" fill="white">TransitBot</text>
    <!-- Fields (none meaningful) -->
    <rect x="310" y="91" width="280" height="20" fill="#e8eaf6"/>
    <text x="320" y="105" fill="#555" font-style="italic" font-size="11">// no instance fields</text>
    <!-- Divider -->
    <line x1="310" y1="111" x2="590" y2="111" stroke="#aaa" stroke-width="1"/>
    <!-- Methods -->
    <rect x="310" y="111" width="280" height="72" fill="white" rx="0 0 4 4" stroke="#1a1a2e" stroke-width="1.5"/>
    <text x="320" y="127" fill="#1a1a2e">+ main(args: String[]): void</text>
    <text x="320" y="145" fill="#1a1a2e">+ setUpUser(scan: Scanner): User</text>
    <rect x="310" y="55" width="280" height="128" fill="none" stroke="#1a1a2e" stroke-width="1.5" rx="4"/>
  </g>

  <!-- ===================== User (bottom left) ===================== -->
  <g id="user">
    <rect x="40" y="350" width="230" height="36" fill="#1a1a2e" rx="4 4 0 0"/>
    <text x="155" y="373" text-anchor="middle" font-weight="bold" fill="white">User</text>
    <!-- Fields -->
    <rect x="40" y="386" width="230" height="52" fill="#e8eaf6"/>
    <text x="52" y="402" fill="#333">- name: String</text>
    <text x="52" y="420" fill="#333">- userType: int</text>
    <!-- Divider -->
    <line x1="40" y1="438" x2="270" y2="438" stroke="#aaa" stroke-width="1"/>
    <!-- Methods -->
    <rect x="40" y="438" width="230" height="90" fill="white" rx="0 0 4 4"/>
    <text x="52" y="456" fill="#1a1a2e">+ User(name, userType)</text>
    <text x="52" y="474" fill="#1a1a2e">+ User(name: String)</text>
    <text x="52" y="492" fill="#1a1a2e">+ getName(): String</text>
    <text x="52" y="510" fill="#1a1a2e">+ getUserType(): int</text>
    <text x="52" y="528" fill="#1a1a2e">+ isDiscountEligible(): boolean</text>
    <rect x="40" y="350" width="230" height="178" fill="none" stroke="#1a1a2e" stroke-width="1.5" rx="4"/>
  </g>

  <!-- ===================== Ticket (bottom center) ===================== -->
  <g id="ticket">
    <rect x="335" y="350" width="230" height="36" fill="#1a1a2e" rx="4 4 0 0"/>
    <text x="450" y="373" text-anchor="middle" font-weight="bold" fill="white">Ticket</text>
    <!-- Fields -->
    <rect x="335" y="386" width="230" height="86" fill="#e8eaf6"/>
    <text x="347" y="402" fill="#333">- basePrice: double = 2.5</text>
    <text x="347" y="420" fill="#333">- discount: double = 0.5</text>
    <text x="347" y="438" fill="#333">- price: double</text>
    <text x="347" y="456" fill="#333">- userType: User</text>
    <text x="347" y="474" fill="#333">- numTickets: int</text>
    <!-- Divider -->
    <line x1="335" y1="472" x2="565" y2="472" stroke="#aaa" stroke-width="1"/>
    <!-- Methods -->
    <rect x="335" y="472" width="230" height="56" fill="white" rx="0 0 4 4"/>
    <text x="347" y="490" fill="#1a1a2e">+ Ticket(numTickets, user)</text>
    <text x="347" y="508" fill="#1a1a2e">+ getPrice(): double</text>
    <rect x="335" y="350" width="230" height="178" fill="none" stroke="#1a1a2e" stroke-width="1.5" rx="4"/>
  </g>

  <!-- ===================== Transit (bottom right) ===================== -->
  <g id="transit">
    <rect x="630" y="350" width="240" height="36" fill="#1a1a2e" rx="4 4 0 0"/>
    <text x="750" y="373" text-anchor="middle" font-weight="bold" fill="white">Transit</text>
    <!-- Fields -->
    <rect x="630" y="386" width="240" height="20" fill="#e8eaf6"/>
    <text x="642" y="402" fill="#333">- lines: String[][]</text>
    <!-- Divider -->
    <line x1="630" y1="406" x2="870" y2="406" stroke="#aaa" stroke-width="1"/>
    <!-- Methods -->
    <rect x="630" y="406" width="240" height="122" fill="white" rx="0 0 4 4"/>
    <text x="642" y="424" fill="#1a1a2e">+ Transit()</text>
    <text x="642" y="442" fill="#1a1a2e">+ whereTo(scan: Scanner)</text>
    <text x="642" y="460" fill="#1a1a2e">+ findStopRow(stop): int</text>
    <text x="642" y="478" fill="#1a1a2e">+ findStopCol(stop): int</text>
    <text x="642" y="496" fill="#1a1a2e">+ sameLine(row, rowNew): boolean</text>
    <text x="642" y="514" fill="#1a1a2e">+ whichLine(row): String</text>
    <text x="642" y="532" fill="#1a1a2e">+ findRoute(start, end): void</text>
    <rect x="630" y="350" width="240" height="178" fill="none" stroke="#1a1a2e" stroke-width="1.5" rx="4"/>
  </g>

  <!-- ===================== Arrows ===================== -->

  <!-- TransitBot -> User: creates (dashed dependency) -->
  <!-- Down-left from TransitBot bottom-left to User top -->
  <line x1="380" y1="183" x2="200" y2="350" stroke="#555" stroke-width="1.5" stroke-dasharray="6,4"/>
  <polygon points="200,350 192,330 210,334" fill="#555"/>
  <!-- Label -->
  <text x="255" y="268" text-anchor="middle" fill="#555" font-size="11" font-style="italic">«creates»</text>

  <!-- TransitBot -> Ticket: creates (dashed dependency) -->
  <line x1="450" y1="183" x2="450" y2="350" stroke="#555" stroke-width="1.5" stroke-dasharray="6,4"/>
  <polygon points="450,350 443,330 457,330" fill="#555"/>
  <text x="490" y="272" fill="#555" font-size="11" font-style="italic">«creates»</text>

  <!-- TransitBot -> Transit: creates (dashed dependency) -->
  <line x1="520" y1="183" x2="715" y2="350" stroke="#555" stroke-width="1.5" stroke-dasharray="6,4"/>
  <polygon points="715,350 706,332 720,336" fill="#555"/>
  <text x="647" y="268" fill="#555" font-size="11" font-style="italic">«creates»</text>

  <!-- Ticket -> User: uses / association (solid) -->
  <line x1="335" y1="456" x2="270" y2="456" stroke="#1a1a2e" stroke-width="1.5"/>
  <polygon points="270,456 284,450 284,462" fill="#1a1a2e"/>
  <!-- Label -->
  <text x="302" y="445" text-anchor="middle" fill="#333" font-size="11" font-style="italic">«uses»</text>

  <!-- Legend -->
  <rect x="30" y="560" width="380" height="48" fill="white" stroke="#ccc" stroke-width="1" rx="4"/>
  <text x="45" y="578" font-size="11" fill="#333" font-weight="bold">Legend</text>
  <line x1="45" y1="592" x2="90" y2="592" stroke="#555" stroke-width="1.5" stroke-dasharray="6,4"/>
  <polygon points="90,592 82,588 82,596" fill="#555"/>
  <text x="96" y="596" font-size="11" fill="#555">Dependency (creates / calls)</text>
  <line x1="220" y1="592" x2="265" y2="592" stroke="#1a1a2e" stroke-width="1.5"/>
  <polygon points="265,592 257,588 257,596" fill="#1a1a2e"/>
  <text x="271" y="596" font-size="11" fill="#555">Association (uses object)</text>

</svg>
uml_diagram.svg)<img width="218" height="150" alt="uml_diagram (1)" src="https://github.com/user-attachments/assets/b51cc35d-422b-406a-abaf-074305c9c69c" />


---

## How to Run the Program

**Requirements:** Java Development Kit (JDK) installed on your machine.

1. Download or clone all `.java` source files into the same folder: `TransitBot.java`, `Transit.java`, `Ticket.java`, and `User.java`.
2. Open a terminal and navigate to the folder containing the files.
3. Compile all files with the following command:
   ```
   javac TransitBot.java Transit.java Ticket.java User.java
   ```
4. Run the program with:
   ```
   java TransitBot
   ```
5. Follow the on-screen prompts:
   - Enter your name.
   - Indicate whether you qualify for a discount, and if so, enter your type (`student`, `senior`, or `veteran`).
   - When asked if you want to buy a ticket, enter `y` to continue or `n` to skip.
   - If buying a ticket, enter your **current stop** and **destination stop** exactly as they appear on the trolley system (e.g., `Old Town`, `12th and Imperial`).
   - Repeat for additional tickets as needed.
6. The program will display your total ticket count and final price before exiting.

---

## Development Process

**Challenge:** The most significant challenge during development was connecting the four classes and understanding how to use methods and data from one class inside another.

**How it was solved:** Working through this problem helped clarify why constructors are essential — they allow objects to be initialized with the data they need to function. For example, the `Ticket` class originally had a `User` attribute that was never assigned, causing a crash. Solving this required passing the `User` object directly into the `Ticket` constructor, which also demonstrated how objects in Java can hold references to other objects.

**Future improvement:** With more time, the transfer routing logic would be expanded to support multiple line transfers, allowing the program to handle more complex trips that require switching lines more than once. The user interface would also be improved with cleaner formatting, better input validation, and more descriptive output to make the experience feel more polished.

---

## Use of AI Tools

Two AI tools were used during the development of this project: **Google Gemini** and **Anthropic Claude**.

- **Gemini** was used during the early planning phase for brainstorming the project structure and generating a starting pseudocode outline for the `findRoute` algorithm.
- **Claude** was used for help creating the UML class diagram, identifying bugs during debugging, and general code review.

All AI-generated suggestions and pseudocode were reviewed, tested, and adapted by the student. The final implementation was written independently, and all code in this project is understood by the author.

---

## Author

**Julia Lockwood**
AP Computer Science A

Through building this project, I learned how Java classes interact with each other in practice — specifically how to design objects that work together by passing data through constructors and method calls, and how to organize a multi-class program so that each class has a clear, focused responsibility.
