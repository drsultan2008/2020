#include "vector.cpp"
class teacher{
private:
	std::string code,name;
public:
	teacher():code(""),name(""){};
	teacher(std::string c, std::string n):code(c),name(n){};
	std::string getCode(){return code;};
	std::string getName(){return name;};
	friend std::ostream &operator << (std::ostream &out, teacher &t){
		out << "Ma giao vien: " << t.code << "\n";
		out << "Ho ten giao vien: " << t.name << "\n";
		return out;
	}
};
int main(){
	vector<teacher> v;
	teacher tmp("1000","Le Quang Duy");
	v.ins(tmp,0);
	std::cout << v;
}
