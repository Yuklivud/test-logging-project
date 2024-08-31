This project is a simulation of a hippodrome, featuring horse races. The main objectives are to add testing and logging functionality.

Testing Requirements:

Horse Class:

Constructor validation: Handle null or blank names and negative values for speed and distance, ensuring proper exception messages.
Method checks: Verify getName, getSpeed, getDistance, and move functionality, including mock validations.
Hippodrome Class:

Constructor validation: Handle null or empty horse lists, with appropriate exception messages.
Method checks: Validate getHorses, move, and getWinner methods, ensuring correct behavior with real and mock data.

Main Class:

Main method execution time: Ensure it runs within 22 seconds.

### Logging Requirements

**1. Main Class:**
   - After creating a Hippodrome object, log the following message:
     ```
     2022-05-31 17:05:26,152 INFO Main: Race starts. Number of participants: 7
     ```
   - After displaying the winner's information, log the following message:
     ```
     2022-05-31 17:05:46,963 INFO Main: Race ends. Winner: Cherry
     ```

**2. Hippodrome Class:**
   - If `null` is passed to the constructor, log the following before throwing the exception:
     ```
     2022-05-31 17:29:30,029 ERROR Hippodrome: Horses list is null
     ```
   - If an empty list is passed to the constructor, log the following before throwing the exception:
     ```
     2022-05-31 17:30:41,074 ERROR Hippodrome: Horses list is empty
     ```
   - At the end of the constructor, log the following message:
     ```
     2022-05-31 17:05:26,152 DEBUG Hippodrome: Hippodrome created with horses [7]
     ```

**3. Horse Class:**
   - If `null` is passed as the name to the constructor, log the following before throwing the exception:
     ```
     2022-05-31 17:34:59,483 ERROR Horse: Name is null
     ```
   - If an empty or blank name is passed to the constructor, log the following before throwing the exception:
     ```
     2022-05-31 17:36:44,196 ERROR Horse: Name is blank
     ```
   - If a negative speed is passed to the constructor, log the following before throwing the exception:
     ```
     2022-05-31 17:40:27,267 ERROR Horse: Speed is negative
     ```
   - If a negative distance is passed to the constructor, log the following before throwing the exception:
     ```
     2022-05-31 17:41:21,938 ERROR Horse: Distance is negative
     ```
   - At the end of the constructor, log the following message:
     ```
     2022-05-31 17:15:25,842 DEBUG Horse: Horse created, name [Lobster], speed [2.8]
     ```

**Logging Configuration:**
- Logs should be recorded in the `hippodrome.log` file located in the `logs` directory at the root of the project.
- The log file should be rolled over daily with filenames following the pattern `hippodrome.YYYY-MM-DD.log`.
- A new `hippodrome.log` should be created each day.
- Files older than 7 days should be deleted.
- Use a RollingFileAppender to handle log file rotation and retention. 
