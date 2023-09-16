public class Square 
   {
      public static final int SPACE = 0;
      public static final int WALL = 1;
      public static final int START = 2;
      public static final int EXIT = 3;
      private int row;
      private int col;
      private int type;
      private char status = '_';
      public static final char WORKING = 'o';
      public static final char EXPLORED = '.';
      public static final char FINAL_PATH = 'x'; 
      
      
      public Square (int row, int col, int type)
         {
            this.col = col;
            this.row = row;
            this.type = type;
         }
         
       @Override
       public String toString()
         {
            switch (type)
               {
                  case WALL :
                     return "#";
                  case EXIT : 
                     return "E";
                  case START :
                     return "S";
                  default:
                     return status+"";
               }  
         }
         
         public boolean equals(Object obj)
            {
              return (((Square)obj).getRow() == this.getRow() && ((Square)obj).getCol() == this.getCol());
            }
            
            
         public int getRow()
            {
               return row;
            }
            
         public int getCol()
            {
               return col;   
            }
            
         public int getType()
            {
               return type;
            }
         
         public char getStatus()
            {
               return status;   
            }
            
         public void setStatus (char c)
            {
               status = c; 
            }
            
         public void reset()
            {
               this.setStatus('_');
            }         
   }
