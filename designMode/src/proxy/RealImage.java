package proxy;

public class RealImage implements Image {
	String fileName;
	
	public RealImage(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName=fileName;
		loadFromDisk(fileName);
	}
	public void loadFromDisk(String fileName){
		System.out.println("loading:"+fileName);
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Display:"+fileName);
	}

}
