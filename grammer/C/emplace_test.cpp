#include <iostream>
#include <map>
#include <vector>
#include <list>
using namespace std;

class Test {
  public:
  
  Test(): num(0) {
    cout<< "default constructor" << " " << num << endl;
  }
  
  Test(int num): num(num) 
  {
    cout<< "constructor" << " " << num << endl;
  }
  
  Test(const Test& other): num(other.num) 
  {
    cout<< "copy" << " " << num << endl;
  }
  
  // private:
  int num;
};



int main() 
{
    cout << "------------map test----------" << endl;
    map<int, Test> m;
    m[0].num; // a[0] call default consturctor
    m.emplace(1,1); //skip copy constructor
// ------------map test----------
// default constructor 0
// constructor 1
    
    cout << "------------vector test----------" << endl;
    vector<Test> v;
    v.reserve(100); // Important: alloc space to avoid duplicate copy but not instantiate them
    v.emplace_back(2);
    v.push_back(3);
    v.erase(v.begin());
//------------vector test----------
// constructor 2
// constructor 3
// copy 3
    
    cout << "------------link list test----------" << endl;
    list<Test> l;
    l.emplace_back(1);
    l.emplace_back(2);
    l.emplace_front(0);
    for (auto a =l.begin(); a!=l.end(); a++) {
      cout << a->num << " "; 
    }
    cout << endl;
//     ------------link list test----------
// constructor 1
// constructor 2
// constructor 0
// 0 1 2
    
    auto tail = prev(l.end()); //equal to next(l.end(), -1)
    //
    //x.splice(x_iter, y, y_iter), move the y_iter from y to prev(x_iter) and x_iter
    l.splice(l.begin(), l, tail);  // move the tail of l to the 
    
    for (auto a =l.begin(); a!=l.end(); a++) {
      cout << a->num << " "; 
    }
  // 2 0 1
    cout << endl;

    
    return 0;
}