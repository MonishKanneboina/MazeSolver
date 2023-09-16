import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Maze
   {
      private Square[][] mazeGrid;
      private Square start;
      private Square end;
      
      public Maze()
         {
         }
      
      public boolean loadMaze(String fileName)
         {
            try
               {
                  Scanner file = new Scanner (new File(fileName));
                  mazeGrid = new Square[file.nextInt()][file.nextInt()];
                  while (file.hasNextInt())
                     {
                        for(int r = 0; r < mazeGrid.length; r++)
                           {
                              for(int c = 0; c < mazeGrid[r].length; c++)
                                 {
                                    int type = file.nextInt();
                                    Square s = new Square(r, c, type);
                                    mazeGrid[r][c] = s;
                                    if (type == Square.START)
                                       {
                                          start = mazeGrid[r][c];
                                       }
                                    if(type == Square.EXIT)
                                       {
                                          end = mazeGrid[r][c];
                                       }
                                 }
                           }
                     }  
               }
            catch(IOException e)
               {
                  System.out.println("Error");
                  return false;
               }
             return true;
         }
         
     public List<Square> getNeighbors(Square s)
         {
            ArrayList<Square> Squares = new ArrayList<>();
            int r = s.getRow();
            int c = s.getCol();
            
          
            if (r - 1 >= 0)
            {
              Squares.add(mazeGrid[r-1][c]);
            }
            if (c + 1 < mazeGrid[0].length)
            {
              Squares.add(mazeGrid[r][c+1]);
            }
            if (r + 1 < mazeGrid.length)
            {
              Squares.add(mazeGrid[r+1][c]);
            }
            if (c - 1 >= 0)
            {
              Squares.add(mazeGrid[r][c-1]);
            }  
         
      return Squares;     
   }
   
   public Square getStart()
      {
         return start;
      }
   
   public Square getExit()
      {
         return end;
      }
      
   public void reset()
      {
         for(int r = 0; r < mazeGrid.length; r++)
             {
                 for(int c = 0; c < mazeGrid[r].length; c++)
                 {
                     mazeGrid[r][c].reset();                
                 }
             }      
      }
   
   @Override
   public String toString()
     { 
         String gridString = "";
        
        for(int r = 0; r < mazeGrid.length; r++)
           {
              for(int c = 0; c < mazeGrid[r].length; c++)
                 {
                   gridString += " " + mazeGrid[r][c].toString();              
                 }
              gridString += "\n";
           }      
      return gridString;
     } 
}