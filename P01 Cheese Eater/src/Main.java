//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P01 Cheese Eater
// Files:           Main.java
// Course:          Comp Sci 300, Spring Semester 2018
//
// Author:          Hananh Beers
// Email:           hlbeers@wisc.edu
// Lecturer's Name: Professor Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    No partner
// 
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import java.util.Random;
import java.util.Scanner;
	
public class Main {
	public static int numOfCheeseEaten = 0;
	public static int[] mouseArray = new int [2];
	public static int count = 0;
	public static final int ROOM_WIDTH = 20;
    public static final int ROOM_HEIGHT = 10;
    public static final int NUM_OF_WALLS = 20;
    public static final int NUM_OF_CHEESE = 10;
	public static char[][] roomArray = new char [ROOM_HEIGHT][ROOM_WIDTH];
	public static int[][] cheeseArray = new int [NUM_OF_CHEESE][2];
    public static void main (String [] args) {
    	Scanner scan = new Scanner(System.in);
    	int numOfSteps = 0;
    	int count = 0;
    	char direction;
    	Random rand = new Random();
  	
  	// prints welcome message and room
    	System.out.println("Welcome to the Cheese Eater simulation.");
    	System.out.println("=======================================");
    	System.out.println("Enter the number of steps for this simulation to run: ");
    	System.out.println();
    	placeWalls(roomArray, NUM_OF_WALLS, rand); //places # and . walls
    	placeCheeses(cheeseArray, roomArray, rand); //places cheese and mouse
    	System.out.println("\nThe mouse has eaten " + numOfCheeseEaten + " cheese!");
    	printRoom(roomArray, cheeseArray, mouseArray[0], mouseArray[1]); //prints roomArray
    	numOfSteps = scan.nextInt();
    	
    	//repeats program for specified number of steps
    	while (count < numOfSteps) {
    	System.out.println("Enter the next step you'd like the mouse to take (WASD): ");
    	direction = scan.next().charAt(0);
    	moveMouse(mouseArray[0], mouseArray[1], roomArray, direction);
    	tryToEatCheese(mouseArray[0], mouseArray[1], cheeseArray); //updates numOfCheeseEaten
    System.out.println("\nThe mouse has eaten " + numOfCheeseEaten + " cheese!");
    	printRoom(roomArray, cheeseArray, mouseArray[0], mouseArray[1]);
    	count++;
    }
    	System.out.println("==================================================");
    	System.out.println("Thank you for running the Cheese Eater simulation.");
    }
    
    public static void placeWalls(char[][] room, int numberOfWalls, Random randGen) {
    	    int randX = 0;
    	    int randY = 0;
    	    int count1 = 0;
    	    for(int i = 0; i < room.length; i++) {
    	    	    for(int j = 0; j < room[i].length; j++) {
    	    	    	    	    room[i][j] = '.';
    	        } 
    	    } 
    	    while(count1 < numberOfWalls) {
    	    	   randX = randGen.nextInt(room.length-1);
    	    	   randY = randGen.nextInt(room[0].length-1);
    	    	   if(room[randX][randY] == '.') {
    	    	   room[randX][randY] = '#';
    	    	   numberOfWalls--;
    	    	   }
    	    }
    }
    
    public static void placeCheeses(int[][] cheesePositions, char[][] room, Random randGen) {
    	int xPos = 0;
    	int yPos = 0;
    	int counter = 0;
    	boolean moveOn = false;
    	if(cheesePositions.length > 1) {
        while(counter < cheesePositions.length) {
        	xPos = randGen.nextInt(room[0].length-1);
        yPos = randGen.nextInt(room.length-1);
        	while(moveOn == false) {
          	if (room[yPos][xPos] != '.' || yPos > room.length-1 || yPos < 0 || 
          			xPos > room[0].length-1 || xPos < 0) {
          		xPos = randGen.nextInt(room[0].length-1);
              	yPos = randGen.nextInt(room.length-1);
          	}
          	else {
          		moveOn = true;
          	}
        	}
          	cheeseArray[counter][0] = xPos;
          	cheeseArray[counter][1] = yPos;
          	roomArray[yPos][xPos] = '%';
          	counter++;
          	moveOn = false;
        }
    	}
        mouseArray[0] = randGen.nextInt(room[0].length-1);
        mouseArray[1] = randGen.nextInt(room.length-1);
          	while(room[mouseArray[1]][mouseArray[0]] != '.') {
          		mouseArray[0] = randGen.nextInt(room[0].length-1);
          		mouseArray[1] = randGen.nextInt(room.length-1);
          	}
          	room[mouseArray[1]][mouseArray[0]] = '@';
    }
    
