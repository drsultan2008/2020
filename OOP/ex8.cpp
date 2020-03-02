#include <bits/stdc++.h>
using namespace std;
class matHang{
private:
	string maHang;
	int tonHang,soLuong,loai;
public:
	matHang():maHang(""),tonHang(0),soLuong(0),loai(0){};
	matHang(string m, int t, int s, int l):maHang(m),tonHang(t),soLuong(s),loai(0){};
	inMatHang(){
		cout << "Ma hang: ";
		fflush(stdin);
		getline(cin,maHang);
		cout << "Ton hang: ";
		cin >> tonHang;
		cout << "So luong: ";
		cin >> soLuong;
		cout << "Loai: ";
		cin >> loai;
	}
	outMatHang(){
		cout << "Ma hang: " << maHang << endl;
		cout << "Ton hang: " << tonHang << endl;
		cout << "So luong: " << soLuong << endl;
		cout << "Loai: " << loai << endl;
	}
	double tinhTien(){
		if (loai==1) return 50*soLuong;
		if (loai==2) return 20*soLuong;
		return 30*soLuong;
	}
};
class khuyenMai:public matHang{
private:
	int gioGiam;
public:
	khuyenMai():matHang(),gioGiam(0){}
	khuyenMai(string m, int t, int s, int l, int g):matHang(m,t,s,l),gioGiam(g){};
	double tTien(){
		return tinhTien()-gioGiam;
	}
	void inKhuyenMai(){
		inMatHang();
		cout << "Nhap gio giam: ";
		cin >> gioGiam;
	}
	void outKhuyenMai(){
		outMatHang();
		cout << "Gio giam: " << gioGiam << endl;
	}
	int getGioGiam(){
		return gioGiam;
	}
};
class listt{
private:
	khuyenMai *l;
	int n;
public:
	listt():l(NULL),n(0){};
	listt(int nn){
		n=nn;
		l= new khuyenMai[n];
	}
	void inList(){
		cout << "Nhap so mat hang: ";
		cin >> n;
		l = new khuyenMai[n];
		for (int i=0; i<n; i++){
			cout << "Nhap mat hang thu: " << i+1 << endl;
			l[i].inKhuyenMai();
		}
	}
	void outList(){
		for (int i=0; i<n; i++){
			cout << "Thong tin mat hang thu " << i+1 << endl;
			l[i].outKhuyenMai();
		}
	}
	void sort(){
		for (int i=0; i<n; i++)
			for (int j=i; j<n; j++)
				 if (l[i].getGioGiam()<l[j].getGioGiam())
				 	swap(l[i],l[j]);
		int max=l[0].getGioGiam();
		int i=0;
		cout << "Nhung mat hang gio giam nhieu nhat la: " << endl;
		while (l[i].getGioGiam()==max){
			l[i].outKhuyenMai();
			i++;
		}
	}
};
int main(){
	listt ll;
	ll.inList();
	ll.outList();
	ll.sort();
}
