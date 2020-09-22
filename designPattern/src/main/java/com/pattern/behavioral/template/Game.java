package com.pattern.behavioral.template;

public abstract class Game {
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	public final void play(){
		initialize();//��ʼ��
		startPlay();//��ʼ��Ϸ
		endPlay();//������Ϸ
	}

}
