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
		/* Membentuk sebuah MATRIKS "kosong" yang siap diisi berukuran NB x NK di "ujung kiri" memori */
		/* I.S. NB dan NK adalah valid untuk memori matriks yang dibuat */
		/* F.S. Matriks M sesuai dengan definisi di atas terbentuk */
	   M.NBrsEff=NB;
	   M.NKolEff=NK;
   }

	public void BacaMATRIKS(MATRIKS M){
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
				System.out.println("Masukkan elemen");
				M.Mem[i][j]= input.nextDouble();
			}
		}
		MakeMATRIKS(n,n,M);
	}
	
	public void TulisMATRIKS (MATRIKS M){
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
	public void Test(){
		MATRIKS M = new MATRIKS();
		BacaMATRIKS(M);
		TulisMATRIKS(M);
	}

	public MATRIKS KaliMATRIKS (MATRIKS M1, MATRIKS M2){
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
}