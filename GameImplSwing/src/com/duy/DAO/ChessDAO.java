package com.duy.DAO;

import com.duy.entity.Board;
import com.duy.entity.User;

public interface ChessDAO {
	public void addBoard(Board board);
	public void addUserName(User user);
}
