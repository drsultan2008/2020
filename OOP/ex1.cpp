#include <bits/stdc++.h>
using namespace std;
class frac{
private:
	int num,denomin;
public:
	frac():num(0),denomin(1){}
	frac(int n, int d):num(n),denomin(d){}
	int GCD(int a, int b){return a%b==0?b:GCD(b,a%b);}
	void comp(){
		int div=GCD(num,denomin);
		num/=div;
		denomin/=div;
	}
	friend ostream &operator << (ostream &out, frac &f){
		f.comp();
		if (f.num*f.denomin<0)
			if (abs(f.num)%abs(f.denomin)==0)
				out << "-" << abs(f.num)/abs(f.denomin);
			else out << "-" << abs(f.num) << "/" << abs(f.denomin);
		else if (f.num==0)
			out << 0;
		else if (f.num%f.denomin==0)
			out << f.num/f.denomin;
		else out << f.num << "/" << f.denomin;
		return out;
	}
	friend istream &operator >> (istream &in, frac &f){
		cout << "Tu so: " ;
		in >> f.num;
		do{
			cout << "Mau so: ";
			in >> f.denomin;
		}while (f.denomin==0);
		return in; 
	}
	frac operator + (frac f2){
		f2.num=num*f2.denomin+f2.num*denomin;
		f2.denomin*=denomin;
		f2.comp();
		return f2;
	}
	frac operator - (frac f2){
		f2.num=num*f2.denomin-f2.num*denomin;
		f2.denomin*=denomin;
		f2.comp();
		return f2;
	}
	frac operator * (frac f2){
		f2.num*=num;
		f2.denomin*=denomin;
		f2.comp();
		return f2;
	}
	frac operator / (frac f2){
		f2.num*=denomin;
		f2.denomin*=num;
		swap(f2.denomin,f2.num);
		f2.comp();
		return f2;
	}
};
int main(){
	frac p1,p2,p3,p4;
	cout << "Nhap phan so thu nhat: \n";
	cin >> p1;
	cout << "Nhap phan so thu hai: \n";
	cin >> p2;
	cout << "Nhap phan so thu ba: \n";
	cin >> p3;
	cout << "Nhap phan so thu tu: \n";
	cin >> p4;
	frac p;
	p=(p1+p2)/(p3-p4)*p1;
//	p=p1/p2;
	cout << "Ket qua la: " << p;
}
