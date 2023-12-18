// https://onecompiler.com/cpp/3yp8f7esw
#include <iostream>
#include <stdio.h>
#include <sstream>

using namespace std;


int main() 
{
    cout << "program output" << endl;
    
    // 0. test stringstream
    stringstream ss;
    ss << "aa bb\ncc_ temp,1234.";
    string t;
    while (!ss.eof()) {
      ss >> t;
      cout << t << ";"; // aa;bb;cc_;temp,1234.;
    }
    cout << endl;
    
    // 1. redirect stdout to  file (common in interview)
    freopen("tt.out", "w", stdout);
    cout << "file output" << endl;
    printf("%s", "keke");
    fclose(stdout);
    cout << "program output" << endl;  
    return 0;
}