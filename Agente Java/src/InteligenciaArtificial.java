import java.util.Random;
import java.util.Scanner;

public class InteligenciaArtificial {

	public static void main(String[] args) throws InterruptedException {
		
		int tam = 4;
		int x = 0;
		int y = 0 ;
		
		String[][] labirinto = new String[tam][tam];	
		int[][] passeiPor = new int[tam][tam];
		
		Labirinto lab = new Labirinto();		
		
		Scanner op = new Scanner(System.in);
		
		lab.preencher_labirinto(tam, labirinto);
		
		while(true)
		{			
			System.out.println("Escolha as Posições");
			System.out.print("X: ");
			x = op.nextInt();
			if(x==-1)
			{				 
				//labirinto[random.nextInt(tam-1)][random.nextInt(tam-1)] = "*_*";
				lab.ExibirLab(tam, labirinto);
				break;
			}	
				
			System.out.print("Y: ");
			y = op.nextInt();
			
			labirinto[x][y] = "P";			
			
			lab.ExibirLab(tam, labirinto);
			
		}		
		
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
								
				if(labirinto[i][j].equals("P") && passeiPor[i][j] == 0)
				{
					if(j==tam-1) continue;
					i = i+1;
					j = j-1;
					if(labirinto[i][j].equals("X")) passeiPor[i][j] = 1;
					labirinto[i][j] = "*_*";					
					lab.ExibirLab(tam, labirinto);
					labirinto[i][j] = "O";
					Thread.sleep(1500);
					continue;
				}
				
				if(i>0 && labirinto[i-1][j].equals("X") && passeiPor[i-1][j] == 0)
				{
					i = i-1;
					passeiPor[i][j] = 1;					
					labirinto[i][j] = "*_*";
					lab.ExibirLab(tam, labirinto);					
					labirinto[i][j] = "O";
					Thread.sleep(1500);
					continue;
				}
					
				if(labirinto[i][j].equals("X")) passeiPor[i][j] = 1;
				labirinto[i][j] = "*_*";
				lab.ExibirLab(tam, labirinto);
				labirinto[i][j] = "O";
				Thread.sleep(1500);
			}
		}
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if(passeiPor[i][j] == 0 && labirinto[i][j].equals("X"))
				{
					labirinto[i][j] = "*_*";
					passeiPor[i][j] = 1;
					lab.ExibirLab(tam, labirinto);
					labirinto[i][j] = "O";
					Thread.sleep(1500);
				}
			}
		}
		
		System.out.println("FIM");
		lab.matriz_Lab(tam, passeiPor);
	}

}
