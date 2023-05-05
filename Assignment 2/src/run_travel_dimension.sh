#!/bin/bash
#enter chmod +x run_travel_dimension.sh
javac TravelDimension.java
if [ $? -eq 0 ]
then
  echo "Welcome to the Dimension Traveler"
  java TravelDimension
else
  echo "Failed to load program"
fi
