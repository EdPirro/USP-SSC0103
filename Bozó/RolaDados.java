
public class RolaDados {
	private int nDices;
	private Dado[] dices;
	private int[] last;

	public RolaDados(int n){
		this.nDices = n;
		this.dices = new Dado[n];
		for(int i = 0; i < n; i++)
			dices[i] = new Dado();
		this.last = new int[n];
	}


	public void printDiceOne(){
		System.out.println(dices[0].toString());
	}

	public int[] rolar(){
		int[] ret = new int[this.nDices];
		for(int i = 0; i < nDices ; i++)
			ret[i] = dices[i].rolar();
		this.last = ret;
		return ret;
	}
	
	public int[] rolar(boolean[] quais){
		int[] ret = new int[this.nDices];
		for(int i = 0; i < this.nDices; i++){
			if(quais[i]){
				ret[i] = dices[i].rolar();
				this.last[i] = ret[i];
			}
			else ret[i] = this.last[i];
		}
		
		return ret;
	}
	
	public int[] rolar(String quais){
		int[] ret;
		ret = this.last;
		String[] nums = quais.split(" ");
		for(int i = 0 ; i < nums.length; i++) {
			ret[Integer.parseInt(nums[i]) - 1] = dices[Integer.parseInt(nums[i]) - 1].rolar();
			this.last[Integer.parseInt(nums[i]) - 1] = ret[Integer.parseInt(nums[i]) - 1];
		}
		return ret;
	}


	@Override
	public String toString(){
		String ret = "";
		String[][] dicesPrint = new String[nDices][5];
		for(int i = 0; i < nDices; i++){
			dicesPrint[i] = dices[i].toString().split("\n");
		}
		for(int i = 0 ; i < nDices; i++) ret += i+1 + "          ";
		ret += "\n";
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < nDices; j++){
				ret += dicesPrint[j][i] + "    ";
			}
			ret += "\n";
		}
		return ret;
	}
	
	
}
