#!/bin/bash
#enter chmod +x run_rock_paper_scissors.sh
javac RockPaperScissors.java
if [ $? -eq 0 ]
then
  echo "Welcome to Rock Paper Scissors"
  java RockPaperScissors
else
  echo "Failed to load program"
fi
