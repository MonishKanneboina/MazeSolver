import java.util.*;
import java.util.List;

public abstract class MazeSolver
   {
      private Maze maze;
      private boolean isSolved;
      
      public MazeSolver(Maze maze)
         {
           this.maze = maze;
           makeEmpty();
           add(maze.getStart()); 
         }
         
      public abstract void makeEmpty();
         
         
      public abstract boolean isEmpty();
        
      
      public abstract void add(Square s);
      
      
      public abstract Square next();
      
         
       public String getPath()
         {
            if(isSolved)
               {
                  return "solved";
               }
            else if(isSolved == false && isEmpty())
               {
                  return "unsolvable";
               }
            
            return "not yet solved";
         }
         
       public boolean isSolved()
         {
            return isSolved;
         }
         
       public void step()
         {
            if (isEmpty())
               {
                  System.out.println("not solvable");
               }
            else
               {  
                 Square s = next();
                 s.setStatus(Square.EXPLORED);
                 if (s.getType() == Square.EXIT)
                     {
                        isSolved = true;
                     }
                 else 
                     {
                        List<Square> neighbors = maze.getNeighbors(s);
                        for (int i = 0; i < neighbors.size(); i++)
                           {
                              if (neighbors.get(i).getType() != Square.WALL && neighbors.get(i).getStatus() != Square.EXPLORED && neighbors.get(i).getStatus() != Square.WORKING)
                                 {
                                    add(neighbors.get(i));
                                    neighbors.get(i).setStatus(Square.WORKING);
                                 }
                           }
                     }
               }
         }
         
         public void Solve()
            {
               while (isSolved == false)
                  {
                     step();
                  }
            }
   }