#include <bits/stdc++.h>
int main(){
	int n,m;
	printf("Nhap n="); scanf("%d",&n);
	printf("Nhap m="); scanf("%d",&m);
	int a[n][m];
	for (int i=0; i<n; i++)
		for (int j=0; j<m;j++){
			printf("A[%d][%d]=",i+1,j+1);
			scanf("%d",&a[i][j]);
		}
	printf("Ma tran vua nhap la: ");
	for (int i=0; i<n; i++){
		for (int j=0; j<m;j++)
			printf("%d ",a[i][j]);
		printf("\n");
	}
	// y1
	int min=11;
	for (int i=0; i<n; i++)	
		for (int j=0; j<m; j++)
			if (a[i][j]<10)
				min=(a[i][j]<min)?a[i][j]:min;
	if (min==11)
		printf("Khong co so nao nho hon 10");
	else printf("min=%d",min); 
	//y2
	int res=1;
	int mi;
	mi=(m<n)?m:n;
	for (int i=0; i<mi; i++) res*=a[i][i];
	printf("\nTich cac phan tu co chi so hang bang cot la: %d", res);
	//y3
	double r=0;
	for (int i=0; i<m; i++){
		int tmp=1;
		for (int j=0; j<n; j++)
			tmp*=a[j][i];
		r+=tmp;
	}
	printf("Trung binh cong cua tich cac cot la: %.02lf",r/m);
	// y4
	int rr=0;
	if (m==n){
		printf("Ma tran vuong!");
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				if (i<n-1&&j<n-i-1)
					rr+=a[i][j];
	}
	printf("%d",rr);
			
}
