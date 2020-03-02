#include <bits/stdc++.h>
using namespace std;
class people{
private:
	string code,name;
	int year;
public:
	people():code(""),name(""),year(0){};
	people(string c, string n, int y):code(c),name(n),year(y){};
	friend ostream &operator << (ostream &out, people &p){
		out << "Ho ten: " << p.name << "\n";
		out << "So chung minh nhan dan: " << p.code << "\n";
		out << "Nam sinh: " << p.year;
		return out;
	}
	friend istream &operator >> (istream &in, people &p){
		cout << "Nhap ten: ";
		fflush(stdin);
		getline(in,p.name);
		cout << "Nhap so chung minh nhan dan: ";
		fflush(stdin);
		getline(in,p.code);
		cout << "Nam sinh: ";
		in >> p.year;
		return in;
	}
	void out(){
		cout << "Ho ten: " << name << "\n";
		cout << "So chung minh nhan dan: " << code << "\n";
		cout << "Nam sinh: " << year;
	}
	void in(){
		cout << "Nhap ten: ";
		fflush(stdin);
		getline(cin,name);
		cout << "Nhap so chung minh nhan dan: ";
		getline(cin,code);
		cout << "Nam sinh: ";
		cin >> year;
	}
	int getYear(){
		return year;
	}
	string getName(){
		return name;
	}
	string getCode(){
		return code;
	}
};
class soccer:public people{
private:
	int sptd,sbt;
public:
	soccer():people(),sptd(0),sbt(0){};
	soccer(string c, string n, int y, int sp, int sb):people(c,n,y),sptd(sp),sbt(sb){};
	void ex(){
		out();
		cout << "\nSo ban thang: " << sbt;
		cout << "\nSo phut thi dau: " << sptd;
	}
	void ix(){
		in();
		cout << "So ban thang: ";
		cin >> sbt;
		cout << "So phut thi dau: ";
		cin >> sptd;
	}
	int getSptd(){
		return sptd;
	}
	int getSbt(){
		return sbt;
	}
};
class tienThuong{
private:
	int n;
public:
	int process(soccer a){
		if ((a.getSbt()>=3 && a.getSbt()<5) || a.getSptd() >= 500)
			n=5000000;
		if (a.getSbt()>=5)
			n=7000000;
		else n=0;
		return n;		
	}
	int getN(){
		return n;
	}
};
int main(){
	int n;
	cout << "Nhap so cau thu: ";
	cin >> n;
	soccer a[n];
	for (int i=0; i<n; i++){
		cout << "Nhap cau thu thu " << i+1 << endl;
		a[i].ix();
	}
//	for (int i=0; i<n; i++)
//		a[i].ex();
	soccer minOld=a[0];
	for (int i=1; i<n; i++)
		if (minOld.getYear()>a[i].getYear())
			minOld=a[i];
	cout << "Nguoi co tuoi nho nhat la: " << endl;
	minOld.ex();
	tienThuong tmp;
	for (int i=0; i<n; i++){
		cout << "Tien thuong cua " << a[i].getName() << " la: ";
		cout << tmp.process(a[i]) << "\n";
	}
}
