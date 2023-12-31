Problem Statement:
You are given n projects, each with a profit and a deadline by which it must be completed to earn that profit. You have m workers. Each worker can work on only one project at a time and will take exactly one day to complete any project. Design a program that determines the maximum total profit that can be earned given that all projects are completed by their deadlines. If a project is not completed by its deadline, no profit is earned for that project.

My solution: 
1. We sort the projects in descending order with regards to their profits.
2. We find the max deadline (e.g 0,1,3,4) that represent the max amount of days a customer/project is willing to wait.
3. We create a 2D array with rows the same number as workers and with columns the same number as the max deadline
4. We assign the projects into each array cell.
   For instance: a project inside row 0, column 0 is assigned to worker 1 day 1
                 a project inside row 1, column 0 is assigned to worker 2 day 1 and so on
   Since the projects are already sorted, once we assign a project in the first cell, we should not replace the project with any other project.
   If there exists more projects with the same number of deadlines than workers, we try to add the project to the previous day of the deadline day if applicable
   Important: a project with deadline 3 will be assigned to a worker's 3rd day;
   This optimizes the solution because it allows other more urgent projects to be done earlier.
5. Finally, we iterate through all nonempty cells of the table and sum up the projects' profits.
   By this time, we will have chosen the projects with the highest amount of profit only that will be assigned to the optimal days.
