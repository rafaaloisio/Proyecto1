package Proyecto1;

public class Edge {
	private int pre,suc;
	
	public Edge(int pre,int suc) {
		this.pre = pre;
		this.suc = suc;
	}
	
	public int getPre() {
		return pre;
	}
	
	public int getSuc() {
		return suc;
	}
	
	public void setPre(int pre) {
		this.pre = pre;
	}
	
	public void setSuc(int suc) {
		this.suc = suc;
	}
	
}
