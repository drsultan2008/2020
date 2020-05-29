package com.duy.DAO;

import java.util.List;

import com.duy.entity.Board;
import com.duy.entity.User;

public interface ChessDAO {
	public void addBoard(Board board,User user);
	public void addUserName(User user);
	public List<Board> getBoards(User user);
	public User getUser(String userName);
}
