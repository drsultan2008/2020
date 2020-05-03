package com.duy.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.duy.utils.Constants;

public class Game {
	private Node[][] map;
	
	public Game(Node[][] map) {
		super();
		this.map = map;
	}

	public Game() {
		map = new Node[Constants.SIZE][Constants.SIZE];
	}
	
	public Node[][] getMap() {
		return map;
	}
	
	public void setMap(Node[][] map) {
		this.map = map;
	}
	
	public Node getNode(int i, int j) {
		return map[i][j];
	}
	
	public void read(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(Constants.path+fileName))) {
			String line = br.readLine();
			char[] arr = line.toCharArray();
			int iter = 0;

			for (int i=0; i<Constants.SIZE; i++) {
				for (int j=0; j<Constants.SIZE; j++) {
					Node node = null;
					int index = iter++;
					if (arr[index] == '.') {
						node = new Node(i,j,'.',false);
					}
					else {
						node = new Node(i,j,arr[index],true);
					}
					
					map[i][j] = node;
				}
			}
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found"+e);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	public void save(String fileName) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.path+fileName))){
			
		}
		catch()
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.read("case01.txt");
		
		Node[][] map = game.getMap();
		
		for (Node[] arr:map) {
			for (Node i:arr) {
				System.out.print(i.getVal());
			}
			System.out.println();
		}
		
	}
	
}
