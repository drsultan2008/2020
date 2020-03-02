#include <stdio.h>
int main(){
	int m,n;
	printf("Nhap vao kich thuoc ma tran mxn:");
	scanf("%d%d",&m,&n);
	int a[m+1][n+1];
	for (int i=1; i<=m; i++)
		for (int j=1; j<=n; j++){
			printf("Nhap vao phan tu a[%d,%d]: ",i,j);
			scanf("%d",&a[i][j]);
		}
	printf("\nMa tran kich thuoc %dx%d vua nhap la:\n",m,n);
	for (int i=1; i<=m ; i++){
		for (int j=1; j<=n; j++)
			printf("%d ",a[i][j]);
		printf("\n");
	}
	int res=1;
	for (int i=1; i<=n; i+=2)
		for (int j=1; j<=m; j++)
			res*=a[j][i];
	printf("\nTich cac phan tu cot le la: %d",res);
	int max=a[1][1];
	int posI=1,posJ=1;
	for (int i=1; i<=m; i++)
		for (int j=1; j<=n; j++)
			if (max<a[i][j]){
				max=a[i][j];
				posI=i;
				posJ=j;
			}
	printf("\nPhan tu lon nhat trong ma tran la a[%d,%d]=%d",posI,posJ,max);
}
