
public class Dado{
	private int nSides;
	private int last;

	public Dado(){
		this.nSides = 6;
		this.last = 0;
	}
	
	public Dado(int n){
		this.nSides = n;
		this.last = 0;
	}
	
	public int getLado(){
		return this.last;
	}

	public int rolar(){
		// this.last = (new Random().getIntRand(this.nSides) ) + 1;
		this.last = ((int)(Math.random() * this.nSides)) + 1;
		return this.last;
	}
	
	@Override
	public String toString(){
		String ret = "O dado tem mais de 6 lados";
		switch(this.last){
			case 1:
				ret = "+-----+\n|     |\n|  *  |\n|     |\n+-----+";
				break;
			case 2:
				ret = "+-----+\n|*    |\n|     |\n|    *|\n+-----+";
				break;
			case 3:
				ret = "+-----+\n|*    |\n|  *  |\n|    *|\n+-----+";
				break;
			case 4:
				ret = "+-----+\n|*   *|\n|     |\n|*   *|\n+-----+";
				break;
			case 5:
				ret = "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+";
				break;
			case 6:
				ret =  "+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+";
		}
		return ret;		
	}
	
}
