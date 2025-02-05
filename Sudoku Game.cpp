//SUDOKU GAME using Arrays, Vectors, Reursion and Backtracking

#include<iostream>
#include<vector>
#define SIZE 9		//There exits 9 rows and 9columns in Sudoku
using namespace std;

 
//Function Prototypes
bool sudoku(int [SIZE][SIZE], int, int);		//solved sudoku Puzzle using recursion and backtracking
void next_emptyCell(int [SIZE][SIZE], int, int, int&, int&);	//Find the next empty cell
vector<int> find_allPlaceables(int [SIZE][SIZE], int, int);		//find all possible placeable values  for an empty cell
bool can_place(int [SIZE][SIZE], int, int, int);				//Check whether a value can be placed in a particular empty cell or not
void new_arr(int [SIZE][SIZE], int [SIZE][SIZE]);				//Create new Array
void display(int [SIZE][SIZE]);									//display Sudoku Game

  
//DRIVER CODE
int main() {
	//0 represents the empty cell in the Sudoku Board
	int sudoku_board[SIZE][SIZE]= {
		{ 3,  0,  6,  5,  0,  8,  4,  0,  0},
		{ 5,  2,  0,  0,  0,  0,  0,  0,  0},
		{ 0,  8,  7,  0,  0,  0,  0,  3,  1},
		{ 0,  0,  3,  0,  1,  0,  0,  8,  0},
		{ 9,  0,  0,  8,  6,  3,  0,  0,  0},
		{ 0,  5,  0,  0,  9,  0,  6,  0,  0},
		{ 1,  3,  0,  0,  0,  0,  2,  5,  0},
		{ 0,  0,  0,  0,  0,  0,  0,  7,  4},
		{ 0,  0,  5,  2,  0,  6,  3,  0,  0}
	};

	cout << "\t    SUDOKU PUZZLE\n";
	cout << "    0 represents an Empty Cell\n";
	display(sudoku_board);

	sudoku(sudoku_board, 0, 0);
	cout << "\n\n\t    SOLVED SUDOKU\n";
	display(sudoku_board);
}


//FUNCTIONS DEFINITIONS

bool sudoku(int arr[SIZE][SIZE], int row, int col) {
	//Return true when all rows are visited 
	if (row > 8)	//Base Case
		return true;

	//Skip the cell that already has some value
	if (arr[row][col] != 0) {
		int nxt_row, nxt_col;
		next_emptyCell(arr, row, col, nxt_row, nxt_col);
		return sudoku(arr, nxt_row, nxt_col);
	}

	//Find all the possible placeable values for an empty cell
	vector<int>placeables = find_allPlaceables(arr, row, col);
	if (placeables.size() == 0)		//If there is no_placeable here
		return false;

	bool status = false;

	//The below loop is used for back_tracking.
	//If no placeable is found for a particular cell, it moves back to the previous newly replaceable cell
	for (int i = 0; i < placeables.size(); i++) {
		int n = placeables[i];						//Backtacking
		int arrCpy[SIZE][SIZE];
		new_arr(arr, arrCpy);
		arrCpy[row][col] = n;

		int nxt_row, nxt_col;
		next_emptyCell(arrCpy, row, col, nxt_row, nxt_col);
		if (sudoku(arrCpy, nxt_row, nxt_col)) {		//Recursion
			new_arr(arrCpy, arr);
			status = true;
			break;
		}
	}
	return status;
}


bool can_place(int arr[SIZE][SIZE], int row, int col, int val) {
	if (arr[row][col] != 0)
		return false;

	int grid_x = col / 3 * 3;
	int grid_y = row / 3 * 3;
	bool status = true;
	for (int i = 0; i < 9; i++) {
		//Check val in the row
		if (arr[row][i] == val) {
			status = false;
			break;
		}
		//Check val in the column
		if (arr[i][col] == val) {
			status = false;
			break;
		}
		//Check val in the 3*3 Matrix
		if (arr[grid_y + i / 3][grid_x + i % 3] == val) {
			status = false;
			break;
		}
	}
	return status;
}


vector<int> find_allPlaceables(int arr[SIZE][SIZE], int row, int col) {
	vector<int> cps = {};
	for (int i = 1; i <= 9; i++) {
		if (can_place(arr, row, col, i))
			cps.push_back(i);
	}
	return cps;
}


void new_arr(int arr[SIZE][SIZE], int arrCpy[SIZE][SIZE]) {
	for (int y = 0; y < SIZE; y++) {
		for (int x = 0; x < SIZE; x++) {
			arrCpy[y][x] = arr[y][x];
		}
	}
}


void next_emptyCell(int arr[SIZE][SIZE], int row, int col, int& nxt_row, int& nxt_col) {
	int index = SIZE * SIZE;
	for (int i = row * SIZE + col + 1; i < index; i++) {
		if (arr[i / SIZE][i % SIZE] == 0) {
			index = i;
			break;
		}
	}
	nxt_row = index / SIZE;
	nxt_col = index % SIZE;
}


void display(int arr[SIZE][SIZE]) {
	cout << "-  -  -  -  -  -  -  -  -  -  -  -  -\n\n";
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			cout << " " << arr[i][j] << " ";
			if (j == 2 || j == 5)
				cout << "  -  ";
		}
		cout << endl << endl;
		if (i == 2 || i == 5 || i == 8)
			cout << "-  -  -  -  -  -  -  -  -  -  -  -  -\n\n";
	}
}
