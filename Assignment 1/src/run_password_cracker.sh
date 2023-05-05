#!/bin/bash
#enter chmod +x runPasswordCracker.sh
javac PasswordCracker.java
if [ $? -eq 0 ]
then
  echo "Welcome to the Password Cracker"
  java PasswordCracker
else
  echo "Failed to load program"
fi
