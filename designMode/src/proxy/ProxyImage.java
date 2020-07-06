package proxy;

public class ProxyImage implements Image {
	RealImage realImage;
	String fileName;
	
	public ProxyImage(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName=fileName;
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		if(realImage==null)
			realImage = new RealImage(fileName);
	
		realImage.display();
	}

}
