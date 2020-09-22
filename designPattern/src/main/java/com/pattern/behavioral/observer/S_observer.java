package com.pattern.behavioral.observer;

public class S_observer extends Observer {

	@Override
	public void update(String msg) {
		// TODO �Զ����ɵķ������
		System.out.println(S_observer.class.getName()+":"+msg);

	}

}
