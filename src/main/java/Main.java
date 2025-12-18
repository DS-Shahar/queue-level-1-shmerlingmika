import java.util.*;
public class Main {	
	
	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
	    
		Queue<Integer> q = new Queue<Integer>();
		q.insert(4);
		q.insert(2);
		q.insert(2);
		q.insert(3);
		Queue<Integer> q2 = new Queue<Integer>();
		q2.insert(4);
		q2.insert(9);
		//System.out.println(ex(q,10));
		//System.out.println(ex1(q));
		//System.out.println(ex2(q));
		//System.out.println(ex3(q,8));
		//System.out.println(ex4(q,q2));
		System.out.println(ex5(q,2));
	}
	
	/////////////////////////////////////////////
	
	public static boolean ex(Queue<Integer> q,int num) {
	     while (!q.isEmpty())
	     {
	         if (q.remove() == num)
	            return true;
	     }
	     return false;
	}
	
	public static Queue<Integer> ex1(Queue<Integer> q) 
	//בהנחה ש - n שווה לאורך q הסיבוכיות היא O(n)
	{
	    Queue<Integer> h = new Queue<Integer>();
	    Queue<Integer> p = new Queue<Integer>();
	     while (!q.isEmpty())
	     {
	         p.insert(q.head());
	         h.insert(q.remove());
	     }
	     while (!p.isEmpty())
	     {
	         q.insert(p.remove());
	     }
	     return h;
	}
	
	public static double ex2(Queue<Integer> q)
	//בהנחה ש - n שווה לאורך q הסיבוכיות היא O(n)
	{
	    Queue<Integer> h = ex1(q);
	    int sum = 0;
	    int num = 0;
	     while (!h.isEmpty())
	     {
	         sum+=h.remove();
	         num++;
	     }
	     return (double)sum/num;
	}
	
	public static int ex3(Queue<Integer> h,int num) 
	//בהנחה ש - n שווה לאורך q הסיבוכיות היא O(n)
	{
	    int x = 0;
	    Queue<Integer> q = ex1(h);
	    while (!q.isEmpty())
	    {
	         if (num % q.remove() == 0)
	            x++;
	    }
	    return x;
	}
	
	public static boolean ex4(Queue<Integer> h,Queue<Integer> p) 
	//בהנחה ש - n שווה לאורך q ו - m שווה לאורך h הסיבוכיות היא O(n*m)
	{
	    Queue<Integer> q = ex1(h);
	    Queue<Integer> q2 = ex1(p);
	    boolean bool;
	    while (!q.isEmpty())
	    {
	        bool = false;
	        q2 = ex1(p);
	        while (!q2.isEmpty() && !bool)
	        {
	            if (q2.remove() % q.head() == 0){
	                bool = true;
	            }
	        }
	        q.remove();
	        if (!bool){
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean ex5(Queue<Integer> h,int num) 
	//בהנחה ש - n שווה לאורך q הסיבוכיות היא O(n)
	{
	    boolean bool = false;
	    Queue<Integer> q = ex1(h);
	    while (!q.isEmpty())
	    {
	        if (bool)
	        {
	            if (num == q.remove())
	                return true;
	            bool=false;
	        }
	        else
	        {
	            if (num == q.remove())
	                bool=true;
	        }
	    }
	    return false;
	}
	
}
