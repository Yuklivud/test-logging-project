This project is a simulation of a hippodrome, featuring horse races. The main objectives are to add testing and logging functionality.

Testing Requirements:

Horse Class:

Constructor validation: Handle null or blank names and negative values for speed and distance, ensuring proper exception messages.
Method checks: Verify getName, getSpeed, getDistance, and move functionality, including mock validations.
Hippodrome Class:

Constructor validation: Handle null or empty horse lists, with appropriate exception messages.
Method checks: Validate getHorses, move, and getWinner methods, ensuring correct behavior with real and mock data.
Main Class:

Main method execution time: Ensure it runs within 22 seconds (use @Timeout annotation, then disable for normal testing).
