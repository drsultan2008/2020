#include <stdio.h>
typedef struct cauThu{
	char hoTen[100];
	int soBanThang;
	int doiBong;
};
int main(){
	int n;
	printf("Nhap vao so cau thu:");
	scanf("%d",&n);
	cauThu a[n+1];
	for (int i=1; i<=n; i++){
		printf("\nNhap thong tin cau thu so thu tu %d:",i);
		printf("\nNhap vao ten cau thu:");
		fflush(stdin);
		scanf("%[^\n]",&a[i].hoTen);
		printf("\nNhap vao so ban thang:");
		scanf("%d",&a[i].soBanThang);
		printf("\nNhap vao ten doi bong:");
		scanf("%d",&a[i].doiBong);
	}
	printf("\nThong tin cua %d cau thu vua nhap la: ",n);
	for (int i=1; i<=n; i++){
		printf("\nCau thu so thu tu %d:",i);
		printf("\nHo ten: %s",a[i].hoTen);
		printf("\nSo ban thang: %d",a[i].soBanThang);
		printf("\nDoi thi dau: %d",a[i].doiBong);
	}
	int d[4];
	d[1]=0;d[2]=0;d[3]=0;// So ban thang doi 1,2,3
	for (int i=1; i<=n; i++)
		d[a[i].doiBong]+=a[i].soBanThang;
	for (int i=1; i<=3; i++)
		printf("\nSo ban thang doi %d la: %d",i,d[i]);
	int max=(d[1]>d[2]&&d[1]>d[3])?1:(d[2]>d[3]?2:3);
	printf("\nDoi %d ghi duoc nhieu ban thang nhat",max);
	max=a[1].soBanThang;
	int pos=1;
	for (int i=2; i<=n; i++)
		if (max<a[i].soBanThang){
			max=a[i].soBanThang;
			pos=i;
		}
	printf("\nCau thu ghi duoc nhieu ban thang nhat la: %s , ghi duoc %d ban thang",a[pos].hoTen,max);
	
}
