package com.duy.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

import com.duy.utils.Constants;

public class BoardGame extends Observable {
	private Node[][] map;
	
	public BoardGame(Node[][] map) {
		super();
		this.map = map;
	}

	public BoardGame() {
		map = new Node[Constants.SIZE][Constants.SIZE];
		
		for (int i=0; i<Constants.SIZE; i++) {
			for (int j=0; j<Constants.SIZE; j++) {
				map[i][j] = new Node(i,j,'.',false);
			}
		}
	}
	
	public void read(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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
			
			setChanged();
			notifyObservers();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found"+e);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	public void save(String fileName) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			String data = "";
			for (Node[] arr:map) {
				for (Node i:arr) {
					data+=Character.toString(i.getVal());
				}
			}
			bw.write(data);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	

	public void setMap(Node[][] map) {
		this.map = map;
		setChanged();
		notifyObservers();
	}

	public void setMap(int i, int j, Node node) {
		map[i][j] = node;
		setChanged();
		notifyObservers();
	}

	public Node get(int i, int j) {
		return map[i][j];
	}

	public Node[][] getMap() {
		return map;
	}
}
