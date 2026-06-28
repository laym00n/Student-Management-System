# Student Management System

A simple Java console application for managing student records in memory.

## Features

- Add new students
- Remove students by ID
- Search students by ID
- Search students by name
- Display all students
- Validates student data and handles duplicate or missing records with custom exceptions

## Requirements

- Java 14 or later
- A terminal or IDE that can run a Java console app

## Project Structure

```text
src/
  Main.java
  model/Student.java
  service/StudentManager.java
  ui/UserInterface.java
  exceptions/
```

## Run the Project

From the project root:

```bash
javac -d out src/Main.java src/model/Student.java src/service/StudentManager.java src/ui/UserInterface.java src/exceptions/*.java
java -cp out Main
```

If you are using IntelliJ IDEA, open the project and run `Main`.

## Student Rules

The app expects:

- A non-empty student ID
- A non-empty name
- A valid email containing `@`
- Age between `18` and `33`
- Grade between `0.0` and `10.0`

## Notes

- Data is stored only in memory while the program is running.
- Exiting the program clears all student data.
