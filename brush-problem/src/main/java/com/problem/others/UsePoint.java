package com.problem.others;
class Point{
	int x,y;
}
class Carry{
	void fun(Point p){
		p.x+=p.y;
		p.y*=5;		
	}
}
public class UsePoint {
	public static void main(String args[]){
		Carry s=new Carry();
		Point p=new Point();
		p.x=3;
		p.y=5;
		s.fun(p);
		System.out.println("p.x="+p.x+",p.y="+p.y);
	}

}
