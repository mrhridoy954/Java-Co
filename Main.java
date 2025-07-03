#include "dynarr.h"
        #include <iostream>

using namespace std;

        int main() {
        int rows, cols;
        cout << "rows: ";
        cin >> rows;
        cout << " column: ";
        cin >> cols;

        dynArr obj;
        obj.allocate(rows, cols);

        cout << "values  " << rows << "x" << cols << " array:\n";
        for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
        int value;
        cin >> value;
        obj.setValue(i * cols + j, value);
        }
        }

        cout << "Array:\n";
        for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
        cout << obj.getValue(i * cols + j) << " ";
        }
        cout << endl;
        }


        }
