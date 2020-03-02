#include <stdio.h>
int main(){
	int n;
	printf("Nhap vao n:");
	scanf("%d",&n);
	double a[n+1];
	for (int i=1; i<=n; i++){
		printf("Nhap vao phan tu a[%d]:",i);
		scanf("%.02lf",&a[i]);
	}
	printf("\nDay vua nhap la:");
	for (int i=1; i<=n; i++)
		printf("%lf ",a[i]);
	double res=2019;
	for (int i=1; i<=n; i++)
		res+=(a[i]+2*i+1)/(2*n+7);
	printf("\nGia tri cua bieu thuc la: %.02lf",res);
}
