package com.erudia.demo.connector;

public class IndexMannager {
	public int windowPort;
	public int baseport;
	
	public IndexMannager(int baseport,int wp){
		windowPort=wp;
		this.baseport=baseport;
	}
	int index=0;
	int getIndex(){
		int aux=index;
		index++;
		if(index==windowPort)index=0;
		return aux+baseport;
	}
	
}
