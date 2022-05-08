# Getting Started

### Building the application
1. Navigate to the root folder of the project
2. Run the command **mvn clean install** in order to download all dependencies and build the program

### Running the application
1. Navigate to the root folder of the project
2. Run  the command **mvn spring-boot:run -Dspring-boot.run.arguments="number"** where "number" must be a valid number (not accept decimals)

### Code maintenance
a. The parameter passed informs the total of printed numbers the user wants on the screen
b. There are several how-to comments in the code explaning how in increment the validators:
   First example: user wants to 'Visual Nuts' printed when number is divisible by 3, 5 and 8
   Second example: user also want to provide a new message when number is divisible by 2 and 4.
 *Check code comments and examples already provided in the code for further explanation*