package application;


public class AI {
	Data data;
	
	AI(Data data){
		this.data=data;
	}
	
	String[][] findBestMove(String board[][], int h) {
		String[][] boardCpy = new String[7][5];
		String[][] bestMove = new String[7][5];
		
		int max = -1000000;
		
		for(int i=0;i<7;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(board[i][j].charAt(0)==data.cpu)
                {
                    Cell moves[]=data.legalMove.allMove(i, j, board);
                    Cell move1 = new Cell(i,j);
                    for(int k=0;k<30;k++)
                    {
                        if(moves[k]==null)
                        {
                            break;
                        }
                        boardCpy = copyArr(board);
                        makeMove(boardCpy,move1,moves[k]);
                        int r=moves[k].getRow();
                        int c=moves[k].getCol();
//                        if(board[r][c].charAt(0)=='k')
//                        {
//                        	return boardCpy;
//                        }
                        int a = findBestMove2(boardCpy,-1000000,1000000,h+1);
                        if(max <= a)
                        {
                            max = a;
                            bestMove = copyArr(boardCpy);
                        }
                    }
                }
            }
        }
        return bestMove;
	}
	
   String [][] copyArr(String str[][])
    {
        String boardCpy[][] = new String[7][5];
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<5;j++)
            {
                boardCpy[i][j]=str[i][j];
            }
        }
        return boardCpy;
    }
   
   int findBestMove2(String board[][],int alpha,int beta,int h)
   {
       int min,max;
       min = 1000000;
       max = -1000000;
       int ans;
       String boardCpy[][] = new String[7][5];
       if(h == data.GAME_TREE_HEIGHT)
       {
           ans = evaluate(board);
           return ans;
       }
       for(int i=0;i<7;i++)
       {
           for(int j=0;j<5;j++)
           {
               char ch;
               if((h%2)==0)
               {
                   ch = data.cpu;
               }
               else
               {
                   ch = data.people;
               }
               if(board[i][j].charAt(0)==ch)
               {
                   Cell moves[]=data.legalMove.allMove(i, j, board);
                   Cell move1 = new Cell(i,j);
                   for(int k=0;k<30;k++)
                   {
                       if(beta<=alpha)
                       {
                           if((h%2)==0)
                           {
                               ans = max;
                           }
                           else
                           {
                               ans = min;
                           }
                           return ans;
                       }
                       if(moves[k]==null)
                       {
                           break;
                       }
                       int r=moves[k].getRow();
                       int c=moves[k].getCol();
                       
                       
//                       if(board[r][c].charAt(0)=='k')
//                       {
//                           if(ch == data.playerColor)
//                           {
//                               return (-1000000);
//                           }
//                           else
//                           {
//                               return (1000000);
//                           }
//                       }
                       
                       boardCpy = copyArr(board);
                       makeMove(boardCpy,move1,moves[k]);
                       int a = findBestMove2(boardCpy,alpha,beta,h+1);
                       if((h%2)==0)
                       {
                           if(max<a)
                           {
                               max = a;
                           }
                           if(alpha<a)
                           {
                               alpha=a;
                           }
                       }
                       else
                       {
                           if(min > a)
                           {
                               min = a;
                           }
                           if(beta>a)
                           {
                               beta = a;
                           }
                       }
                   }
               }
           }
       }
       if((h%2)==0)
       {
           ans = max;
       }
       else
       {
           ans = min;
       }
       return ans;
   }
   
   void makeMove(String board[][],Cell move1,Cell move2){

       String temp = board[move1.getRow()][move1.getCol()];
       
       board[move2.getRow()][move2.getCol()] = temp;
       board[move1.getRow()][move1.getCol()] = "###";
   }
   
   int evaluate(String board[][])
   {
       int ans=0;
       for(int i=0;i<7;i++)
       {
           for (int j=0;j<5;j++)
           {
               int a=0;
               if(board[i][j].equals("###"))
               {
                   a=0;
               }
               else if(board[i][j].equals("Tot"))
               {
                   a=20;
               }
               else if(board[i][j].equals("TTom"))
               {
                   a=80;
               }
               else if(board[i][j].equals("Hum"))
               {
                   a=100;
               }
               ans+=a;
           }
       }
       if(data.cpu == 'T')
       {
           ans=ans*(-1);
       }
       return ans;
   }
   
}
