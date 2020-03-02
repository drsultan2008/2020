#include <stdio.h>
typedef struct diem{
	double x,y;
};
int main(){
	int n;
	printf("Nhap vao so diem: ");
	scanf("%d",&n);
	diem a[n+1];
	for (int i=1; i<=n ;i++){
		printf("Nhap vao diem thu i:",i);
		scanf("%lf%lf",&a[i].x,&a[i].y);
	}
	printf("\nCac diem vua nhap la:");
	for (int i=1; i<=n; i++)
		printf("(%.02lf,%.02lf) ",a[i].x,a[i].y);
	int d=0;
	for (int i=1; i<=n; i++)
		if ((a[i].x*a[i].x+a[i].y*a[i].y)<=7.5*7.5)
			d++;
	printf("\nSo diem nam trong duong tron tam O ban kinh 7.5 la: %d",d);
}
