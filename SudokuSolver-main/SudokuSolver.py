# -*- coding: utf-8 -*-
"""
Created on Mon Feb 13 11:30:39 2023

@author: aidan
"""
import numpy as np
    
def solvePuzzle(puzzle):
    #Solve suddoku puzzle using backtracking and recursion
    #Goal is to make multiple guesses until the correct solution is obtained
    
    #start by checking for next empty space to make a guess
    row, col = findNextSpace(puzzle)
    
    #if there's nowhere left, then the puzzle is solved since we only pass valid inputs
    if row is None:
        return True

    #next start guessing numbers that have already appeared the most
    #these numbers should have the least amount of potential spaces
    #this should cause you to backtrack sooner if a guess is wrong
    integerCounter = orderList(puzzle) 
    
    #if there is an open square, make a guess from most appearing digits to least
    for guess in range(9): #range 9 iterates over our sorted list
        if isValid(puzzle, integerCounter[guess], row, col): #check if the current guess could go in this square
            puzzle[row][col] = integerCounter[guess]
            
            if solvePuzzle(puzzle): #recursively call the puzzle function to see if this guess works
                return True
    
        puzzle[row][col] = 0 #reset puzzle if guess isn't valid or if guess does not solve puzzle
        
    return False # if no solutions found, then puzzle is unsolvable
    
def orderList(puzzle):
    integerCounter = [[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[0,7],[0,8],[0,9]] #initialize a list to store the count of each digit and its respective digit
    
    #each time a number appears, increase it's count
    for i in range(1,10):
        for r in range(9):
            for c in range(9):
                if puzzle[r][c] == i:
                    integerCounter[i-1][0] = integerCounter[i-1][0] + 1
                    
    
    #sort your list from highest count to lowest
    integerCounter.sort(key = lambda l:l[0], reverse=True)
    
    #return only the integer values, and omit the counts
    returnList = [integerCounter[i][1] for i in range(9)]
    
    return returnList


def findNextSpace(puzzle):
    #look for the next empty box that can be filled
    #start by looking at spaces that are the most restricted
    #return [none,none] if no available spaces
    Row = None
    Col = None
    Conflicts = -1
    
    #iterate over the puzzle to find the cell with the most conflicts
    for row in range(9):
        for col in range(9):
            if puzzle[row][col] == 0 and getConflicts(puzzle, row, col) > Conflicts:
                #check if this cell is more restricted than any other cell
                #if yes, mark this as the new most conflicted cell
                Row, Col = row, col
    return Row, Col

def isValid(puzzle, guess, row, col):
    
    # get each row and column the cell can see
    rowVals = puzzle[row]
    colVals = puzzle[:,col]
    
    #check if the guess made conflicts with any cells in that row or column
    if guess in rowVals or guess in colVals:
        return False
    
    #make the same check over the smaller boxes
    #start by identifying which box the cell is in
    rowStart = (row // 3) * 3
    colStart = (col // 3) * 3
    
    #iterate over the specific box to check for duplicates
    for r in range(rowStart, rowStart + 3):
        for c in range(colStart, colStart + 3):
            if puzzle[r][c] == guess:
                return False
    #if you've made it this far, then the guess works for now        
    return True
    
def getConflicts(puzzle, row, col):
    #track the number of unique digits a cell sees
    
    #use a similar method to the validation method
    rowVals = puzzle[row] #get the row for the cell being checked
    colVals = puzzle[:,col] #get the column for the cell being checked
    count = 0 #initialize counter
    countVals = [] #initialize a check list to identify unique digits
    
    #check each value in the row to see if there is a new digit
    for i in range(len(rowVals)):
        if rowVals[i] != 0 and rowVals[i] not in countVals:
            #if there is a new digit in that row, increase the counter and add that specific digit to the check list
            count += 1
            countVals.append(rowVals[i])
    
    #repeat for columns
    for i in range(len(colVals)):
        if rowVals[i] != 0 and colVals[i] not in countVals:
            count += 1
            countVals.append(colVals[i])
    
    #repeat for each grid
    rowStart = (row // 3) * 3
    colStart = (col // 3) * 3
    
    for r in range(rowStart, rowStart + 3):
        for c in range(colStart, colStart + 3):
            if puzzle[r][c] != 0 and puzzle[r][c] not in countVals:
                count += 1
                countVals.append(puzzle[r][c])
                
    return count 


#initialize board
sudoku = np.zeros((9,9),dtype=int) #create empty 9x9 grid of integers

#add given values to grid
sudoku[2,2] = 1
sudoku[2,4] = 2
sudoku[1,5] = 3
sudoku[1,7] = 8
sudoku[1,8] = 5
sudoku[5,1] = 9
sudoku[4,2] = 4
sudoku[3,3] = 5
sudoku[3,5] = 7
sudoku[4,6] = 1
sudoku[6,0] = 5
sudoku[7,2] = 2
sudoku[7,4] = 1
sudoku[8,4] = 4
sudoku[6,7] = 7
sudoku[6,8] = 3
sudoku[8,8] = 9

print(sudoku) #display initialized grid

#start a timer for total runtime
start = time.time()

print(solvePuzzle(sudoku)) #print if the solution is valid

#end timer for runtime
end = time.time()

print("Runtime:", time.strftime('%H:%M:%S', time.gmtime(end-start)))

print(sudoku) #print either the correct solution or reprint the starter

        
