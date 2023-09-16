import java.util.*;
import java.util.Arrays;

public class MyStack implements StackADT
   {
      private Square[] stack;
      private int size;
      
      public MyStack()
         {
            this.size = 0;
            this.stack = new Square[5];
         }
      
      public MyStack(int initCap)
         {
            this.size = 0;
            this.stack = new Square[initCap];
         }
         
       public boolean isEmpty()
         {
            if (size == 0)
               {
                  return true;
               }
            return false;
         }
         
       public Square peek()
         {
            if (size == 0)
            {
               throw new EmptyStackException();
            }
            else
            {
             return stack[size-1];
            }
         }

       public Square pop()
       {
         Square a = peek();
         size -= 1;
         return a;
       }
       
       public void doubleCapacity()
       {
         Square[] d = new Square[stack.length * 2];
         for(int i = 0; i < stack.length; i++)
            {
               d[i] = stack[i];
            }
          stack = d;
       }
       
      public void push(Square item)
      {
         if(size == stack.length)
            {
               doubleCapacity();
            }
         stack[size] = item;
         size++;
      }
      
     @Override 
     public String toString()
         {
            String s = "";
            for(int i = 0; i < stack.length; i++)
               {
                  if(stack[i] != null)
                     {
                        if(i == 0)
                           {
                              s += "{" + stack[i];
                           }
                        else
                           {
                              s += ", " + stack[i];
                           }
                     }
               }
            s += "}";   
               
            return s;
         }
         
     public void clear()
         {
            while (!(this.isEmpty()))
               {
                  this.pop();
               }
         }
      
      public int size()
         {
            return this.size();
         }
   }