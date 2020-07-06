package template;

public abstract class Game {
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	public final void play(){
		initialize();//初始化
		startPlay();//开始游戏
		endPlay();//结束游戏
	}

}
