// https://onecompiler.com/cpp/3yj7mg296
#include <iostream>
#include <vector>
using namespace std;

// https://www.zhihu.com/question/286330926, do not use move to return value, just used to avoid copy 
int main() 
{
    int a = 5;
    int &la = a;
    int &&ra = std::move(a);
    a = 6;
    cout << a << " " << la << " "  <<  ra << endl;
    
    
    string s = "t";
    string &ls = s;
    string &&rs(std::move(s));
    s.append("q");
    cout << s << " " << ls << " "  <<  rs << endl;
    
    
    vector<string> v(1);
    vector<string> &lv = v;
    vector<string> &&rv(std::move(v));  //nothing happen on v, move is just equal to static_cast<vector<string> &&>(), so it does not move or copy anything. 
    v.push_back(std::move(s)); //the behavior is determined by move constructor or function, like push back, clear the original `s`
    v.emplace_back("2");
    cout << s << " " << v.size()  << " " << lv.size() << " "  <<  rv.size() << endl;
    return 0;
}