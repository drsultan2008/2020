#include <bits/stdc++.h>
using namespace std;
class toaDo{
private:
	double x,y;
public:
	toaDo():x(0),y(0){};
	toaDo(double xx, double yy):x(xx),y(yy){}
	nhap(){
		cout << "\nHoanh do:" ;
		cin >> x;
		cout << "\nTung do: ";
		cin >> y;
	}
	xuat(){
		cout << "Diem: (" << x << "," << y << ")";
	}
	double d(){
		return sqrt(x*x+y*y);
	}
};
class diemMau:public toaDo{
private:
	int mau;
public:
	diemMau():toaDo(),mau(0){}
	diemMau(double xx, double yy, int m):toaDo(xx,yy),mau(m){}
	nhap(){
		toaDo::nhap();
		cout << "Nhap mau: ";
		cin >> mau;
	}
	xuat(){
		toaDo::xuat();
		cout << "Co ma mau la:" << mau;
	}
	int getMau(){
		return mau;
	}
};
class lis{
private:
	diemMau *p;
	int n;
public:
	lis():p(NULL),n(0){}
	lis(int n){
		p = new diemMau[n];
		this->n=n;
	}
	nhap(){
		cout << "Nhap n: ";
		cin >> n;
		p= new diemMau[n];
		for (int i=0; i<n; i++){
			p[i].nhap();
		}
	}
	xuat(){
		for (int i=0; i<n; i++)
			p[i].xuat();
	}
	loai(){
		int a[4];
		for (int i=1; i<4; i++)
			a[i]=0;
		for (int i=0; i<n; i++)
			a[p[i].getMau()]++;
		cout << "Co " << a[1] << "mau do" << endl;
		cout << "Co " << a[2] << "mau vang" << endl;
		cout << "Co " << a[3] << "mau xanh" << endl;
	}
	sort(){
		for (int i=0; i<n; i++)
			for (int j=i; j<n; j++)
				if (p[i].d()<p[j].d())
					swap(p[i],p[j]);
	}
	
};
int main(){
	lis a;
	a.nhap();
	a.xuat();
	a.loai();
	a.sort();
	a.xuat();
}
