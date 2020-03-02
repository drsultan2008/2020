#include "linkedList.cpp"
#include <conio.h>
using namespace std; 
bool isPrime(double  n){
	if (n!=int(n)) return false;
	int tmp = (int)n;
	if (n<2) return false;
	for (int i=2; i<sqrt(tmp); i++)
		if (tmp%i==0) return false;
	return true;
}
class app{
private:
	LList<double> l;
public:
	app();
	int createList();
	int insertList();
	int freK();
	int isTripleEven();
	int sort();
	int delPrime();
	int delDup();
	void print();
	int menu();
	void run();
};
app::app(){
	
}
int app::createList(){
	LListItr<double> iter=l.first();
	for (;iter.isValid(); iter.advance())
		l.del(1);
	std::string read;
	int i=0;
	cin >> read;
	while (read[0]!='#'){
		double tmp;
		tmp=atof(read.c_str());
		cin >> read;
		l.ins(tmp,++i);
	}
	return 1;
}
int app::insertList(){
	double val;
	int pos;
	cout << "\nNhap gia tri muon chen: " ;
	cin >> val;
	cout << "Nhap vi tri can chen: " ;
	cin >> pos;
	while (pos<1 || pos > l.size()){
		cout << "\nVi tri nay khong ton tai, nhap vi tri tu 1 den " << l.size() << ":";
		cin >> pos;
	}
	l.ins(val,pos);
	return 1;
}
int app::freK(){
	double k;
	cout << "\nNhap k=";
	cin >> k;
	int fre=0;
	LListItr<double> iter=l.first();
	for (;iter.isValid();iter.advance())
		fre+=iter.retrieve()==k;
	cout << "\nSo " << k << " xuat hien " << fre << " lan trong day";
	return 1;
}
int app::isTripleEven(){
	LListItr<double> iter=l.first();
	double st1=iter.retrieve();
	if (!iter.isValid())
		return 0;
	iter.advance();
	double st2=iter.retrieve();
	if (!iter.isValid())
		return 0;
	iter.advance();
	for (int i=3;iter.isValid();iter.advance(),i++){
		if ((int)iter.retrieve()%2==0 && (int)st1%2==0 && (int)st2%2==0 && iter.retrieve()==(int)iter.retrieve() && st1 == (int)st1 && st2==(int)st2 && st1>=0 && st2>=0 && iter.retrieve()>=0){
			cout << "Vi tri: " << i-2 << "," << i-1 << "," << i << endl;
			return 1;
		}
		else{
			st1=st2;
			st2=iter.retrieve();
		}
	}
	return 0;
}
int app::sort(){
	LListItr<double> i=l.first();
	LListItr<double> j=l.first();
	for (;i.isValid();i.advance())
		for(;j.isValid();j.advance())
			if (i.retrieve()<j.retrieve()){
				int tmp= i.retrieve();
				i.retrieve()=j.retrieve();
				j.retrieve()=tmp;
			}
	return 1;
}
int app::delPrime(){
	LListItr<double> iter=l.first();
	for (int pos=1;iter.isValid(); iter.advance()){
		if (isPrime(iter.retrieve())){
			l.del(pos);
		}else pos++;
	}
	return 1;
}
void app::print(){
	LListItr<double> iter=l.first();
	for (;iter.isValid(); iter.advance())
		cout << iter.retrieve() << " " ;
}
int app::delDup(){
	LListItr<double> iter=l.first();
	for (int i=1;iter.isValid();iter.advance(),i++){
		LListItr<double> iter2=iter;
		iter2.advance();
		for (int j=i+1;iter2.isValid(); iter2.advance()){
			if (iter.retrieve()==iter2.retrieve()){
				l.del(j);
			}
			else j++;
		}
	}
	return 1;
}
int app::menu(){
	int n;
	cout << "Bam phim 1 tao danh sach." << endl;
	cout << "Bam phim 2 chen danh sach." << endl;
	cout << "Bam phim 3 xem tan suat cua mot so." << endl;
	cout << "Bam phim 4 de tim 3 so chan lien nhau" << endl;
	cout << "Bam phim 5 de sap xep danh sach" << endl;
	cout << "Bam phim 6 de xoa tat ca cac so nguyen to khoi danh sach" << endl;
	cout << "Bam phim 7 de in danh sach" << endl;
	cout << "Bam phim 8 de xoa cac so trung nhau trong danh sach" << endl;
	cout << "Bam phim 9 de ket thuc chuong trinh." << endl;
	cin >> n;
	return n;
}
void app::run(){
	int choise;
	do{
		system("cls");
		choise=menu();
		switch (choise){
			case 1:
				cout << "Nhap sanh sach so can tao, ket thuc boi phim #:" << endl;
				createList();
				break;
			case 2:
				cout << "Ban dang o chuc nang chen so vao danh sach:" << endl;
				if (insertList())
					cout << "Da chen";
				break;
			case 3: 
				cout << "Ban chon chuc nang tim tan suat so k:" << endl;
				freK();
				break;
			case 4:
				cout << "Dang kiem tra co 3 so chan lien tiep trong danh sach: " << endl;
				if (isTripleEven())
					cout << "Co 3 so chan lien nhau";
				else 
					cout << "Khong co 3 so chan lien nhau";
				break;
			case 5:
				cout << "Dang sap xep danh sach:" << endl;
				if (sort())
					cout << "Da sap xep danh sach.";
				else cout << "Khong the sap xep danh sach";
				break;
			case 6:
				cout << "Dang xoa tat ca cac so nguyen to trong danh sach:" << endl;
				delPrime();
				break;
			case 7:
				cout << "In danh sach: " << endl;
				print();
				break;
			case 8:
				cout << "Dang xoa tat ca cac so trung nhau trong danh sach:" << endl;
				if (delDup())
					cout << "Da xoa tat ca cac so trung nhau trong sanh sach";
				break;
		}
		getch();
	}while (choise!=9);	
}
