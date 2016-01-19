package kids.cute.spacethello.activities;

import java.util.*;
class GreedyAI{
          static  int a[][]=new int[8][8];
           static char str[]=new char[10];
            public static Pair white()
            {
                    int max1=0,x1,y1,i,j;
                     int x,x2=-1,y,y2=-1,max=0,c,co=0;
             //        System.out.print("hello");
                    for(i=0;i<8;i++)
                    {
                            for(j=0;j<8;j++)
                            {
                                    
                                    if(a[i][j]==0)
                                    {
                                         //   System.out.print("%d %d",i,j);
                                           c=0;
                                            x=i;y=j;
                                           while(x<8&&x>=1)
                                            {
                                                    if(a[x-1][y]==1)
                                                            c++;
                                                       
                                               else{
                                               x--;
                                                    break;
                                                   }
                                                   x--;
                                                  
                                            }
                                            if(max<c&&a[x][y]==2)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                    co=1;
                                             }
                                                    c=0;
                                                     x=i;y=j;
                                            while(x<7&&x>=0)
                                            {
                                                    if(a[x+1][y]==1)
                                                            c++;
                                                   
                                                   else{
                                                    x++;
                                                    break;
                                                    }
                                                    x++;
                                                    
                                            }
                                            if(max<c&&a[x][y]==2)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=2;
                                             }
                                                    c=0;
                                                 x=i;y=j;
                                            while(y<8&&y>=1)
                                            {
                                                    if(a[x][y-1]==1)
                                                            c++;
                                                
                                                else{
                                                y--;
                                                    break;
                                                    }
                                                    y--;
                                                    
                                            }
                                            if(max<c&&a[x][y]==2)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=3;
                                             }
                                                    c=0;
                                                x=i;y=j;
                                            while(y<7&&y>=0)
                                            {
                                                    if(a[x][y+1]==1)
                                                            c++;
                                                    
                                                    else{
                                                     y++;
                                                     break;
                                                    }
                                                    y++;
                                                     
                                            }
                                            if(max<c&&a[x][y]==2)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=4;
                                             }
                                                    c=0;
                                                  x=i;y=j;
                                            while(y<8&&y>=1&&x<8&&x>=1)
                                            {
                                                    if(a[x-1][y-1]==1)
                                                            c++;
                                                 
                                                  else{
                                                   y--;x--;
                                                    break;
                                                    }
                                                  y--;x--;   
                                                     
                                            }
                                            if(max<c&&a[x][y]==2)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=5;
                                             }
                                                    c=0;
                                                          x=i;y=j;
                                            while(y<7&&y>=0&&x<8&&x>=1)
                                            {
                                                    if(a[x-1][y+1]==1)
                                                            c++;
                                                     
                                                    else
                                                    {
                                                            y++;x--;       
                                                                    break;
                                                     }
                                                     y++;x--;
                                                    
                                            }
                                            if(max<c&&a[x][y]==2)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=6;
                                             }
                                                    c=0;
                                                                  x=i;y=j;
                                            while(y<8&&y>=1&&x<7&&x>=0)
                                            {
                                                    if(a[x+1][y-1]==1)
                                                            c++;
                                                   
                                                    else
                                                    {
                                                             x++;y--;
                                                     break;
                                                    }
                                                     x++;y--;
                                                     
                                            }
                                            if(max<c&&a[x][y]==2)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=7;
                                             }
                                                    c=0;
                                                                           x=i;y=j;
                                            while(y<7&&y>=0&&x<7&&x>=0)
                                            {
                                                    if(a[x+1][y+1]==1)
                                                            c++;
                                                    
                                                    else{
                                                            x++;y++;
                                                            break;
                                                    }
                                                    x++;y++;
                                                     
                                            }
                                            if(max<c&&a[x][y]==2)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=8;
                                             }
                                                 // System.out.print("%d %d %c %c\n",max,co,x2+65,y2+65); 
                                    }
                                   
                            }
                            
                    }
                    Pair obj=new Pair(x2+1,y2+1);
                    return obj;

            }
          public static Pair black()
            {
                    int max1=0,x1,y1,i,j;
                     int x,x2=-1,y,y2=-1,max=0,c,co=0;
             //        System.out.print("hello");
                    for(i=0;i<8;i++)
                    {
                            for(j=0;j<8;j++)
                            {
                                    
                                    if(a[i][j]==0)
                                    {
                                         //   System.out.print("%d %d",i,j);
                                           c=0;
                                            x=i;y=j;
                                           while(x<8&&x>=1)
                                            {
                                                    if(a[x-1][y]==2)
                                                            c++;
                                                       
                                               else{
                                               x--;
                                                    break;
                                                   }
                                                   x--;
                                                  
                                            }
                                            if(max<c&&a[x][y]==1)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                    co=1;
                                             }
                                                    c=0;
                                                     x=i;y=j;
                                            while(x<7&&x>=0)
                                            {
                                                    if(a[x+1][y]==2)
                                                            c++;
                                                   
                                                   else{
                                                    x++;
                                                    break;
                                                    }
                                                    x++;
                                                    
                                            }
                                            if(max<c&&a[x][y]==1)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=2;
                                             }
                                                    c=0;
                                                 x=i;y=j;
                                            while(y<8&&y>=1)
                                            {
                                                    if(a[x][y-1]==2)
                                                            c++;
                                                
                                                else{
                                                y--;
                                                    break;
                                                    }
                                                    y--;
                                                    
                                            }
                                            if(max<c&&a[x][y]==1)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=3;
                                             }
                                                    c=0;
                                                x=i;y=j;
                                            while(y<7&&y>=0)
                                            {
                                                    if(a[x][y+1]==2)
                                                            c++;
                                                    
                                                    else{
                                                     y++;
                                                     break;
                                                    }
                                                    y++;
                                                     
                                            }
                                            if(max<c&&a[x][y]==1)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=4;
                                             }
                                                    c=0;
                                                  x=i;y=j;
                                            while(y<8&&y>=1&&x<8&&x>=1)
                                            {
                                                    if(a[x-1][y-1]==2)
                                                            c++;
                                                 
                                                  else{
                                                   y--;x--;
                                                    break;
                                                    }
                                                  y--;x--;   
                                                     
                                            }
                                            if(max<c&&a[x][y]==1)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=5;
                                             }
                                                    c=0;
                                                          x=i;y=j;
                                            while(y<7&&y>=0&&x<8&&x>=1)
                                            {
                                                    if(a[x-1][y+1]==2)
                                                            c++;
                                                     
                                                    else
                                                    {
                                                            y++;x--;       
                                                                    break;
                                                     }
                                                     y++;x--;
                                                    
                                            }
                                            if(max<c&&a[x][y]==1)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=6;
                                             }
                                                    c=0;
                                                                  x=i;y=j;
                                            while(y<8&&y>=1&&x<7&&x>=0)
                                            {
                                                    if(a[x+1][y-1]==2)
                                                            c++;
                                                   
                                                    else
                                                    {
                                                             x++;y--;
                                                     break;
                                                    }
                                                     x++;y--;
                                                     
                                            }
                                            if(max<c&&a[x][y]==1)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=7;
                                             }
                                                    c=0;
                                                                           x=i;y=j;
                                            while(y<7&&y>=0&&x<7&&x>=0)
                                            {
                                                    if(a[x+1][y+1]==2)
                                                            c++;
                                                    
                                                    else{
                                                            x++;y++;
                                                            break;
                                                    }
                                                    x++;y++;
                                                     
                                            }
                                            if(max<c&&a[x][y]==1)
                                            {
                                                    max=c;
                                                    x2=i;
                                                    y2=j;
                                                     co=8;
                                             }
                                                  //System.out.print("%d %d %c %c\n",max,co,x2+65,y2+65); 
                                    }
                                   
                            }
                            
                    }
                Pair obj=new Pair(x2+1,y2+1);
                return obj;

            }
            public Pair getNextMove(int k,int [][] grid)
            {
                    final int SUN=1;
                    final int MOON=2;
                    int i,j;
                     for(i=0;i<8;i++)
                      {
                            for(j=0;j<8;j++)
                            {
                                a[i][j]=grid[i+1][j+1];
                                   // scanf("%d",&a[i][j]);
                            }
                      }
                     if(k==SUN)
                        return black();
                     else
                         return white();
           // return 0;
            }
}
