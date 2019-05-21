import java.util.Random;

public class Labirinto {
	
	public void preencher_labirinto(int tam, String labirinto[][]) {
		Random random = new Random();
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				labirinto[i][j] = "O";
			}
		}
		for (int i = 0; i < tam*3; i++) {
			labirinto[random.nextInt(tam-1)][random.nextInt(tam-1)] = "X";
		}
	}
	
	public void ExibirLab(int tam, String labirinto[][])
	{
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if(labirinto[i][j].equals("*_*"))
				{
					System.out.print("|"+ labirinto[i][j] +"|");
				}
				else
				{
					System.out.print("| "+ labirinto[i][j] +" |");
				}
				
			}
			
			System.out.println("");
		}
		System.out.println("");

	}
	
	public void matriz_Lab(int tam,int passeiPor[][])
	{
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				System.out.print("| "+passeiPor[i][j]+" |");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	
}
