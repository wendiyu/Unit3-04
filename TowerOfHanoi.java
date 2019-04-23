/****************************************************************************
 *
 * Created by: Wendi Yu
 * Created on: April 20
 * Created for: ICS4U
 * Recursive Towers of Hanoi program in java
 ****************************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class TowerOfHanoi {
	public static void main(String[] args) {
		
		// main stub for Towers of Hanoi program
		Scanner input = new Scanner(System.in);
		
		int disks;
		
		String poleA = "Pole A";
		String poleB = "Pole B";
		String poleC = "Pole C";
		
		// introduction text
		System.out.print("Move all the disks over to Pole B:\n");
		//user input
		System.out.print("Enter a positive integer for the number of disks: ");
		
		if(input.hasNextInt()) {
			
			disks = input.nextInt();
			
			if(disks < 0){
				System.out.println("\nError");
			}
			else {
				double min = minMoves(disks);
				System.out.println("\nMinimum number of moves: " + min);
				moves(disks, poleA, poleB, poleC);
			}
		}
		else {
			System.out.println("\nError");
		}
	}
	
	public static void moves(int num, String startPole, String endPole, String auxPole) {
		// returns instructions on how to solve Towers of Hanoi problem with user input of disks in the minimum moves
		
		if(num == 1) {
			displayMoves(num, startPole, endPole);
		}
		else {
			moves(num - 1, startPole, auxPole, endPole);
			displayMoves(num, startPole, endPole);
			moves(num - 1, auxPole, endPole, startPole);
		}
	}
	
	public static void displayMoves (int num, String startPole, String endPole) {
		// method for printing out moves
		System.out.println("Move disk " + num + " from " + startPole + " to " + endPole + ".");
	}
	
	public static double minMoves(int num) {
		//method for finding number of minimum number of moves according to number user inputs
		double moves = Math.pow(2, num) - 1;
		return moves;
	}
}
