#include <bits/stdc++.h>
using namespace std;
class daThuc{
private:
	double *hs;
	int bac;
public:
	daThuc():hs(NULL),bac(0){};
	daThuc(int b){
		bac=b;
		hs= new double[b+1];
	}
	~daThuc(){
		delete [] hs;
	}
	friend ostream &operator << (ostream &out, daThuc &d){
		out << d.hs[0];
		for (int i=1; i<=d.bac; i++){
			out << "+" << d.hs[i] << "x^" << i;
		}
		return out;
	}
	friend istream &operator >> (istream &in, daThuc &d){
		cout << "Nhap so bac cua da thuc: ";
		in >> d.bac;
		d.hs = new double [d.bac+1];
		for (int i=0; i<=d.bac; i++){
			cout << "Nhap he so thu " << i << ":";
			in >> d.hs[i];
		}
		return in;
	}
	friend double res(int x, daThuc d){
		double tmp=0;
		for (int i=0; i<=d.bac; i++)
			tmp+=d.hs[i]*pow(x,i);
		return tmp;
	}
};
int main(){
	daThuc p;
	cin >> p;
	cout << "Da thuc vua nhap la: " << endl << p;
	double d1,d2;
	cout << "Nhap vao d1,d2: "; cin >> d1 >> d2;
	cout << "Gia tri can bac hai cua P(d1)-p(d2) la: " << sqrt(res(d1,p)-res(d2,p));
}
