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
	void display(){
		comp();
		if (num*denomin<0)
			if (abs(num)%abs(denomin)==0)
				cout << "-" << abs(num)/abs(denomin);
			else cout << "-" << abs(num) << "/" << abs(denomin);
		else if (num==0)
			cout << 0;
		else if (num%denomin==0)
			cout << num/denomin;
		else cout << num << "/" << denomin;
	}
	void read(){
		cout << "Tu so: " ;
		cin >> num;
		do{
			cout << "Mau so: ";
			cin >> denomin;
		}while (denomin==0);
	}
	frac cong (frac f2){
		f2.num=num*f2.denomin+f2.num*denomin;
		f2.denomin*=denomin;
		f2.comp();
		return f2;
	}
	frac tru (frac f2){
		f2.num=num*f2.denomin-f2.num*denomin;
		f2.denomin*=denomin;
		f2.comp();
		return f2;
	}
	frac nhan (frac f2){
		f2.num*=num;
		f2.denomin*=denomin;
		f2.comp();
		return f2;
	}
	frac chia (frac f2){
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
	p1.read();
	cout << "Nhap phan so thu hai: \n";
	p2.read();
	cout << "Nhap phan so thu ba: \n";
	p3.read();
	cout << "Nhap phan so thu tu: \n";
	p4.read();
	frac p;
	p=p1.cong(p2).chia(p3.tru(p4)).nhan(p1);
	cout << "Ket qua la: " ;
	p.display();
}
