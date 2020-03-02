#include <bits/stdc++.h>
using namespace std;
class diem{
private:
	double x;
	double y;
public:
	diem():x(0),y(0){}
	diem(double xx, double yy):x(xx),y(yy){}
	double d(){
		return sqrt(x*x+y*y);
	}
	friend istream &operator >> (istream  &in, diem &p){
		cout << "\nHoanh do:";
		in >> p.x;
		cout  << "\nTung do:";
		in >> p.y;
		return in;
	}
	friend ostream &operator << (ostream &out, diem &p){
		out << "\nDiem co toa do: (" << p.x << "," << p.y << ")";
		return out;
	}
};
class dayDiem{
private:
	diem *p;
	int n;
public:
	dayDiem():p(NULL),n(0){};
	dayDiem(int n){
		p= new diem[n];
		this->n=n;
	}	
	nhap(){
		cout << "Nhap so diem: ";
		cin >> n;
	    p = new diem[n];
	    for (int i=0; i<n; i++){
	    	cout << "Nhap diem thu" << i+1 << endl;
	    	cin >> p[i];
		}
	}
	sum(){
		double res=0;
		for (int i=0; i<n; i++)
			res+=p[i].d();
			return res;
	}
	diem min(){
		diem tmp=p[0];
		for (int i=0; i<n; i++)
			if (p[i].d()<tmp.d())
				tmp=p[i];
		return tmp;
	}
	xuat(){
		for (int i=0; i<n; i++)
			cout << p[i];
	}
};
int main(){
	dayDiem a;
	a.nhap();
	cout << "Tong cac diem vua nhap: " << a.sum();
	a.xuat();
	diem p=a.min();
	cout << p;
}
