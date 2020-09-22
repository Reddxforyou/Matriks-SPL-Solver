import java.util.Scanner;
import java.lang.Math; 

public class ADTMat{
	/* Tipe data matriks */
	public class MATRIKS{
		public double [][] Mem = new double[100][100]; 
		public int NBrsEff;
		public int NKolEff; 
	}

	public void MakeMATRIKS (int NB, int NK, MATRIKS M) { 
		// Reihan Andhika Putra , Checked
		/* Membentuk sebuah MATRIKS "kosong" yang siap diisi berukuran NB x NK di "ujung kiri" memori */
		/* I.S. NB dan NK adalah valid untuk memori matriks yang dibuat */
		/* F.S. Matriks M sesuai dengan definisi di atas terbentuk */
	   M.NBrsEff=NB;
	   M.NKolEff=NK;
   }

	public void BacaMATRIKS(MATRIKS M){
		// Reihan Andhika Putra , Checked
		/* I.S. IsIdxValid(NB,NK) */ 
		/* F.S. M terdefinisi nilai elemen efektifnya, berukuran NB x NK */
		/* Proses: Melakukan MakeMATRIKS(M,NB,NK) dan mengisi nilai efektifnya */
		/* Selanjutnya membaca nilai elemen per baris dan kolom */
		/* Contoh: Jika NB = 3 dan NK = 3, maka contoh cara membaca isi matriks :
		1 2 3
		4 5 6
		8 9 10 
		*/
		int i,j,n;
		Scanner input = new Scanner(System.in);
		System.out.print("Masukkan ordo matriks nxn : ");
		n = input.nextInt();

		for(i = 0; i < n; i++){
			for (j = 0; j < n; j++){
				M.Mem[i][j]= input.nextDouble();
			}
		}
		MakeMATRIKS(n,n,M);
	}
	
	public void TulisMATRIKS (MATRIKS M){
		// Reihan Andhika Putra , Checked
		/* I.S. M terdefinisi */
		/* F.S. Nilai M(i,j) ditulis ke layar per baris per kolom, masing-masing elemen per baris 
			dipisahkan sebuah spasi */
		/* Proses: Menulis nilai setiap elemen M ke layar dengan traversal per baris dan per kolom */
		/* Contoh: menulis matriks 3x3 (ingat di akhir tiap baris, tidak ada spasi)
		1 2 3
		4 5 6
		8 9 10
		*/
		int i,j ;
		for(i = 0; i <= M.NBrsEff-1; i++){
			for (j = 0; j <= M.NBrsEff-1; j++){
				if (j == (M.NBrsEff-1) && i == (M.NBrsEff-1)) {
					System.out.print(M.Mem[i][j]);
				} else if (j == (M.NBrsEff-1)){
					System.out.print(M.Mem[i][j]);
					System.out.println();
				} else {
					System.out.print(M.Mem[i][j]);
					System.out.print(" ");
				}
			}
		}
	}
	public void TestReihan(){
		MATRIKS M1= new MATRIKS();
		// MATRIKS M2 = new MATRIKS();
		System.out.println("Masukkan elemen M1");
		BacaMATRIKS(M1);
		TulisMATRIKS(M1);
		// System.out.println("Masukkan elemen M2");
		// BacaMATRIKS(M2);
		// TulisMATRIKS(M2);
		// MATRIKS M3 = new MATRIKS();
		// M3 = KaliMATRIKS(M1, M2);
		// System.out.println("Hasil kali M1 M2");
		// TulisMATRIKS(M3);
		System.out.println();
		double x = EkspansiKofaktor(M1);
		System.out.println(x);

	}

	public MATRIKS KaliMATRIKS (MATRIKS M1, MATRIKS M2){
		// Reihan Andhika Putra ,Checked
		/* Prekondisi : Ukuran kolom efektif M1 = ukuran baris efektif M2 */
		/* Mengirim hasil perkalian matriks: salinan M1 * M2 */
		int i,j,k;
		double el;
		MATRIKS M3 = new MATRIKS();
		MakeMATRIKS(M1.NBrsEff,M1.NKolEff,M3);
		for(i = 0; i <= M3.NBrsEff-1; i++){
			for (j = 0; j <= M3.NKolEff-1; j++){
				el = 0;
				for (k = 0 ; k <= M1.NKolEff; k++){
					el = el + M1.Mem[i][k]*M2.Mem[k][j];
				}
				M3.Mem[i][j] = el;
			}
		}
		return M3;
	}
	public void Transpose(MATRIKS M){
		// Reihan Andhika Putra
		/* I.S. M terdefinisi dan IsBujursangkar(M) */
		/* F.S. M "di-transpose", yaitu setiap elemen M(i,j) ditukar nilainya dengan elemen M(j,i) */
		MATRIKS M3 = new MATRIKS();
		int i,j;
		MakeMATRIKS(M.NBrsEff,M.NKolEff,M3);
		for (i = 0; i < M.NBrsEff; i++)
		{
			for (j = 0; j < M.NKolEff; j++)
			{
				M3.Mem[i][j] = M.Mem[j][i] ;
			}
		}
		M.Mem = M3.Mem;
	}

	public void TukarBaris(MATRIKS M, int B1, int B2) {
		// Reihan Andhika Putra
		// Reihan Andhika Putra
		/* I.S. M terdefinisi dan B1 , B2 dalam range, perhatikan bahwa indeks (0,x) adalah baris ke 1
		/* F.S. M di baris ke B1 ditukar dengan B2*/
		B1 = B1-1; 
		B2 = B2-1;
		int j ;
		double temp;
		for (j = 0; j < M.NKolEff; j++){
			temp = M.Mem[B1][j];
			M.Mem[B1][j] = M.Mem[B2][j];
			M.Mem[B2][j] = temp;
		}
	}

	public double EkspansiKofaktor(MATRIKS M)
	{
		// Reihan Andhika Putra
		/* Prekondisi: IsBujurSangkar(M) */
		/* Menghitung nilai determinan M menggunakan ekspansi kofaktor pada baris ke-1 */
		if (M.NBrsEff == 1)
		{
			return M.Mem[0][0];
		}
		else
		{
			MATRIKS Minor = new MATRIKS();
			MakeMATRIKS((M.NBrsEff - 1), (M.NKolEff - 1), Minor);
			int i, j, k, ci, cj;
			double det;
			int koef = 1;

			det = 0;
			if (M.NBrsEff == 2)
			{

				det = M.Mem[0][0] * M.Mem[1][1] - M.Mem[0][1] * M.Mem[1][0];
				return det;
			}
			else
			{
				for (i = 0; i < M.NBrsEff; i++)
				{
					ci = 0; 
					cj = 0;
					for (j = 0; j < M.NBrsEff; j++)
					{
						for (k = 0; k < M.NBrsEff; k++)
						{
							if (j != 0 && k != i)
							{
								Minor.Mem[ci][cj] = M.Mem[j][k];
								cj = cj + 1;
								if (cj > M.NBrsEff - 2)
								{
									ci = ci + 1;
									cj = 0;
								}
							}
						}
					}
					det = det + koef * ((M.Mem[0][i]) * EkspansiKofaktor(Minor));
					koef = -1 * koef;
				}
			}
			return det;
		}
	}
}