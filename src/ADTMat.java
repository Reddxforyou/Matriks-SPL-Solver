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

	public void BacaMATRIKSAugmented(MATRIKS M){
		// Reihan Andhika Putra , Checked
		/* I.S. IsIdxValid(NB,NK) */ 
		/* F.S. M terdefinisi nilai elemen efektifnya, berukuran NB x NK */
		/* Proses: Melakukan MakeMATRIKS(M,NB,NK) dan mengisi nilai efektifnya */
		/* Selanjutnya membaca nilai elemen per baris dan kolom */
		int i,j,m,n;
		Scanner input = new Scanner(System.in);
		System.out.print("Masukkan ordo matriks mxn : ");
		m = input.nextInt();
		n = input.nextInt();

		for(i = 0; i < m; i++){
			for (j = 0; j < n; j++){
				M.Mem[i][j]= input.nextDouble();
			}
		}
		MakeMATRIKS(m,n,M);
	}
	
	public void TulisMATRIKS (MATRIKS M){
		// Reihan Andhika Putra , Checked
		/* I.S. M terdefinisi */
		/* F.S. Nilai M(i,j) ditulis ke layar per baris per kolom, masing-masing elemen per baris 
			dipisahkan sebuah spasi */
		/* Proses: Menulis nilai setiap elemen M ke layar dengan traversal per baris dan per kolom */
		int i,j ;
		for(i = 0; i <= M.NBrsEff-1; i++){
			for (j = 0; j <= M.NKolEff-1; j++){
				if (j == (M.NKolEff-1) && i == (M.NBrsEff-1)) {
					System.out.print(M.Mem[i][j]);
				} else if (j == (M.NKolEff-1)){
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
		System.out.println("Masukkan elemen M1");
		BacaMATRIKSAugmented(M1);
		TulisMATRIKS(M1);
		System.out.println();
		MetodeCramer(M1);
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

	public void PKaliKons(MATRIKS M, double K)
	{
		// Reihan Andhika Putra checked
		/* I.S. M terdefinisi, K terdefinisi */
		/* F.S. Mengalikan setiap elemen M dengan K */
		int i,j;
		for (i = 0; i < M.NBrsEff; i++)
		{
			for (j = 0; j < M.NKolEff; j++)
			{
				M.Mem[i][j] = M.Mem[i][j] * K;
			}
		}
	}

	public double KofakElmt(MATRIKS M, int i, int j){
		// Reihan Andhika Putra, Checked
		/* I.S. M terdefinisi, i, j dalam range matriks */
		/* F.S. Mengeluarkan elemen kofaktor(i,j) dari sebuah matriks */
		MATRIKS Minor = new MATRIKS();
		MakeMATRIKS((M.NBrsEff - 1), (M.NKolEff - 1), Minor);
		int ii, jj, mi, mj;
		double koef = Math.pow(-1, (i+j+2)) ;
		mi = 0; 
		mj = 0;
		for (ii = 0; ii < M.NBrsEff; ii++) {
			for (jj = 0; jj < M.NKolEff; jj++) {
				if (ii != i && jj != j) {
					Minor.Mem[mi][mj] = M.Mem[ii][jj];
					mj = mj + 1;
					if (mj > M.NBrsEff - 2) {
						mi = mi + 1;
						mj = 0;
					}
				}
			}
		}
		return EkspansiKofaktor(Minor)*koef ;			
	}
	public MATRIKS MATRIKSKofaktor (MATRIKS M){
		// Reihan Andhika Putra, Checked
		/* I.S. M terdefinisi */
		/* F.S. Mengeluarkan Matriks kofaktor dari sebuah matriks */
		int i,j;
		MATRIKS Kofaktor = new MATRIKS();
		MakeMATRIKS(M.NBrsEff,M.NKolEff,Kofaktor);
		for (i = 0; i < M.NBrsEff; i++)
		{
			for (j = 0; j < M.NKolEff; j++)
			{
				Kofaktor.Mem[i][j] = KofakElmt(M, i, j);
			}
		}
		return Kofaktor;
	}
	public void InverseKofaktor (MATRIKS M){
		// Reihan Andhika Putra, Checked
		/* I.S. M terdefinisi */
		/* F.S. Memprint matriks invers dari matriks M dengan metode determinant dan adjoint */
		MATRIKS Adjoint = new MATRIKS();
		Adjoint = MATRIKSKofaktor(M);
		Transpose(Adjoint);
		double perdet ;
		if (EkspansiKofaktor(M)==0){
			System.out.println("Tidak mempunyai invers");
		} else {
			perdet = 1/EkspansiKofaktor(M);
			PKaliKons(Adjoint, perdet);
			TulisMATRIKS(Adjoint);
		}
	}

	public void GetMATRIKSKoefisien (MATRIKS MAug, MATRIKS MK){	
		// Reihan Andhika Putra, Checked
		/* I.S. MAug, dan MK terdefinisi */
		/* F.S. Mengambil matriks yang merupakan matriks koefisien dari variabel di matriks augmented */
    int i,j;
    MakeMATRIKS(MAug.NBrsEff, MAug.NKolEff-1, MK);
    for (i=0; i< MK.NBrsEff;i++){
      for (j=0; j< MK.NKolEff;j++){
        MK.Mem[i][j] = MAug.Mem[i][j];
      }
    }
	}

	public void GetMATRIKSHasil (MATRIKS MAug, MATRIKS MH) {
		// Reihan Andhika Putra, Checked
		/* I.S. MAug, dan MH terdefinisi */
		/* F.S. Membentuk matriks MK berukuran Nx1 yang berisikan bagian konstanta dari MAug */
		int i;
		MakeMATRIKS(MAug.NBrsEff, 1, MH);
		for (i=0; i< MAug.NBrsEff; i++){
			MH.Mem[i][0]=MAug.Mem[i][MAug.NKolEff-1];
		}
	}

	public void CopyMATRIKS(MATRIKS MIn, MATRIKS MHsl){
		// Reihan Andhika Putra, Checked
		/* I.S. MIn, dan MHsl terdefinisi */
		/* F.S. Melakukan assignment MHsl  MIn */
		int i,j;
		for (i=0; i< MIn.NBrsEff; i++){
			for (j=0; j< MIn.NKolEff; j++){
				 MHsl.Mem[i][j] = MIn.Mem[i][j];
			}
	 }
	}

	public MATRIKS MATRIKSCramer(MATRIKS MK, MATRIKS MH, int kol) {
		// Reihan Andhika Putra, Checked
		/* I.S. Mk, Mh, dan kol terdefinisi */
		/* F.S. Membentuk matriks cramer dengan Mk kolom indeks kol diganti dengan MH */
		MATRIKS Cramer = new MATRIKS();
		int i;
		MakeMATRIKS(MK.NBrsEff, MK.NKolEff, Cramer);
		CopyMATRIKS(MK, Cramer);
		for (i=0; i< Cramer.NBrsEff; i++){
			Cramer.Mem[i][kol] = MH.Mem[i][0];
		}
		return Cramer;
	}

	public void MetodeCramer (MATRIKS Maug) {
		// Reihan Andhika Putra, Checked
		/* I.S. Mk, Mh, dan kol terdefinisi */
		/* F.S. Menyelesaikan SPL dengan metode Cramer */
		double[] solusi = new double[100];
		MATRIKS MK = new MATRIKS();
		MATRIKS MH = new MATRIKS();
		int i;
		GetMATRIKSKoefisien(Maug, MK);
		GetMATRIKSHasil(Maug, MH);
		System.out.println("Matrisk Koef");
		TulisMATRIKS(MK);
		System.out.println();
		System.out.println("Matrisk Hasil");
		TulisMATRIKS(MH);
		System.out.println();
		System.out.println("Nilai koef");
		if (EkspansiKofaktor(MK)==0){
			System.out.println("Tidak mempunyai solusi");
		} else {
			for (i=0; i < MK.NKolEff; i++){
				solusi[i] = EkspansiKofaktor(MATRIKSCramer(MK, MH, i))/EkspansiKofaktor(MK);
				System.out.println(solusi[i]);
			}
		}
	}

	public float DetGaus(MATRIKS M){
		// Ryo Richardo, Checked
		/* I.S. M terdefinisi, IsBujurSangkar(M) */
		/* F.S. Menghitung nilai dedterminan matriks M dengan metode Gauss */
		int n, i, j; 
		double line1, line2;
		float count = 1;
		boolean found;
		for (n = 0; n < M.NBrsEff; n++){
			if (M.Mem[n][n] == 0){
				found = false;
			  	i = n+1;
			  	while (!found && i < M.NBrsEff){
					if (M.Mem[i][n] != 0){
						found = true;
						for (j = n; j < M.NKolEff; j++){
							M.Mem[n][j] += M.Mem[i][j];
						}
				 	}
				 	i++;
			  	}
			  	if (!found){
					return 0;
			  	}
		   	}
		   	for (i = n+1; i < M.NBrsEff; i++){       
			  	if (M.Mem[i][n] != 0){        
				 	line1 = M.Mem[n][n];
				 	line2 = M.Mem[i][n]; 
					for (j = n; j < M.NKolEff; j++){
						M.Mem[i][j] *= line1;
						M.Mem[n][j] *= line2;
						M.Mem[i][j] -= M.Mem[n][j];
					}
					count /= (line1 * line2);
				}
			}
			count *= M.Mem[n][n];
		}
		return count;
	}

	public void TestRyo(){
		MATRIKS M1= new MATRIKS();
		//System.out.println("Masukkan elemen M1");
		// BacaMATRIKSAugmented(M1);
		//TulisMATRIKS(M1);
		//System.out.println();
		//System.out.println(DetGaus(M1));
		M1 = MakeMatriksInterpolasi(3, M1);
		TulisMATRIKS(M1);
	}

	public MATRIKS MakeMatriksInterpolasi(int n, MATRIKS Mout) {
		// Ryo Richardo, Checked
		// I.S. n (derajat interpolasi), Mout terdefinisi
		// F.S. terbentuk matriks representasi Interpolasi inputnya.

		int i, j;
		MATRIKS M = new MATRIKS();
		Scanner input = new Scanner(System.in);

		for(i = 0; i <= n ; i++){
			for (j = 0; j < 2; j++){
				M.Mem[i][j]= input.nextDouble();
			}
		}
		MakeMATRIKS(n, 2, M);

		for(i = 0; i <= n+1; i++){
			for (j = 0; j <= n+1; j++){
				if (j == 0){
					Mout.Mem[i][j] = 1;
				}
				else if (j == n+1){
					Mout.Mem[i][j] = M.Mem[i][1];
				}
				else{
					Mout.Mem[i][j] = Math.pow(M.Mem[i][0], j);
				}
			}
		}
		MakeMATRIKS(n+1, n+2, Mout);
		return Mout;
	}
}

