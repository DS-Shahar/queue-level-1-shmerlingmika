import java.util.*;
public class Main {	
	
	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
	    
		Queue<Integer> q = new Queue<Integer>();
		q.insert(8);
		q.insert(5);
		q.insert(16);
		q.insert(2);
		//System.out.println(ex(q,10));
		//System.out.println(ex1(q));
		//System.out.println(ex2(q));
		System.out.println(ex3(q,8));
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
	
	public static Queue<Integer> ex1(Queue<Integer> q) {
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
	
	public static double ex2(Queue<Integer> q) {
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
	
	
	
}
