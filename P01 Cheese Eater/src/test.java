import java.util.Random;

public class test {
	
	public static void main(String[] args) {
		
	/*int[][] cheeseArray = new int [1][2];
	char[][] roomArray = new char [5][5];
	Random rand = new Random();
	
	for(int i = 0; i < roomArray.length; i++) {
	for(int k = 0; k < roomArray[0].length; k++) {
			roomArray[i][k] = '.';
		}
	}
	System.out.println(cheeseArray.length);
	Main.printRoom(roomArray, cheeseArray, 0, 0);
	System.out.println("Cheese X: " + cheeseArray[0][0]);
	System.out.println("Cheese Y: " + cheeseArray[0][1]);
	
	for(int i = 0; i < roomArray.length; i++) {
		for(int k = 0; k < roomArray[0].length; k++) {
			System.out.print(roomArray[i][k] = '.');
		}
		System.out.println();
	}*/
		
		Main.printRoom(Main.roomArray, Main.cheeseArray, Main.mouseArray[0], Main.mouseArray[1]);	
		
		
	} 
	}

	int xPos = 0;
	int yPos = 0;
	int counter = 0;
	boolean moveOn = false;
    while(counter < cheesePositions.length) {
    	xPos = randGen.nextInt(room[0].length-1);
    yPos = randGen.nextInt(room.length-1);
    	while(moveOn == false) {
      	if (room[yPos][xPos] != '.') {
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
    mouseArray[0] = randGen.nextInt(room[0].length-1);
    mouseArray[1] = randGen.nextInt(room.length-1);
      	while(room[mouseArray[1]][mouseArray[0]] != '.') {
      		mouseArray[0] = randGen.nextInt(room[0].length-1);
      		mouseArray[1] = randGen.nextInt(room.length-1);
      	}
      	room[mouseArray[1]][mouseArray[0]] = '@';
      	
      	
      	
      	
      	
      	
      	
      	int randRow;
     	int randCol;
    	    for(int i = 0; i < cheesePositions.length; i++) {
            randRow = randGen.nextInt(room.length-1);
            randCol = randGen.nextInt(room[0].length-1);
            if(room[randRow][randCol] != '#' && room[randRow][randCol] != '%') {
            	    room[randRow][randCol] = '%';
            	    cheesePositions[i][0] = randCol;
            	    cheesePositions[i][1] = randRow;
            }
            else {
            	    i--;
            }
        }