    public static void printRoom(char[][] room, int[][] cheesePositions, int mouseX, int mouseY) {
    	
    	for(int i = 0; i < cheesePositions.length; i++) {
    		if(cheesePositions[i][1] != -1) {
        	room[cheesePositions[i][1]][cheesePositions[i][0]] = '%';
        	}
    	}
     	
    	room[mouseY][mouseX] = '@';
    	
      	for(int i = 0; i < room.length; i++) {
            for(int j = 0; j < room[i].length; j++) {
            	    System.out.print(room[i][j]);
            }
            System.out.print("\n");
        	}  
    	
    }
    
    public static int[] moveMouse(int mouseX, int mouseY, char[][] room, char move) {
    	if(move == 'w' || move == 'W') {   
    	    if(mouseY-1 < 0) {
     		System.out.println("WARNING: Mouse cannot move outside the room.");
     		return null;
     	}
    	    else if(room[mouseY-1][mouseX] == '#') {
    	     		System.out.println("WARNING: Mouse cannot move into wall.");
    	     		return null;
    	     	}
    	     	else {
    	    	    room[mouseY][mouseX] = '.';
    	    	    mouseY--;
    	    	    count++;
    	     	}
    	    }
    	    else if(move == 'a' || move == 'A') {
    	      	if(mouseX-1 < 0) {
    	     		System.out.println("WARNING: Mouse cannot move outside the room.");
    	     		return null;
    	     	}
    	      	else if(room[mouseY][mouseX-1] == '#') {
    	     		System.out.println("WARNING: Mouse cannot move into wall.");
    	     		return null;
    	     	}
    	      	else {
    	     	room[mouseY][mouseX] = '.';
         	mouseX--;
    	      	}
    	    }
    	    else  if(move == 's' || move == 'S') {
    	    	    if(mouseY+1 > room.length-1) {
    	     		System.out.println("WARNING: Mouse cannot move outside the room.");
    	     		return null;
    	     	}
    	    else if(room[mouseY+1][mouseX] == '#') {
    	     		System.out.println("WARNING: Mouse cannot move into wall.");
    	     		return null;
    	     	}
    	        else {
    	     	room[mouseY][mouseX] = '.';
        	    mouseY++;
    	        }
        }
    	    else if(move == 'd' || move == 'D') {
    	     	if(mouseX+1 > room[0].length-1) {
    	     		System.out.println("WARNING: Mouse cannot move outside the room.");
    	     		return null;
    	     	}
    	     	else if(room[mouseY][mouseX+1] == '#') {
    	     		System.out.println("WARNING: Mouse cannot move into wall.");
    	     		return null;
    	     	}
    	     	else {
    	     	room[mouseY][mouseX] = '.';
	        mouseX++;
    	     	}
        }
    	    else {
    	    	    System.out.println("WARNING: Didn't recognize move command: " + move + "\n");
    	    	    return null;
    	    }	
	    mouseArray[0] = mouseX;
     	mouseArray[1] = mouseY;
     	room[mouseY][mouseX] = '@';
     	return mouseArray;   
    }
    
    public static boolean tryToEatCheese(int mouseX, int mouseY, int[][] cheesePositions) {
    	boolean isCheese = false;
    	for(int i = 0; i < cheesePositions.length; i++) {
    		for(int j = 0; j < cheesePositions[i].length; j++) {
    	if(cheesePositions[i][0] == mouseX && cheesePositions[i][1] == mouseY) {
    		cheesePositions[i][0] = -1;
    		cheesePositions[i][1] = -1;
    		isCheese = true;
    		numOfCheeseEaten++;
    	}
    		}
    	}
    	    return isCheese;
    }



}
