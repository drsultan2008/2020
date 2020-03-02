#include <bits/stdc++.h>
using namespace std;
class employe{
private:
	string name,code;
public:
	employe():name(""),code(""){}
	employe(string n, string c):name(n),code(c){};
	void inEmploye(){
		cout << "Ten nhan vien : "; fflush(stdin); getline(cin,name);
		cout << "Ma nhan vien : "; fflush(stdin); getline(cin,code);
	}
	void outEmploye(){
			cout << "Ten nhan vien: " << name << endl;
			cout << "Ma nhan vien: " << code << endl;
	}
	string getName(){
		return name;
	}
};
class hopDong:public employe{
private:
	double ngayCong,tienCong;
public:
	hopDong():employe(),ngayCong(0),tienCong(0){};
	hopDong(string n, string c, int nc, int tc):employe(n,c),ngayCong(nc),tienCong(tc){};
	void inHopDong(){
		inEmploye();
		cout << "Ngay cong: " ; cin >> ngayCong;
		cout << "Tien cong: " ; cin >> tienCong;
	}
	void outHopDong(){
		outEmploye();
		cout << "Ngay cong: " << ngayCong << endl;
		cout << "Tien cong: " << tienCong << endl;
	}
	double tinhLuong(){
		return ngayCong*tienCong;
	}
	int getNgayCong(){
		return ngayCong;
	}
};
class listt{
private:
	hopDong *a;
	int n;
public:
	listt():a(NULL),n(0){};
	listt(int nn){
		n=nn;
		a = new hopDong[n];
	}
	void sort(){
		for (int i=0; i<n; i++)
			for (int j=i; j<n; j++)
				if (a[i].tinhLuong()>a[j].tinhLuong())
					swap(a[i],a[j]);
	}
	void outList(){
		for (int i=0; i<n; i++)
		{
			a[i].outHopDong();
			cout << endl;	
		}
	}
	void inList(){
		cout << "Nhap so nhan vien hop dong: ";
		cin >> n;
		a= new hopDong[n];
		for (int i=0; i<n; i++)
			a[i].inHopDong();
	}
	void p(){
		hopDong min=a[0];
		for (int i=1; i<n; i++)
			if (a[i].getNgayCong()<min.getNgayCong())
				min=a[i];
		cout << "Nhan vien nghi lam nhieu nhat la: " << min.getName(); 
	}
};
int main(){
	listt l;
	l.inList();
	cout << "Danh sach nhan vien vua nhap: ";
	l.sort();
	l.outList();
	l.p();
}
